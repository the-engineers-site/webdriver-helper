package com.example.oragnehr.pages;

import com.automation.executionhelper.IdentifierCollection;
import org.openqa.selenium.By;

import java.util.HashMap;

public class Login {


    public Login() {
        HashMap<String, By> collection = new HashMap<>();
        collection.put("User Name", By.id("txtUsername"));
        collection.put("Password", By.id("txtPassword"));
        collection.put("Login", By.id("btnLogin"));
        collection.put("Validation Message", By.id("spanMessage"));
        IdentifierCollection.loadIdentifiers(collection);
    }
}
