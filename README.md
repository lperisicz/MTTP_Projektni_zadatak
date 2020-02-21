
#  MTTP Project Assignment

In this repository you can find tests for webpage ("https://www.vinkoprom.com/"),  written in Kotlin programming language. Using POM objects different parts of webpage are separated and generalized by BasePOM class.

## Prerequisites

[Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)<br/>
[IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows) (with Kotlin plugin)<br />
[Maven](https://maven.apache.org/download.cgi)<br />
[Chrome driver](https://chromedriver.chromium.org/)<br />

## Installing

### 1. Install IntelliJ IDEA

- Go to [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)<br />
- Run the downloaded file<br />

### 2. Install Java JDK

- Go to [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)<br />
- Run the downloaded executable file <br />

### 3. Install Maven

- Go to [Maven](https://maven.apache.org/download.cgi)<br />
- Download the binary zip archive<br />
- Open the .zip archive and extract it into C:\Program Files<br />
- Add "C:\Program Files\apache-maven-x.x.x" to Path

### 4. Install Chrome driver

- Go to [Chrome driver](https://chromedriver.chromium.org/)<br />
- Download the chrome driver<br />
- Move the downloaded chrome driver into your desired folder, make sure to add correct path in MainTest.kt file for used driver<br />

### 5. Install GIT

- Go to [GIT](https://git-scm.com/downloads) and follow the instructions<br />

### 5. Adding additional Kotlin depencies in pom.xml file

- Add <br />
```xml
<dependency>
 <groupId>org.jetbrains.kotlin</groupId>
 <artifactId>kotlin-stdlib-jdk8</artifactId>
 <version>1.3.61</version>
</dependency>
```
and
```xml
<plugin>
 <groupId>org.jetbrains.kotlin</groupId>
 <artifactId>kotlin-maven-plugin</artifactId>
 <version>1.3.61</version>
 <executions> <execution> <id>compile</id>
 <phase>process-sources</phase>
 <goals> <goal>compile</goal>
 </goals> </execution> </executions></plugin>
```

## Downloading the repository
```
git clone https://github.com/hydro1337x/PcShopTests.git
```

## Running the tests

Run tests inside of IntelliJ Idea or bi running command in terminal:<br />
```
mvn test
```
Reports are found inside "target\surefire-reports". Run index.html to view the reports.

## Test descriptions

### Login Test

Go to home page, wait until page content is loaded with WebDriverWait.until(...) and and check if MyAccount pom class has required elements.

### Simple toolbar navigation test

Go to home page, login, and from the toolbar go to Habitation results and check if the price of the first result matches the expected price value.

### Complex toolbar navigation test

Go to home page, login, and from the toolbar check Garden -> Tools -> -> Hand Tools and go to product results and check if the price of the first result matches the expected price value in the ProductResults.

### Side categories navigation test
Go to home page, login, and from the toolbar check Garden -> Tools -> -> Hand Tools and go to product results and from there in side category view go to Habitation products page and check if the price of the first result is the same as expected.


### Logout test

Go to home page, login and from there check logout button in the toolbar, check if login button is visible again.