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


