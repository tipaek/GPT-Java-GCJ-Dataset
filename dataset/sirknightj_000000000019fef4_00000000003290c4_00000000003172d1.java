import java.awt.*;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int slices = scanner.nextInt();
            int numSatisf = scanner.nextInt();
            Map<Long, Integer> pizza = new TreeMap<>();
            for(int j = 0; j < slices; j++) {
                long number = scanner.nextLong();
                if(pizza.containsKey(number)) {
                    pizza.put(number, pizza.get(number) + 1);
                } else {
                    pizza.put(number, 1);
                }
            }
            long longest = findMap(pizza);

            int cut = 0;
            if(slices == 1) {
                cut = numSatisf - 1;
            } else {
                while(pizza.get(longest) < numSatisf) {
                    if(pizza.containsKey(longest * 2)) {
                        slice(longest * 2, longest, pizza);
                        cut++;
                    } else if (pizza.containsKey(longest * 3)) {
                        slice(longest * 3, longest, pizza);
                        cut++;
                    } else {
                        slice(smallestSlice(pizza), 1, pizza);
                        cut++;
                    }
                    longest = findMap(pizza);
                }
            }
            System.out.println("Case #" + (i+1) + ": " + cut);

//            if(d != 0) {
//                System.out.println("Case #" + (i+1) + ": " + d);
//            } else {
//                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
//            }
        }
    }

    public static void slice(long slice, long chop, Map<Long, Integer> map) {
        long remainder = slice - chop;
        if(map.get(slice) == 1) {
            map.remove(slice);
        } else {
            map.put(slice, map.get(slice) - 1);
        }
        mapPut(remainder, map);
        mapPut(chop, map);
    }

    public static void mapPut(long put, Map<Long, Integer> map) {
        if(map.containsKey(put)) {
            map.put(put, map.get(put) + 1);
        } else {
            map.put(put, 1);
        }
    }

    public static long findMap(Map<Long, Integer> map) {
        long max = 0;
        int quantity = 0;
        for(long b : map.keySet()) {
            if(map.get(b) > quantity) {
                max = b;
                quantity = map.get(b);
            }
        }
        return max;
    }

    public static long smallestSlice(Map<Long, Integer> map) {
        return Collections.min(map.keySet());
    }
}