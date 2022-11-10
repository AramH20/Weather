import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Aram_HTest {

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(1000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);


        Thread.sleep(3000);
        driver.quit();

    }

//
//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide
// и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap


    @Test
    public void testGuidPageAndTitle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String urlGuide = "https://openweathermap.org/guide";
        String pageTitle = "Guide";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement guideMenueButton = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//li/a[@href = '/guide']"));


        guideMenueButton.click();

        WebElement newPageTitle = driver.findElement(
                By.xpath("//div[@class = 'container']//div/h1[@class = 'breadcrumb-title']"));

//        newPageTitle.getText() = pageTitle;

        String actualResult1 = driver.getCurrentUrl();
        String actualResult2 = driver.getTitle();
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);


//        if(driver.getCurrentUrl() == "https://openweathermap.org/guide"){
//            driver.get(By.xpath("//html/head/title") == "OpenWeatherMap API guide - OpenWeatherMap");
//        }

        Thread.sleep(3000);
        driver.quit();
    }

//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Подтвердить, что температура для города показана в Фарингейтах

        @Test
    public void testImperialFatintahe() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        boolean expectedResult = true;

       driver.get(url);
       Thread.sleep(5000);
       WebElement weatherButtonF = driver.findElement(
               By.xpath("//*[@id=\"weather-widget\"]/div[1]/div/div/div[1]/div[2]/div[3]"));
       weatherButtonF.click();

       WebElement tempInF = driver.findElement(
               By.xpath("//*[@id=\"weather-widget\"]/div[2]/div[1]/div[1]/div[2]/div[1]/span"));

       boolean actualResult = tempInF.getText().contains("F");
       Assert.assertEquals(actualResult, expectedResult);

       Thread.sleep(3000);
       driver.quit();

    }

//    TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies
// which are essential for the site to work. We also use non-essential cookies to help us improve our services.
// Any data collected is anonymised. You can allow all cookies or manage them individually.”
// 3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”


        @Test
    public void testCookies() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. Any data collected is anonymised. " +
                "You can allow all cookies or manage them individually.";
        String allButton = "Allow all";
        String manageButton = "Manage cookies";


        driver.get(url);
        Thread.sleep(5000);

        WebElement cookiesText = driver.findElement(
                    By.xpath("//div[@id=\"stick-footer-panel\"]/div/div/div/div/p"));

        WebElement buttonAllowAll = driver.findElement(
                By.xpath("//div[@id=\"stick-footer-panel\"]//div/button[@type = 'button']"));

        WebElement buttonManageCookies = driver.findElement(
                By.xpath("//div[@id=\"stick-footer-panel\"]//div/a[@href=\"/cookies-settings\"]"));
        String buttonAll = buttonAllowAll.getText();
        String buttonManage = buttonManageCookies.getText();

        Assert.assertEquals(buttonAll, allButton);
        Assert.assertEquals(buttonManage, manageButton);
        Assert.assertEquals(cookiesText.getText(),expectedResult);

        Thread.sleep(3000);
        driver.quit();

    }



//    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testSupportMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "FAQ";
        String expectedResult2 = "How to start";
        String expectedResult3 = "Ask a question";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement supportButton = driver.findElement(
                By.xpath("//div[@id= 'support-dropdown']"));
        supportButton.click();
        Thread.sleep(2000);

        WebElement menuSize = driver.findElement(By.xpath("//div//ul[@id= 'support-dropdown-menu']/li/a"));
//        int n = menuSize.getSize();

//        Assert.assertEquals(menuSize.getSize(),3);

        String actualResult1 = driver.findElement(By.xpath("//div//ul[@id='support-dropdown-menu']/li[1]")).getText();
        String actualResult2 = driver.findElement(By.xpath("//div//ul[@id='support-dropdown-menu']/li[2]")).getText();
        String actualResult3 = driver.findElement(By.xpath("//div//ul[@id='support-dropdown-menu']/li[3]")).getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        Thread.sleep(3000);
        driver.quit();
    }


