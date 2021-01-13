#!/usr/bin/env bash

set -e
hash=$(git log -1 --format="%H"| cut -c -7)
docker push "gcr.io/PROJECT_ID/demo:native-${hash}"

export hash="${hash}"
envsubst < knative-service.yaml >> service.yaml
gcloud beta run services replace --platform=managed --region=europe-west4 service.yaml
rm service.yaml
