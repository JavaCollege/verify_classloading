### 验证类加载的几个问题

如下两个包是同一个代码打包的，执行里面的主类io.github.kimmking.Main分别输出v0.0.1版本和v0.0.2版本。

- versions-0.0.1-SNAPSHOT.jar

- versions-0.0.2-SNAPSHOT.jar

#### 验证类的加载执行顺序

```
$ java -cp versions-0.0.1-SNAPSHOT.jar:versions-0.0.2-SNAPSHOT.jar io.github.kimmking.Main
v0.0.1
$ java -cp versions-0.0.2-SNAPSHOT.jar:versions-0.0.1-SNAPSHOT.jar io.github.kimmking.Main
v0.0.2
```

这就说明了，谁放在classpath的前面就会执行谁。

### 验证通过扩展类加载器加载（JDK1.8）

```
$ java -cp versions-0.0.1-SNAPSHOT.jar  io.github.kimmking.Main
v0.0.1
$ mkdir /tmp/1 && cp versions-0.0.2-SNAPSHOT.jar /tmp/1
$ java -cp versions-0.0.1-SNAPSHOT.jar -Djava.ext.dirs=/tmp/1  io.github.kimmking.Main
v0.0.2
```

这就说明了，通过java.ext.dirs指定的扩展类加载器加载的优先级比较高。

如果我们在代码里加上打印类的classloader，就会发现：

```
$java -cp versions-0.0.1-SNAPSHOT.jar io.github.kimmking.Main
sun.misc.Launcher$AppClassLoader@4e25154f
v0.0.1

$java -cp versions-0.0.1-SNAPSHOT.jar -Djava.ext.dirs=/tmp/1 io.github.kimmking.Main
sun.misc.Launcher$ExtClassLoader@7852e922
v0.0.2
```

这就验证了确实是通过ExtClassLoader加载的。

### 验证JDK类运行期修改

两个可行办法：

- 通过java agent在instrument中可以修改JDK中的类，比如这里的例子里（[代码](https://github.com/kimmking/research/blob/master/agentx/src/main/java/cn/kimmking/research/agentx/XAgent.java)）运行时修改了java.util.Date类，运行方式参考（[README.md](https://github.com/kimmking/research/blob/master/agentx/README.md)）。
- 通过-Djava.endorsed.dirs覆盖类（jdk1.8有这个参数），比如覆盖掉UUID类（详见[uuid.md](uuid/uuid.md) ）。
