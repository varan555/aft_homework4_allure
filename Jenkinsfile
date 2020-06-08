pipeline{
    agent any
    stages {
        stage('build') {
            steps{
                sh 'clean -Denvironment=opera ' +
                        '-Dcucumber.options="--tags @correct" ' +
                        '-Dtest=CucumberRunner ' +
                        '-DfailIfNoTests=false test'
            }
        }
    }
}