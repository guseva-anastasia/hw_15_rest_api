package config;

import com.codeborne.selenide.Configuration;

public class WebDriverProvider {

    private final WebDriverConfig config;

    public WebDriverProvider(WebDriverConfig config) {
        this.config = config;
    }

    public void setConfig(){
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browserVersion = config.getVersion();
        if (config.getRemote()) {
            Configuration.remote = config.getRemoteURL();
        }


    }



}
