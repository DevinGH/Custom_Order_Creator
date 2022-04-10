/**
 * TCSS 342A: Homework 1
 * Author: Devin Hanson
 * Date: 4/11/2022
 */
public class Burger {
    /**
     * Instance Variables
     */
    private String pattyType = "Beef";
    private int pattyCount = 0;
    private MyStack<String> burger = new MyStack<String>();
    private MyStack<String> recipe = new MyStack<String>();

    /**
     * a constructor that  initializes  a  Burger  with only  a  bun  and
     * patty if theWorks is false and a Baron Burger if theWorks is true
     * @param theWorks
     */
    Burger(boolean theWorks){
        if(!theWorks){
            burger.push("Bun");
            burger.push(pattyType);
            burger.push("Bun");
        }else{
            MyStack<String> nonPrintOrderBurger = new MyStack<String>();
            this.recipe();
            while(!recipe.isEmpty()){
                nonPrintOrderBurger.push(recipe.pop());
            }

            while(!nonPrintOrderBurger.isEmpty()){
                burger.push(nonPrintOrderBurger.pop());
            }

            this.recipe();
        }

    }

    /**
     * this method changes all patties in the Burger to
     * the pattyType
     * @param pattyType
     */
    public void changePatties(String pattyType){
        MyStack<String> tempBurger = new MyStack<String>();

        for(int i = 0; i < burger.size(); i++){
            String temp = burger.pop();

            if(temp.equalsIgnoreCase(this.pattyType)){
                tempBurger.push(pattyType);
            }else{
                tempBurger.push(temp);
            }

            i--;
        }

        this.pattyType = pattyType;

        for(int i = 0; i < tempBurger.size(); i++){
            burger.push(tempBurger.pop());

            i--;
        }
    }

    /**
     * this method adds one patty to the Burger up to the maximum of 3
     */
    public void addPatty(){
        MyStack<String> tempRecipe = new MyStack<String>();
        boolean addedPatty = false;

        if(recipe.isEmpty()) {
            this.recipe();
        }
            for(int i = 0; i < recipe.size(); i++){
                if(recipe.peek().equalsIgnoreCase("Pepperjack") && addedPatty == false){
                    tempRecipe.push(pattyType);
                    addedPatty = true;
                    pattyCount += 1;
                }else{
                    tempRecipe.push(recipe.pop());

                }

                i--;
            }

            while(!tempRecipe.isEmpty()){
                recipe.push(tempRecipe.pop());
            }

        burger.push(pattyType);
        this.sortBurger();
        addedPatty = false;
    }

    /**
     * this method adds all items of the type to the Burger in the
     * proper locations
     * @param type
     */
    public void addCategory(String type){
        if(type.equalsIgnoreCase("Cheese")){
            this.addIngredient("Cheddar");
            this.addIngredient("Pepperjack");
            this.addIngredient("Mozzarella");
        }
        if(type.equalsIgnoreCase("Veggies")){
            this.addIngredient("Lettuce");
            this.addIngredient("Tomato");
            this.addIngredient("Onions");
            this.addIngredient("Pickle");
            this.addIngredient("Mushrooms");
        }
        if(type.equalsIgnoreCase("Sauce")){
            this.addIngredient("Ketchup");
            this.addIngredient("Mustard");
            this.addIngredient("Mayonnaise");
            this.addIngredient("Baron-Sauce");
        }
    }

    /**
     * this method removes all items of the type from the Burger
     * @param type
     */
    public void removeCategory(String type){
        MyStack<String> tempBurger = new MyStack<String>();

        if(type.equalsIgnoreCase("Sauce")){
            for(int i = 0; i < burger.size(); i++){
                String temp = burger.pop();

                if(temp.equalsIgnoreCase("Ketchup") ||
                temp.equalsIgnoreCase("Mustard") ||
                temp.equalsIgnoreCase("Mayonnaise") ||
                temp.equalsIgnoreCase("Baron-Sauce")){
                }else{
                    tempBurger.push(temp);
                }

                i--;
            }
        }
        if(type.equalsIgnoreCase("Veggies")){
            for(int i = 0; i < burger.size(); i++){
                String temp = burger.pop();

                if(temp.equalsIgnoreCase("Lettuce") ||
                        temp.equalsIgnoreCase("Tomato") ||
                        temp.equalsIgnoreCase("Onions") ||
                        temp.equalsIgnoreCase("Pickle") ||
                        temp.equalsIgnoreCase("Mushrooms")){
                }else{
                    tempBurger.push(temp);
                }

                i--;
            }
        }
        if(type.equalsIgnoreCase("Cheese")){
            for(int i = 0; i < burger.size(); i++){
                String temp = burger.pop();

                if(temp.equalsIgnoreCase("Cheddar") ||
                        temp.equalsIgnoreCase("Mozzarella") ||
                        temp.equalsIgnoreCase("Pepperjack")){
                }else{
                    tempBurger.push(temp);
                }

                i--;
            }
        }

        for(int i = 0; i < tempBurger.size(); i++){
            burger.push(tempBurger.pop());

            i--;
        }
    }

    /**
     * this method adds the ingredient type to the Burger in the
     * proper location (unless it is already there, in which case this method does nothing)
     * @param type
     */
    public void addIngredient(String type){
        if(recipe.isEmpty()){
            this.recipe();
        }
        if(!burger.contains(type) && recipe.contains(type)){
            burger.push(type);
            this.sortBurger();
        }
    }

    /**
     * this  method  removes the  ingredient type from the Burger
     * @param type
     */
    public void removeIngredient(String type){
        MyStack<String> tempBurger = new MyStack<String>();

        for(int i = 0; i < burger.size(); i++){
            String temp = burger.pop();

            if(temp.equalsIgnoreCase(type)){
            }else{
                tempBurger.push(temp);
            }

            i--;
        }

        for(int i = 0; i < tempBurger.size(); i++){
            burger.push(tempBurger.pop());

            i--;
        }
    }

    /**
     * Initializes the recipe for the basic baron burger
     */
    private void recipe(){
        recipe.push("Bun");
        recipe.push("Ketchup");
        recipe.push("Mustard");
        recipe.push("Mushrooms");
        recipe.push(pattyType);
        recipe.push("Cheddar");
        recipe.push("Mozzarella");
        recipe.push("Pepperjack");
        if(pattyCount > 0){
            for(int i = 0; i < pattyCount; i++){
                recipe.push(pattyType);
            }
        }
        recipe.push("Onions");
        recipe.push("Tomato");
        recipe.push("Lettuce");
        recipe.push("Baron-Sauce");
        recipe.push("Mayonnaise");
        recipe.push("Bun");
        recipe.push("Pickle");

    }

    private void sortBurger(){
        MyStack<String> holderStack = new MyStack<String>();
        MyStack<String> orderedStack = new MyStack<String>();

        if(recipe.isEmpty()){
            this.recipe();
        }
        while(!burger.isEmpty()){
            if(!recipe.peek().equalsIgnoreCase(burger.peek())){
                if(!burger.contains(recipe.peek())){
                    recipe.pop();
                }else{
                    holderStack.push(burger.pop());
                }

            }else{
                orderedStack.push(burger.pop());
                recipe.pop();
                while(!holderStack.isEmpty()){
                    burger.push(holderStack.pop());
                }
            }
        }

        while(!orderedStack.isEmpty()){
            String item = orderedStack.pop();

            burger.push(item);
        }


    }

    @Override
    /**
     * this method converts the Burger to a String for display
     */
    public String toString(){
        return burger.toString();
    }
}
