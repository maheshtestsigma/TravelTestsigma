import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookTicket {

    private static String city ="//div[@class='dropdown-menu fixed_dropdown right show']//a[@class='dropdown-item ng-binding ng-scope'][normalize-space()='xxx']";

    public static void main(String [] args){

        List<String> cityList = new ArrayList<>();
        cityList.add("Washington, D.C.");
        cityList.add("Los Angeles");
        cityList.add("New York City");
        cityList.add("London");

        System.setProperty("webdriver.chrome.driver", "/Users/mahesh/IdeaProjects/TravelTestsigma/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        for(int i=0;i<4;i++) {

            //This method returns the time in millis
            long startTime = System.nanoTime();
            driver.get("http://travel.testsigma.com/login");
            driver.findElement(By.id("first_name")).sendKeys("admin");

            driver.findElement(By.xpath("//input[@id='icon_telephone']")).sendKeys("12345");

            driver.findElement(By.xpath("//button[@name='action']")).click();
//5
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }

//6
            driver.findElement(By.xpath("//span[@id='departure_cities']")).click();

//7
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
//8
            if(!driver.findElement(By.cssSelector(".dropdown-menu.fixed_dropdown.right")).isDisplayed()){
                break;
            }

//9

            driver.findElement(By.xpath(city.replace("xxx",cityList.get(i)))).click();

//10
            driver.findElement(By.xpath("//span[@id='arraival_cities']//span[@class='ng-binding'][normalize-space()='LD-UK']")).click();

//11

            if(!driver.findElement(By.xpath("//div[@class='dropdown-menu fixed_dropdown left show']//a[@class='dropdown-item ng-binding ng-scope'][normalize-space()='Washington, D.C.']")).isDisplayed())
            {

                break;
            }
//12

            driver.findElement(By.xpath("//span[@id='arraival_cities']")).click();

//13
            driver.findElement(By.xpath("//input[@id='departure']")).click();

//14
            if(!driver.findElement(By.cssSelector(".datepicker-modal.open")).isDisplayed()){
                break;
            }

//15

            if(!driver.findElement(By.cssSelector(".datepicker-modal.open td.is-today button")).isDisplayed()){
                break;
            }

//16
            driver.findElement(By.cssSelector(".datepicker-modal.open td.is-today button")).click();

//17
            driver.findElement(By.xpath("(//button[text()='Ok'])[1]")).click();


//18
            driver.findElement(By.cssSelector("button.hsw_searchButton")).click();



//19
            if(!driver.findElement(By.xpath("//div[@class='d-flex px-0 px-xl-3 justify-content-center flex-column flex-xl-row flex-lg-row flex-md-row flex-sm-column align-items-center']//span[@class='ng-binding'][normalize-space()='BO | Bo-747']")).isDisplayed()){
                break;
            }

            long stopTime = System.nanoTime();
            long convert = TimeUnit.SECONDS.convert(stopTime - startTime, TimeUnit.NANOSECONDS);
            System.out.println("---------"+i+"--------");
            System.out.println(convert);
            System.out.println("======================");
        }











    }



}
