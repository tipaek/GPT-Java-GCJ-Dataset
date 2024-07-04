import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < t; i++) {
            writer.print("Case #" + (i + 1) + ": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            long[] arr = new long[n];
            tokenizer = new StringTokenizer(reader.readLine());
            
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(tokenizer.nextToken());
            }
            
            if (d == 2) {
                if (containsDuplicate(arr)) {
                    writer.println(0);
                } else {
                    writer.println(1);
                }
            } else {
                int result = calculateResultForDGreaterThanTwo(arr);
                writer.println(result);
            }
        }
        
        reader.close();
        writer.close();
    }
    
    private static boolean containsDuplicate(long[] arr) {
        Set<Long> seen = new HashSet<>();
        for (long num : arr) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
    
    private static int calculateResultForDGreaterThanTwo(long[] arr) {
        int sameCount = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long sameMin = Long.MAX_VALUE;
        boolean workfs = false;

        for (int j = 0; j < arr.length; j++) {
            min = Math.min(min, arr[j]);
            max = Math.max(max, arr[j]);
            for (int k = j + 1; k < arr.length; k++) {
                if (arr[j] / 2.0 == arr[k] || arr[k] / 2.0 == arr[j]) {
                    workfs = true;
                }
                if (arr[j] == arr[k]) {
                    sameCount++;
                    sameMin = Math.min(sameMin, arr[j]);
                }
                for (int p = k + 1; p < arr.length; p++) {
                    if (arr[j] == arr[k] && arr[k] == arr[p]) {
                        return 0;
                    }
                }
            }
        }

        if ((sameCount > 0 && max > sameMin) || workfs) {
            return 1;
        } else {
            return 2;
        }
    }
}