#!/usr/bin/env groovy

def call(String imageName) {
  echo "building image..."
  withCredentials([userPassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PWD', usernameVariable: 'USER')]){
    sh "docker build -t $imageName ."
    sh "echo $PWD | docker login -u $USER --password-stdin"
    sh "docker push $imageName"
  }
}