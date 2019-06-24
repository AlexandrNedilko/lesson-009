package company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe"); //--whitelist-ip %*
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        this.mainPage = new MainPage(this.driver);

    }

    @Test
    public void canSelectSizeLForTShirt() {
        Assert.assertTrue(
                mainPage.openMainPage()
                        .openTShirtTab()
                        .selectSizeL()
                        .isSizeL());
    }

    @Test
    public void openRegistrationButton() {
        Assert.assertTrue(
                mainPage.openMainPage()
                        .openRegistrationButton()
                        .isSignIN());
    }

    @Test()
    public void createAnAccount () {
          By emailButton =By.xpath("//*[@id='email_create']");
          By creatAccaut =By.xpath("//*[@id='SubmitCreate']/span");
          By firstForm= By.xpath("//*[@id='id_gender1']");
          By secondFom= By.xpath("//*[@id='customer_firstname']");
          By _3Form= By.xpath("//*[@id='customer_lastname']");
          //By _4Form= By.xpath("//*[@id=passwd]");

          By _33Form= By.xpath("//*[@id='alias']");
          By register= By.xpath("//*[@id='submitAccount']/span");
          By finish= By.xpath("//*[@id='center_column']/div/p");


        WebElement webElement= mainPage.openMainPage()
                        .openRegistrationButton()
                        .enterSomeBody_andClick(emailButton, "qw@ee.rr", creatAccaut, firstForm);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        mainPage.click(webElement, firstForm);
        mainPage.fillForm(webElement, secondFom, "Igor");
        mainPage.fillForm(webElement, _3Form, "Popkin");
        //mainPage.fillForm(webElement, _4Form, "123456");
        //mainPage.fillForm(webElement, _5Form);
        //mainPage.fillForm(webElement, _6Form);
        mainPage.fillForm(webElement, _33Form,"Obolon");

        mainPage.click(webElement, register);


        Assert.assertTrue(mainPage.isRegister(finish));
    }




   /* @After
    public void cleanup(){
    driver.manage().deleteAllCookies();
    driver.close();
    }*/
}