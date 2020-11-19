/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedingmachine;

/**
 *
 * @author User
 */
public class Supply {
    public static int[] quantityOfFoodInBox = new int[3];
    //Feeding_OneTypeAllTime alltime = new Feeding_OneTypeAllTime();
    private int max = 2000;
    private int min ;
    private static int posibilityOfQuantity;
    private int quantity;
    private int location;
    private int locationOfBox;

    public Supply(int quantityInBox1, int quantityInBox2, int quantityInBox3) {
        //this.min = SettingSystem.quantityForPet;
        this.quantityOfFoodInBox[0] = quantityInBox1;
        this.quantityOfFoodInBox[1] = quantityInBox2;
        this.quantityOfFoodInBox[2] = quantityInBox3;
    }
    
    
    public Supply(int quantityForPet) {
        this.min = quantityForPet;
    }
    

    public void checkSupply() {
        int numOfBox;
        for (int i = 0; i < this.quantityOfFoodInBox.length; i++) {
            numOfBox = i + 1;
            if (this.quantityOfFoodInBox[i] >= 0 && this.quantityOfFoodInBox[i] <= max) {//เช็คกรณีติดลบ
                if (this.quantityOfFoodInBox[i] <= min) {
                    System.out.println("Quantity of food in the box" + numOfBox + " are " + this.quantityOfFoodInBox[i] + " ,pleas add food in Box" + numOfBox);
                } else if (this.quantityOfFoodInBox[i] > min && this.quantityOfFoodInBox[i] < max) {
                    System.out.println("Quantity of food in the box" + numOfBox + " are " + this.quantityOfFoodInBox[i]);
                } else if (this.quantityOfFoodInBox[i] == max) {
                    System.out.println("Quantity of food in the box" + numOfBox + " are " + this.quantityOfFoodInBox[i] + " that are Maximum ,Don't add food!");
                }
            } else {
                this.quantityOfFoodInBox[i] = 0;//รีเซ็ตให้เป็น 0 อัตโนมัติ
                System.out.println("Plsas add food in the box" + numOfBox + " again ,Now this quantity in the box is " + this.quantityOfFoodInBox[i]);

            }
        }
    }

    public void addFood(int numberOfBox, int quantity) {
        this.quantity = quantity;
        this.location = numberOfBox - 1;
        int posibilityOfQuantity = this.quantityOfFoodInBox[this.location] + this.quantity;
        if (numberOfBox > 0 && numberOfBox <= 3) {
            if (posibilityOfQuantity <= max) {//เช็คความเป็นไปได้ที่อาหารที่เพิ่มมาเมื่อรวมของเดิมจะไม่เกินค่าสูงสุด หากไม่เกินจึงจะย้อมให้เพิ่มค่า
                this.quantityOfFoodInBox[this.location] += this.quantity;
            } else {
                System.out.println("Pleas reduce quantity and add food in the box" + numberOfBox + " again");
            }
        } else {//ไม่ต้องมีก็น่าจะได้ ยังไงก็ eror ถ้าเลือกเกินขนาดไซส์ที่มีให้
            System.out.println("Don't have a box" + numberOfBox + " Pleas try to choose new number of box again");
        }
    }



    public void deleteFoodInBox(int numberOfBox) {
        this.location = numberOfBox - 1;
        if (numberOfBox > 0 && numberOfBox <= 3) {
            this.quantityOfFoodInBox[this.location] = 0;
        }
    }

    public void decrease(int locationOfBox) {

        Supply.quantityOfFoodInBox[locationOfBox] -= this.min; 
    }

    public void checkOnlyBox(int locationOfFoodBox) {
        int locationOfBox = locationOfFoodBox;
        while (locationOfBox <= 3) {
            if (locationOfBox <= 2) {
                if (quantityOfFoodInBox[locationOfBox] - this.min >= 0) {
                    decrease(locationOfBox);
                    break;
                }else if (quantityOfFoodInBox[0]<this.min && quantityOfFoodInBox[1]<this.min&&quantityOfFoodInBox[2]<this.min) {
                    //System.out.println("Plese add food to the boxs");
                    checkSupply();
                    break;
                }else {
                    locationOfBox++;
                }
            } else {
                locationOfBox = 0;
            }

        }
    }

    public void getQuantityOfFoodInBox() {
        for (int i = 0; i < this.quantityOfFoodInBox.length; i++) {
            int numOfBox = i + 1;
            System.out.println("Quantity at now in box" + numOfBox + " are " + quantityOfFoodInBox[i]);
        }
        //return this.quantityOfFoodInBox; //ทำไมต้องรีเทิร์นออก ทำไมไม่ใช้ void
    }
    
   public int getQuanInBox1() {
      int QuanInBox1 = this.quantityOfFoodInBox[0];
        return QuanInBox1;
    }
   
   public int getQuanInBox2() {
      int QuanInBox2 = this.quantityOfFoodInBox[1];
        return QuanInBox2;
    }
   
   public int getQuanInBox3() {
      int QuanInBox3 = this.quantityOfFoodInBox[2];
        return QuanInBox3;
    }
}
