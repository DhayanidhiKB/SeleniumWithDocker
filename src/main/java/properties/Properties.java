package properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:${user.dir}/resources/FlightReservation.properties",
        "file:${user.dir}/resources/URLFlightReservation.properties"})


public interface Properties extends Config {

    @Key("UrlFlightsPage")
    String UrlToNavigate();

    @Key("firstName")
    String firstName();

    @Key("lastName")
    String lastName();

    @Key("emailId")
    String emailID();

    @Key("pswd")
    String pswd();

    @Key("street")
    String street();

    @Key("city")
    String city();

    @Key("zip")
    String zip();

}
