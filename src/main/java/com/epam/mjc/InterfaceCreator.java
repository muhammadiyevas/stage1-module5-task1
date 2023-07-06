package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;



public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
       return list -> list.stream().allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
           list.addAll(
                   list.stream()
                           .filter(s->s%2==0)
                           .collect(Collectors.toList())
           );
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
     return ()->values.stream()
             .filter(s->Character.isUpperCase(s.charAt(0)))
             .filter(s -> s.endsWith("."))
             .filter(s->s.split(" ").length>3)
             .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> resultMap = new HashMap<>();

            for (String str : list) {
                resultMap.put(str, str.length());
            }
            return resultMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList = (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
        return concatList;
    }
}
