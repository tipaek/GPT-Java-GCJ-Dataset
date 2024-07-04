
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            int U = in.nextInt();
            Map<Integer, Set<String>> cache = new HashMap<>();
            Set<Character> allhar = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                int m = in.nextInt();
                String u = in.next();
                Set<String> list = cache.getOrDefault(m, new HashSet<>());
                list.add(u);
                cache.put(m, list);
                for(char c: u.toCharArray())allhar.add(c);
            }

            List<Integer> list = cache.keySet().stream().collect(Collectors.toList());
            Collections.sort(list);
            Map<Integer, Character> dict = new HashMap<>();
            for(int num: list) {
                if (num<10)
                    use(num, cache.get(num), dict);
                else break;
            }
            allhar.removeAll(dict.values());
            dict.put(0, allhar.stream().findAny().get());
            String ans = "";
            for (int i = 0; i < 10; i++) {
                ans += dict.get(i);
            }
            System.out.print("Case #"+(i11+1)+": " + ans+"\t");
        }
        in.close();
    }

    private static void use(int num, Set<String> strings, Map<Integer, Character> dict) {
        //System.out.println(num + ""+ strings);
        Collection<Character> allLower = dict.values();
        char c = strings.stream().map(s -> s.charAt(0)).filter(c1 -> !allLower.contains(c1)).findFirst().get();
        dict.put(num, c);
    }
}
