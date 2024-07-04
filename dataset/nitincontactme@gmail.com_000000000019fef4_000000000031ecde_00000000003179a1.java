
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
            Map<Long, Set<String>> cache = new HashMap<>();
            Set<Character> allhar = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                long m = in.nextLong();
                String u = in.next();
                Set<String> list = cache.getOrDefault(m, new HashSet<>());
                list.add(u);
                cache.put(m, list);
                for(char c: u.toCharArray())allhar.add(c);
            }

            List<Long> list = cache.keySet().stream().collect(Collectors.toList());
            Collections.sort(list);
            Map<Integer, Set<Character>> dict = new HashMap<>();
            for(long num: list) {
                Set<String> allPossible = cache.get(num);
                for(String s: allPossible) {
                    String numS = Long.toString(num);
                    if (s.length() != Long.toString(num).length())continue;
                    System.out.println(numS+"\t"+s);
                    use(numS.charAt(0)-'0', s.charAt(0), dict);
//                    for (int i = 0; i < s.length(); i++) {
//                        use(numS.charAt(s.length()-1-i)-'0', s.charAt(s.length()-1-i), dict);
//                    }
                }
                //use(num, cache.get(num), dict);
            }
            allhar.removeAll(dict.values());
            //dict.put(0, allhar.stream().findAny().get());
            String ans = "";
            Set<Character> cum = new HashSet<>();
            for (int i = 1; i < 10; i++) {
                //ans += dict.get(i);
                Set<Character> set = dict.get(i);
                set.removeAll(cum);
                cum.addAll(set);
                ans += set.stream().findFirst().get();
            }
            allhar.removeAll(cum);
            ans = allhar.stream().findFirst().get() + ans;
            System.out.print("Case #"+(i11+1)+": " + ans+"\n");
        }
        in.close();
    }

    private static void use(int num, char c, Map<Integer, Set<Character>> dict) {
        //System.out.println(num + ""+ strings);
//        Collection<Character> allLower = dict.values();
//        char c = strings.stream().map(s -> s.charAt(0)).filter(c1 -> !allLower.contains(c1)).findFirst().get();
//        dict.put(num, c);
        System.out.println(num +"\t"+ c);
        Set<Character> set = dict.getOrDefault(num, new HashSet<>());
        set.add(c);
        dict.put(num, set);
    }
}
