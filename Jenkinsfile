node {
    stage ('SCM Checkout'){
    git 'https://github.com/Positivemindset/GenericFrameworkSamKnows'
    }
    stage ('Compile-Package'){
    def mvn_home= tool name: 'maven', type: 'maven'
        sh "${mvn_home}/bin/mvn clean"
    }
}
