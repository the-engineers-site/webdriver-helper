## Changelog


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
 
  