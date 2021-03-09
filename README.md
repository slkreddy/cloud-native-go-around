# cloud-native-go-around
Gusto exploration around Cloud Native Principles leveraging Kubernetes, Spring-Boot, Istio and other tools 

Project: gusto-sb : a Spring boot application that checks the health of given 'URL'. 
Rest end point:
Example: http://192.168.64.3:30001/heartbeat?url=https://www.google.com
Response: The URL: https://www.google.com is UP; Response Message is OK

Directory structure:

kubernetes-istio
|-- deployment
    |-- gusto-deployment-def.yaml => To fetch the docker image that's built out of gusto-sb from Docker Hub. It creates the deployment with required number of replicas.
|-- service
    |--gusto-service-def.yaml => To create the app as exposable service on the kubernetes cluster. To get the endpoint run this command: minikube service gusto-sb --url



Dockerfile: this creates the docker image in local with required dependencies