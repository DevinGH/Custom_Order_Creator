public class Burger {
    /**
     * Instance Variables
     */
    private String pattyType = "Beef";
    private String pattyCount = "Single";
    private MyStack<String> burger = new MyStack<String>();
    private MyStack<String> recipe = new MyStack<String>();

    /**
     * Categories
     */
    /*private enum Patties{
        BEEF, VEGGIE, CHICKEN
    }

    private enum Cheeses{
        CHEDDAR, MOZZARELLA, PEPPERJACK
    }

    private enum Veggies{
        LETTUCE, TOMATO, ONIONS, PICKLE, MUSHROOMS
    }

    private enum Sauces{
        KETCHUP, MUSTARD, MAYONNAISE, BARONSAUCE
    }*/

    /**
     * a constructor that  initializes  a  Burger  with only  a  bun  and
     * patty if theWorks is false and a Baron Burger if theWorks is true
     * @param theWorks
     */
    Burger(boolean theWorks){
        if(!theWorks){
            burger.push("Bun");
            burger.push(pattyType);
        }else{
            this.recipe();
            burger = recipe;
        }

    }

    /**
     * this method changes all patties in the Burger to
     * the pattyType
     * @param pattyType
     */
    public void changePatties(String pattyType){
        MyStack<String> tempBurger = burger;

        clear();

        for(int i = 0; i < tempBurger.size(); i++){
            //System.out.println(tempBurger);
            String temp = tempBurger.pop();

            if(temp.equalsIgnoreCase(this.pattyType)){
                burger.push(pattyType);
            }else{
                burger.push(temp);
            }

            i--;
        }

        this.pattyType = pattyType;
        System.out.println(burger);
    }

    /**
     * this method adds one patty to the Burger up to the maximum of 3
     */
    public void addPatty(){

    }

    /**
     * this method adds all items of the type to the Burger in the
     * proper locations
     * @param type
     */
    public void addCategory(String type){

    }

    /**
     * this method removes all items of the type from the Burger
     * @param type
     */
    public void removeCategory(String type){

    }

    /**
     * this method adds the ingredient type to the Burger in the
     * proper location (unless it is already there, in which case this method does nothing)
     * @param type
     */
    public void addIngredient(String type){

    }

    /**
     * this  method  removes the  ingredient type  from the Burger
     * @param type
     */
    public void removeIngredient(String type){

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
        recipe.push("Onions");
        recipe.push("Tomato");
        recipe.push("Lettuce");
        recipe.push("Baron Sauce");
        recipe.push("Mayonnaise");
        recipe.push("Bun");
        recipe.push("Pickle");

    }

    /**
     * Clears the burger stack
     * @return
     */
    private void clear(){
        for(int i = 0; i < burger.size(); i++){
            burger.pop();
            i--;
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
