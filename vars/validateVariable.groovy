def call(String environment) {
  def secret_name = "release-${environment}-kubeconfig"
  println "SECRETNAME"
  println "${secret_name}"
  pipeline {
    agent {
      any {
        label "jenkins-slave-${UUID.randomUUID().toString()}"
        inheritFrom 'default'
        defaultContainer 'kapitan'
        yaml  """
  apiVersion: v1
  kind: Pod
  metadata:
    labels:
      kapitan-container: deploy
  spec:
    containers:
    - name: kapitan
      image: https://github.com/deepmind/kapitan.git
      - cat
      tty: true
      env:
        - name: KUBECONFIG
          value: /etc/kubernetes/kubeconfig
      volumeMounts:
      - name: kubeconfig
        mountPath: /etc/kubernetes
    volumes:
    - name: kubeconfig
      secret:
        secretName: "${secret_name}"
  """
      }
    }
    stages {
      stage('Validate templates') {
        steps {
          sh echo "${secret_name}"
        }
      }
    }
    }
  }

