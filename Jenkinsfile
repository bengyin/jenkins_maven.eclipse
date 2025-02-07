pipeline{
	agent any
	tools { 
        maven 'Maven' 
        jdk 'Java JDK 17' 
    }
	stages{
		stage("clean"){
			steps{
				echo "Start Clean again"
				bat "mvn clean"
			}
		}
		stage("test"){
			steps{
				echo "Start Test again"
				bat "mvn test"
			}
		}
		stage("build"){
			steps{
				echo "Start build again"
				bat "mvn install -DskipTests"
			}
		}
	}
} 
