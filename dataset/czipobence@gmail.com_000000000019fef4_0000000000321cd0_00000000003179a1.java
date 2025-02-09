import java.util.*;
import java.io.*;
public class Solution {

    public static String sortByValue(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            builder.append(entry.getKey());
        }

        return builder.reverse().toString();
    }

   public static void main(String[] args) {
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
       for (int i = 1; i <= t; ++i) {
           int u = in.nextInt();
           in.nextLine();

           Set<Character> chars = new HashSet<>();

           Map<Character, Integer> countAsMsb = new HashMap<>();


           for (int dataCount = 0; dataCount < 10000; dataCount++) {
               String line = in.nextLine();
               String[] splited = line.split(" ");

               String randomString = splited[1];

               if (chars.size() < 10) {
                   for (char c: randomString.toCharArray()) {
                       chars.add(c);
                   }
               }



               char firstChar = randomString.charAt(0);
               countAsMsb.put(firstChar, countAsMsb.getOrDefault(firstChar, 0) + 1);
           }

           char forZero = '?';

           for (char key: chars) {
               if (!countAsMsb.containsKey(key)) {
                   forZero = key;
               }
           }

           String keys = sortByValue(countAsMsb);

           System.out.println("Case #" + i + ": " + forZero + keys);
       }
    }
}