## Building and running the sample using the command line

### Clone Git Repo
:pushpin: [Switch to Eclipse example](/docs/Using-WDT.md/#clone-git-repo)

```bash

$ git clone https://github.com/WASdev/sample.microservices.12factorapp.git

```

### Building the sample
:pushpin: [Switch to Eclipse example](/docs/Using-WDT.md/#building-the-sample-in-eclipse)

This sample can be built using either [Gradle](#gradle-commands) or [Maven](#maven-commands).

###### [Gradle](http://gradle.org/) commands

The build will pull down a copy of Liberty, build the sample and produce a packaged liberty server that can be run locally or pushed up to Bluemix.

```bash
$ gradle build publishToMavenLocal
```

To run the tests against a local Liberty install, [download WAS Liberty](/docs/Downloading-WAS-Liberty.md) and update the build.gradle file to point to your install. See [ci.gradle](https://github.com/WASdev/ci.gradle#installliberty-task) for more details.

###### [Apache Maven](http://maven.apache.org/) commands

By default, maven will build the sample, run both unit and integration tests and produce a packaged Liberty server with application inside. It will also download a Liberty install to run the integration tests against.

```bash
$ mvn install
```
To run the tests against a local Liberty install, [download WAS Liberty](/docs/Downloading-WAS-Liberty.md) and update the pom.xml file to point to your install. See [ci.maven](https://github.com/WASdev/ci.maven/blob/master/docs/install-server.md#install-server) for more details.

### Running the application locally
:pushpin: [Switch to Eclipse example](/docs/Using-WDT.md/#running-the-application-locally)

Pre-requisite: [Create and configure a Cloudant database](/docs/Creating-Cloudant-database.md). Make sure you have set the system environment variables 'dbUsername', 'dbPassword' and 'dbUrl' then you are ready to run your application.

Use the following to start the server and run the application:

###### [Gradle](http://gradle.org/) commands
```bash
$ gradle libertyStart
```

###### [Apache Maven](http://maven.apache.org/) commands
```bash
$ mvn liberty:run-server
```

### Deploying to Bluemix using the command line
:pushpin: [Switch to Eclipse example](/docs/Using-WDT.md/#deploying-to-bluemix-using-eclipse)

First you will need to download the [Cloud Foundry command line interface][cloudfoundry], this can be used to deploy and manage applications on Bluemix. Next we need to configure the environment variables that will specify the credentials of Cloudant. (If you haven't created a Cloudant database yet see ['Creating a Cloudant database'](/docs/Creating-Cloudant-database.md).) These can be added to the application after it is deployed or by providing a manifest.yml file. Create a manifest.yml file using the following template:

```text
---
env:
   dbUsername: <Cloudant 'username' credential>
   dbPassword: <Cloudant 'password' credential>
   dbUrl: <Cloudant 'url' credential>
```

Then we simply push the zip file containing our packaged server to Bluemix.

```bash
$ \path\to\12-factor-application\build\libs> cf push <appName> -p 12FactorApp.zip -f \path\to\manifest.yml
```

Bluemix will use the manifest.yml file we provided as long as it is in the same directory as the zip we are pushing and will add the environment variables to our application.
[cloudfoundry]: https://www.ng.bluemix.net/docs/starters/install_cli.html
