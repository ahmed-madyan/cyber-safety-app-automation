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
                sh 'mvn clean compile'
            }
        }
        stage('API Testing') {
            steps {
                echo 'API Testing..'
               sh 'mvn test -DsuiteXmlFile=testng-api.xml'
            }
        }
        stage('Android Testing') {
            steps {
                echo 'Android Testing..'
//                sudo 'mvn test -DsuiteXmlFile=testng-android.xml'
            }
        }
        stage('Extent Report') {
            steps {
                echo '$cd'
            //    publishHTML(target: [allowMissing         : false,
           //                          alwaysLinkToLastBuild: true,
              //                       keepAll              : true,
              //                       reportDir            : 'SparkReport',
              //                       reportFiles          : 'ExtentReport.html',
              //                       reportName           : 'My Reports',
               //                      reportTitles         : 'The Report'])
           }
        }
    }
}