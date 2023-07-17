package io.eunhae.indonesia.store;

import io.eunhae.indonesia.entity.JavaAnimalClub;

import java.util.List;

public interface ClubStore {

    void create(JavaAnimalClub javaAnimalClub);

    JavaAnimalClub retrieve(String clubId);

    List<JavaAnimalClub> retrieveAllByName(String clubName);
    List<JavaAnimalClub> retrieveAll();

    void update(JavaAnimalClub updateClub);
    void delete(String clubId);

}