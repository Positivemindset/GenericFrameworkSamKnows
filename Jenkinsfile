node {
    stage ('SCM Checkout'){
    tool name: 'maven', type: 'maven'
    git 'https://github.com/Positivemindset/GenericFrameworkSamKnows'
    }
    stage ('Compile-Package'){
    sh 'mvn clean'
    }
}
