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



kubernetes commands:
1. To start the minikube
(base) LaxmiKumars-Air:~ laxmikumar$ minikube start

2. To start the minikube dashboard (optional)
(base) LaxmiKumars-Air:~ laxmikumar$ minikube dashboard

3. To deploy the app into pod (make sure the defs dir exists and to copy the the yaml file into it)
(base) LaxmiKumars-Air:~ laxmikumar$ kubectl create -f defs/gusto-deloyment-def.yaml

4. To expose the app as accessible endpoint (make sure the defs dir exists and to copy the the yaml file into it)
(base) LaxmiKumars-Air:~ laxmikumar$ kubectl create -f defs/service-def.yaml

5. To know the exact endpoint to access the api
(base) LaxmiKumars-Air:~ minikube service gusto-sb --url

6. To see the logs of the pod
(base) LaxmiKumars-Air:~ kubectl get pod
Copy the name of the pod
(base) LaxmiKumars-Air:~ kubectl logs <Name of the pod>

