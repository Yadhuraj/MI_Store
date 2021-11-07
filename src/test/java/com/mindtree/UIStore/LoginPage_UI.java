package com.mindtree.UIStore;

import org.openqa.selenium.By;

public class LoginPage_UI {
 public static By login_key = By.xpath("//*[@class='entry']//a[contains(text(),'Sign in')]");
 public static By user_input = By.cssSelector("[name='account']");
 public static By pass_input = By.cssSelector("[name='password']");
 public static By login_submit = By.cssSelector("[type='submit']");
 public static By login_confirm = By.cssSelector("[id='J_userName']");
 
}
