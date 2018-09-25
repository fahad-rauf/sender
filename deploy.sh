#!/usr/bin/env bash
set -e

mvn package
cp target/sender-*.jar out/
docker build -f Dockerfile -t fahadrauf/sender out/
docker push fahadrauf/sender
kubectl --kubeconfig /Users/fahad/apps/config-devtest-apps187 apply -f src/main/kubernetes -n mock
