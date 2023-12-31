package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import properties.ProjectProps;
import utils.AppUtils;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;


public class DriverManager {

    private WebDriver driver;

    public DriverManager(String browserName) throws InterruptedException {
        this.driver = createDriver(browserName);
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * createDriver calls the specific app initialization for the browser, which uses Selenium Manager (from Selenium 4.6),
     * webdriver files are no longer required.
     * @param browserName
     * @return WebDriver
     */
    private WebDriver createDriver(String browserName) throws InterruptedException {
        WebDriver webDriver = null;
        switch (browserName.toLowerCase()) {
            case "chrome":
                webDriver = getChromeDriver();
                break;
            case "edge":
                webDriver = getEdgeDriver();
                break;
            case "firefox":
                webDriver = getFirefoxDriver();
                break;
            case "safari":
                webDriver = getSafariDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Browser:%s not supported. Please choose from: [chrome, edge, firefox or safari]",browserName));
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return webDriver;
    }

    public WebDriver getChromeDriver(){
        HashMap<String, Object> chromePrefs = new HashMap<>();
//         chromePrefs.put("profile.default_content_settings.popups", 0);
         chromePrefs.put("browser.setDownloadBehavior", "allow");
         String absolutePath = AppUtils.getAbsolutePath(ProjectProps.DOWNLOAD_DIR)+ "\\";
         System.out.println(absolutePath);
         chromePrefs.put("download.default_directory", absolutePath);


        final ChromeOptions chromeOptions = new ChromeOptions();
        // Arguments: https://peter.sh/experiments/chromium-command-line-switches/
//        // chromeOptions.addArguments("user-data-dir=/path/to/custom/profile");
//        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.addArguments("--window-size=1920,1200");
//        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("--disable-extensions");
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-infobars");
        //Ad Blocker
        //chromeOptions.addExtensions(new File("C:\\Users\\afawzia\\Documents\\GitHub\\java-selenium-cucumber-template\\src\\main\\java\\app\\addBlocker\\gighmmpiobklfepjocnamgkkbiglidom-5.4.1-Crx4Chrome.com.crx"));
        //Thread.sleep(3000);


        //Preferences: https://chromium.googlesource.com/chromium/src/+/master/chrome/common/pref_names.cc
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);


        System.out.println(String.format("Driver session: %s", chromeDriver.getSessionId()));
        return chromeDriver;
    }

    private WebDriver getEdgeDriver() {
        final EdgeOptions edgeOptions = new EdgeOptions();

        //Arguments:
//        edgeOptions.addArguments("window-size=500,500");
//        edgeOptions.addArguments("start-maximized");

        //Preferences:
        HashMap<String, Object> edgePrefs = new HashMap<>();
//        edgePrefs.put("profile.default_content_settings.popups", 0)
        edgeOptions.setExperimentalOption("prefs", edgePrefs);

        WebDriver edgeDriver = new EdgeDriver(edgeOptions);
        System.out.println(String.format("Driver session: %s", ((RemoteWebDriver) edgeDriver).getSessionId()));
        return edgeDriver;
    }

    private WebDriver getFirefoxDriver(){
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");
        final FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
        firefoxProfile.setPreference("pageLoadStrategy", "normal");
//        HashMap<String, Object> firefoxPrefs = new HashMap<>();
//        firefoxProfile.setPreference("prefs",firefoxPrefs);

        //Arguments:
//        firefoxOptions.addArguments("--private");

        //Preferences: Type "about:config" in firefox browser search bar to see options
//        firefoxProfile.setPreference("browser.startup.homepage","https://qaconsultants.com/");
        firefoxOptions.setProfile(firefoxProfile);

        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        System.out.println(String.format("Driver session: %s", ((RemoteWebDriver) firefoxDriver).getSessionId()));
        return firefoxDriver;
    }

    private WebDriver getSafariDriver(){
        SafariDriver safariDriver = new SafariDriver();

        // Add arguments and preferences

        System.out.println(String.format("Driver session: %s", ((RemoteWebDriver) safariDriver).getSessionId()));
        return safariDriver;
    }

    public void quitDriver(){
        driver.close();
        driver.quit();
    }

}