//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

    @Test
    public void testAskQuestion() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = "google@gmail.com";
        String message = "Test message";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement supportButton = driver.findElement(
                By.xpath("//div[@id=\'support-dropdown\']"));
        supportButton.click();
        Thread.sleep(2000);

        WebElement questionButton = driver.findElement(By.xpath("//div//ul[@id=\'support-dropdown-menu\']/li[3]"));
        questionButton.click();

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement emailField = driver.findElement(By.xpath("//input[@class = 'form-control string email required']"));
        emailField.sendKeys(email);

        WebElement selectField = driver.findElement(By.xpath("//select[@id = 'question_form_subject']"));
        selectField.click();
        Thread.sleep(2000);

        WebElement selectFieldChoice = driver.findElement(By.xpath("//select[@id = 'question_form_subject']//option[@value='Sales']"));
        selectFieldChoice.click();

        WebElement messageField = driver.findElement(By.xpath("//textarea[@class = 'form-control text required']"));
        messageField.sendKeys(message);

        WebElement submitButton = driver.findElement(By.xpath("//input[@data-disable-with='Create Question form']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement reCaptchaText = driver.findElement(By.xpath("//div[@class='help-block']"));
        String actualResult = reCaptchaText.getText();

        Assert.assertEquals(actualResult, expectedResult);


        Thread.sleep(3000);
        driver.quit();
    }


//    TC_11_06
//1.  Открыть базовую ссылку
//2.  Нажать пункт меню Support → Ask a question
//3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//4.  Оставить пустым поле Email
//5. Заполнить поля  Subject, Message
//6. Подтвердить CAPTCHA
//7. Нажать кнопку Submit
//8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”


    @Test
    public void testAskQuestionCaptcha() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = "google@gmail.com";
        String message = "Test message";
        String expectedResult = "can't be blank";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement supportButton = driver.findElement(
                By.xpath("//div[@id=\'support-dropdown\']"));
        supportButton.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(2000);

        WebElement questionButton = driver.findElement(By.xpath("//div//ul[@id=\'support-dropdown-menu\']/li[3]"));
        questionButton.click();

//        Thread.sleep(4000);
//        for(String windowHandle : driver.getWindowHandles()){
//            if(!originalWindow.contentEquals(windowHandle)){
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement selectField = driver.findElement(By.xpath("//select[@id = 'question_form_subject']"));
        selectField.click();
        Thread.sleep(2000);

        WebElement selectFieldChoice = driver.findElement(By.xpath("//select[@id = 'question_form_subject']//option[@value='Sales']"));
        selectFieldChoice.click();

        WebElement messageField = driver.findElement(By.xpath("//textarea[@class = 'form-control text required']"));
        messageField.click();
        messageField.sendKeys(message);
        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title = 'reCAPTCHA']")));

        WebElement captchaButton = driver.findElement(
                By.xpath("//span[@id= 'recaptcha-anchor']/div[1][@class = 'recaptcha-checkbox-border']"));
        captchaButton.click();
        Thread.sleep(5000);

        driver.switchTo().window(window2);
        WebElement submitButton = driver.findElement(By.xpath("//input[@data-disable-with='Create Question form']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement confirmErrorElement = driver.findElement(
                By.xpath("//div[@class='col-sm-8']/span[@class = 'help-block']"));
        String actualResult = confirmErrorElement.getText();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(3000);
        driver.quit();

 }


//    TC_11_07
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Нажать на единицы измерения Metric: °C, m/s
//4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С

    @Test
    public void testImperialCelcius() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        boolean expectedResult = true;

        driver.get(url);
        Thread.sleep(5000);

        WebElement weatherButtonF = driver.findElement(
                By.xpath("//div[@id=\"weather-widget\"]/div[1]/div/div/div[1]/div[2]/div[3]"));
        weatherButtonF.click();
        Thread.sleep(3000);

        WebElement weatherButtonCelsius = driver.findElement(
                By.xpath("//div[@id=\"weather-widget\"]/div[1]/div/div/div[1]/div[2]/div[2]"));
        weatherButtonCelsius.click();

        WebElement tempInC = driver.findElement(
                By.xpath("//div[@id=\"weather-widget\"]/div[1]/div/div/div[1]/div[2]/div[2]"));

        boolean actualResult = tempInC.getText().contains("C");
        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(3000);
        driver.quit();

    }


//    TC_11_08
//1.  Открыть базовую ссылку
//2.  Нажать на лого компании
//
//3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась


    @Test
    public void testRefreshThePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = url;

        driver.get(url);
        Thread.sleep(5000);

        WebElement logoImageButton = driver.findElement(
                By.xpath("//ul[@id = 'first-level-nav']/li/a/img"));


        logoImageButton.click();

//        WebElement newPageTitle = driver.findElement(
//                By.xpath("//div[@class = 'container']//div/h1[@class = 'breadcrumb-title']"));

//        newPageTitle.getText() = pageTitle;

        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(3000);
        driver.quit();
    }


//    TC_11_09
//1.  Открыть базовую ссылку
//2.  В строке поиска в навигационной панели набрать “Rome”
//
//            3.  Нажать клавишу Enter
//4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
//            5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”

    @Test
    public void testSearchingBar() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String title = "Rome";
        String expectedResult1 = "Rome";
        String urltitle = "find";
        boolean expectedResult3 = true;

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchBar = driver.findElement(By.xpath("//div[@id = 'desktop-menu']/form/input[1]"));
        searchBar.click();
        searchBar.sendKeys(title);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement newSearchButton = driver.findElement(By.xpath("//input[@id='search_str']"));
        String actualResult1 = newSearchButton.getAttribute("value");
        boolean actualResult2 = driver.getCurrentUrl().contains(urltitle);
        boolean actualResult3 = driver.getCurrentUrl().contains(title);

        Assert.assertEquals(expectedResult1, actualResult1);
        Assert.assertEquals(expectedResult3, actualResult2);
        Assert.assertEquals(expectedResult3, actualResult2);


        Thread.sleep(3000);
        driver.quit();

    }

//    TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок

    @Test
    public void testAPIMenuButton() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        int expectedResult = 30;

        driver.get(url);
        Thread.sleep(5000);

        WebElement menuButtonAPI = driver.findElement(By.xpath("//div[@id='desktop-menu']/ul/li[2]/a"));
        menuButtonAPI.click();

        int actualResultOrangeButtons = driver.findElements(
                By.xpath("//a[contains(@class, 'orange')]")).size();

        Assert.assertEquals(expectedResult, actualResultOrangeButtons);

        Thread.sleep(3000);
        driver.quit();
    }

//    @Test
//    public void testH2TagText_WhenSearchingCityCountry(){
//        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//


//
//        Thread.sleep(3000);
//        driver.quit();
//
//    }
}
