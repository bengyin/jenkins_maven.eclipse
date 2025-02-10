pipeline{
	agent any
	environment {
		SONAR_RUNNER_HOME = "C:\\Users\\bengy\\SonarQube\\sonar-scanner-cli-7.0.1.4817\\sonar-scanner-7.0.1.4817"
    }
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
		stage("Docker build"){
			steps{
				echo "Start Docker build"
				bat "docker build -t bengyin/jenkins_maven.eclipse:latest ."
			}
		}
		stage("SonarQube analysis") {
			steps{
				echo "Start SonarQube"
				withSonarQubeEnv('SonarQube') {
					bat "${env.SONAR_RUNNER_HOME}\\bin\\sonar-scanner.bat -Dsonar.projectKey=jenkins_maven.eclipse -Dsonar.java.binaries=target/classes"
				}
			}
		}
	}
} 

