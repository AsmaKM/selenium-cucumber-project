//Jenkins job

pipeline {
    agent any
    stages {
        stage('Build') {
            
            steps {
                
                // Get some code from a GitHub repository
                 git branch: 'main', url: 'https://github.com/AsmaKawserM/selenium-training-project.git'
                withMaven(maven: 'mymaven'){
                    
                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
                }
            }

           
        }
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
