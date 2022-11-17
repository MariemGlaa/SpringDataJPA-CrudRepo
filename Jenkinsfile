pipeline{
    environment { 
        registry = "ligo05/achat" 
        registryCredential ='dockerhubtoken' 
        dockerImage ='' 
    }
    agent any;
    stages {
        stage('GIT'){
            steps {
                echo 'getting project from Github '
                git branch: 'LiliaGossa',  url: 'https://github.com/MariemGlaa/SpringDataJPA-CrudRepo.git'
            }
        }
        stage('MVN COMPILE') {
            steps {
                
                 sh 'mvn package -DskipTests'
              }
        }
        stage('TEST') {
            steps {
                 echo "Test project"
                sh 'mvn test'
              }
        }
        stage('SonarQube'){
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
        stage('NEXUS') {
            steps {
                 sh 'mvn deploy -DskipTests'
              }
        }
        stage('building Docker image'){
            steps{
                script{
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            }
        }
        stage('push image'){
            steps{
                script{
                    docker.withRegistry( '', registryCredential ){
                        dockerImage.push("${env.BUILD_NUMBER}")
                    }
                }
            }
        }
        stage('Docker compose') {
            steps {
                 sh 'docker-compose up'
              }
        }

        }
}
