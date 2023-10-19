package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
public class PropertiesReader {
    private static final String PATH_FILE_APPLICATION_PROPERTIES = "src/test/resources/serenity.properties";
    private final Properties properties;
    public PropertiesReader() throws IOException {
        File file = new File(PATH_FILE_APPLICATION_PROPERTIES);
        String absolutePath = file.getAbsolutePath();
        this.properties = new Properties();
        this.properties.load(Files.newInputStream(Paths.get(absolutePath)));
    }
    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }

}