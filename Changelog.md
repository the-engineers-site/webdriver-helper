## Changelog

### [`1.3.2`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.3.2/jar): Identifier loading made automatic 
* Just define page object and Identifiers inside it. Automatically all the identifier will get loaded once you specify destination page
* New field in config added called `START_PAGE_CLASS` which will hold value for 1st page. 


### [`1.3.1`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.3.1/jar): Dependencies Moved to jar itself 
* Now you dont need to add any dependency to your project if you are adding webdriver-helper dependency.

### [`1.3`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.3/jar): New Functionality
* Now you can create Page Collection and add you page classes, New Instance of page will be created once you perform click on element which will navigate to required page
* Logging changed, Info logs are More readable logs and debug will be more detailed.
* Wait method for element disappear added. 


### [`1.2.6.2`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.2.6.2/jar): Maintenance Release
 * Bugfix [`#1 `](https://github.com/yjagdale/webdriver-helper/issues/1)

### [`1.2.6`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.2.6/jar): Maintenance Release
 * Basic Method To close and navigate on browser
 * Updated version to take from command line
 * Fixed css selector issue when selector contains space 

### [`1.2.5`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.2.5/jar): Maintenance Release
 * Debug mode enhanced. [New border added]  
 * New Method for executing javascript async. 
```
### [`1.2.4`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.2.4/jar)
 * New finder is added with attribute and property name  
 * Logging will be removed [ You need to add your own log4j file to add logging] 
 * All UI Methods now enabled with Identifier collection[You can pass key to method and method will take identifier from collection]
 refer below example 
 ```java_holder_method_tree
        String title = Browser.getInstance().getTitle();
        Assert.assertEquals("OrangeHRM", title);
        ElementActions.type("User Name", "Admin", 60);
        ElementActions.click("Login", 30);
        String validationMessage = ElementActions.getText("Validation Message");
        Assert.assertEquals(validationMessage, "Password cannot be empty");
```


### [`1.2.3`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.2.3/jar)
* New finder is added with attribute and property name  
* Loggin has been improved
* Added Runtime identifier collection to store and use all the identifiers for test case.
* New property with DEBUG MODE Added
 
 
------
### [`1.2.2`](https://search.maven.org/artifact/com.github.yjagdale.webdriverutil/webdriver-helper-utils/1.2.2/jar)

* Finder API exposed
 ```
 ElementBy.cssSelector("#ext-gen18 input");
 ElementBy.cssSelector("ext-gen20 input");
 ElementBy.AttributeWithValue("type", "button");
```
* DEBUG_MODE functionality is added 
By Using this mode you  can debug UI test case and you will be highllighted with element and action description will be show in toast message
 
  