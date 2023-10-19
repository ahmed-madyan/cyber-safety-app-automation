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
        stage('API Testing') {
            steps {
                echo 'API Testing..'
                bat 'mvn test -Dfile=testng-api.xml'
            }
        }
        stage('Android Testing') {
            steps {
                echo 'Android Testing..'
                bat 'mvn test -Dfile=testng-android.xml'
            }
        }
    }
}