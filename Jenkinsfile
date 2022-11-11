pipeline { 
    environment {
        registry = "mariemglaa/repo"
        registryCredential= 'dockerhub_id'
        dockerImage=''
    }
    agent any;               
    stages {        
        stage('GIT'){            
            steps {                 
                echo 'getting project from Github branch'                 
                git branch: 'MariemGlaaa',  
                url: 'https://github.com/MariemGlaa/SpringDataJPA-CrudRepo.git'
            }
        }         
        stage ('COMPILING'){          
            steps{             
                sh 'mvn clean' 
                sh 'mvn package -DskipTests'
            }      
        }
       
         stage('TEST') {
            steps {
                echo "Test project"
                sh 'mvn test'
              }
        }
        stage ('SONARQUBE'){
            steps{
                echo 'Testing code with sonar'
                sh 'mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes -Dsonar.css.node=.  -Dsonar.host.url=http://localhost:9000  -Dsonar.projectKey=tn.esprit.rh:achat  -Dsonar.login=admin  -Dsonar.password=root'
            }
        }
       
        stage('NEXUS') {
            steps {
                 sh 'mvn deploy -DskipTests'
              }
        }
        stage('BUILD IMAGE') {
                steps {
                    script {
                        dockerImage= docker.build registry + ":$BUILD_NUMBER" 
                    }
                }
            }
        stage('DEPLOYMENT') {
                steps {
                    script {
                    docker.withRegistry( '', registryCredential) {
                     dockerImage.push()
                    }
                }
            }
        }
         stage('CLEAN') {
            steps { 
                sh "docker rmi $registry:$BUILD_NUMBER" 
            }
        }
    }
}
