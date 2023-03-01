#!/usr/bin/env groovy

def call() {
  echo "building image..."
  withCredentials([userPassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PWD', usernameVariable: 'USER')]){
    sh "docker build -t pedroalves23/demo-app:1.0"
    sh "echo $PWD | docker login -u $USER --password-stdin"
    sh "docker push pedroalves23/demo-app:1.0"
  }
}