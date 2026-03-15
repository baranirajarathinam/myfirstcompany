# Mass Web MVP – Full Stack Application

A simple full-stack MVP demonstrating:

- Angular UI
- Spring Boot WebFlux middleware
- Google Cloud Firestore (Native mode)
- End-to-end User Create & List flow

This project is intentionally kept minimal and easy to extend.

---

## High-Level Architecture

Angular UI (ng serve :4200)  
→ REST / JSON  
→ Spring Boot WebFlux API (:8080)  
→ Firestore SDK  
→ Google Cloud Firestore (Native)

---

## Repository Structure

mass-web-mvp/
- frontend/                 Angular UI
- backend/                  Spring Boot Middleware
- README.md

---

## Technology Stack & Versions

### Frontend (UI)
- Angular 13.4.x
- Angular CLI 13.3.x
- Node.js 14.x or 16.x (recommended for Angular 13)
- RxJS 6.6.x
- TypeScript 4.6.x

### Backend (Middleware)
- Java 17
- Spring Boot 3.2.5
- Spring WebFlux
- Spring Cloud GCP Firestore 5.3.0
- Maven 3.9+

### Database
- Google Cloud Firestore
- Native mode
- Database ID: myfirstfirestore

---

## Prerequisites

### Software
- Java 17
- Maven
- Node.js (14 or 16)
- Angular CLI 13+
- Google Cloud account

### Google Cloud Setup
- Firestore API enabled
- Firestore Native mode
- Firestore database created
- Database ID: myfirstfirestore
- Service account with Firestore User role

---

## Credentials Setup (Local Development)

### Option 1: Environment Variable (Recommended)

set GOOGLE_APPLICATION_CREDENTIALS=backend/src/main/resources/service-account.json

### Option 2: application.properties

spring.cloud.gcp.credentials.location=classpath:service-account.json

NOTE: Never commit service-account.json to Git.

---

## Backend Configuration

backend/src/main/resources/application.properties

server.port=8080  
spring.cloud.gcp.project-id=decoded-pivot-255606  
spring.cloud.gcp.firestore.enabled=true  
spring.cloud.gcp.firestore.database-id=myfirstfirestore  

---

## Start the Middleware (Backend)

cd backend  
mvn clean spring-boot:run  

Backend runs at:  
http://localhost:8080

---

## Start the UI (Frontend)

cd frontend  
npm install  
ng serve  

UI runs at:  
http://localhost:4200

---

## Sample UI Usage

The UI contains:
- Name input
- Email input
- Save button
- List of saved users

User Flow:
1. Open http://localhost:4200
2. Enter Name and Email
3. Click Save
4. User appears immediately in the list
5. Data is persisted in Firestore

---

## Middleware API Endpoints

### Get All Users

Request:
GET /api/users

Response:
[
  {
    "id": "abc123",
    "name": "Barani",
    "email": "barani@test.com"
  }
]

---

### Get User by ID

Request:
GET /api/users/{id}

Response:
{
  "id": "abc123",
  "name": "Barani",
  "email": "barani@test.com"
}

---

### Create User

Request:
POST /api/users  
Content-Type: application/json

{
  "name": "Barani",
  "email": "barani@test.com"
}

Response:
{
  "id": "auto-generated-id",
  "name": "Barani",
  "email": "barani@test.com"
}

---

## CORS Configuration

Backend allows Angular dev server:

@CrossOrigin(origins = "http://localhost:4200")

---

## Common Issues & Fixes

- 415 Unsupported Media Type  
  Ensure Content-Type: application/json

- Firestore NOT_FOUND  
  Ensure database exists and database-id is correct

- Permission Denied  
  Ensure Firestore API is enabled and service account has correct role

---

## Suggested Enhancements

- Upgrade Angular to 17+
- Move API URLs to environment.ts
- Add Update and Delete APIs
- Add authentication (JWT / Firebase Auth)
- Use Firestore Emulator for local dev
- Dockerize frontend and backend
- Deploy to GCP or Firebase Hosting

---

## Author

Mass Web MVP  
A clean, scalable full-stack starter template.

---

## License

MIT
Step 0 — Prerequisites (run once locally)

# Command for reference
## any terminal in the vs code to setup the gcp coud project with local

PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp> cd .\cloud\
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> dir
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> ls 
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud init
Welcome! This command will take you through the configuration of gcloud.

Settings from your current configuration [myfirstproj] are:
accessibility:
  screen_reader: 'True'
core:
  account: baranitestproject@test.com
  disable_usage_reporting: 'False'
  project: able-analyst-258805

Pick configuration to use:
 [1] Re-initialize this configuration [myfirstproj] with new settings 
 [2] Create a new configuration
 [3] Switch to and re-initialize existing configuration: [default]
