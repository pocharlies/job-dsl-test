```git clone git@github.com:pocharlies/job-dsl-test.git```

```cd job-dsl-test```

```docker-compose -f docker/jenkins/docker-compose.yml up -d```

Once the jenkins is up, if we go to the jenkins webpage at http://<docker-url> to see it running.

**user: admin**
**pass: admin**
 
Go to console and execute command to upload seed job to jenkins 

```./gradlew rest -Dpattern="jobs/seed.groovy" -DbaseUrl="http://docker.machine/" -Dusername=admin -Dpassword=admin"```

Once that seed is uploaded to jenkins, we can perform commits to project job-dsl-test and automatically jenkins will update "only if we have docker accesible from internet and we configured scm to trigger by commit"

if we want to launch seed automatically from console, go to test/config/config.env and setup url and admin token.

_to optain admin token, go to <url_jenkins>/user/admin/configure  and click into **show api token** _

to launch seed job, ```./test/seed/bin/run```

to test _Configuration as code and Pipelines_ launch ```./test/1/bin/run``` 

is possible to see pipeline how is downloading from another repo the web-hello-world example with one unit test with 100% code coverage.

once test pass properly, war is created and trigger another build that storage the artiffact created.

to test _Scripting with Jenkins_ launch ```./test/2/bin/run```

this script launch 10 jobs that creates a random file in his own workspace with 100MB "example size" file.

We can see all space used with plugin diskspace, "around 1,2GB finally."

all jobs are executed in slave container. It have 3 executors then it is possible to arribe at the situation that if we only have 1GB space in jenkins and all workspaces are going to crash because of non free space. a trigger launch another job:
 
 ```./test/2/bin/clean```
 
 This job is launched in master executor, to prevent to be in the backlog and then it is executed instantly. we can create another slave container to perform this task but for testing purposes it means similar.
 
 This clean job just search all jobs that are not being executed and clean all workspaces, and all executing jobs are not being stopped or deleted the workspace.
 
 
 
 All jobs have a executor slave specified and is possible to install dependencies directly into docker container to manage dependencies easily and faster.
 
 All jobs are seeding with testing passing to prevent that some job does not work properly or any dependency can be miss.
