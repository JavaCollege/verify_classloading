在jdk1.8下：
```
$ javac java/util/UUID.java
$ jar cvf u.jar java
$ javac UUIDemo.java

$ java UUIDemo
7349bc21-b935-429c-a98c-f15db4a78494
de95026b-89f1-452b-be26-c7bd52d15f36
81100165-2b01-4695-8fc9-7311de6054a0
6bf9002b-9c90-4587-b64b-b62099004ee7
e5433d85-9eba-4f1e-b397-2d2a756978b0

$ java -Djava.endorsed.dirs=. UUIDemo
1a1a1a1a-1a1a-1a1a-1a1a-1a1a1a1a1a1a
1a1a1a1a-1a1a-1a1a-1a1a-1a1a1a1a1a1a
1a1a1a1a-1a1a-1a1a-1a1a-1a1a1a1a1a1a
1a1a1a1a-1a1a-1a1a-1a1a-1a1a1a1a1a1a
1a1a1a1a-1a1a-1a1a-1a1a-1a1a1a1a1a1a
```
从这里可以看出来，UUID.randomUUID方法已经被我们改掉了。
