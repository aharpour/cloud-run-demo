#!/usr/bin/env bash
gcloud beta run services replace --platform=managed --region=europe-west4 knative-service.yaml
