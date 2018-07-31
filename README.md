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
