/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl_builderpattern;

/**
 *
 * @author Anggasta
 */
public class PL_BuilderPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MealBuilder mealBuilder = new MealBuilder();
       
       Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("VEG MEAL");
        vegMeal.showItems();
        System.out.println("Total Cost : " + vegMeal.getCost());
        System.out.println("========================");
        
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("NON VEG MEAL");
        nonVegMeal.showItems();
        System.out.println("Total Cost : " + nonVegMeal.getCost());
        System.out.println("========================");
    }
    
}