#!/usr/bin/env groovy

def call() {
  echo "build application"
  sh 'mvn package'
}