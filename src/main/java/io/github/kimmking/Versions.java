package io.github.kimmking;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/4 05:15
 */
public class Versions {

    public static String echo() {

        System.out.println(Versions.class.getProtectionDomain().getCodeSource());
        System.out.println(Versions.class.getClassLoader());
        return "v0.0.1";
    }

}
