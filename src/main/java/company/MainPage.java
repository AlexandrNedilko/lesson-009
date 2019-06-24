package company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static final String MAIN_PAGE_URL = "http://automationpractice.com";
    private WebDriver driver;

    private By tshirtsTab = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
    private By sizeLcheckbox = By.id("layered_id_attribute_group_3");

    private By singIn = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
    private By singIn1 = By.xpath("//*[@id='columns']/div[1]/span[2]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public MainPage openMainPage(){
        this.driver.navigate().to(MAIN_PAGE_URL);
        return this;
    }

    public MainPage openTShirtTab(){
        this.driver.findElement(tshirtsTab).click();
        return this;
    }

    public MainPage selectSizeL(){
        this.driver.findElement(sizeLcheckbox).click();
        return this;
    }

    public boolean isSizeL(){
        return this.driver.findElement(sizeLcheckbox).isSelected();
    }

    public MainPage openRegistrationButton() {
        this.driver.findElement(singIn).click();
        return this;
    }

    public boolean isSignIN() {
        return this.driver.findElement(singIn1).isEnabled();
    }

    public WebElement enterSomeBody_andClick(By path, String someone, By click, By firstForm) {
        WebElement webElement= this.driver.findElement(path);
        webElement.sendKeys(someone);
        webElement.findElement(click).click();
       return this.driver.findElement(firstForm);
    }

    public void click (WebElement webElement, By firstForm) {
        webElement.findElement(firstForm).click();
    }

    public void fillForm(WebElement webElement, By form, String field) {

        /*try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }*/

        webElement.findElement(form).click();
        webElement.findElement(form).clear();
        /*try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }*/
        webElement.findElement(form).sendKeys(field);
    }
    public boolean isRegister(By isRegister) {
        return this.driver.findElement(isRegister).isEnabled();
    }
}