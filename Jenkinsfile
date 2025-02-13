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
/*			steps{
				echo "Start SonarQube"
				withSonarQubeEnv('SonarQube') {
					bat "${env.SONAR_RUNNER_HOME}\\bin\\sonar-scanner.bat -Dsonar.projectKey=jenkins_maven.eclipse -Dsonar.java.binaries=target/classes"
				}
			}
		} */
			steps {
				script {
/*					def scannerHome = tool 'sonarqube_scanner' */

                    // Prepare SonarQube environment
					def sonarProperties = """
						sonar.projectKey=maven-project-jenkins-lab2
						sonar.projectName=maven-project-jenkins-lab2-name
						sonar.projectVersion=1.0
						sonar.sources=src/main
						sonar.sourceEncoding=UTF-8
						sonar.language=java
                        
						sonar.tests=src/test
						sonar.junit.reportsPath=target/surefire-reports
						sonar.surefire.reportsPath=target/surefire-reports
						sonar.jacoco.reportPath=target/jacoco.exec
                        
						sonar.java.binaries=target/classes
						sonar.java.coveragePlugin=jacoco
					"""

                    // Create sonar-project.properties file
					writeFile file: 'sonar-project.properties', text: sonarProperties

                    // Run SonarQube scan using the properties file
                    withSonarQubeEnv('SonarQube') {
                    	bat "${env.SONAR_RUNNER_HOME}\\bin\\sonar-scanner.bat -Dproject.settings=sonar-project.properties"
                	}
                }
            }
        }
	}
} 

