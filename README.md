# SENG 438 Assignment 3
## Group 38
Group members: Tony Vo, Chace Nielson, Chad Holst, Olisehemeka Chukwuma

## **IMPORTANT NOTES**
* The hamcrest-core-1.3.jar file that was included with the jfreechart-1.0.19.zip of Assignment3-artifact.zip from GitHub Classroom did not work when we tried to compile our tests. We found that using hamcrest-all-1.3.jar instead of hamcrest-core-1.3.jar fixed our compilation errors. Therefore, it is **essential** to use hamcrest-all-1.3.jar instead of hamcrest-core-1.3.jar. Please use the JARs found in [Reference Library](Referenced%20Libraries/) of JAR files for the project buildpath rather than the ones provided from Assignment3-artifact.zip.
  * In order to do this, extract all the JAR files from [Reference Library](Referenced%20Libraries/) into a folder. Once the [JFreeChart Unit Tests](JFreeChartLab3/src/org/jfree/data/test) files have been imported into Eclipse as a project, right click on the project (where it says "JFreeChart"), then click on Build Path → Use as Source Folder. Finally, select the folder that the JAR files were extracted into so that Hamcrest compilation error is fixed.

* The condition coverage metric didn’t show up in any of the coverage tools available to us. We decided to focus on method coverage instead to have more information shown in our results. After this decision, we were able to make tests to meet the criteria of 90% statement coverage, 70% branch coverage, and 60% method coverage.

* `getCentralValue()` in the Range class has a defect in the source code and even with proper tests, we always get a failing test. Therefore, running the our tests will always result in one error originating from this method.

## Deliverables
- [JFreeChart Unit Tests](JFreeChartLab3/src/org/jfree/data/test)
- [Lab Report](Assignment3-LabReport.md) 
- [Referenced Library](Referenced%20Libraries/)
