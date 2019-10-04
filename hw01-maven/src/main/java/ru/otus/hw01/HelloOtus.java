package ru.otus.hw01;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class HelloOtus {
    public static void main(String... args) {
        List<Integer> example = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println(Lists.reverse(example));
    }
}