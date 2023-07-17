package io.eunhae.indonesia.ui.menu;

import io.eunhae.indonesia.ui.console.ClubConsole;

import java.util.Scanner;

public class ClubMenu {

    private Scanner scanner;
    private ClubConsole console;

    public ClubMenu(){
        this.scanner = new Scanner(System.in);
        this.console = new ClubConsole();
    }

    public void show(){
        int inputNumber = 0;

        while(true){
            displayMenu();
            inputNumber = selectMenu();

            switch (inputNumber){
                case 1:
                    console.register();
                    break;
                case 2:
                    console.findAll();
                    break;
                case 3:
                    console.findById();
                    break;
                case 4:
                    console.findByName();
                    break;
                case 5:
                    console.modify();
                    break;
                case 6:
                    console.remove();
                    break;
                case 0:
                    //
                    return;
                default:
                    System.out.println("Choose again!");
            }
        }
    }

    private void displayMenu(){
        System.out.println("...........................");
        System.out.println("Club Menu");
        System.out.println("...........................");
        System.out.println("1. Register");
        System.out.println("2. Find all clubs");
        System.out.println("3. Find by ID");
        System.out.println("4. Find by name");
        System.out.println("5. modify");
        System.out.println("6. Remove");
        System.out.println("...........................");
        System.out.println("0. Previous");
        System.out.println("...........................");
    }

    private int selectMenu(){
        System.out.print("Select : ");
        int menuNumber = scanner.nextInt();
        if(menuNumber >= 0 && menuNumber <= 6){
            scanner.nextLine();
            return menuNumber;
        }else{
            System.out.println("It's a invalid number -->" + menuNumber);
            return -1;
        }
    }

}
