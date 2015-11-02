Development Manual
=======

##Introduction:

This manual shows what is necessary and explanations on how to get the project TicTacToe and how to build on a fresh machine.

##TicTacToe - Snidgengid
An account on GitHub is needed to access the organization Snidgengid and the repository tictactoe. As well as the developer needs to get access to the repositories room on gitter.

- https://github.com/Snidgengid
- https://github.com/Snidgengid/tictactoe

Gradle is used for the build process.

On local host the following need to be installed and running.
- Java 1.8
 - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Redis
 - http://redis.io/

##Tools to help the structure

**Git - github:** Source control system. We have an organization on github and a repository for the game.

**Gradle:** Build automation system to simplify the build process.

**Jococo:** After each gradle build jococo gives a codecoverage report.

**Travis:** Integration service, runs after each commit to github. If everything is ok it deploys to Heroku.

**Heroku:** Production environment.

**Redis:** open source environment for our database.

**Codecov:** test for code coverage on all commits to github. Tag available in our documentation.

**gitter.im:** communication between the mebers of the group.
