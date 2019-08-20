package ru.stqa.d7.addressbook.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.d7.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;



public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }
//
//  public ApplicationManager getApp() {
//    return app;
//  }
}
