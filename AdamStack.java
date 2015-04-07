import java.util.Array;

public class AdamStack<E> {

    private int top;
    private static final int MAX_SIZE = 100;
    private E[] elements;

    public AdamStack(Class<E> c) {
        @SuppressWarnings("unchecked")
        elements = (E[]) Array.newInstance(c, MAX_SIZE);
        this.elements = elements;
        top = 0;
    }

    //add new element to top of stack (array)
    public void push(E data) {
        if(top < MAX_SIZE) {
            elements[top] = data;
            top++;
        } else {
            System.out.println("Stack Overflow!");
        }
    }

    //remove element from top of stack
    public E pop() {
        if(!this.empty()) {
            E temp = this.peek();
            elements[top - 1] = null;
            top--;
            return temp;
        } else {
            return null;
        }
    }

    //get the element at top of stack
    public E peek() {
        if(!this.empty())
            return elements[top - 1];
        else
            return null;
    }

    //check if stack is empty (check top variable)
    public boolean empty() {
        if(top == 0)
            return true;
        else
            return false;
    }
}