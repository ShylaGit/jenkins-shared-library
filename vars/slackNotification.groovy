def call(Map pipelineParams) {
            success {
                slackSend channel: pipelineParams.get('channel', ''),
                baseUrl: 'https://hooks.slack.com/services/',
                color: 'good',
                message: "${env.JOB_NAME} - #${currentBuild.number} Success after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
                tokenCredentialId: 'slack-demo'
            }
            failure {
                slackSend channel: pipelineParams.get('channel', ''),
                baseUrl: 'https://hooks.slack.com/services/',
                color: 'good',
                message: "${env.JOB_NAME} - #${currentBuild.number} Success after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
                tokenCredentialId: 'slack-demo'
            }
            unstable {
                slackSend channel: pipelineParams.get('channel', ''),
                baseUrl: 'https://hooks.slack.com/services/',
                color: 'good',
                message: "${env.JOB_NAME} - #${currentBuild.number} Success after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
                tokenCredentialId: 'slack-demo'
            }
}
