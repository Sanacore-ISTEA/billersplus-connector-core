pipeline {
  agent any
  stages {
    stage('test') {
      steps {
        sh 'mvn test'
      }
    }

    

    stage('build') {
      steps {
        sh 'mvn package'
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv(installationName: 'sonarqube', credentialsId: 'token-sonarqube') {
          sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=CON_billersplus-connector-core_AYDEZmMKLgNLztso_Anm'
        }

      }
    }

  }
  environment {
    NEXUS_VERSION = 'nexus2'
    NEXUS_PROTOCOL = 'http'
    NEXUS_URL = '192.168.0.137:8081/nexus'
    NEXUS_REPOSITORY = 'releases'
    NEXUS_CREDENTIAL_ID = 'userNexus'
  }
}