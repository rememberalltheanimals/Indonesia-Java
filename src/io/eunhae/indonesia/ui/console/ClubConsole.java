package io.eunhae.indonesia.ui.console;

import io.eunhae.indonesia.entity.JavaAnimalClub;
import io.eunhae.indonesia.service.ClubService;
import io.eunhae.indonesia.service.ServiceLogicLifeCycler;
import io.eunhae.indonesia.service.logic.ClubServiceLogic;
import io.eunhae.indonesia.util.ConsoleUtil;

import java.util.List;
import java.util.Locale;

public class ClubConsole {

    private ConsoleUtil consoleUtil;

    private ClubService clubService;

    public ClubConsole(){
        this.consoleUtil = new ConsoleUtil();
        //
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }

    public void register(){

        while(true){
            String clubName = consoleUtil.getValueOf("Club Name(0.Club Menu)");
            if(clubName.equals("0")){
                return;
            }

            String intro = consoleUtil.getValueOf("Club Intro(0.Club Menu)");
            if(intro.equals("0")){
                return;
            }

            JavaAnimalClub newClub = new JavaAnimalClub(clubName, intro);
            // Store in the array
            clubService.register(newClub);

            System.out.println("Registered club : " + newClub.toString());
        }
    }

    public void findAll(){
        //
        List<JavaAnimalClub> foundClubs = clubService.findAll();
        if(foundClubs.isEmpty()){
            System.out.println("Empty");
            return;
        }

        for(JavaAnimalClub club : foundClubs){
            System.out.println(club.toString());
        }
    }

    public void findById(){
        JavaAnimalClub foundClub = null;

        while(true){
            String clubId = consoleUtil.getValueOf("Please type the Club id to find(0.Club Menu)");
            if(clubId.equals("0")){
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null){
                System.out.println(foundClub.toString());
            }else{
                System.out.println("Cannot find club ID : " + clubId);
            }
        }
    }

    public void findByName(){
        List<JavaAnimalClub> foundClubs = null;
        while(true){
            String clubName = consoleUtil.getValueOf("Please type the club name to find(Type 0 to return to the Club Menu)");
            if(clubName.equals("0")){
                break;
            }

            foundClubs = clubService.findByName(clubName);

            if(foundClubs != null && !foundClubs.isEmpty()){
                for(JavaAnimalClub club : foundClubs){
                    System.out.println(club);
                }
            }else{
                System.out.println("Cannot find club name : " + clubName);
            }
        }
    }

    private JavaAnimalClub findOne(){

        JavaAnimalClub foundClub = null;

        while(true){
            String clubId = consoleUtil.getValueOf("Please type the Club id to find(0.Club Menu)");
            if(clubId.equals("0")){
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null){
                break;
            }else{
                System.out.println("Cannot find club ID : " + clubId);
            }
        }
        return foundClub;
    }

    public void modify(){
        JavaAnimalClub targetClub = findOne();

        String newName = consoleUtil.getValueOf("New Club name(0.Club Menu, Enter. No Change.)");
        if(newName.equals("0")){
            return;
        }
        if(!newName.isEmpty()){
            targetClub.setClubName(newName);
        }
        String newIntro = consoleUtil.getValueOf("New Club intro(0.Club Menu, Enter. No Change.)");

        if(!newIntro.isEmpty()){
            targetClub.setIntro(newIntro);
        }

        clubService.modify(targetClub);

        System.out.println("Modify Club : " + targetClub.toString());
    }

    public void remove(){
        JavaAnimalClub targetClub = findOne();

        String confirmStr = consoleUtil.getValueOf("Remove this club?(Y:yes, N:no)");
        if(confirmStr.equals("Y") || confirmStr.equals("yes")){
            System.out.println("Removing a club -->" +targetClub.getClubName());
            clubService.remove(targetClub.getId());
        }else{
            System.out.println("Remove cancelled, your club is saved." + targetClub.getClubName());
        }
    }
}
