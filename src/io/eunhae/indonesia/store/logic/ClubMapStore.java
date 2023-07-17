package io.eunhae.indonesia.store.logic;

import io.eunhae.indonesia.entity.JavaAnimalClub;
import io.eunhae.indonesia.store.ClubStore;

import java.util.*;
import java.util.stream.Collectors;

public class ClubMapStore implements ClubStore {

    private Map<String, JavaAnimalClub> clubMap;

    public ClubMapStore(){
        this.clubMap = new HashMap<>();
    }

    @Override
    public void create(JavaAnimalClub javaAnimalClub) {
        this.clubMap.put(javaAnimalClub.getId(), javaAnimalClub);
    }

    @Override
    public JavaAnimalClub retrieve(String clubId) {

        return this.clubMap.get(clubId);
    }

    @Override
    public List<JavaAnimalClub> retrieveAllByName(String clubName) {
//        List<JavaAnimalClub> foundClubs = new ArrayList<>();
//
//        for(JavaAnimalClub club : this.clubMap.values()){
//            if(club.getClubName().equals(clubName)){
//                foundClubs.add(club);
//            }
//        }

//        Iterator<JavaAnimalClub> iterator = this.clubMap.values().iterator();
//        while(iterator.hasNext()){
//            JavaAnimalClub club = iterator.next();
//            if(club.getClubName().equals(clubName)){
//                foundClubs.add(club);
//            }
//        }

        return clubMap.values().stream()
                .filter(club -> club.getClubName().equals(clubName))
                .collect(Collectors.toList());

    }

    @Override
    public List<JavaAnimalClub> retrieveAll() {
        return new ArrayList<>(this.clubMap.values());
    }

    @Override
    public void update(JavaAnimalClub updateClub) {
        this.clubMap.put(updateClub.getId(), updateClub);
    }

    @Override
    public void delete(String clubId) {
        this.clubMap.remove(clubId);
    }
}
