# Generics Hands-on

## 1. Custom Generic Type

Given: a class Box below has been implemented without using Generics.

```java
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
```

Problem: you must create a version of the Box class using Generics
such that the data type of the object inside the box can be generic.

Here's a sample usage of the Generic Box class:

```java
Box<Double> box = new Box<>();
box.box(1.2345);
Double value = box.unbox();
```

