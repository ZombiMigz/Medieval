package org.whitemist.medieval.modules.announcements;

import org.whitemist.medieval.Main;

public class AnnouncementHandler {
    public static void init(Main main) {
        new AnnouncementBroadcaster().runTaskTimer(main, 20, 12000);
    }
}
