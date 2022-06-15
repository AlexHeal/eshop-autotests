package alexheal.eshop.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/mobile/androidLocal.properties",
        "classpath:config/mobile/androidRemote.properties"
})
public interface AndroidConfig extends Config {
    String bs_username();

    String bs_access_key();
}
