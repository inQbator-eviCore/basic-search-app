# Simple Patient Search Starter Project

This is a simple search application over a set of patient records.
You can clone this repo or provision an instant dev environment via http://beta.codenvy.com/f?id=qu9bnf9n1h40whho

## Your Mission

In src/main/java you'll find the starter backend code and in src/main/webapp you'll find the start UI code.
If you start up the application, you'll see a basic search application. It's a simple ember app that hits
an endpoint in src/main/java/com/qpidhealth/qpid/search/services/PatientService.

Take 30 minutes to an hour and implement some basic improvements to this application, this can include

 * Making the code cleaner using better object-oriented design, etc.
 * Making the PatientService actually filter the patient records and documents as part of the response
 * Improving the result rendering in the UI with styled snippets and highlighting
 * Updating the search interface to debounce calls to the backend
 * Improving the patient and document data models
 * Anything else your creativity can dream up, bonus points for something fresh and unexpected

After you are done, right click the src folder and download it. 
Email the final code to michael.barrett@qpidhealth.com

Good Luck!

## Running the application

From Codenvy you can use the build and run command at the top of the development environment.

Otherwise, everything ready-to-run with a simple `maven clean install tomee:run`
