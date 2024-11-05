pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Pull Provar project from your repository
                git 'https://your-repo-url.git'
            }
        }
        stage('Run Provar Tests') {
            steps {
                // Run Provar CLI command to execute tests
                sh 'provar-cli -p /path/to/your/ProvarProject.provar -t TestCasesFolder -r /path/to/output/results'
            }
        }
    }
    post {
        always {
            // Archive test results for review
            archiveArtifacts artifacts: 'path/to/output/results/**', allowEmptyArchive: true
        }
    }
}
