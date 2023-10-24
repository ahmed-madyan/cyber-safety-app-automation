pipeline {
    agent any
//    git credentialsId: 'PAT-Jenkins', url: 'https://github.com/ahmed-madyan/cyber-safety-app-automation.git'
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
                bat 'mvn test -DsuiteXmlFile=testng-api.xml'
            }
        }
        stage('Android Testing') {
            steps {
                echo 'Android Testing..'
//                bat 'mvn test -DsuiteXmlFile=testng-android.xml'
            }
        }
        stage('Extent Report') {
            steps {
                publishHTML(target: [allowMissing         : false,
                                     alwaysLinkToLastBuild: true,
                                     keepAll              : true,
                                     reportDir            : 'reports',
                                     reportFiles          : 'SparkReport/ExtentReport.html',
                                     reportName           : 'My Reports',
                                     reportTitles         : 'The Report'])
            }
        }
    }
}