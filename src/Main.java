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
        System.out.println(testStack.peek());
        System.out.println(testStack.pop());
        System.out.println(testStack);
    }

    /**
     * test method for Burger
     */
    public void testBurger(){
        Burger burger = new Burger(true);

        System.out.println(burger);
        burger.changePatties("Veggie");
        System.out.println(burger);
    }
}
