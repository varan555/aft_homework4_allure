  
node{
    stage('SCM chekout'){
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
