package io.eunhae.indonesia.entity;

import io.eunhae.indonesia.util.DateUtil;

import java.util.UUID;

public class JavaAnimalClub {
    // Fields
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final int MINIMUM_INTRO_LENGTH = 10;
    private String id;
    private String clubName;
    private String intro;
    private String foundationDay;

    // Constructors
    private JavaAnimalClub(){
        this.id = UUID.randomUUID().toString();
    }

    public JavaAnimalClub(String clubName, String intro){
        this();
        setClubName(clubName);
        setIntro(intro);
        //this.clubName = clubName;
        //this.intro = intro;
        this.foundationDay = DateUtil.today();
    }

    // Methods
    public void setClubName(String clubName){
        if(clubName.length() < MINIMUM_NAME_LENGTH){
            System.out.println("Club name should be longer than 3");
            return;
        }
        this.clubName = clubName;
    }

    public String getClubName(){
        return this.clubName;
    }

    public void setIntro(String intro){
        if(intro.length() < MINIMUM_INTRO_LENGTH){
            System.out.println("Club intro should be longer than " + MINIMUM_INTRO_LENGTH);
            return;
        }
        this.intro = intro;
    }

    public String getIntro(){
        return this.intro;
    }

    public String getId(){
        return this.id;
    }

    public String getFoundationDay(){
        return this.foundationDay;
    }

    public static JavaAnimalClub getSample(){
        String clubName = "Sample Club";
        String intro = "Sample Club Intro...";
        JavaAnimalClub sampleClub = new JavaAnimalClub(clubName, intro);
        return sampleClub;

        //return new JavaAnimalClub("Sample Club", "Sample Club Intro...");
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("JavaAnimalClub ID : ").append(id);
       builder.append(", ClubName : ").append(clubName);
       builder.append(", Intro : ").append(intro);
       builder.append(", FoundationDay : ").append(foundationDay);

       return builder.toString();
    }
}
