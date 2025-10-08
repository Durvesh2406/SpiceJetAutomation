package com.SpiceJet;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderAutomation {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		WebDriver wd = new ChromeDriver(chromeOptions);
		
		wd.get("https://www.spicejet.com/");
		
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		
		By fromCityTextBoxLocator = By.xpath("//div[text() = \"From\"]/following-sibling::div/input");
		WebElement fromCityTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(fromCityTextBoxLocator));
		fromCityTextBox.sendKeys("Mum");
		
		By ToCityTextBoxLocator = By.xpath("//div[text() = \"To\"]/following-sibling::div/input");
		WebElement ToCityTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(ToCityTextBoxLocator));
		ToCityTextBox.sendKeys("Nagp");
		
		By calenderPickerLocator = By.xpath("//div[@data-testid= \"undefined-calendar-picker\"] ");
		WebElement calenderPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(calenderPickerLocator));
		
		By NextButtonLocator = By.xpath(".//*[local-name()='svg' and @data-testid=\"svg-img\"]");
		WebElement nextButton = calenderPicker.findElement(NextButtonLocator);
		nextButton.click();
		
		LocalDate localDate = LocalDate.now();
		LocalDate targetdate = localDate.plusMonths(2);
		
		String month = targetdate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int Year = targetdate.getYear();
		
		By monthCalenderLocator = By.xpath("//div[@data-testid=\"undefined-month-"+month+"-"+Year+"\"]");
		WebElement monthCalender = wait.until(ExpectedConditions.visibilityOfElementLocated(monthCalenderLocator));
		By dateLocator = By.xpath(".//div[text()='15']");
		monthCalender.findElement(dateLocator).click();
		
		By SearchButtonLocator = By.xpath("//div[text()='Search Flight']/parent::*");
		WebElement SearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
		SearchButton.click();
	}

}
