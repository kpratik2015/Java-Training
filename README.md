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


### Overriding contains and equals

```
package com.pratik.training.basics;

public class User {

	private String username;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
}

```

```
package com.pratik.training.basics;

import java.util.ArrayList;
import java.util.List;

public class UserService {

	private List<User> users;
	
	public UserService() {
		users = new ArrayList<>();
		users.add(new User("pratik","123"));
		users.add(new User("josh","456"));
		users.add(new User("rahul","789"));
		users.add(new User("ritesh","1011"));
		users.add(new User("karthik","1213"));
	}
	
	public boolean isValidUser(String username, String password) {
//		for( User us : users) {
//			if	(
//					us.getUsername().equals(username) 
//					&& us.getPassword().equals(password)
//				)
//				return true;
//		}
//		return false;
		/*
		 * OVERRIDE HASHCODE AND EQUALS TO GET CORRECT OUTPUT FROM CONTAINS
		 */
		return users.contains(new User(username, password)); 
	}
	
	public static void main(String[] args) {
		UserService us = new UserService();
		System.out.println(us.isValidUser("pratik", "123"));
	}
}

```

#### // TODO helps us identify lines of code which are to be implemented.

## Innerclass and Lambda

- It can be public. 
- There is no as such benefit but it is used for logical purpose. However, we can better hide by making innerclass private.
- Innerclass has access to private variables of class enclosing it.

_ALLOWED (Class inside function): \[This is more popular\]
```
package com.pratik.training.innerclass;

@FunctionalInterface
interface Printer {
	void print(String document);
}


class DotMatrixPrinter implements Printer {
	@Override
	public void print(String document) {
		System.out.println("Code to print the " + document);
	}
}

class WordApplication {

	/*
	 * This code is not highly re-usable. 
	 * It is not worth writing in separate file and sharing with others.
	 * Basically its usability is less.
	 */
	
	class InbuiltPrinter implements Printer {
		/*
		 * Innerclass can be a public class.
		 * Why this innerclass? Because logically WordApplication is not a printer.
		 * That is, there is no IS-A relation with Printer for WordApplication.	
		 */
		@Override
		public void print(String document) {
			System.out.println("Code to print the " + document);
		}
	}

	
}


public class InnerClassesAndLambda {
	
	public static void main(String[] args) {
		
		class InkjetPrinter implements Printer {
			@Override
			public void print(String document) {
				System.out.println("Code to print the " + document);
			}
		}
		InkjetPrinter ip = new InkjetPrinter();
		ip.print("abc.txt");
		
		// Anonymous Inner Class
		Printer p = new Printer() { // Writing a class that implements Printer interface
			public void print(String document) {
				System.out.println("Code to print the " + document);
			}
		};
		p.print("xyz.txt");
		
		// Lamba Style - anonymous functions/methods
		// Lambda style can only be used with interfaces having one method
		Printer pr = (String document) -> {
			System.out.println("Code to print the " + document);
		};
		// OR
		// Printer pr = (String document) -> System.out.println("Code to print the " + document);
		// OR
		// Printer pr = d -> System.out.println("Code to print the " + d);
		pr.print("ai.txt");
	}
	
}
```

Anonymous class is always a subclass. It either implements an interface or extends a class.

Lambda style can only be used with interfaces having one method

@FunctionalInterface for interface with only one method.

## Threading

Two ways to create java thread:
- Extend the java.lang.Thread class
- Implement the java.lang.Runnable interface

When a Java Virtual Machine starts up, there is usually a single non-daemon thread (which typically calls the method named main of some designated class). 

The name of thread created after java wakes up is Main. Basically every java program is a thread. JVM creates this non-daemon thread called Main.

By default in java any thread we create is non-daemon. JVM will wait for any thread that is still running. 

##### if thread is set as daemon then the JVM doesn't wait for the thread to complete. And as JVM quits, thread also quit as they need JVM to run.

Download: [Java Concurrency Animated](https://sourceforge.net/projects/javaconcurrenta/)

Add synchronized keyword before function signature for common function that can be executed by multiple threads.

Semaphore has permits. It can allow 'n' number of threads to execute a block of code. Mutex in java is achieved through synchornized keyword.

Latch is like multiple locks with different keys on a block of code.

## Streams

Reading and writing and networking are common areas for stream. 

A stream is a path of information from a source to destination.

There are 2 types of streams: Bytes stream and character stream.

Byte stream has inputstream and outputstream

Character stream has reader and writer

Character encoding: 
- ANSI/ASC II (only for english characters)
- UTF-8 
- UTF-16 (for chinese, japanse languages - simplified)
- UTF-32

#### /** to start for documentation

Buffer size is 8 kb. Without BufferedInputStream, the FileInputStream has to go through many layers of OS, driver, etc. to get the reading done for file.

Higher the size of buffer doesn't mean speedier the copy. The buffer is in JVM. Basically there is buffer in JVM and in RAM. The solution is nio library.

_Note popular use of fetching line by line_
```
String line = "";
			
while(true) {
	line = inBuffer.readLine();
	if(line == null) break;
	outBuffer.write(line);
	outBuffer.newLine();
}
```

_Note to remove duplicates we can use hashset._

## Serialization

Serialization provides a standard way to save and restore object graphs between sessions on the same or different systems.

Serialization saves the following:
- Object type
- Internal information
- Reference to other objects.

E.g. open notepad, resize and move. Then close. Re-open and it will open up where it was closed with the same size. Here, the state is saved. OR games

Making an object for Serialization: sample object has to implement Serializable.

Classes to help us make serializable object: ObjectOutputStream, ObjectInputStream

Serializable interface is markup interface. There are no functions.

#### Externaizable can be used to customize how the object is written in file.

_Activation and Passivation terms are used in session. Passivation means saving state into persistent medium_

#### Marker Interface: Is used only for identification or toggling like a class is serializable only when 'implements' done. E.g. cloneable, serializable.

_nio library -> non blocking i/o
It will require only one buffer and it'll be shared between OS and JVM.
allocateDirect() helps in above sharing (making it very fast).
Channel in nio gives native handle to file which makes it fast.
_
