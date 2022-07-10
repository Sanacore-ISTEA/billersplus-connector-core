pipeline { 
agent any 
stages { 

    stage('Test'){
      steps{
        sh 'mvn test'
      }
    }
    stage('package') {
      steps {
        sh 'mvn package'
      }
    }
stage('Build'){ 
steps{ 
configFileProvider([configFile(fileId: 'e8318da6-536c-48ed-a6e5-50cf933db266', variable: 'MAVEN_SETTINGS_XML')]) { 
sh 'mvn -U clean deploy -s $MAVEN_SETTINGS_XML' 
} 
} 
} 
} 
}
