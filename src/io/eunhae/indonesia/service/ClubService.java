package io.eunhae.indonesia.service;

import io.eunhae.indonesia.entity.JavaAnimalClub;

import java.util.List;

public interface ClubService {

    void register(JavaAnimalClub javaAnimalClub);
    List<JavaAnimalClub> findAll();
    List<JavaAnimalClub> findByName(String clubName);
    JavaAnimalClub findById(String clubId);

    void modify(JavaAnimalClub modifyClub);
    void remove(String clubId);
}
