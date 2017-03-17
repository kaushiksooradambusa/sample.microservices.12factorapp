## Eclipse / WDT

The WebSphere Development Tools (WDT) for Eclipse can be used to control the server (start/stop/dump etc.). The tools also support incremental publishing with minimal restarts and works with a debugger to allow you to step through your applications plus many more features including:

* content-assist for server configuration (server configuration is minimal but the tools can help you find what you need)
* automatic incremental publish of applications so that changes can be written and tested locally without doing a build/publish cycle or restarting the server (the server does restart nice and quickly but it's still nice not being forced to do it!)

Installing WDT on Eclipse is a simple drag and drop process as explained on [wasdev.net][wasdev-wdt].

[wasdev-wdt]: https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/

#### Clone Git Repo
:pushpin: [Switch to cmd line example](/docs/Using-cmd-line.md/#clone-git-repo)

If the sample git repository hasn't been cloned yet, WDT has git tools integrated into the IDE:

1.  Open the Git repositories view
    * *Window -> Show View -> Other*
    * Type "git" in the filter box, and select *Git Repositories*
2.  Copy Git repo url by finding the textbox under "HTTPS clone URL" at the top of this page, and select *Copy to clipboard*
3.  In the Git repositories view, select the hyperlink `Clone a Git repository`
4.  The git repo url should already be filled in.  Select *Next -> Next -> Finish*
5.  The "sample.microservices.12factorapp [master]" repo should appear in the view

### Building the sample in Eclipse
:pushpin: [Switch to cmd line example](/docs/Using-cmd-line.md/#building-the-sample)

This sample can be built using either [Gradle](#building-with-gradle) or [Maven](#building-with-maven).

#### Building with [Gradle](http://gradle.org/)

###### Import Gradle projects into WDT

This assumes you have the Gradle [Buildship](https://projects.eclipse.org/projects/tools.buildship) tools installed into Eclipse Mars.

1. In the Git Repository view, expand the 12factorapp repo to see the "Working Directory" folder
2. Right-click on this folder, and select *Copy path to Clipboard*
3. Select menu *File -> Import -> Gradle -> Gradle Project*
4. In the *Project root directory* folder textbox, Paste in the repository directory.
5. Click *Next* twice
6. One project should be listed in the *Gradle project structure* click *Finish*
7. This will create a project in Eclipse called net.wasdev.wlp.sample.12-factor-application
8. Go to the *Gradle Tasks* view in Eclipse and navigate to the *net.wasdev.wlp.sample.12-factor-application* project
9. Double click on the *eclipse* task to generate all the Eclipse files
10. In the *Enterprise Explorer* view in Eclipse right click on your project and click refresh

:star: *Note:* If you did not use Eclipse/WDT to clone the git repository, follow from step 3, but navigate to the cloned repository directory rather than pasting its name in step 4.

###### Run Gradle build

1. Right-click on build.gradle
2. *Run As > Gradle Build...*
3. In the *Gradle Tasks* section enter "build"
4. Click *Run*

#### Building with [Maven](http://maven.apache.org/)

###### Import Maven projects into WDT

1. In the Git Repository view, expand the 12factorapp repo to see the "Working Directory" folder
2. Right-click on this folder, and select *Copy path to Clipboard*
3. Select menu *File -> Import -> Maven -> Existing Maven Projects*
4. In the Root Directory textbox, Paste in the repository directory
5. Select *Browse..." button and select *Finish* (confirm it finds a pom.xml file)
6. This will create a project in Eclipse called net.wasdev.wlp.sample.12-factor-application

:star: *Note:* If you did not use Eclipse/WDT to clone the git repository, follow from step 3, but navigate to the cloned repository directory rather than pasting its name.

###### Run Maven install

1. Right-click on pom.xml
2. *Run As > Maven build...*
3. In the *Goals* section enter "install"
4. Click *Run*
