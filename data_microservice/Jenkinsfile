pipeline {
  agent any
  environment {
    BRANCH = "${env.BRANCH_NAME}"
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        sh './mvnw clean package -DskipTests'
      }
    }
    stage('Test') {
      steps {
        sh './mvnw test'
      }
    }
    stage('Security Scan') {
      steps {
        dependencyCheck additionalArguments: '--scan ./target'
      }
    }
    stage('Docker Build') {
      steps {
        sh 'docker build -t backend-admin:${BRANCH} .'
      }
    }
    stage('Push Docker (main only)') {
      when {
        branch 'main'
      }
      steps {
        sh 'docker tag backend-admin:main tuusuario/backend-admin:latest'
        sh 'docker push tuusuario/backend-admin:latest'
      }
    }
  }
}
