[![Travis Build Status](https://travis-ci.org/webdriverextensions/webdriverextensions.svg?branch=master)](https://travis-ci.org/webdriverextensions/webdriverextensions) [![Maven Central](https://img.shields.io/maven-central/v/com.github.yjagdale.webdriverutil/webdriver-helper-utils.svg)](https://search.maven.org/search?q=com.github.yjagdale)

WebDriver Helper
===================

WebDriver Helper Extensions is designed to simplify Java based Selenium/WebDriver tests. It's built on top of Selenium/WebDriver to make your tests more readable, reusabable and maintainable by providing easy handling towards browser and advance identifiers.

Available through the [Maven Central Repository](http://mvnrepository.com/search?q=com.github.yjagdale.webdriverutil)! Latest release is version 1.2.1 which includes selenium-java 3.14 as a transitive dependency.


<br>

### What's included in this utility?
- Browser handling ( interaction towards all the available browsers)
- Advanced selenium identifiers which can help you for rapid developement.
- Advanced way to manage driver executables for each env(ubuntu/mac/windows) [Webdrivermanager](https://github.com/yjagdale/webdriver-helper)
- Muti browser support.
<br>

### Want to Contribute?
If you find a bug or have a feature request please [create a new GitHub issue](https://github.com/yjagdale/webdriver-helper/issues/new) or even better clone this repository, commit your changes and make a [Pull Request](https://help.github.com/articles/using-pull-requests/).

<br>

### Have any Questions?
If you have question you can [ask them in a GitHub issue](https://github.com/yjagdale/webdriver-helper/issues/new).

<br>

# Content
- [Hello World Example](#hello-world-example)
    - [With WebDriver Extensions](#with-webdriver-extensions)
- [License](#license)



<br>

# Hello World Example
Here is an example of how a cross browser test looks like with and without the WebDriver Extensions Framework. The test will run on Firefox, Chrome and Internet Explorer. It will google for "Hello World" and assert that the search result contains the searched text "Hello World".

[Sample Project]("https://github.com/yjagdale/webdriver-helper-impl")


### config file 

```text
BROWSER_TYPE=ch
BASE_URL=https://opensource-demo.orangehrmlive.com/
IMPLICIT_WAIT=10
DEBUG_MODE=true
```



### With WebDriver Extensions
```java
class ExampleTestCases {
 @Test
    public void validationMessagePassword() {
        ElementActions.type("User Name", "Admin");
        ElementActions.click("Login");
        String errorMessage = ElementActions.getText("Error Message");
        Assert.assertEquals(errorMessage, "Password cannot be empty");
    }


    @Test
    public void validationMessageUser() {
        ElementActions.clear("User Name");
        ElementActions.sendKeys("Password", "admin123");
        ElementActions.click("Login");
        String errorMessage = ElementActions.getText("Error Message");
        Assert.assertEquals(errorMessage, "Username cannot be empty");
    }
}
```
_<sub>Imports are hidden for the sake of simplicity, for imports and instructions on how to run this example see this [gist](https://gist.github.com/andidev/ad006a454edfd9f0e9e5)</sub>_


<br>


### Debug Mode

```text
 System.setProperty("DEBUG_MODE", "true");
```

Once you enable debug mode every action will be displayed with toast message as well as element will be highlighted.
[Demo Video]("http://52.183.43.60/dashboard/") Can be seen here.

-----

## Version History:

[ChangeLog](Changelog.md)


# License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
