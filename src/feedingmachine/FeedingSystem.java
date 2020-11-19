/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedingmachine;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author User
 */
public class FeedingSystem {

    Timer myTimer;
    private String formattedDate;
    //private String timeForFeed;
    private static Date startFeedingTime = new Date();
    private static int realTime;
    private int quan1, quan2, quan3;
    private int quantityForPet;
    private static Supply sup;
    private static Feeding_OneTypeAllTime allTime;
    private FoodInBox box;
    private int boxOfFood;

    // private Scanner input = new Scanner(System.in);
    // private int a,b,c,d;
    // private static SettingSystem st;
    public FeedingSystem(int quan1, int quan2, int quan3, int realTime, int boxOfFood, int quantityForPet) {

        this.quan1 = quan1;
        this.quan2 = quan2;
        this.quan3 = quan3;
        this.realTime = realTime;
        this.quantityForPet = quantityForPet;
        switch (boxOfFood) {
            case 1:
                this.box = FoodInBox.Box1;
                break;
            case 2:
                this.box = FoodInBox.Box2;
                break;
            case 3:
                this.box = FoodInBox.Box3;
                break;
            default:
                this.box = FoodInBox.Box1;
        }

        //Supply sup = new Supply(this.quan1, this.quan2, this.quan3);
        //sup = new Supply(this.quantityForPet);
        //allTime = new Feeding_OneTypeAllTime(this.box,this.quantityForPet);
        //allTime.feed();
        //sup.getQuantityOfFoodInBox();
        //  SettingSystem st = new SettingSystem(this.quan1, this.quan2, this.quan3);
    }
    
    /*public FeedingSystem(int realTime,int boxOfFood, int quantityForPet) {
         this.realTime = realTime;
        this.quantityForPet = quantityForPet;
        switch (boxOfFood) {
            case 1:
                this.box = FoodInBox.Box1;
                break;
            case 2:
                this.box = FoodInBox.Box2;
                break;
            case 3:
                this.box = FoodInBox.Box3;
                break;
            default:
                this.box = FoodInBox.Box1;
        }
    }*/

    public void FeedingMachine() {

        //Timer myTimer;
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            public void run() {
                timerTick();
            }
        }, 0, 1000);
        /*if (sup.getQuanInBox1() <= this.quantityForPet && sup.getQuanInBox2() <= this.quantityForPet && sup.getQuanInBox3() <= this.quantityForPet) {
            myTimer.cancel();
        }*/
//        myTimer.cancel();
    }

    public void timerTick() {
        Date nowFeedingTime = new Date();
        double diff = Math.abs(nowFeedingTime.getTime() - startFeedingTime.getTime()) / 1000;
        if (diff == this.realTime) {
            startFeedingTime = new Date();
            //startFeeding();
            setFoodTypeForAllTime();
            //editFoodAndQuan(this.boxOfFood, this.quantityForPet);
           // sup.getQuantityOfFoodInBox();
        }
    }

    /* public static void startFeeding() {
        st.setFoodTypeForAllTime(FoodInBox.Box1, 100);
    }*/
    public int convert2Hours(int hour) {
        return 60 * 60 * hour;
    }

    public void setFoodTypeForAllTime() {
        this.quantityForPet = quantityForPet;
        this.box = box;
        allTime = new Feeding_OneTypeAllTime(this.box, this.quantityForPet);
        Supply sup = new Supply(this.quantityForPet);
        allTime.feed();
        sup.getQuantityOfFoodInBox();
    }

    public void start() {
        allTime.feed();
        //FeedingMachine();
    }

    /*public void editFoodAndQuan(int box, int quantityForPet) {
        this.boxOfFood = box;
        switch (boxOfFood) {
            case 1:
                this.box = FoodInBox.Box1;
                break;
            case 2:
                this.box = FoodInBox.Box2;
                break;
            case 3:
                this.box = FoodInBox.Box3;
                break;
            default:
                this.box = FoodInBox.Box1;
        }
        this.quantityForPet = quantityForPet;
        allTime.editFoodAndQuan(this.box, this.quantityForPet);
        System.out.println("Set box of food for pet are is " + this.box);
        System.out.println("Set quantity of food for pet are " + this.quantityForPet);

    }*/
   /* public void editFoodAndQuan(int box, int quantityForPet) {
        this.boxOfFood = box;
        switch (boxOfFood) {
            case 1:
                this.box = FoodInBox.Box1;
                break;
            case 2:
                this.box = FoodInBox.Box2;
                break;
            case 3:
                this.box = FoodInBox.Box3;
                break;
            default:
                this.box = FoodInBox.Box1;
        }
        this.quantityForPet = quantityForPet;
    }*/

}
