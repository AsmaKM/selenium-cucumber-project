package app;

import lombok.Getter;
import lombok.Setter;

public class AppSession {

    @Getter @Setter private int defaultTimeout = 10;
    @Getter @Setter private int extendedTimeout = 60;
    @Getter private String baseUrl;
    @Getter private DriverManager driverManager;


    public AppSession(String browserName, String baseUrl) throws InterruptedException {
        driverManager = new DriverManager(browserName);
        this.baseUrl = baseUrl;
    }
}
