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
            String s = br.readLine();
            int len = s.length();
            int arr[] = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = s.charAt(j) - 48;
            }
            bw.write("Case #" + i + ": ");
            String str = "";
            for (int j = 0; j < arr[0]; j++) {
                bw.write("" + "(");
            }
            bw.write("" + arr[0]);
            for (int j = 0; j < len - 1; j++) {
                int diff = arr[j + 1] - arr[j];
                if (diff >= 0) {
                    for (int k = 0; k < diff; k++) {
                        bw.write("" + "(");
                    }
                } else {
                    diff = -diff;
                    for (int k = 0; k < diff; k++) {
                        bw.write("" + ")");
                    }
                }
                bw.write("" + arr[j + 1]);
            }
            for (int j = 0; j < arr[len - 1]; j++) {
                bw.write("" + ")");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}