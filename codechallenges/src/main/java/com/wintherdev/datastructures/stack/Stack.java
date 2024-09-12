package com.wintherdev.datastructures.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Stack <T>{

    private List<T> content = new LinkedList<>();


    /**
     * Creates a stack data structure.
     * A stack is a last-in first-out structure.
     * Stores objects into a sort of vertical tower.
     *
    */
    public Stack(){
    }


    /**
     * Adds an object of the specified type to the stack.
     * @param in Object of type which the stack holds.
     * @return the same object that was added to the stack.
     */
    public synchronized T push (T in){
        content.add(in);
        return in;
    }

    /**
     * Removes the last added object from the stack.
     * @return The object at the top of the stack / the last added object.
     * @throws EmptyStackException
     */
    public synchronized T pop () throws EmptyStackException {
        if(content.isEmpty()) throw new EmptyStackException();

        T toRemove = content.getLast();
        content.remove(toRemove);
        return toRemove;
    }

    /**
     * Looks at the object at the top of the stack / the last added object, without removing it.
     * @return The object at the top of the stack / the last added object.
     * @throws EmptyStackException
     */
    public synchronized T peek(){
        if(content.isEmpty()) throw new EmptyStackException();

        return content.getLast();
    }

    /**
     * Checks the stack for the object inputs index.
     * @param in The object to check the stack for.
     * @return The index of the object. If it returns -1, the object is not in the stack.
     * @throws EmptyStackException
     */
    public synchronized int search (T in){
        if(content.isEmpty()) throw new EmptyStackException();

        int i = content.indexOf(in);
        if(i >= 0){
            return i;
        }
        return -1;
    }


    public boolean isEmpty(){
        return content.isEmpty();
    }


    @Override
    public String toString() {
        return content.toString();
    }
}
