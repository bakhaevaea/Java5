package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.*;

public class NameWorkers {
    private static HashMap<String, Integer> namesRank = new HashMap<>();
    public void add (String fio) {
        String name = fio.split(" ")[0];
        if (namesRank.containsKey(name)) {
            int count  = namesRank.get(name);
            count++;
            namesRank.put(name, count);
            //namesRank.replace(name, count, count++);
        } else {
            namesRank.put(name, 1);
        }
    }
    public void getSortNamesRank(){
        Map<String, Integer> sortedNameRank = namesRank.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        sortedNameRank.entrySet().forEach(System.out::println);
    }
    public static HashMap<String, Integer> getNamesRank() {
        return namesRank;
    }
}
