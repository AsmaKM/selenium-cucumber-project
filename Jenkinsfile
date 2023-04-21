//Jenkins job

pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/AsmaKawserM/selenium-training-project.git'
                withMaven(maven: 'mymaven'){
                // To run Maven on a Windows agent, use
                bat "mvn test"
                }
            }

           
        }
    }
}
