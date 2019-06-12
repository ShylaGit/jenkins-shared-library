def call(Map pipelineParams) {
     post {
            success {
                slackSend channel: pipelineParams.get('channel', ''),
                    color: 'good',
                    message: "${env.JOB_NAME} - #${currentBuild.number} Success after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
            }
            failure {
                slackSend channel: pipelineParams.get('channel', ''),
                    color: 'danger',
                    message: "${env.JOB_NAME} - #${currentBuild.number} Failure after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
            }
            unstable {
                slackSend channel: pipelineParams.get('channel', ''),
                    color: 'warning',
                    message: "${env.JOB_NAME} - #${currentBuild.number} Unstable after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
            }
        }

