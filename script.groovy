def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-user', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t anuragjha1411/anurag:anurag-erd .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push anuragjha1411/anurag:anurag-erd'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
