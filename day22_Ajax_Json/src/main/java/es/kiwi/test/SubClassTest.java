package es.kiwi.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SubClassTest {
    public static void main(String[] args) throws InterruptedException {
        SonClass1 sonClass1 = new SonClass1();
        SonClass2 sonClass2 = new SonClass2();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        sonClass2.addList("aaa", list2);
        sonClass1.addList("bbb", list1);

        new Thread(()->{
            List<String> list3 = new ArrayList<>();
            sonClass1.addList("ccc", list3);
            System.out.println(list3);
        }, "t1").start();
        Thread.sleep(1000);
        System.out.println(list1);
        System.out.println(list2);

    }

}
class ParClass {

    protected void addList(String str, List<String> list) {
        list.add(str);
    }


}
class SonClass1 extends ParClass {

}
class SonClass2 extends ParClass {

}