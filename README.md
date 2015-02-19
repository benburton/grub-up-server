## grub-up-server

Grub Up Server is the server-side piece of a [Steel City CodeFest 2015](http://steelcitycodefest.org/) project intending
to help people better discover meals provided by the CitiParks program. The project was initially cloned from Heroku's
[template-java-spring-hibernate](https://github.com/heroku/template-java-spring-hibernate) project.

### Local Development Setup

#### Install Maven

##### OS X

First, install [Homebrew](http://brew.sh/) (recommended) or [Macports](https://www.macports.org/).

Using Homebrew, install as follows:

    brew install maven

Or with MacPorts:

    sudo port install maven


##### Linux

If you're using a Linux distribution with Apt (Ubuntu, Debian), you should be able to install as follows:

    sudo apt-get install maven

Otherwise, you can install the binary distribution from the Maven website using the following commands:

    wget http://mirror.olnevhost.net/pub/apache/maven/maven-3/3.0.5/binaries/apache-maven-3.0.5-bin.tar.gz
    tar xvf apache-maven-3.0.5-bin.tar.gz
    mv apache-maven-3.0.5  /usr/local/apache-maven

Then append the following to your `~/.bashrc`, `~/.zshrc` or whatever the config file is for your shell of choice:

    export M2_HOME=/usr/local/apache-maven
    export M2=$M2_HOME/bin
    export PATH=$M2:$PATH

Check that you have properly installed Maven by running the following:

    mvn -version
    Apache Maven 3.2.5 (12a6b3acb947671f09b81f49094c53f426d8cea1; 2014-12-14T12:29:23-05:00)
    Maven home: /usr/local/Cellar/maven/3.2.5/libexec
    Java version: 1.6.0_65, vendor: Apple Inc.
    Java home: /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home
    Default locale: en_US, platform encoding: MacRoman
    OS name: "mac os x", version: "10.10.2", arch: "x86_64", family: "mac"


#### Install PostgreSQL

##### Mac OS

Install [Postgres.app](http://postgresapp.com/).

Then append the following to your `~/.bashrc`, `~/.zshrc` or whatever the config file is for your shell of choice:

    alias psql='/Applications/Postgres.app/Contents/Versions/9.4/bin'/psql -p5432

##### Linux

    sudo apt-get postgres
    sudo yum install postgres

Hopefully? Whoever uses Linux please flesh this part out.

#### Run

Build using

    mvn clean install

and then run with

    java -jar target/dependency/webapp-runner.jar target/*.war


### Deploying to Heroku

#### Install Heroku Toolbelt

Simply [download and install Heroku Toolbelt](https://toolbelt.heroku.com/) for your operating system.

#### Log into Heroku

Using the command line app from the Heroku Toolbelt, log in:

    heroku login
    Enter your Heroku credentials.
    Email: benjamin.joseph.burton@gmail.com
    Password (typing will be hidden):
    Authentication successful.

#### Check for Permissions on Project

To ensure that you have rights to the `grub-up` project on Heroku, use the `heroku list` command, and check that the
results contain the `grup-up` project:

    heroku list | grep grub-up
    grub-up

If this does not return anything, contact someone on the team to get collaborator access to the Heroku project.

#### Add the Heroku Git Endpoint

Use the following command to add the Heroku project as a remote:

    git remote add prod https://git.heroku.com/grub-up-server.git

Check that this worked:

    git remote -v                                                                                                                                                                                   [ruby-2.0.0-p481]
    origin	git@github.com:benburton/grub-up-server.git (fetch)
    origin	git@github.com:benburton/grub-up-server.git (push)
    prod	https://git.heroku.com/grub-up-server.git (fetch)
    prod	https://git.heroku.com/grub-up-server.git (push)

#### Push the code to Heroku

Deploying to Heroku is as simple as this:

    git push -f prod master                                                                                                                                                                          [ruby-2.0.0-p481]
    Counting objects: 32, done.
    Delta compression using up to 8 threads.
    Compressing objects: 100% (21/21), done.
    Writing objects: 100% (32/32), 11.21 KiB | 0 bytes/s, done.
    Total 32 (delta 1), reused 0 (delta 0)
    remote: Compressing source files... done.
    remote: Building source:
    remote:
    remote: -----> Java app detected
    remote: -----> Installing OpenJDK 1.6... done
    ....
    remote:        [INFO] ------------------------------------------------------------------------
    remote:        [INFO] BUILD SUCCESS
    remote:        [INFO] ------------------------------------------------------------------------
    remote:        [INFO] Total time: 22.674 s
    remote:        [INFO] Finished at: 2015-02-19T01:59:30+00:00
    remote:        [INFO] Final Memory: 21M/513M
    remote:        [INFO] ------------------------------------------------------------------------
    remote: -----> Discovering process types
    remote:        Procfile declares types -> web
    remote:
    remote: -----> Compressing... done, 79.3MB
    remote: -----> Launching... done, v18
    remote:        https://grub-up.herokuapp.com/ deployed to Heroku
    remote:
    remote: Verifying deploy... done.


### License

This project is distributed under the MIT License found in the provided [LICENSE](/LICENSE) file.
