
pipeline {
    agent any

    environment {
        IMAGE_NAME = 'toktarbay-adilet-student-api'
        IMAGE_TAG = 'v1.0-toktarbay-adilet'
        STUDENT_NAME = 'Adilet Toktarbay'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checkout for ${STUDENT_NAME}"
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building project for ${STUDENT_NAME}"
                sh 'chmod +x gradlew'
                sh './gradlew clean compileJava'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests for ${STUDENT_NAME}"
                sh './gradlew test'
            }
        }

        stage('Docker Build') {
            steps {
                echo "Building Docker image for ${STUDENT_NAME}"
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('Verify') {
            steps {
                echo "Verifying Docker image for ${STUDENT_NAME}"
                sh 'docker image inspect $IMAGE_NAME:$IMAGE_TAG --format "{{.Id}}"'
            }
        }
    }

    post {
        success {
            echo "SUCCESS: Pipeline completed for ${STUDENT_NAME}"
        }

        failure {
            echo "FAILED: Pipeline failed for ${STUDENT_NAME}"
        }
    }
}
