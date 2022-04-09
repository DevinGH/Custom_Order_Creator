public class Main {
    /**
     * static  main  method  used  to  run  the  program  and  test  the
     * program elements. The input file containing the list of burger orders is to be passed as a
     * command line argument, so that the file name is available to your program as args[0]
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();

        main.testBurger();
    }

    /**
     * parses a line of input from the file and outputs the burger
     * @param line
     */
    public void parseLine(String line){

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
        burger.addPatty();
        burger.removeCategory("Sauce");
        System.out.println(burger);


    }
}
