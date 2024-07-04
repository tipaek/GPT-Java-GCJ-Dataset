import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] list = new long[n];
            long max = 0;
            
            HashMap<Long, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                long l = sc.nextLong();
                max = Math.max(max, l);
                addToMap(map, l);
            }
            
            System.out.print("Case #" + test + ": ");
            
            if (containsValue(map, d)) {
                System.out.println(0);
                continue;
            }
            
            if (d == 2) {
                System.out.println(1);
                continue;
            }
            
            if (containsPair(map, max)) {
                System.out.println(1);
                continue;
            }
            
            System.out.println(2);
        }
    }

    static void addToMap(HashMap<Long, Integer> map, Long value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
    }

    static boolean containsValue(HashMap<Long, Integer> map, int value) {
        for (int count : map.values()) {
            if (count == value) {
                return true;
            }
        }
        return false;
    }

    static boolean containsPair(HashMap<Long, Integer> map, long max) {
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long key = entry.getKey();
            if (map.containsKey(key * 2) || (entry.getValue() == 2 && key < max)) {
                return true;
            }
        }
        return false;
    }
}