# Generics (Part 2) Hands-on

## 1. Bounded Type Parameters

a) Modify the Generic `Box<T>` class to restrict the Type Parameter to Collection of String

```java
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
```

b) In a separate class `BoundedTypeBoxMain` in its `main()` method, instantiate `Box` class in 1.a
and invoke `box()` method with an ArrayList of String

```java
box.box(new ArrayList<String>());
```   

c) Invoke `box()` method with a HashSet of String. Will the code compile?

```java
box.box(new HashSet<String>());
```

## 2. Bounded Type Parameters in Generic Methods

a) Modify `PairUtils` `equals()` method to bound
parameter type `T` to `CharSequence` (java.lang.CharSequence) and
parameter type `S` to `Box<T>`.

```java
public class PairUtils {

    public static <T, S> boolean equals(Pair<T, S> pair1, Pair<T, S> pair2) {
        if (pair1 == null || pair2 == null ||
                pair1.getLeft() == null || pair1.getRight() == null ||
                pair2.getLeft() == null || pair2.getRight() == null) {
            return false;
        }
        return pair1.getLeft().equals(pair2.getLeft()) && pair1.getRight().equals(pair2.getRight());
    }

}
```

b) Try using `PairUtils` `equals()` method in another class.
You may create a new class `PairUtilsTest` and write a `main()`
method containing the following invocations:

```java
public class PairUtilsTest {
    public static void main(String[] args){
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Hello World");
        Pair<String, StringBuilder> pair1 = new Pair<>("mykey", stringBuilder1);
        
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Hello");
        Pair<String, StringBuilder> pair2 = new Pair<>("mykey", stringBuilder2);
        
        System.out.println("equal: " + PairUtils.equals(pair1, pair2));
    }
}
```

## 3. Generics and Inheritance

Given the following code for ATM Process/Logic, extract the lines of code for the transaction proper into separate
classes and figure out the generic steps to reduce the transaction processes into one Generic Type.

```java
public class AtmLogic {

    public void start() {
        // Start a new transaction
        String cardNumber = userInterface.askToInsertCard();
        Transaction transaction = bankGateway.createNewTransaction(cardNumber);

        // Validate PIN
        String pin;
        int pinValidationAttempts = 0;
        do {
            if (pinValidationAttempts == 3) {
                transaction.setResult(new TransactionResult(TransactionStatus.CARD_BLOCKED));
                break;
            }
            pin = userInterface.askForPin();
            pinValidationAttempts++;
        } while (!bankGateway.isValidPin(pin, transaction));

        if (transaction.getResult() == null || !TransactionStatus.CARD_BLOCKED.equals(transaction.getResult().getStatus())) {
            TransactionType transactionType = userInterface.askForTransactionType();
            transaction.setType(transactionType);

            // Perform Transaction Proper
            BigDecimal availableBalance;
            BigDecimal amount;

            switch (transactionType) {
                case BALANCE_INQUIRY:
                    availableBalance = bankGateway.inquireBalance(transaction);
                    transaction.setResult(new TransactionResult(TransactionStatus.SUCCESSFUL, availableBalance));
                    break;
                case DEPOSIT:
                    amount = userInterface.askForAmount();
                    transaction.setAmount(amount);
                    bankGateway.creditAccount(amount, transaction);
                    availableBalance = bankGateway.inquireBalance(transaction);
                    transaction.setResult(new TransactionResult(TransactionStatus.SUCCESSFUL, availableBalance));
                    break;
                case WITHDRAWAL:
                    amount = userInterface.askForAmount();
                    transaction.setAmount(amount);
                    bankGateway.debitAccount(amount, transaction);
                    availableBalance = bankGateway.inquireBalance(transaction);
                    transaction.setResult(new TransactionResult(TransactionStatus.SUCCESSFUL, availableBalance));
                    break;
                default:
            }
        }

        // Display Result
        userInterface.displayTransactionResult(transaction);
    }

}
```

## 4. Type Inference

a) Given:

```java
static <T> T pick(T t1, T t2) {
    return t2;
}
```

Will the following compile? Why?

```java
Serializable value = pick("Hello World!", new ArrayList<Integer>());
``` 

b) Will the following compile? Why?

```java
Collection<String> collections = new ArrayList<String>();
```

How will the statement look like if we apply Type Inference?

c) Given:

```java
Map<String, Map<String, Object>> doubleMap = new HashMap<>();
```

Is the following statement valid?

```java
doubleMap.put("abc", Collections.<String, Map<String, Object>>emptyMap());
```

Correct the statement above and apply Type Inference.


