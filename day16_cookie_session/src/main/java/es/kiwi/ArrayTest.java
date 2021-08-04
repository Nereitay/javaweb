package es.kiwi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            arrayList.add(i);
        }
        Integer reduce = arrayList.stream().reduce(100, (a, b) -> a - b);
        System.out.println(reduce);
    }



}
