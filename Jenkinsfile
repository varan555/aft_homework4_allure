pipeline {
    agent any
    tools {
        maven 'maven_3.6.3'
    }
    stages {
        stage('Run test') {
            steps {

                    script {
                        bat(script: "powershell cmd (mvn clean -Denvironment=opera -Dcucumber.options=\"--tags @correct \" -Dtest=CucumberRunner -DfailIfNoTests=false test)")
                    }
//  //              withMaven(maven: 'maven_3.6.3') {
//                        bat 'mvn clean -Denvironment=opera ' +
//                                '-Dcucumber.options="--tags @correct' +
//                                '-Dtest=CucumberRunner ' +
//                                '-DfailIfNoTests=false ' +
//                                'test'
//                    }
                }
            }
    //    }
        stage('Allure report generation') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
            }
        }
    }
            post {
                always {
                    cleanWs notFailBuild: true
                }
            }
        }


