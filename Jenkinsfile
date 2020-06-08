pipeline{
    stages {
        stage('build') {
            steps{
                mvn clean -Denvironment=opera -Dcucumber.options="--tags @correct" -Dtest=CucumberRunner -DfailIfNoTests=false test
            }
        }
    }
}