Please enter your numeric choice:  3

Your current configuration has been set to: [default]

You can skip diagnostics next time by using the following flag:
  gcloud init --skip-diagnostics

Network diagnostic detects and fixes local network connection issues.
Checking network connection...done.
Reachability Check passed.
Network diagnostic passed (1/1 checks passed).

Choose the account you want to use for this configuration.
To use a federated user account, exit this command and sign in to the gcloud CLI with your login configuration file,
 then run this command again.

Select an account:
 [1] baranitestproject@test.com
 [2] Sign in with a new Google Account
 [3] Skip this step
Please enter your numeric choice:  1

You are signed in as: [baranitestproject@test.com].

Pick cloud project to use: 
 [1] able-analyst-258805
 [2] decoded-pivot-255606
 [3] psyched-hook-258503
 [4] Enter a project ID
 [5] Create a new project
Please enter numeric choice or text value (must exactly match list item):  2

Your current project has been set to: [decoded-pivot-255606].

Not setting default zone/region (this feature makes it easier to use
[gcloud compute] by setting an appropriate default value for the
--zone and --region flag).
See https://cloud.google.com/compute/docs/gcloud-compute section on how to set
default compute region and zone manually. If you would like [gcloud init] to be
able to do this for you the next time you run it, make sure the
Compute Engine API is enabled for your project on the
https://console.developers.google.com/apis page.

Error creating a default .boto configuration file. Please run [gsutil config -n] if you would like to create this file.
The Google Cloud CLI is configured and ready to use!

* Commands that require authentication will use baranitestproject@test.com by default
* Commands will reference project `decoded-pivot-255606` by default
Run `gcloud help config` to learn how to change individual settings

This gcloud configuration is called [default]. You can create additional configurations if you work with multiple accounts and/or projects.
Run `gcloud topic configurations` to learn more.

Some things to try next:

* Run `gcloud --help` to see the Cloud Platform services you can interact with. And run `gcloud help COMMAND` to get help on any gcloud command.
* Run `gcloud topic --help` to learn about advanced features of the CLI like arg files and output formatting        
* Run `gcloud cheat-sheet` to see a roster of go-to `gcloud` commands.


Updates are available for some Google Cloud CLI components.  To install them,
please run:
  $ gcloud components update



To take a quick anonymous survey, run:
  $ gcloud survey


## There should be a active billing account in GCP to run the cloud, make sure it is enabled.
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud services enable run.googleapis.com
ERROR: (gcloud.services.enable) FAILED_PRECONDITION: Billing account for project '468386309267' is not open. Billing must be enabled for activation of service(s) 'run.googleapis.com,artifactregistry.googleapis.com,containerregistry.googleapis.com' to proceed.
Help Token: AerXPhWOay8hK9kERO2aM9H3QM4H5cAfhBPqXjEFmrsLxFlVEfAHtQTk9hfmU8fpL0KmvRL2X4q_2x6jRgXYblai1WBVDRI8CanBZ0egswM2OgfQ
- '@type': type.googleapis.com/google.rpc.PreconditionFailure
  violations:
  - subject: ?error_code=390002&project=468386309267&services=run.googleapis.com&services=artifactregistry.googleapis.com&services=containerregistry.googleapis.com
    type: googleapis.com/billing-enabled
- '@type': type.googleapis.com/google.rpc.ErrorInfo
  domain: serviceusage.googleapis.com/billing-enabled
  metadata:
    project: '468386309267'
    services: run.googleapis.com,artifactregistry.googleapis.com,containerregistry.googleapis.com
  reason: UREQ_PROJECT_BILLING_NOT_OPEN
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud services enable run.googleapis.com
ERROR: (gcloud.services.enable) FAILED_PRECONDITION: Billing account for project '468386309267' is not open. Billing must be enabled for activation of service(s) 'run.googleapis.com,artifactregistry.googleapis.com,containerregistry.googleapis.com' to proceed.
Help Token: AerXPhVC2vQJb7xc35Z-i5WwVtVhJHYMG1DVlEfLlOfJOu1PD8kiNPHktnN-mpqzVWzFEHkeBhYoek4kcCfHPqBgm08DkfDQFgcd_4ckf_ua2xxG
- '@type': type.googleapis.com/google.rpc.PreconditionFailure
  violations:
  - subject: ?error_code=390002&project=468386309267&services=run.googleapis.com&services=artifactregistry.googleapis.com&services=containerregistry.googleapis.com
    type: googleapis.com/billing-enabled
