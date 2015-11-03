Development Manual
=======

##Introduction:

This manual shows what is necessary and explanations on how to get the project TicTacToe and how to build on a fresh machine.

##TicTacToe - Snidgengid
An account on GitHub is needed to access the organization Snidgengid and the repository tictactoe. As well as the developer needs to get access to the repositories chat room on gitter.im.

### Organization and Repositories
- [Organization account](https://github.com/Snidgengid)
- [Repository](https://github.com/Snidgengid/tictactoe)

### Collaboration and communication
- [TicTacToe Gitter.im chat room](https://gitter.im/Snidgengid/tictactoe)

Gradle is used for the build process.

On local host the following need to be installed and running.
- [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Redis](http://redis.io/) or  ```sudo apt-get install redis-server ```
- [Git Client](https://www.github.com)

##Development tools, frameworks and services

**Git - GitHub:** Source control and versioning system. We have an organization on GitHub and a repository for the game.

**Gradle:** Build automation system to simplify the build process, run unit, integration and end-to-end tests.

**Jococo:** Locally available code coverage reports.

**Travis:** Continuous Integration and Deployment service. Runs after each commit to GitHub. If build and test succeed may be deployd to Heroku (Dependent on branch).

**Heroku:** Production and development environment to run the application.

**Redis:** Key/Value Database.

**Codecov:** Tests for code coverage of unit tests on code for all commits to github. Restults and history are available online.

**gitter.im:** Communication between the members of the group and notifications of travis build failures/successes and GitHub activity.

**checkstyle** Implemented in build.gradle, checkstyle performs quality check on code and generates report in every build. The checkstyle configuration document can be found at ~/tictactoe/checkstyle/checkstyle.xml. Reports can be found ~/tictactoe/build/reports/checkstyle/main.xml are generated after each build.

**findbugs** Implemented in build.gradle, findbugs is a program which uses static analysis to look for bugs in Java code. Configuration document can be found at ~/tictactoe/findbugs/includeFilter.xml. Reports can be found at ~/tictactoe/build/reports/findbugs/main.xml and are generated after each build.

##Get going
Clone our repo and build and run tictactoe on your machine, or develop. 
 ```
 git clone https://github.com/Snidgengid/tictactoe.git
 cd tictactoe
 git checkout master #If that's what you want
 ./gradlew build
 ./gradlew run
 #Browse to http://localhost:4567
 ```
##Continuous Integration pipeline
![](https://github.com/Snidgengid/tictactoe/blob/dev/images/flowchart2.png)
##Heroku
Different branches are deployed to different locations on heroku:
- master branch: [Snidgengid](http://snidgengid.herokuapp.com/)
- dev branch: [Secure intlet](http://secure-inlet-7452.herokuapp.com/)
- spark branch: [Powerful savannah](https://powerful-savannah-2609.herokuapp.com/)
- documentation: [Javadoc](http://snidgengid.herokuapp.com/javadoc/)
