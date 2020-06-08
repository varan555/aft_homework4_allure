pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean -Denvironment=opera ' +
                            '-Dcucumber.options="--tags @correct" ' +
                            '-Dtest=CucumberRunner ' +
                            '-DfailIfNoTests=false ' +
                            'test'
                }
            }
        }
    }
}