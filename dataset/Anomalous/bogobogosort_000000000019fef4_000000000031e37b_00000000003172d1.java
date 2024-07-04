import java.util.*;
import java.io.*;

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
                boolean foundPair = false;
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[j] == arr[k]) {
                            writer.println(0);
                            foundPair = true;
                            break;
                        }
                    }
                    if (foundPair) break;
                }
                if (!foundPair) {
                    writer.println(n != 1 ? 1 : 2);
                }
            } else {
                int sameCount = 0;
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                long sameMin = Long.MAX_VALUE;
                boolean workFirstScenario = false;

                for (int j = 0; j < n; j++) {
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                    for (int k = j + 1; k < n; k++) {
                        if (arr[j] / 2 == arr[k] || arr[k] / 2 == arr[j]) {
                            workFirstScenario = true;
                        }
                        if (arr[j] == arr[k]) {
                            sameCount++;
                            sameMin = Math.min(sameMin, arr[j]);
                        }
                        for (int p = k + 1; p < n; p++) {
                            if (arr[j] == arr[k] && arr[k] == arr[p]) {
                                writer.println(0);
                                continue;
                            }
                        }
                    }
                }

                if ((sameCount > 0 && max > sameMin) || workFirstScenario) {
                    writer.println(1);
                } else {
                    writer.println(2);
                }
            }
        }
        
        reader.close();
        writer.close();
    }
}