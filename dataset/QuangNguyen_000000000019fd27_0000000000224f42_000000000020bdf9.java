import java.util.*;
import java.io.*;
public class Solution {
    public static class Helper{
        public int start;
        public int end;
        public Helper(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Helper[] arr = new Helper[n];
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Helper temp = new Helper(start, end);
                arr[j] = temp;
            }
            StringBuilder builder = new StringBuilder();
            String re = compute(arr, builder,0, new ArrayList<Helper>(), new ArrayList<Helper>());
            if (re.equals(""))
                re = "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + re);
        }
    }
    public static String compute(Helper[] arr, StringBuilder builder, int i
                                    , ArrayList<Helper> arr1, ArrayList<Helper> arr2) {
        if (i == arr.length)
            return builder.toString();
        Helper cur = arr.get(i);
        int index = insert(cur, arr1);
        if (index != -1) {
            builder.append("C");
            String re = compute(arr, builder, i + 1, arr1, arr2);
            if (re.length() == arr.length)
                return re;
            builder.deleteCharAt(builder.length() - 1);
            arr1.remove(index);
        }
        index = insert(cur, arr2);
        if (index != -1) {
            builder.append("J");
            String re = compute(arr, builder, i + 1, arr1, arr2);
            if (re.length() == arr.length)
                return re;
            builder.deleteCharAt(builder.length() - 1);
            arr2.remove(index);
        }
        return "";
    }
    
    public static int insert(Helper cur, ArrayList<Helper> arr) {
        int start = 0;
        int end = arr.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            Helper temp = arr.get(mid);
            if (cur.start > temp.start)
                start = mid;
            else if (cur.start < temp.start)
                end = mid - 1;
            else 
                break;
        }
        Helper temp = arr.get(start);
        if (temp.end <= cur.start) {
            if (start + 1 < arr.size()) {
                Helper temp2 = arr.get(start + 1);
                if (temp2.start > cur.end) {
                    arr.add(start, cur);
                    return start;
                }
            }
        }        
        return -1;
    }
}