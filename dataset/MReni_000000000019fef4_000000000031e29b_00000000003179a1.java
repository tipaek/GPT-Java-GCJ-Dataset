
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Xiaochuan\\Documents\\workspace\\lc\\lc\\src\\main\\java\\jam2020\\overrandom.input")));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            TreeMap<Long, String> map = new TreeMap<>();
            Map<Character, Integer> charCounter = new HashMap<>();

            for (int j = 0; j < 10000; j++) {
                long num = in.nextLong();
                String s = in.nextLine().trim();
                for (char c : s.toCharArray()) charCounter.compute(c, (k,v) -> v == null? 1 : v+1);
                map.put(num, s);
            }
  
          String output = getOutput(map, charCounter);
          System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String getOutput(TreeMap<Long, String> map, Map<Character, Integer> charCounter) {
        LinkedHashMap<Character, Integer> output = new LinkedHashMap<>();
        charCounter.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
            .forEachOrdered(x -> output.put(x.getKey(), x.getValue()));
        
        char[] out = new char[charCounter.size()];
        int idx = 1;
        for (Character c : output.keySet()) {
            out[idx++ % charCounter.size()] = c;
        }
     
        return new String(out);
    }

}