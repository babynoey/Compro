package machine;

import java.util.Scanner;

class Feeding_System {

    private int qtt1, qtt2, qtt3;
    private int timeToFeed; //every timeTofeed hour machine will feed pet
    private int firstBox; //choose box be a first to feed
    private int toFeed; //Amount of food => plate
    private int chooseBox; // choose box for addind food to that box
    private int amount; //amount you want to addฃ
    private int sum;
    private int max = 2000;
    private Supply[] supply = {new Supply("BOX 1"), new Supply("BOX 2"), new Supply("BOX 3")};
    private String name;

    Scanner sc = new Scanner(System.in);

    /**
     * Set everything in first time including addFood , timeToFeed , toFeed(Amount of food to feed)
     */
    //    ===== FIRST SETTING =====
    public void firstSetting() {
        for (int i = 0; i < supply.length; i++) {
            System.out.print("Add amount of food to BOX " + (i + 1) + " : ");
            qtt1 = sc.nextInt();
            if(qtt1 > max){
                System.out.println("Your amount of food is over capacity of storage so your food will be 2000 auto");
                qtt1 = max;
            }
            supply[i].setQuantity(qtt1);
        }
        System.out.print("Please select time for feeding : ");
        timeToFeed = sc.nextInt();
        System.out.print("Please inout amount of food you want to feed : ");
        toFeed = sc.nextInt();
        showStatus();
    }
//    ===== END FIRST SETTING =====

    /**
     * Add food to box 
     */
    //    ===== ADD FOOD =====
    public void addFood() {
        do {
            System.out.print("What box you want to add :");
            chooseBox = sc.nextInt() - 1;
            if(chooseBox < 0 || chooseBox > 2){
                System.out.println("Don't have this box,Please try again");
            }
        }while(chooseBox < 0 || chooseBox > 2);
        do {

            System.out.print("Enter your amount : ");
            amount = sc.nextInt() ;
            sum = supply[chooseBox].getQuantity() + amount;
            if(sum > max){
                System.out.println("Please Try again");
            }
            }while (sum > max);
        supply[chooseBox].add(amount);
        showStatus();
    }
//    ===== END ADD FOOD =====

    /**
     * Show status including amount of food in box1 box2 box3,time to feed,amount of food to feed
     */
//    ===== SHOW STATUS =====
    public void showStatus() {
        System.out.println("=*=*=*=*=*=*=*=*=*=*");
        System.out.println("     **STATUS**     ");
        for (int i = 0; i < supply.length; i++) {
            System.out.println(supply[i].getName() + " => Food Amount : " + supply[i].getQuantity());
        }
        System.out.println("Time to feed => " + timeToFeed + " Hr/time");
        System.out.println("Amount food to feed => " + toFeed);
        System.out.println("=*=*=*=*=*=*=*=*=*=*");
    }
//    ===== END SHOW STATUS =====

    /**
     * show remaining food in every box
     */
//    ===== SHOW REMAIN FOOD =====
    public void showRemainFood() {
        for (int i = 0; i < supply.length; i++) {
            System.out.println(supply[i].getName() + " => Food Amount : " + supply[i].getQuantity());
        }
    }


//    ===== END SHOW REMAIN FOOD =====

    /**
     * setting new amount of food to feed and time to feed
     */
//    ===== EDIT SETTINGS =====
    public void editSetting() {
        System.out.print("1. Edit time for feeding"
                + "\n2. Edit amount food to feed"
                + "\nWhat do you want to edit? : ");
        int edit = sc.nextInt();
        if (edit == 1) {
            System.out.print("Enter your new time : ");
            int newTime = sc.nextInt();
            timeToFeed = newTime;
        } else if (edit == 2) {
            System.out.print("Enter your new amount : ");
            int newAmount = sc.nextInt();
            toFeed = newAmount;
        } else {
            System.out.print("*** Please try again ***");
            editSetting();
        }
    }
//    ===== END EDIT SETTINGS =====


    /**
     * check food in box1 if not enough method will check in box2 and loop
     * @throws InterruptedException
     */
    //    ===== CHECK SUPPLY =====
    public void checkSupply() throws InterruptedException {
        for (int i = 0; i < supply.length; i++) {
            if (supply[i].getQuantity() < toFeed) {
                 System.out.println("Not enough food in " + supply[i].getName() + " to feed.");
               /* if (supply[i].getQuantity() < toFeed) {
                    System.out.println("Not enough food in " + supply[i].getName() + " to feed.");
                }else {
                    System.out.println("Not enough food in " + supply[i].getName() + " to feed.");
                }*/
            }else{
                supply[i].feed(toFeed); 
                /*if(supply[i].getQuantity()<0){
                    supply[i].setQuantity(0);
                }*/
                break;
            }
        }
    }
//    ===== END CHECK SUPPLY =====

    /**
     * start feeding pet
     * @throws InterruptedException
     */
//    ===== START FEEDING =====
    public void startFeed() throws InterruptedException {
        do {
            checkSupply();
            int time = timeToFeed;
            do {
                Thread.sleep(timeToFeed * 1000); //**FOR PRESENTATION** timeToFeed(sec) => timeToFeed(mill)
//                Thread.sleep(timeToFeed*60*60*1000); //timeTofeed(Hr) => timeToFeed(min) => timeToFeed(sec) => timeToFeed(mill)
                System.out.println(time + " minutes to feed.");
                time--;
            } while (time != 0);
            Thread.sleep(500);
            System.out.println("Feeding");
            showRemainFood();
        } while ((supply[0].getQuantity() >= toFeed || supply[1].getQuantity() >= toFeed || supply[2].getQuantity() >= toFeed) || (supply[0].getQuantity() >= toFeed && supply[1].getQuantity() >= toFeed && supply[2].getQuantity() >= toFeed));
    }

}
