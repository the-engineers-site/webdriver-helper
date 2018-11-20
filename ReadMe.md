[![Travis Build Status](https://travis-ci.org/webdriverextensions/webdriverextensions.svg?branch=master)](https://travis-ci.org/webdriverextensions/webdriverextensions) [![Maven Central](https://img.shields.io/maven-central/v/com.github.webdriverextensions/webdriverextensions.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3Acom.github.webdriverextensions)

WebDriver Helper
===================

WebDriver Helper Extensions is designed to simplify Java based Selenium/WebDriver tests. It's built on top of Selenium/WebDriver to make your tests more readable, reusabable and maintainable by providing easy handling towards browser and advance identifiers.

Available through the [Maven Central Repository](http://mvnrepository.com/search?q=webdriverextensions)! Latest release is version 3.10.0 which includes selenium-java 3.8.1 as a transitive dependency.


<br>

### What's included in this utility?
- Browser handling ( interaction towards all the available browsers)
- Advanced selenium identifiers which can help you for rapid developement.
- Advanced way to manage driver executables for each env(ubuntu/mac/windows) [Webdrivermanager](https://github.com/bonigarcia/webdrivermanager)
- Muti browser support.
<br>

### Want to Contribute?
If you find a bug or have a feature request please [create a new GitHub issue](https://github.com/webdriverextensions/webdriverextensions/issues/new) or even better clone this repository, commit your changes and make a [Pull Request](https://help.github.com/articles/using-pull-requests/).

<br>

### Have any Questions?
If you have question you can [ask them in a GitHub issue](https://github.com/yjagdale/webdriver-helper/issues/new).

<br>

# Content
- [Hello World Example](#hello-world-example)
    - [With WebDriver Extensions](#with-webdriver-extensions)
    - [Without WebDriver Extensions](#without-webdriver-extensions)
    - [Further increased readability with Groovy](#further-increased-readability-with-groovy)
- [Getting Started](#getting-started)
    - [Requirements](#requirements)
    - [Use Maven to add WebDriver Extensions](#use-maven-to-add-webdriver-extensions)
    - [Download and manage your drivers with the Maven Plugin](#download-and-manage-your-drivers-with-the-maven-plugin)
    - [Speed up your tests by running them in parallel](#speed-up-your-tests-by-running-them-in-parallel)
    - [Cross Browser test your website with the JUnitRunner](#cross-browser-test-your-website-with-the-junitrunner)
    - [Model your website with the Page Object Pattern](#model-your-website-with-the-page-object-pattern)
    - [Model your page components with the WebComponent](#model-your-page-components-with-the-webcomponent)
    - [Make your test readable as instructions with the Bot Pattern](#make-your-test-readable-as-instructions-with-the-bot-pattern)
    - [Create new projects with the Maven Archetype](#create-new-projects-with-the-maven-archetype)
- [Javadoc](#javadoc)
- [Changelog](#changelog)
- [Contributors](#contributors)
- [License](#license)



<br>

# Hello World Example
Here is an example of how a cross browser test looks like with and without the WebDriver Extensions Framework. The test will run on Firefox, Chrome and Internet Explorer. It will google for "Hello World" and assert that the search result contains the searched text "Hello World".



### With WebDriver Extensions
```java
@RunWith(WebDriverRunner.class)
@Firefox
@Chrome
@InternetExplorer
public class WebDriverExtensionsExampleTest {

    // Model
    @FindBy(name = "q")
    WebElement queryInput;
    @FindBy(name = "btnG")
    WebElement searchButton;
    @FindBy(id = "search")
    WebElement searchResult;

    @Test
    public void searchGoogleForHelloWorldTest() {
        open("http://www.google.com");
        assertCurrentUrlContains("google");

        type("Hello World", queryInput);
        click(searchButton);

        waitFor(3, SECONDS);
        assertTextContains("Hello World", searchResult);
    }
}
```
_<sub>Imports are hidden for the sake of simplicity, for imports and instructions on how to run this example see this [gist](https://gist.github.com/andidev/ad006a454edfd9f0e9e5)</sub>_


<br>

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
