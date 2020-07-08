node {
    stage ('SCM Checkout'){
    git 'https://github.com/Positivemindset/GenericFrameworkSamKnows'
    }
    
    stage ('Compile-Package'){
    def mvn_home= tool name: 'maven', type: 'maven'
        sh "${mvn_home}/bin/mvn clean"
    }
    
    stage ('Email Notification'){
     mail bcc: '', body: 'Build is run ', cc: '', from: '', replyTo: '', subject: 'Jenkins Build', to: 'harsha.evuri2@gmail.com'
    }
}
