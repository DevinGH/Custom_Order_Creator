public class Burger {
    /**
     * Instance Variable
     */
    private String pattyType = "Beef";
    private String pattyCount = "Single";
    private MyStack<String> burger = new MyStack<String>();

    /**
     * Categories
     */
    private enum Patties{
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
    }

    /**
     * a constructor that  initializes  a  Burger  with only  a  bun  and
     * patty if theWorks is false and a Baron Burger if theWorks is true
     * @param theWorks
     */
    Burger(boolean theWorks){
        if(!theWorks){
            burger.push("Bun");
            burger.push(pattyType);
        }

    }

    /**
     * this method changes all patties in the Burger to
     * the pattyType
     * @param pattyType
     */
    public void changePatties(String pattyType){
        MyStack<String> tempBurger = burger;

        for(int i = 0; i < tempBurger.size(); i++){
            for(Patties p : Patties.values()){
                if(tempBurger.pop().equalsIgnoreCase(p.toString())){
                    tempBurger.push(pattyType);
                }
            }
        }
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

    @Override
    /**
     * this method converts the Burger to a String for display
     */
    public String toString(){
        return "Placement String";
    }
}
