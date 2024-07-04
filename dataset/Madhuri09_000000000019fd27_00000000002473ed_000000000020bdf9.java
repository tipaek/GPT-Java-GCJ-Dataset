import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Pair implements Comparable<Pair> {
    public final int index;
    public final int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.valueOf(this.value).compareTo(other.value);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int start[] = new int[n];
            int end[] = new int[n];
            TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
            for (int j = 0; j < n; j++) {
               String s[] = br.readLine().split(" ");
               start[j] = Integer.parseInt(s[0]);
               end[j] = Integer.parseInt(s[1]);
            }
            int c = 0;
            int k = 0;
            int flag = 0;
            Pair[] sortedArray = new Pair[n];
            for  (int j = 0; j < n; j++) {
                sortedArray[j] = new Pair(j, start[j]);
            }
            Arrays.sort(sortedArray);
            bw.write("Case #" + i + ": ");
            for  (int j = 0; j < n; j++) {
                int val = sortedArray[j].value;
                int ind = sortedArray[j].index;
                if (val >= c) {
                    c = end[ind];
                    tm.put(ind, "C");
                } else if (val >= k) {
                    k = end[ind];
                    tm.put(ind, "J");
                } else {
                    bw.write("IMPOSSIBLE");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                for (Map.Entry<Integer, String> entry : tm.entrySet()) {
                    bw.write(entry.getValue() + "");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}