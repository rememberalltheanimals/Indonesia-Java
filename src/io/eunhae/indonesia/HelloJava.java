package io.eunhae.indonesia;

import io.eunhae.indonesia.entity.JavaAnimalClub;
import io.eunhae.indonesia.util.DateUtil;

public class HelloJava {

    public static void main(String [] args){
        System.out.println("Halo, wong sing njaga kewan ing pulo Jawa!");
        System.out.println(DateUtil.today());

        JavaAnimalClub newClub = new JavaAnimalClub("Javanese Animal Protection Group", "Java island's animal protection organization");
        System.out.println(newClub.toString());

        System.out.println(JavaAnimalClub.getSample().toString());
    }

}
