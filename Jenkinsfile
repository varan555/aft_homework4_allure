pipeline {
    agent any
    stages {
        stage('Run test') {
            steps {
                withMaven(maven : 'maven_3.6.2') {
                    bat 'mvn clean -Denvironment=opera ' +
                            '-Dcucumber.options="--tags @correct" ' +
                            '-Dtest=CucumberRunner ' +
                            '-DfailIfNoTests=false ' +
                            'test'
                }
                }
            }
        stage('Allure report generation') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
                }
            }
        post {
            always {
                cleanWs notFailBuild: true
            }
        }
    }
}
