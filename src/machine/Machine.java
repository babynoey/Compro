package machine;

import java.util.Scanner;

public class Machine {

    public static void main(String[] args) throws InterruptedException {
        int choice;
        int time = 5;
        Scanner sc = new Scanner(System.in);
        Feeding_System fs = new Feeding_System();
        String start;

        System.out.println("===== WELCOME TO AUTOMATIC FEEDING MACHINE FOR THE FIRST TIME=====");
        fs.firstSetting();
        do {
            System.out.print("Do you want to start a system? (Type 'Yes' or 'No') : ");
            start = sc.next().toLowerCase();

//        if(start.equals("yes")){fs.feed();}
            if (start.equals("no")) {
                do {
                    System.out.println("Menu : "
                            + "\n1. Edit Settings"
                            + "\n2. Add food to specific box"
                            + "\n3. Show status"
                            + "\n4. Reset ALL settings"
                            + "\n5. Show remain food"
                            + "\n\n\n0. Exit ");

                    System.out.print("Select Menu : ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            fs.editSetiing();
                            break;
                        case 2:
                            fs.addFood();
                            break;
                        case 3:
                            fs.showStatus();
                            break;
                        case 4:
                            fs.firstSetting();
                            break;
                        case 5:
                            fs.showRemainFood();
                            break;
                    }
                } while (choice != 0);
            }
            if (start.equals("yes")) {
                fs.startFeed();
                System.out.println("!!!Run out of food!!!");
                System.out.println("Please add food into box");
                fs.addFood();
                start = "no";

            }
            if (!start.equals("yes") && !start.equals("no")) {
                System.out.println("Please try agiain");
            }
        } while (start.equals("no") || !start.equals("yes") && !start.equals("no"));
    }
}
