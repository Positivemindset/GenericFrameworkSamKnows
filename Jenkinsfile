node {
    stage ('SCM Checkout'){
    git 'https://github.com/Positivemindset/GenericFrameworkSamKnows'
    }
    stage ('Compile-Package'){
    sh 'mvn clean'
    }
}
