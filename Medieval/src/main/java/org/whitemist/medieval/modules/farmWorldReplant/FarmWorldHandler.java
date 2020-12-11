package org.whitemist.medieval.modules.farmWorldReplant;

import org.whitemist.medieval.Main;

public class FarmWorldHandler {
    public static void init(Main main) {
        main.getServer().getPluginManager().registerEvents(new PlantBreakListener(main), main);
    }
}
