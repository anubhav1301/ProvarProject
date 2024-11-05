pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Pull Provar project from your repository
                git 'https://github.com/anubhav1301/ProvarProject.git'
            }
        }
        stage('Run Provar Tests') {
    steps {
        // Run Provar CLI command to execute tests with corrected path
        sh 'provar-cli -p C:/Users/anubhav.sharma/Provar/PPProject/Anubhav -t C:/Users/anubhav.sharma/Provar/PPProject/Anubhav/tests -r C:/Users/anubhav.sharma/Provar/PPProject/Anubhav/ANT/Results'
    }
}
    }
    post {
        always {
            // Archive test results for review
            archiveArtifacts artifacts: 'test-results/**', allowEmptyArchive: true
        }
    }
}
