## 0. Intro

While going through this training you will develop console `online store`. Each next task will append some functionality or flexibility to it; 

Each task has a description and materials, it doesn't mean that you should read this or only this materials,
 you are free to 'google' topics and select the most preferable content.
 
### Process 
A trainee must read and understand all materials related to the task and then complete all requirements from the task file.

A link to the pull request must be sent to the trainer via Email or Skype. 
The trainer performs the code review, a trainee must update code according to the comments from 
the code review and then inform his/her trainer that additional code review is required in the 
scope of the same pull request. 

### Administrative part
A trainee is obligated to inform his trainer about vacations or other activities, which will stop training process for 1 week and more. If there is no obstacles, then it is advised to complete at least one task per week (depends on the task scope). If a trainee is assigned on a project, then he/she should work on the training in his/her own time. Training must be completed in < 3 months. If training takes > 3 months, then situation will be reviewed individually (continue or stop the training and find the cause of a slow progress). 
If a trainee has difficulties, then he/she can ask the trainer for advice or a hint (only about the task itself). The final task is the end of the training. Basing on this task the trainer forms feedback for stakeholders, therefore a trainee works on it without any help. 

### Before start

#### Knowledge

Before starting this course you should be familiar with:

- Programming in general
- How to write and launch java application
- Java classes, methods, variables, exceptions
- Java if/else, switch, loops 

All this topics you can discover before the course [here](https://www.homeandlearn.co.uk/java/java.html) (Sections 1-8) 

#### Software

Before start you should install:

1. [Java 1.8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
2. [Git](https://git-scm.com/)
3. [IntellijIdea](https://www.jetbrains.com/idea/) Community edition

----
Good luck! 

## 1. Git

----
### Materials

[Git](https://git-scm.com/doc)

[GitHub Hello World](https://guides.github.com/activities/hello-world/)

[GitHub. Common workflows](https://drive.google.com/file/d/1ScaBHdoBatP-MaWqqvTmBeuO\_A7nyhJ4/view?usp=sharing)



### Task #1

We will store source code of our `OnlineStore` in GitHub. Before start you should read and 
understand git principals and main git commands.

task code to this branch and create a pull request from your branch to master branch, and assign it to your trainer. 
Do not merge it yourself!

## 2. Maven

----
### Materials

[Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

[Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)

[Naming Maven](http://maven.apache.org/guides/mini/guide-naming-conventions.html)

[Naming Java](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)

### Video Lectures

1. [Maven Basics] (https://drive.google.com/file/d/1Vl4Zcz8iSx2HM41VOHlPs2VvYppkI769/view?usp=sharing) - Вasics of maven. How to add and manage dependencies, how to create multimodular projects.
2. [How to use GitHub Classroom] (https://drive.google.com/drive/u/0/folders/1W4HSvnvzTKWH90h0aGnPATyhavaZbZjD)   - Workflows with GitHub Classroom. Common mistakes.

### Task #2

Before start implementation our `OnlineStore`, we need to prepare project structure and set up dependency manager.
To handle our project dependencies and source code build we will use `Maven`.

Please crete multi-module maven project in `Idea`, with such modules:

1. parent (this is general store module)
2. domain
3. store
4. consoleApp   
