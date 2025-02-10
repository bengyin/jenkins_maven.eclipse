pipeline{
	agent any
	tools { 
        maven 'Maven' 
        jdk 'Java JDK 17'
    }
	stages{
		stage("clean"){
			steps{
				echo "Start Clean"
				bat "mvn clean"
			}
		}
		stage("test"){
			steps{
				echo "Start Test"
				bat "mvn test"
			}
		}
		stage("build"){
			steps{
				echo "Start build"
				bat "mvn install -DskipTests"
			}
		}
		stage("SonarQube analysis") {
			steps{
				echo "Start SonarQube"
				withSonarQubeEnv('SonarQube') {
					bat "C:\\Users\\bengy\\SonarQube\\sonar-scanner-cli-7.0.1.4817\\sonar-scanner-7.0.1.4817\\bin\\sonar-scanner.bat -Dsonar.projectKey=maven-project-jenkins-lab -Dsonar.host.url=http://localhost:9000 -Dsonar.exclusions=**/*.java"
				}
			}
		}
	}
} 

