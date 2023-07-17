package io.eunhae.indonesia.ui.console;

import io.eunhae.indonesia.service.ClubService;
import io.eunhae.indonesia.service.ServiceLogicLifeCycler;
import io.eunhae.indonesia.service.logic.ClubServiceLogic;

public class ClubSubConsole {
    private ClubService clubService;

    public ClubSubConsole(){
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }
}
