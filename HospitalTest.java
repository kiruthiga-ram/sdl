import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.junit.jupiter.api.*; 
import static org.junit.jupiter.api.Assertions.*;
public class HospitalTest { 
static WebDriver driver; 
@BeforeAll 
public static void setup() { 
driver = new ChromeDriver(); 
} 
@BeforeEach 
public void openHMSPage() { 
driver.get("file:///C:/ravi/index.html"); 
} 
@Test 
public void testAddPatient() throws InterruptedException { 
WebElement nameField = driver.findElement(By.id("name")); 
WebElement ageField = driver.findElement(By.id("age")); 
WebElement diseaseField = driver.findElement(By.id("disease")); 
WebElement submitButton = driver.findElement(By.id("submit")); 
nameField.sendKeys("John"); 
ageField.sendKeys("30"); 
diseaseField.sendKeys("Flu"); 
submitButton.click(); 
Thread.sleep(1000); // Wait for the update 
WebElement count = driver.findElement(By.id("patientCount")); 
assertTrue(count.getText().contains("1")); 
} 
@AfterAll 
public static void tearDown() { 
if (driver != null) { 
driver.quit(); 
} 
}
}