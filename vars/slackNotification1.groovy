def call(String buildResult) {
    if ( buildResult == "SUCCESS" ) {
            slackSend baseUrl: 'https://hooks.slack.com/services/', channel: 'sqa-alerts', color: 'good', message: 'SUCCESS', tokenCredentialId: 'slack-demo'
                echo "Success"
            }
    if ( buildResult == "FAILURE" ) {
                slackSend baseUrl: 'https://hooks.slack.com/services/', channel: 'sqa-alerts', color: 'danger', message: 'FAILURE', tokenCredentialId: 'slack-demo'
                echo "Failure"
            }
    if ( buildResult == "UNSTABLE" ) {
                slackSend baseUrl: 'https://hooks.slack.com/services/', channel: 'sqa-alerts', color: 'warning', message: 'UNSTABLE', tokenCredentialId: 'slack-demo'
                echo "Unstable"
            }
}
