pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Unit Test') {
            steps {
                echo 'Building..'
            }
        }
        stage('Integration Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('FrontEnd Test') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}