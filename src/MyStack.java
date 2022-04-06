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

    @Override
    /**
     * this method converts the contents of the MyStack to a String for display
     */
    public String toString(){
        String output = "";

        for(MyStack<Type> current = this; !current.isEmpty(); current = current.prev){
            System.out.print(output + current.item + " ");
        }

        return output;
    }
}

