pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the application'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing the application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application'
            }
        }
    }

    post{
        always{
            emailext body: 'Summary', subject:'Pipeline Status',to:'hs49017@gmail.com'
        }
    }
}
