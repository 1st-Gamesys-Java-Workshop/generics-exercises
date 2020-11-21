package com.gamesys.exercises.generics.with;

public class Box<T> {

    private T object;

    public void box(T object) {
        this.object = object;
    }

    public T unbox() {
        T objectToUnbox = object;
        object = null;
        return objectToUnbox;
    }

    public boolean isEmpty() {
        return object == null;
    }

}
