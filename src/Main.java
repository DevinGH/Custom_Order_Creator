/**
 * TCSS 342A: Homework 1
 * Author: Devin Hanson
 * Date: 4/11/2022
 *
 * Github: https://github.com/DevinGH/TCSS_342A/tree/master/src
 */

import java.io.*;
import java.util.*;

public class Main {
    /**
     * Instance Variables
     */
    private boolean omissions = false;
    private boolean exceptions = false;
    private boolean additions = false;
    private static int orderNumber = 0;
    private boolean theWorks = false;
    private List<String> categories = List.of("Cheese", "Veggies", "Sauce");
    private List<String> ingredients = List.of("Cheddar", "Mozzarella", "Pepperjack", "Lettuce", "Tomato",
                                                "Onions", "Pickle", "Mushrooms", "Ketchup", "Mustard", "Mayonnaise",
                                                "Baron-Sauce");

    /**
     * static  main  method  used  to  run  the  program  and  test  the
     * program elements. The input file containing the list of burger orders is to be passed as a
     * command line argument, so that the file name is available to your program as args[0]
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();

        Scanner orders = new Scanner(new File(args[0]));

        while(orders.hasNext()){
            String order = orders.nextLine();
            System.out.println("Processing Order " + orderNumber + ": " + order);
            main.parseLine(order);
        }
    }

    /**
     * parses a line of input from the file and outputs the burger
     * @param line
     */
    public void parseLine(String line){
        String[] order = line.split(" ");

        for(int i = 0; i < order.length - 1; i++){
            if(order[i].equalsIgnoreCase("Baron") && order[i + 1].equalsIgnoreCase("Burger")){
                theWorks = true;
            }
        }

        Burger burger = new Burger(theWorks);

        if(order[0].equalsIgnoreCase("Double")){
            burger.addPatty();
        }
        if(order[0].equalsIgnoreCase("Triple")){
            burger.addPatty();
            burger.addPatty();
        }

        if(theWorks == false){
            for(int i = 0; i < order.length; i++){
                if(additions){
                    if(ingredients.contains(order[i])){
                        burger.addIngredient(order[i]);
                    }
                    if(categories.contains(order[i])){
                        burger.addCategory(order[i]);
                    }
                }
                if(exceptions){
                    burger.removeIngredient(order[i]);
                }
                if(order[i].equalsIgnoreCase("with")){
                    additions = true;
                }
                if(order[i].equalsIgnoreCase("no")){
                    additions = false;
                    exceptions = true;
                }
            }

            exceptions = false;
        }
        if(theWorks == true){
            for(int i = 0; i < order.length; i++){
                if(omissions){
                    if(ingredients.contains(order[i])){
                        burger.removeIngredient(order[i]);
                    }
                    if(categories.contains(order[i])){
                        burger.removeCategory(order[i]);
                    }
                }
                if(exceptions){
                    burger.addIngredient(order[i]);
                }
                if(order[i].equalsIgnoreCase("no")){
                    omissions = true;
                }
                if(order[i].equalsIgnoreCase("but")){
                    omissions = false;
                    exceptions = true;
                }
            }

            exceptions = false;
        }

        if(order.length > 1 && order[1].equalsIgnoreCase("Chicken")){
            burger.changePatties("Chicken");
        }
        if(order.length > 1 && order[1].equalsIgnoreCase("Veggie")){
            burger.changePatties("Veggie");
        }

        System.out.println(burger);

        theWorks = false;
        orderNumber++;
        System.out.println();
    }

    /**
     * test method for MyStack
     */
    public void testMyStack(){
        MyStack<String> testStack = new MyStack<String>();

        testStack.push("Yes");
        testStack.push("Maybe");
        testStack.push("No");

        System.out.println("Is stack empty: " + testStack.isEmpty());
        System.out.println("Size of the stack: " + testStack.size());
        System.out.println(testStack);
        System.out.println("Yes in stack: " + testStack.contains("No"));
    }

    /**
     * test method for Burger
     */
    public void testBurger(){
        Burger burger = new Burger(true);

        System.out.println(burger);
        burger.addPatty();
        burger.addPatty();
        burger.removeCategory("Cheese");
        burger.addIngredient("Cheddar");
        burger.removeCategory("Sauce");
        System.out.println(burger);


    }
}
