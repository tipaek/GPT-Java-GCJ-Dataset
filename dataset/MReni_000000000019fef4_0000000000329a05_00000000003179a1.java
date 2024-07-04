
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Xiaochuan\\Documents\\workspace\\lc\\lc\\src\\main\\java\\jam2020\\overrandom.input")));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            in.nextInt();
            TreeMap<Long, List<String>> map = new TreeMap<>();
            Map<Character, Integer> charCounter = new HashMap<>();

            for (int j = 0; j < 10000; j++) {
                long num = in.nextLong();
                String s = in.nextLine().trim();
                for (char c : s.toCharArray()) charCounter.compute(c, (k,v) -> v == null? 1 : v+1);
                if (map.containsKey(num)) map.get(num).add(s);
                else {
                    List<String> lst = new ArrayList<>();
                    lst.add(s);
                    map.put(num, lst);
                }
            }
  
          String output = getOutput(map, charCounter);
          System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String getOutput(TreeMap<Long, List<String>> map, Map<Character, Integer> charCounter) {
        // Map<Character, Set<Integer>> pos = new HashMap<>();
        // for (char c : charCounter.keySet()) {
        //     Set<Integer> posSet = new HashSet<>();
        //     for (int i = 0; i < 10; i++) posSet.add(i);
        //     pos.put(c, posSet);
        // }

        // for (Map.Entry<Long, List<String>> entry : map.entrySet()) {
        //     long limit = entry.getKey();
        //     List<String> values = entry.getValue();
        //     for (String value : values) {
        //         char[] chars = value.toCharArray();
        //         for (int i = 0; i < chars.length; i++) {
        //             char c = chars[i];
        //         }
        //     }
        // }

        Map<Character, Set<Integer>> pos = new HashMap<>();
        char[] out = new char[charCounter.size()];
        for (Map.Entry<Long, List<String>> entry : map.entrySet()) {
			long key = entry.getKey();
            List<String> results = entry.getValue();
            if (key < 10) {
                for (String result : results) {
                    if (result.length() == 0) 
                        System.out.println(result);
                    char resultChar = result.charAt(0);
                    Set<Integer> possC = pos.getOrDefault(resultChar, new HashSet<>());
                    if (possC.size() == 1) continue;
                    for (int i = 1; i <= key; i++) {
                        if (out[i] == 0) {
                            possC.add(i);
                        } else {
                            possC.remove(i);
                        }
                    }
                    if (possC.size() == 1) out[possC.stream().findFirst().get()] = resultChar;
                    pos.put(resultChar, possC);
                }
            } else {
                for ( Map.Entry<Character, Set<Integer>> posC : pos.entrySet()) {
                    if (posC.getValue().size() == 1) {
                        out[posC.getValue().stream().findFirst().get()] = posC.getKey();
                    }
                }
            }
        }

        for (char c : charCounter.keySet()) {
            boolean eql = false;
            for (char x : out) {
                if (x == c) eql = true;
            }
            if (!eql) out[0] = c;
        }


        // LinkedHashMap<Character, Integer> output = new LinkedHashMap<>();
        // charCounter.entrySet()
        //     .stream()
        //     .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
        //     .forEachOrdered(x -> output.put(x.getKey(), x.getValue()));
        
        // int idx = 1;
        // for (Character c : output.keySet()) {
        //     out[idx++ % charCounter.size()] = c;
        // }
     
        return new String(out);
    }

}