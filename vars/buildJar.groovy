#!/usr/bin/env groovy

def call() {
  echo "build application for $BRANCH_NAME"
  sh 'mvn package'
}