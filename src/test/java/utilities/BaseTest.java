package utilities;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.io.IOException;
public class BaseTest {
    private static String URL_LOGIN;
    private static String URL_HOME;
    private static String VALID_USERNAME;
    private static String VALID_PASSWORD;
    private static String OFFICE_CODE;
    private static String APPL_NO_FROM;
    private static String APPL_NO_TO;
    private static String SUCCESS_APPL_NO;
    private static final EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String BASE_URL = EnvironmentSpecificConfiguration.from(env).getProperty("webdriver.base.url");
    public void initializeProperties() throws IOException {
        loadProperties();
    }
    private void loadProperties() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader();

        URL_LOGIN = propertiesReader.getProperty("loginPage");
        URL_HOME = propertiesReader.getProperty("homePage");
        VALID_USERNAME = propertiesReader.getProperty("validUsername");
        VALID_PASSWORD = propertiesReader.getProperty("validPassword");
        OFFICE_CODE = propertiesReader.getProperty("officeCode");
        APPL_NO_FROM = propertiesReader.getProperty("applNoFrom");
        APPL_NO_TO = propertiesReader.getProperty("applNoTo");
        SUCCESS_APPL_NO = propertiesReader.getProperty("successApplNo");
    }
    public static String getBaseUrl() {
        return BASE_URL;
    }
    public static String getUrlLogin() {
        return URL_LOGIN;
    }
    public static String getUrlHome() {
        return URL_HOME;
    }
    public static String getValidUsername() {
        return VALID_USERNAME;
    }
    public static String getValidPassword() {
        return VALID_PASSWORD;
    }
    public static String getApplNoFrom() {
        return APPL_NO_FROM;
    }
    public static String getApplNoTo() {
        return APPL_NO_TO;
    }
    public static String getOfficeCode() {
        return OFFICE_CODE;
    }
    public static String getSuccessApplNo() {
        return SUCCESS_APPL_NO;
    }
}