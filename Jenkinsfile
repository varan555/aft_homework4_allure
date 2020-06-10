pipeline {
    agent any

    stages {
        stage('Run test') {
            steps {
                step {def mvnHome = tool name: 'maven-3', type: 'maven'}
     //           withMaven() {
                    step {
                        bat "${mvnHome}/bin/mvn clean -Denvironment=opera " +
                                '-Dcucumber.options="--tags @correct' +
                                "-Dtest=CucumberRunner " +
                                "-DfailIfNoTests=false " +
                                "test"
                    }
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


