//Jenkins job

pipeline {
    agent any
    tools {
        // Install the Maven version and add it to the path.
        maven "mymaven"
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/AsmaKawserM/selenium-training-project.git'
                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

           
        }
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/AsmaKawserM/selenium-training-project.git'

                // To run Maven on a Windows agent, use
                bat "mvn test"
            }

           
        }
    }
}
