#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {

  def script

  Docker(script) {
    this.script = script
  }

  def buildDockerImage(String imageName){
    script.echo "building image..."
    script.withCredentials([script.userPassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PWD', usernameVariable: 'USER')]){
      script.sh "docker build -t $imageName ."
      script.sh "echo $script.PWD | docker login -u $script.USER --password-stdin"
      script. sh "docker push $imageName"
    }
  }

}