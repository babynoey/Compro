package feedingmachine;

import java.util.Scanner;

public class test {

    private static Scanner scn = new Scanner(System.in);

    private static int qty, qtyBox1, qtyBox2, qtyBox3, realTime, boxOfFood, quantityForPet, menu;

    public static void main(String[] args) {
        FeedingSystem fm;
        Supply sup = null;
        int menu = 0;
        String start;
        System.out.println("wellcome to Autometic Feeding Machine");
        fristSetting();
        fm = new FeedingSystem(qtyBox1, qtyBox2, qtyBox3, realTime, boxOfFood, quantityForPet);
        sup = new Supply(qtyBox1, qtyBox2, qtyBox3);
        sup = new Supply(quantityForPet);
        System.out.println("Do you want to Start (yes or no) : ");
        start = scn.next().toLowerCase();


            if (start.equals("yes")) {
                fm = new FeedingSystem(qtyBox1, qtyBox2, qtyBox3, realTime, boxOfFood, quantityForPet);
                fm.setFoodTypeForAllTime();
                //fm.start();
                fm.FeedingMachine();
            } else if (start.equals("no")) {
                do {
                    System.out.println("MENU \n" + "1.Edit box of food and quantity for pet\n" + "2.Check supply\n"
                            + "3.Add quantity of food in specific box\n" + "4.Delete quantity of food in specific box\n" + "5.Show quantity of food in all box\n" + "0.Exit");
                    System.out.println("Choose the number of menu : ");
                    menu = scn.nextInt();
                    switch (menu) {

                    /*   case 1:
                            editFoodAndQuanForPet();
                            fm = new FeedingSystem(realTime,boxOfFood, quantityForPet);      
                            //fm.editFoodAndQuan(boxOfFood, quantityForPet);
                            fm.setFoodTypeForAllTime();
                            
                            fm.FeedingMachine();
                        break;*/
                        case 2: //ได้แล้ว
                            sup.checkSupply();
                            break;
                        case 3: //ได้แล้ว
                            addFood();
                            sup.addFood(boxOfFood, qty);
                            break;
                        case 4://ได้แล้ว
                            deleteQuanOfFood();
                            sup.deleteFoodInBox(boxOfFood);
                            break;
                        case 5://ได้แล้ว
                            sup.getQuantityOfFoodInBox();
                            break;
                        case 0:
                            System.out.println("close machine");
                            break;
                        case 6 :
                            ;break;

                    }

                } while (menu != 0);
           }
        
    }

    public static void fristSetting() {
        System.out.println("Plass add food in box1 : ");
        qtyBox1 = scn.nextInt();
        System.out.println("Plass add food in box2 : ");
        qtyBox2 = scn.nextInt();
        System.out.println("Plass add food in box3 : ");
        qtyBox3 = scn.nextInt();
        System.out.println("Time to feed : ");
        realTime = scn.nextInt();
        System.out.println("Plass choose the box of food : ");
        boxOfFood = scn.nextInt();
        System.out.println("Plass add quantity for pet : ");
        quantityForPet = scn.nextInt();
    }

 /* public static void editFoodAndQuanForPet() {
        System.out.println("Plass choose the time ot feeding: ");
        realTime = scn.nextInt();
        System.out.println("Plass choose the box of food to edit: ");
        boxOfFood = scn.nextInt();
        System.out.println("Plass add quantity for pet : ");
        quantityForPet = scn.nextInt();
    }*/

    public static void addFood() {
        System.out.println("Plass choose the box of food to add : ");
        boxOfFood = scn.nextInt();
        System.out.println("Plass add quantity of food : ");
        qty = scn.nextInt();
    }

    public static void deleteQuanOfFood() {
        System.out.println("Plass choose the box of food to delete : ");
        boxOfFood = scn.nextInt();
    }
}
