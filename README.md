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
Explore the classes __BankMain__ and __Bank__

```java
public class BankMain {

    public static void main(String[] args) {
        AccountService accountService = new FakeAccountService();

        BalanceInquiryHandler balanceInquiryHandler = new BalanceInquiryHandler(accountService);
        DepositHandler depositHandler = new DepositHandler(accountService);
        WithdrawalHandler withdrawalHandler = new WithdrawalHandler(accountService);
        FundTransferHandler fundTransferHandler = new FundTransferHandler(accountService);

        Bank bank = new Bank(balanceInquiryHandler, depositHandler, withdrawalHandler, fundTransferHandler);

        String account1 = "0001234567";
        String account2 = "0001234600";

        System.out.println("Balance Inquiry...");
        TransactionResult result = bank.balanceInquiry(new BalanceInquiry(account1));
        System.out.println(result);

        System.out.println("\nDeposit Amount...");
        result = bank.deposit(new Deposit(account1, new BigDecimal("100.0")));
        System.out.println(result);

        System.out.println("\nWithdraw Amount...");
        result = bank.withdraw(new Withdrawal(account1, new BigDecimal("15.0")));
        System.out.println(result);

        System.out.println("\nFund Transfer...");
        result = bank.fundTransfer(new FundTransfer(account1, account2, new BigDecimal("25.0")));
        System.out.println(result);
    }

}
```

```java
public class Bank {

    private final BalanceInquiryHandler balanceInquiryHandler;
    private final DepositHandler depositHandler;
    private final WithdrawalHandler withdrawalHandler;
    private final FundTransferHandler fundTransferHandler;

    public Bank(BalanceInquiryHandler balanceInquiryHandler,
                DepositHandler depositHandler,
                WithdrawalHandler withdrawalHandler,
                FundTransferHandler fundTransferHandler) {
        this.balanceInquiryHandler = balanceInquiryHandler;
        this.depositHandler = depositHandler;
        this.withdrawalHandler = withdrawalHandler;
        this.fundTransferHandler = fundTransferHandler;
    }

    public TransactionResult balanceInquiry(BalanceInquiry balanceInquiry) {
        return balanceInquiryHandler.handleTransaction(balanceInquiry);
    }

    public TransactionResult deposit(Deposit deposit) {
        return depositHandler.handleTransaction(deposit);
    }

    public TransactionResult withdraw(Withdrawal withdrawal) {
        return withdrawalHandler.handleTransaction(withdrawal);
    }

    public TransactionResult fundTransfer(FundTransfer fundTransfer) {
        return fundTransferHandler.handleTransaction(fundTransfer);
    }

}
```

Modify the application such that Balance Inquiry, Deposit, Widthdrawal and Fund Transfer will be handled
by just one __GenericTransactionHandler__.

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


