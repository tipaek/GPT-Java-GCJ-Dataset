import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String temp = in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] ss = line.split(" ");
            int n = Integer.parseInt(ss[0]);
            int d = Integer.parseInt(ss[1]);
            long[] nums = new long[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextLong();
            }
            temp = in.nextLine();

            String ans = solve(n, d, nums);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(int n, int d, long[] nums) {
        long min = 0, max = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Long> count = new HashMap<>();
        for (long key : map.keySet()) {
            int c = map.get(key);
            if (!count.containsKey(c) || count.get(c) > key) {
                count.put(map.get(key), key);
            }
        }

        if (d == 2) {
            if (count.containsKey(2)) {
                return "0";
            } else {
                return "1";
            }
        } else {
            if (count.containsKey(3)) {
                return "0";
            }

            //a and 2a
            for (long key : map.keySet()) {
                if (map.containsKey(2 * key)) {
                    return "1";
                }
            }

            //a,a and b
            if (count.containsKey(2)) {
                long curr = count.get(2);
                if (max > curr) {
                    return "1";
                }
            }

            return "2";

        }

    }

    private static String solve1(String[] input, String[] output) {
        boolean flag = false;
        Set<Character>[] sets = new Set[10];
        Set<Character> all = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            sets[i] = new HashSet<>();
        }

        for (int i = 0; i < input.length; i++) {
            //check skip
            if (input[i].charAt(0) == '-') {
                flag = true;
                break;
            }
            int in = input[i].charAt(0) - '0';
            char out = output[i].charAt(0);

            if (input[i].length() == output[i].length()) {
                sets[in].add(out);
            }

            for (int j = 0; j < output[i].length(); j++) {
                all.add(output[i].charAt(j));
            }
        }

        if (!flag) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 9; i++) {
                char curr = sets[i].iterator().next();
                sb.append(curr);

                for (int j = i + 1; j <= 9; j++) {
                    sets[j].remove(curr);
                }
                all.remove(curr);
            }
            char curr = all.iterator().next();
            sb.insert(0, curr);
            return sb.toString();
        } else {
            //set3

            Map<Character, Integer> count = new HashMap<>();
            Set<Character> all2 = new HashSet<>();
            for (int i = 0; i < input.length; i++) {
                char curr = output[i].charAt(0);
                count.put(curr, count.getOrDefault(curr, 0) + 1);



                for (int j = 0; j < output[i].length(); j++) {
                    all2.add(output[i].charAt(j));
                }
            }

            PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> (count.get(b) - count.get(a)));
            for (char key : count.keySet()) {
                pq.add(key);
                all2.remove(key);
            }

            StringBuilder sb = new StringBuilder();
            if (!all2.isEmpty())
            sb.append(all2.iterator().next());
            while(!pq.isEmpty()) {
                sb.append(pq.remove());
            }
            return sb.toString();




        }




    }


    private static String solve0(int x, int y, String s) {
        char[] route = s.toCharArray();
        int t = 0;
        int n = route.length;

        for (int i = 0; i < n; i++) {
            int curr = Math.abs(x) + Math.abs(y);
            if (curr <= t) {
                return String.valueOf(i);
            }

            if (route[i] == 'S') {
                y--;
            } else if (route[i] == 'N') {
                y++;
            } else if (route[i] == 'E') {
                x++;
            } else {
                x--;
            }
            t++;

        }
        if (Math.abs(x) + Math.abs(y) <= t) {
            return String.valueOf(n);
        } else {

            return "IMPOSSIBLE";
        }
    }




}




class TrieNode{
    char c;
    int count;
    TrieNode[] next;
    public TrieNode(char _c){
        c = _c;
        next = new TrieNode[26];
        count = 0;
    }
}
