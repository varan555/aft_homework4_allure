pipeline {
    agent any
    tools {
        maven 'maven_3.5.4'
    }

    stages {
        node{
            stage ('Build') {

                git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'

                withMaven(
                        maven: 'maven-3',
                        mavenSettingsConfig: 'my-maven-settings') {
                    sh "mvn clean verify"
                }
            }
        }

        stage('Run test') {
            steps {
                withMaven(maven: 'maven_3.5.4') {
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
    }
            post {
                always {
                    cleanWs notFailBuild: true
                }
            }
        }


