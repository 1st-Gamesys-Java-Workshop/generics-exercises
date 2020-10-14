package com.gamesys.exercises.generics.without;

public class Box {

    private Object object;

    public void box(Object object) {
        this.object = object;
    }

    public Object unbox() {
        return object;
    }

    public boolean isEmpty() {
        return object == null;
    }

}
