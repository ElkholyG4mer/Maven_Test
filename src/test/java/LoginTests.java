import org.example.LoginAndRegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
    LoginAndRegisterPage loginPage;

    //Variables
    String URL = "https://automationexercise.com/";
    String email = "mostafa.elkholy@gmail.com";
    String password = "abcd123456";
    String expectedLoginHeader = "Login to your account";

    @BeforeMethod
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginAndRegisterPage(driver);
        loginPage.navigateToURL(URL);
        loginPage.clickLoginTabButton();
    }

    @Test
    public void loginTC01(){
        loginPage.assertOnLoginHeader(expectedLoginHeader);
        loginPage.fillLoginData(email,password);
        loginPage.clickLoginButton();
        loginPage.assertOnLogoutButton();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
