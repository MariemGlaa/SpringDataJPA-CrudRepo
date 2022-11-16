pipeline{
    agent any;
    stages {
        stage('GIT'){
            steps {
                echo 'getting project from Github '
                git branch: 'main',  url: 'https://github.com/MariemGlaa/SpringDataJPA-CrudRepo.git'
            }
        }
        stage ('MVN CLEAN'){
            steps{ 
            sh 'mvn clean'
             }
        }
        stage('MVN COMPILE') {
            steps {
                
                 sh 'mvn package -DskipTests'
              }
        }
        stage ('sonar'){
            steps{
                echo 'Testing code with sonar'
               sh 'mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes -Dsonar.css.node=.  -Dsonar.host.url=http://192.168.1.13:9000  -Dsonar.projectKey=tn.esprit.rh:achat  -Dsonar.login=admin  -Dsonar.password=jenkins'
            }
            
        }
        stage('NEXUS') {
            steps {
                
                 sh 'mvn deploy -DskipTests'
              }
        }
            
        }
}
