# 🛫 SpiceJet Calendar Automation

This project automates the flight search workflow on [SpiceJet](https://www.spicejet.com/) using Selenium WebDriver in Java. It selects source and destination cities, navigates the calendar to a future date, and initiates a flight search.

## 🚀 Features

- Automates city selection using dynamic XPath locators
- Navigates to a date two months ahead using Java's `LocalDate`
- Dynamically selects the calendar month and date
- Clicks the "Search Flight" button to initiate search
- Uses `WebDriverWait` for robust element handling

## 🧰 Tech Stack

- **Java 17+**
- **Selenium WebDriver**
- **ChromeDriver**
- **Maven** (optional for dependency management)

## 📦 Project Structure
SpiceJetCalendarAutomation/
├── src/
│   └── com/
│       └── spicejet/
│           └── CalendarAutomation.java
├── README.md
├── .gitignore
└── pom.xml   # Optional if using Maven
