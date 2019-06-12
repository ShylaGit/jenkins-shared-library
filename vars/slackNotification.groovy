def call(Map pipelineParams) {
success {
            slackSend baseUrl: 'https://hooks.slack.com/services/', channel: 'sqa-alerts', color: 'good', message: 'Mute please', tokenCredentialId: 'slack-demo'
                echo "Success"
            }
            failure {
                slackSend baseUrl: 'https://hooks.slack.com/services/', channel: 'sqa-alerts', color: 'danger', message: 'Mute please', tokenCredentialId: 'slack-demo'
                echo "Failure"
            }
            unstable {
                slackSend baseUrl: 'https://hooks.slack.com/services/', channel: 'sqa-alerts', color: 'warning', message: 'Mute please', tokenCredentialId: 'slack-demo'
                echo "Unstable"
            }
}
