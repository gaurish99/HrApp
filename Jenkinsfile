pipeline {
    agent any
    triggers { pollSCM('* * * * *')}
    stages {
        stage('Build') { 
            steps {
                git url:"https://github.com/gaurish99/HrApp.git", branch:"main"
                bat 'mvnw.cmd clean package' 
            }
        }
    }
}