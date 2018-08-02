# Java-Training

## Strings

Heap is where all the objects are kept

The strings that are hardcoded in code are put into string pool

Dynamic string i.e. string content produced at runtime will be on heap or one with new

_intern() will force a string to string pool. Forcibly keeping objects in string pool is costly because they're not easily available for garbage collection_

Strings are constant (immutable). They cannot change. That is, on doing uppercase function on a string, a new object is created in memory. 
_However, String buffers are mutable_

Writing override is optional. It is done to improve readability. Also, a compile time check is done by editor.

```
@Override // Right Clicking on Person, Source -> GeneratetoString()
public String toString() {
  return "Person [name=" + name + ", age=" + age + "]";
}
```

_Same signature => overriding_

#### Note: println is calling valueOf and valueOf is calling toString

Operator overloading is not supported in Java.

== checks addresses. equals() should be used for checking content

To see native code, you need to install java open source. Java became open source from 6 onwards. That is, openjdk.

When you override equals, hashCode has to be overriden too. The option is available in source. By default, hashCode returns memory address of object (till it is not overriden). hashCode() is for the benefit of HashMap.


finalize() - It's an empty method. It is called by garbage collector whenever object is available for garbage collection. It's like last code before object is freed from RAM. _Generally not used_

```
obj = null; // eligible for garbage collection provided no one else is pointing to it. Still only if garbage collection is called.
System.gc(); // forcing garbage collection
```
_System.gc() should not be used in production/final code_

### Tricky

```
class A {
  int x = 10;
  void print() { ... hello ... }
}

class B extends A {
  int x = 20;
  void print() { ... Hi ... }
}

main() {

  A a = new B()
  sysout(a.x) // 10 prints. early binding i.e. at compile time for variable
  a.print()  // Hi prints. late binding for function
}
```

### Wrapper classes are also immutable in nature e.g. Integer/int

_clone() performs shallow copy. It cannot be called without overriding.
clone() is protected. It is only available to subclasses. 
We can call it from inside xyz class. We cannot create object outside and call it._

shallow copy: A shallow copy of an object copies the ‘main’ object, but doesn’t copy the inner objects. The ‘inner objects’ are shared between the original object and its copy. For example, in our Person object, we would create a second Person, but both objects would share the same Name and Address objects.

deep copy: ? 

Steps: 1. override clone, 2. handle CloneNotSupportedException, 3. add implements Cloneable to xyz class

Cloning does not call constructor. Cloning copies data bit by bit and hence faster. Cloning is best when you don't know all the variables with varying scopes.
### We can increase visibility/scope when overriding. E.g. We can make protected to public.

## Interface

It is like a restricted verison of class. Contains only signatures of methods. Interface is like skeleton. Interface is meant for creating contracts.

You've to implement/override all the methods in interface. Interface's object is not created, it has reference to a class which has implements to the interface.

Methods need to be public in interface. Everything is abstract by default so no abstract keyword needed.

_From Java 8 on, non-abstract & static methods are allowed. Syntax:_
```
public default String info() {
  return "Dev by Google";
```
In above, info() can be overrided. It is however not compulsory.

#### If you don't want to implement a method that has to be overriden due to interface, we do:
```
@Override
	public void pause() {
		throw new UnsupportedOperationException("Method not yet implemented");
	}
```

#### Multiple inheritance is not supported by java. Even though you can say interface helps in it but not really. Why? Because in inheritance we get properties and characteristics of parent. However, in case of interface we aren't getting anything since it is just a skeleton. Rather we are getting more burden to put life into the methods of interface.

#### If two interfaces that are implemented in class have 2 methods with same name then we only need to define one body in class.

## Exception Handling

```
public double withdraw(double amount) throws Exception {
	if( amount > balance ) {
		Exception e = new Exception("Insufficient Balance!");
		throw e;
	}
	else {
		balance -= amount;
		return balance;
	}
}
```
_throws need to be mentioned in signature so that we can throw_

```
public static void main(String[] args) {
	BankAccount bankAcc = new BankAccount(100, 5000);

	try {
		double balance = bankAcc.withdraw(6000);
		System.out.println("Balance left: " + balance);
	} catch(Exception e) {
		System.out.println(e.getMessage());
	}

}
```

#### Throwable is parent class of Exception. Throwable has 2 types/childs: Exception and Error. 

#### Exceptions are checked i.e. compiler checks if exception is handled or not (try catch provided), and errors are unchecked.

#### Exceptions can be recovered from. Errors are something we cannot recover from.

#### OutOfMemoryError e.g. are errors because there is no point in catching it. So errors are generally related to low level resources (ram, cpu, etc.)

There are some exceptions that are not needed to be handled like error. The child class to exception called RuntimeException are unchecked in nature. E.g. NullPointerException, ArrayIndexOutOfBounds

```
public double withdraw(double amount) throws RuntimeException {
	if( amount > balance ) {
		RuntimeException e = new RuntimeException("Insufficient Balance!");
		throw e;
	}
	else {
		balance -= amount;
		return balance;
	}
}

public static void main(String[] args) {
	BankAccount bankAcc = new BankAccount(100, 5000);

//		try {
		double balance = bankAcc.withdraw(6000);
		System.out.println("Balance left: " + balance);
//		} catch(BankAccountException e) {
//			System.out.println(e);
//		}

}
```

### Tricky

```
class First {
	First() {
		def1
	}
	
	First(int x) {
		param1
	}
}

class Second extends First {

	Second() {
		def2
	}
	
	Second(int x) {
		param2
	}

}


main() {
	Second s1 = new Second(); // def1 def2
	Second s2 = new Second(10); // def1 param2
}
```

To avoid above, we explicitly put super keyword with specific constructor to call in parent. Otherwise default constructor of parent will be called.

#### Better to use List (interface) instead of ArrayList. This will promote loose coupling and we are talking through interface.

#### String ... strings => array of string 
