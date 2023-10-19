pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }
    options {
        skipStagesAfterUnstable()
    }
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