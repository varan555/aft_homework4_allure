pipeline {
    agent any
    tools {
        maven 'maven_3.6.3'
        jdk 'jdk8'
    }
    stages {
        stage('build') {
            steps {
                       sh 'mvn clean -Denvironment=opera ' +
                            '-Dcucumber.options="--tags @correct" ' +
                            '-Dtest=CucumberRunner ' +
                            '-DfailIfNoTests=false ' +
                            'test'
                }
            }
        }
    }
