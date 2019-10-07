package ru.otus.hw02;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DIYarrayList<Integer> srcList = new DIYarrayList<>();
        DIYarrayList<Integer> destList = new DIYarrayList<>();

        Random random = new Random();

        for (int i = 0; i < 23; i++) {
            srcList.add(random.nextInt(100));
            destList.add(i);
        }

        System.out.println("---------------- task 1: copy collections ----------------");
        System.out.println("copy before src : " + srcList.toString());
        System.out.println("copy before dest : " + destList.toString());
        Collections.copy(destList, srcList);
        System.out.println("\ncopy after src : " + srcList.toString());
        System.out.println("copy after dest : " + destList.toString());

        System.out.println("\n---------------- task 2: collections add all ----------------");
        boolean addAllResult = Collections.addAll(destList, 100, 101,102);
        System.out.println("addAll success : " + addAllResult);
        System.out.println("addAll result : " + destList.toString());

        System.out.println("\n---------------- task 3: collections sort ----------------");
        Collections.sort(destList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null && o2 == null) return 0;
                if (o1 == null) return 1;
                if (o2 == null) return -1;
                return o1 - o2;
            }
        });
        System.out.println("sort result: " + destList.toString());
    }
}
