import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            int u;
            char c;
            int min;
            boolean foundAll;
            HashMap<Character, Integer> map;
            for (int l = 1; l <= t; ++l) {
                u = in.nextInt();

                map = new HashMap<>();
                foundAll = false;
                for (int i = 0; i < Math.pow(10, 4); i++) {
                    Long m = in.nextLong();
                    String s = in.next();

                    c = s.charAt(0);
                    if (map.get(c) != null) {
                        min = map.get(c);
                    } else {
                        min = 10;
                    }

                    int firstNum = Integer.parseInt(Long.toString(m).substring(0, 1));
                    if (min > firstNum && s.length() == u) {
                        map.put(c, firstNum);
                    }
                    //System.out.println("m: " + m + ", s: " + s + ", map: " + map);

                    if (!foundAll) {
                        for (int j = 1; j < s.length(); j++) {

                            if (map.get(s.charAt(j)) == null) {
                                map.put(s.charAt(j), 10);
                            }
                        }
                    }
                    if (map.size() == 10) {
                        foundAll = true;
                    }
                }

                Character[] res = new Character[10];

                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == 10) {
                        res[0] = entry.getKey();
                    } else {
                        res[entry.getValue()] = entry.getKey();
                    }
                }
                String s = "";  
                for(int i=0;i<10;i++){
                    s+=res[i];
                }
               
                System.out.println("Case #" + l + ": " + s);

            }
      }
    }