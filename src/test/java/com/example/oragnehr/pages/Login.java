package com.example.oragnehr.pages;

import com.automation.executionhelper.IdentifierCollection;
import com.automation.utils.ElementBy;
import org.openqa.selenium.By;

import java.util.HashMap;

public class Login {


    public Login() {
        HashMap<String, By> collection = new HashMap<>();
        collection.put("User Name", ElementBy.Id("txtUsername"));
        collection.put("Password", ElementBy.Id("txtPassword"));
        collection.put("Login", ElementBy.id("btnLogin"));
        collection.put("Validation Message", ElementBy.id("spanMessage"));
        IdentifierCollection.loadIdentifiers(collection);
    }
}
