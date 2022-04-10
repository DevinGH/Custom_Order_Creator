/**
 * TCSS 342A: Homework 1
 * Author: Devin Hanson
 * Date: 4/11/2022
 *
 * Source used to help with implementation: https://levelup.gitconnected.com/selfmade-stack-class-in-java-d401dc7d68f0
 */
public class MyStack<Type> {
    /**
     * Instance Variables
     */
    private MyStack<Type> prev;
    private Type item;

    /**
     * a constructor that initializes an empty MyStack
     */
    MyStack(){

    }

    /**
     * Recursive constructor for MyStack
     * @param prev
     * @param item
     */
    MyStack(MyStack<Type> prev, Type item){
        this.prev = prev;
        this.item = item;
    }

    /**
     * returns true if the MyStack is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return this.prev == null;
    }

    /**
     * this method adds the item to the top of the MyStack
     * @param item
     */
    public void push(Type item){
        this.prev = new MyStack<Type>(this.prev, this.item);
        this.item = item;
    }

    /**
     * this method removes and returns the item on the top of the MyStack
     * @return Type
     */
    public Type pop(){
        if(this.isEmpty()){
            throw new IllegalArgumentException("There is no stack");
        }

        Type stackTop = this.item;
        this.item = this.prev.item;
        this.prev = this.prev.prev;

        return stackTop;
    }

    /**
     * this method returns the item on the top of the MyStack
     * @return Type
     */
    public Type peek(){
        return this.item;
    }

    /**
     * this method returns the number of items in the MyStack
     * @return int
     */
    public int size(){
        return this.isEmpty() ? 0 : 1 + this.prev.size();
    }

    /**
     * this method returns if the stack contains an item or nor
     * @return boolean
     */
    public boolean contains(Type item){
        boolean doesContain = false;

        for(MyStack<Type> current = this; !current.isEmpty(); current = current.prev){
            if(current.item.equals(item)){
                doesContain = true;
                break;
            }else{
                doesContain = false;
            }
        }

        return doesContain;
    }

    @Override
    /**
     * this method converts the contents of the MyStack to a String for display
     */
    public String toString(){
        String output = "[";

        for(MyStack<Type> current = this; !current.isEmpty(); current = current.prev){
            if(current.size() == 1){
                output += current.item + "]";
            }else{
                output += current.item + ", ";
            }
        }

        return output;
    }
}

