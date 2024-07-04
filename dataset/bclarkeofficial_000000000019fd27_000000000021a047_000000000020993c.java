import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            in.nextLine();
            int trace = 0;
            int index = 0;
            List<List<Integer>> cols = new ArrayList<>();
            int[] dupeCols = new int[n];
            int[] dupeRows = new int[n];
            int repeat = n;
            while(repeat > 0) {
                cols.add(new ArrayList<>());
                repeat--;
            }
            repeat = n;
            while(repeat > 0) {
                String nums = in.nextLine();
                List<Integer> integers = new ArrayList<>();
                for (int x = 0; x < nums.length(); x+=2) {
                    integers.add(Character.getNumericValue(nums.charAt(x)));
                }
                trace += integers.get(index);
                List<Integer> curr = new ArrayList<>();
                for (int x = 0; x < integers.size(); x++) {
                    int num = integers.get(x);
                    if (cols.get(x).contains(num)) {
                        dupeCols[x] = 1;
                    }
                    cols.get(x).add(num);
                    if (curr.contains(num)) {
                        dupeRows[index] = 1;
                    }
                    curr.add(num);
                }
                index++;
                repeat--;
            }

            int numDupeRows = 0;
            for (int num : dupeRows) {
                if (num == 1) numDupeRows++;
            }
            int numDupeCols = 0;
            for (int num : dupeCols) {
                if (num == 1) numDupeCols++;
            }

            System.out.println("Case #" + i + ": " + trace + " " + numDupeRows + " " + numDupeCols);
        }
    }
}