package config;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources(value = "classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    String login();
    String password();
}
