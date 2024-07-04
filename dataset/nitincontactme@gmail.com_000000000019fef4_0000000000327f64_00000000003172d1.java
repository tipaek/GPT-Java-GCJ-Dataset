
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            int n = in.nextInt(), d = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = in.nextLong();
            Arrays.sort(arr);

            int ans = cut(arr, d, 0);
            System.out.print("Case #"+(i11+1)+": " + ans+"\n");
        }
        in.close();
    }

    private static int cut(long[] arr, int d, int i) {

        if (d==0)return 0;
        if (i>=arr.length) return 10000;
        String key = Arrays.toString(arr)+"\t"+i+"\t"+d;
        if (cache.containsKey(key))
            return cache.get(key);
        long val = arr[i];
        //make no cut
        int nocut = cut(arr, d-1, i+1, val);

        //make 1 cut
        int cut12 = 1+cut(arr, d-2, i+1, val/2);

        //make 2 cut
        int cut22 = 2+cut(arr, d-4, i+1, val/4);

        long[] arrDup = Arrays.copyOf(arr, arr.length);
        arrDup[i] = (d-1)*val/d;
        int cutDiv = 1 + cut(arrDup, d-1, i);

        int ans = min(nocut, cut12, cut22, cutDiv, cut(arr, d, i+1));
        cache.put(key, ans);
        return ans;
    }

    private static int min(int...nums) {
        int min = 10000;
        for(int n: nums)
            min = Math.min(min, n);
        return min;
    }

    static Map<String, Integer> cache = new HashMap<>();

    private static int cut(long[] arr, int d, int index, double fixVal) {
        if (d<=0) return 0;
        if (index>=arr.length)return Integer.MAX_VALUE/2;
        String key = Arrays.toString(arr)+"\t"+index+" "+fixVal;
        if (cache.containsKey(key))return cache.get(key);
        long curr = arr[index];
        int ans = Integer.MAX_VALUE;
        //System.out.println(d+"\t"+index+"\t"+fixVal);
        if (fixVal==curr) {
            ans = cut(arr, d-1, index, fixVal);
        } if (curr>fixVal && curr<2*fixVal) {
            ans = 1+cut(arr, d-1, index+1, fixVal);
        } else if (curr>fixVal && curr==2*fixVal) {
            ans = 1+cut(arr, d-2, index+1, fixVal);
        } else if (curr>fixVal && curr>2*fixVal) {
            //make 1 cut
            int ans1 = 1+cut(arr, d-1, index+1, fixVal);
            //make 2 cut
            int ans2 = 2+cut(arr, d-2, index+1, fixVal);
            ans = min(ans1, ans2);
        }
        cache.put(key, ans);
        return ans;
    }
}
