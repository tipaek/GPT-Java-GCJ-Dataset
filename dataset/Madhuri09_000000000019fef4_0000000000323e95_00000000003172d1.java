import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            String str[] = br.readLine().split(" ");
            long arr[] = new long[n];
            int k = 1;
            int ans = d- 1;
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(str[j]);
                if (!hm.containsKey(arr[j])) {
                    hm.put(arr[j], 1);
                } else {
                    hm.put(arr[j], hm.get(arr[j]) + 1);
                    k = Math.max(k, hm.get(arr[j]));
                }
            }
            Arrays.sort(arr);
            if (d == 2) {
                if (k >= 2) ans = 0;
                else  ans = 1;
            } else if (d == 3) {
                if (k >= 3) ans = 0;
                else {
                    int p = 0;
                    for (int j = 0; j < n; j++) {
                        if (hm.containsKey(arr[j] * 2)) {
                            ans = 1;
                            p = 1;
                            break;
                        }
                    }
                    if (p == 0) ans = 2;
                }
            } 
            bw.write("Case #" + i + ": " + ans + "\n");
        }
        bw.flush();
    }
}