package io.eunhae.indonesia.service.logic;

import io.eunhae.indonesia.entity.JavaAnimalClub;
import io.eunhae.indonesia.service.ClubService;
import io.eunhae.indonesia.store.ClubStore;
import io.eunhae.indonesia.store.StoreLifeCycler;

import java.util.List;

public class ClubServiceLogic implements ClubService {

   private ClubStore clubStore;

    public ClubServiceLogic(){
        this.clubStore = StoreLifeCycler.getUniqueInstance().requestClubStore();
    }

    @Override
    public void register(JavaAnimalClub javaAnimalClub) {
       this.clubStore.create(javaAnimalClub);
    }

    @Override
    public List<JavaAnimalClub> findAll() {
        return this.clubStore.retrieveAll();
    }

    @Override
    public List<JavaAnimalClub> findByName(String clubName) {

        return this.clubStore.retrieveAllByName(clubName);
    }

    @Override
    public JavaAnimalClub findById(String clubId) {

        return this.clubStore.retrieve(clubId);
    }

    @Override
    public void modify(JavaAnimalClub modifyClub) {

        this.clubStore.update(modifyClub);
    }

    @Override
    public void remove(String clubId) {
       this.clubStore.delete(clubId);
    }
}
