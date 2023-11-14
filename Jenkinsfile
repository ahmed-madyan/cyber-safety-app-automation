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
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    echo 'API Testing..'
                    sudo 'mvn test -DsuiteXmlFile=testng/testng-api.xml'
                }
            }
        }
        stage('Android Testing') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    echo 'Android Testing..'
                    bat 'mvn test -DsuiteXmlFile=testng/testng-android.xml'
                }
            }
        }
        stage('iOS Testing') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    echo 'iOS Testing..'
                    bat 'mvn test -DsuiteXmlFile=testng/testng-ios.xml'
                }
            }
        }
        stage('Extent Report') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    echo '$cd'
                    publishHTML(target: [allowMissing         : false,
                                         alwaysLinkToLastBuild: true,
                                         keepAll              : true,
                                         reportDir            : 'SparkReport',
                                         reportFiles          : 'ExtentReport.html',
                                         reportName  : 'Extent Reports',
                                         reportTitles: 'The Report'])
                }
            }
        }
//        stage('Allure Report') {
//            steps {
//                bat 'cd allure-results'
//                bat 'allure serve allure-results'
//                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
//                publishHTML(target: [allowMissing         : false,
//                                     alwaysLinkToLastBuild: true,
//                                     keepAll              : true,
//                                     reportDir            : 'SparkReport',
//                                     reportFiles          : 'ExtentReport.html',
//                                     reportName           : 'Allure Reports',
//                                     reportTitles         : 'The Report'])
//            }
//        }
    }
}