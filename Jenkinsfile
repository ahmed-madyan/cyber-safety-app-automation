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
                bat 'mvn test -Dfile=”testng-api.xml”'
            }
            post {

                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    publishHTML([
                            allowMissing          : false,
                            alwaysLinkToLastBuild : false,
                            keepAll               : false,
                            reportDir             : 'Reports',
                            reportFiles           : 'Spark.html',
                            reportName            : 'ExtentReport',
                            reportTitles          : '',
                            useWrapperFileDirectly: true])
                }
            }
        }
        stage('Android Testing') {
            steps {
                echo 'Android Testing..'
                bat 'mvn test -Dfile=”testng-api.xml”'
            }
            post {

                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    publishHTML([
                            allowMissing          : false,
                            alwaysLinkToLastBuild : false,
                            keepAll               : false,
                            reportDir             : 'Reports',
                            reportFiles           : 'Spark.html',
                            reportName            : 'ExtentReport',
                            reportTitles          : '',
                            useWrapperFileDirectly: true])
                }
            }
        }
    }
}