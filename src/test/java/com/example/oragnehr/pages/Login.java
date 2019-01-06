package com.example.oragnehr.pages;

import com.automation.executionhelper.IdentifierCollection;
import com.automation.utils.ElementBy;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Login {
    By User_Name = ElementBy.Id("txtUsername");
    By Password = ElementBy.Id("txtPassword");
    By Login = ElementBy.id("btnLogin");
    By Validation_Message = ElementBy.id("spanMessage");
}
