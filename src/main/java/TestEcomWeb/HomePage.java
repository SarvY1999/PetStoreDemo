package TestEcomWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {
    public static void main(String[] args) {
        String[] Arr = {"Computers", "Electronics", "Apparel", "Digital Downloads", "Books", "Jewelry", "Gift Cards"};
        String [] subLinkComp = {"Desktops", "Notepooks", "Software"};
        String [] subLinkElectric = {"Camera & photo", "Cell phones", "Others"};
        String [] subLinkApprale = {"Shoes", "Clothing", "Accessories"};

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        Actions action = new Actions(driver);  // Actions are used for hovering over an element

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("img[alt='nopCommerce demo store']"));

        // verify if all the links are visible or not
        List <WebElement> headerLinks = driver.findElements(By.cssSelector("ul.top-menu.notmobile > li"));
        System.out.println(headerLinks.size());

        HashMap<String, String[]> subList = new HashMap<>();
        subList.put("Computers", subLinkComp);
        subList.put("Electronics", subLinkElectric);
        subList.put("Apparel", subLinkApprale);

        for(int i = 0; i <= headerLinks.size() - 1; i++){
            String text = headerLinks.get(i).getText();
            if(text.equals(Arr[i])){
                action.moveToElement(headerLinks.get(i)).perform();  // hover on element
                if(text.equals("Computers") || text.equals("Electronics") || text.equals("Apparel")){
                    String[] sublistArr = subList.get(text);
                    for (int j = 0; j < sublistArr.size(); j++) {
                        System.out.println(sublistArr.get(i));
                    }

                }

            }
        }


        driver.quit();
    }
}