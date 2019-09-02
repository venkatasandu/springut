pipeline { 
    agent any 
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('clean clone') { 
            steps { 
                sh "git clone https://github.com/venkatasandu/springut.git ."
                sh "mvn clean"
            }
        }
        stage('Test'){
            steps {
                sh "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                sh "mvn package"
            }
        }
    }
}