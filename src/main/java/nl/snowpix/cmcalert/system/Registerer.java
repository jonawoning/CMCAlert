package nl.snowpix.cmcalert.system;

import nl.snowpix.cmcalert.CMCAlert;
import nl.snowpix.cmcalert.commands.Broadcast;

public class Registerer {

    public static void RegisterEvents(){
        CMCAlert.instance.getCommand("broadcast").setExecutor(new Broadcast());
    }

}
