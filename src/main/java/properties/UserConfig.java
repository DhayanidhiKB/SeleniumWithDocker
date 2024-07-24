package properties;

import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public final class UserConfig {
    private UserConfig() {
    }

   @Getter
    static Properties properties;

    static {
        properties = ConfigFactory.create(Properties.class);
    }
}
