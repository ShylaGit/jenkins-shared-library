def call(Map pipelineParams) {
    if ( buildResult == "SUCCESS" ) {
        slackSend channel: pipelineParams.get('channel', ''),
                    color: 'good',
                    message: "${env.JOB_NAME} - #${currentBuild.number} Success after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
    }
    if ( buildResult == "FAILURE" ) {
        slackSend channel: pipelineParams.get('channel', ''),
                    color: 'danger',
                    message: "${env.JOB_NAME} - #${currentBuild.number} Success after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
    }
    if ( buildResult == "UNSTABLE" ) {
        slackSend channel: pipelineParams.get('channel', ''),
                    color: 'warning',
                    message: "${env.JOB_NAME} - #${currentBuild.number} Success after ${currentBuild.durationString.replace(' and counting', '')} (<${currentBuild.absoluteUrl}|Open>)${isPR ? "\nGitHub Pull Request Build #${env.CHANGE_ID} from ${env.CHANGE_AUTHOR}" : ''}"
    }
}
