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
                echo 'Clean and compile..'
                bat 'mvn clean compile'
            }
        }
        stage('Unit Test') {
            steps {
                bat 'mvn test -Dfile=”testng-api.xml”'
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