- '@type': type.googleapis.com/google.rpc.ErrorInfo
  domain: serviceusage.googleapis.com/billing-enabled
  metadata:
    project: '468386309267'
    services: run.googleapis.com,artifactregistry.googleapis.com,containerregistry.googleapis.com
  reason: UREQ_PROJECT_BILLING_NOT_OPEN
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud services enable run.googleapis.com
ERROR: (gcloud.services.enable) FAILED_PRECONDITION: Billing account for project '468386309267' is not open. Billing must be enabled for activation of service(s) 'run.googleapis.com,artifactregistry.googleapis.com,containerregistry.googleapis.com' to proceed.
Help Token: AerXPhUvLh34iFJJ7VGMZMNWjMMTITQ1tOJUWcqYoNUJIudm6kNBORD2vhwg9V-eLwvIWI4l2CRFvUEXxxwD4e_l-cPYdIGjpdBAWdQq6eluB_N0
- '@type': type.googleapis.com/google.rpc.PreconditionFailure
  violations:
  - subject: ?error_code=390002&project=468386309267&services=run.googleapis.com&services=artifactregistry.googleapis.com&services=containerregistry.googleapis.com
    type: googleapis.com/billing-enabled
- '@type': type.googleapis.com/google.rpc.ErrorInfo
  domain: serviceusage.googleapis.com/billing-enabled
  metadata:
    project: '468386309267'
    services: run.googleapis.com,artifactregistry.googleapis.com,containerregistry.googleapis.com
  reason: UREQ_PROJECT_BILLING_NOT_OPEN
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud config get-value project
decoded-pivot-255606
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud config get-value project^C
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud beta billing projects describe decoded-pivot-255606
billingAccountName: billingAccounts/014BFC-1D63C7-ED1B43
billingEnabled: false
name: projects/decoded-pivot-255606/billingInfo
projectId: decoded-pivot-255606
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud beta billing accounts list
ACCOUNT_ID: 013882-7F5DF6-8FEEF6
NAME: My Billing Account
OPEN: False
MASTER_ACCOUNT_ID:

ACCOUNT_ID: 014BFC-1D63C7-ED1B43
NAME: My Billing Account
OPEN: False
MASTER_ACCOUNT_ID:
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud services enable run.googleapis.com        
ERROR: (gcloud.services.enable) FAILED_PRECONDITION: Billing account for project '468386309267' is not open. Billing must be enabled for activation of service(s) 'run.googleapis.com,artifactregistry.googleapis.com,containerregistry.googleapis.com' to proceed.
Help Token: AerXPhVdaQuA9xhgtHzTtlibRx2UMjH4sqpc2r-ligCoLOSfJCMJ1c8j76NWxYvzSVrB8GRvq-mWn4sXaQvOqtqTEWtVmepOmlDBIlAz8CaQx77K
- '@type': type.googleapis.com/google.rpc.PreconditionFailure
  violations:
  - subject: ?error_code=390002&project=468386309267&services=run.googleapis.com&services=artifactregistry.googleapis.com&services=containerregistry.googleapis.com
    type: googleapis.com/billing-enabled
- '@type': type.googleapis.com/google.rpc.ErrorInfo
  domain: serviceusage.googleapis.com/billing-enabled
  metadata:
    project: '468386309267'
    services: run.googleapis.com,artifactregistry.googleapis.com,containerregistry.googleapis.com
  reason: UREQ_PROJECT_BILLING_NOT_OPEN


## this command is to enable to cloud run service for the code, since it is run on a empty folder it would throw the error so need to run on backend folder
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud services enable run.googleapis.com
Operation "operations/acf.p2-468386309267-f96b5935-5b5f-41de-9bd1-bc3379220142" finished successfully.
PS D:\projects\realtime-project\forms-help-gov\mass-web-mvp\cloud> gcloud services enable cloudbuild.googleapis.com
Operation "operations/acf.p2-468386309267-90ea6bea-557c-4fcd-96cc-65dc8b6d9108" finished successfully.

##  if you fix something in backend the follow below to build and deploy the backend

# make change to the necessary file
D:\projects\realtime-project\forms-help-gov\mass-web-mvp\backend>mvn clean package
gcloud run deploy mass-api --source . --region asia-south1 --allow-unauthenticated


## UI

# first time build deployment - run it on powershell or terminal with admin mode

 gsutil mb -l asia-south1 gs://mass-web-ui
 gsutil iam ch allUsers:objectViewer gs://mass-web-ui
 gsutil web set -m index.html -e index.html gs://mass-web-ui


##  if you fix something in frontend the follow below to build and deploy the frontend

D:\projects\realtime-project\forms-help-gov\mass-web-mvp\backend> cd ..\frontend\
ng build --configuration production --base-href https://storage.googleapis.com/mass-web-ui/
gsutil -m rsync -r dist/frontend gs://mass-web-ui