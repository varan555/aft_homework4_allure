node{
    stage('DCM chekout'){
        git 'https://github.com/varan555/aft_homework4_allure'
    }
    stage('Compile'){
        def mvnHome = tool name: 'maven-3', type 'maven'
        bat "${mvnHome}/bin/mvn clean -Denvironment=opera " +
                            '-Dcucumber.options="--tags @correct' +
                            "-Dtest=CucumberRunner " +
                            "-DfailIfNoTests=false " +
                            "test"
    }
}






//pipeline {
//    agent any
//
//    stages {
//        stage('Run test') {
//            steps {
//                def mvnHome = tool name: 'maven-3', type: 'maven'
//                withMaven() {
//                    bat "${mvnHome}/bin/mvn clean -Denvironment=opera " +
//                            '-Dcucumber.options="--tags @correct' +
//                            "-Dtest=CucumberRunner " +
//                            "-DfailIfNoTests=false " +
//                            "test"
//                }
//            }
//        }
//        stage('Allure report generation') {
//            steps {
//                allure includeProperties: false,
//                        jdk: '',
//                        results: [[path: 'target/allure-results']]
//            }
//        }
//    }
//            post {
//                always {
//                    cleanWs notFailBuild: true
//                }
//            }
//        }


