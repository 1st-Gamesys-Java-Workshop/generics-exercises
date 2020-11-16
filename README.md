# Generics Hands-on

## 1. Working on objects without Generics

Given: a class Box below has been implemented without using Generics.

```java
public class Box {

    private Object object;

    public void box(Object object) {
        this.object = object;
    }

    public Object unbox() {
        Object objectToUnbox = object;
        object = null;
        return objectToUnbox;
    }

    public boolean isEmpty() {
        return object == null;
    }

}
```

In NonGenericBoxMain, remove the comment on the following line
and fix the compile error

```java
//    String content = box.unbox();
```

## 2. Custom Generic Type

Modify or create a version of the Box class using Generics
such that the data type of the object inside the box can be generic.

Here's a sample usage of the Generic Box class:

```java
Box<Double> box = new Box<>();
box.box(1.2345);
Double value = box.unbox();
```

Also, try
```java
Box<Integer> box = new Box<>();
box.box("Trial"); // will this compile?
```

## 3. Working with Multiple Type Parameters and Parameterized Types

Given: a class Pair below with two type parameters T and S

```java
public class Pair<T, S> {

    private T left;
    private S right;

    public Pair(T left, S right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public S getRight() {
        return right;
    }
}
```

In `GenericPairMain` `main()` method:
*  Instantiate a Pair object with Integer and Boolean as the left and right data types,
respectively. Note: you may set any valid value.
* Instantiate a Pair object with String and List of Integers as the left and right data types,
  respectively. Note: you may set any valid value.
* Get the value of the left and right values and assign them to a String and List variable, respectively.

## 4: Working with Generic Methods

Given the Generic Box class in exercise #2, create the following methods in class BoxUtil:
* equals() - determines whether two boxes are equal by comparing their contents (field object);
returns `true` if two boxes are equal, `false` otherwise 
* clone() - accepts a Box object as an argument and returns a new Box object with the same content (field object)
