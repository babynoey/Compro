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
public class Feeding_OneTypeAllTime {
    private FoodInBox box = FoodInBox.Box1;
    private int quantityForPet;
    private int plate;
    private int locationOfFoodBox;
    private Supply sup;

    public Feeding_OneTypeAllTime(FoodInBox box,int quantityForPet) {
        this.quantityForPet = quantityForPet;

        this.box = box;
        switch (this.box) {
            case Box1:
                this.locationOfFoodBox = 0;
                break;
            case Box2:
                this.locationOfFoodBox = 1;
                break;
            case Box3:
                this.locationOfFoodBox = 2;
                break;
        }

    }   
         
   /* public void setQuantityForPet(int quantityForPet) {
        this.quantityForPet = quantityForPet;
    }*/
     
    public void editFoodAndQuan(FoodInBox box,int quantityForPet) {
        this.box = box;
        this.quantityForPet=quantityForPet;
    }

    public int feed() {
        Supply sup = new Supply(this.quantityForPet);
        sup.checkOnlyBox(this.locationOfFoodBox);
        
        this.plate += this.quantityForPet;
        sup.getQuantityOfFoodInBox();
        if (Supply.quantityOfFoodInBox[0] >= this.quantityForPet || Supply.quantityOfFoodInBox[1] >= this.quantityForPet || Supply.quantityOfFoodInBox[2] >= this.quantityForPet) {
            System.out.println("Quantity of food in this plate are " + this.plate);
        }else{
            System.out.println("don't have quantity of food in this plate");
        }
        
        return this.plate;
    }   
}
