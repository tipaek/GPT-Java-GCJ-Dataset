import java.util.*;
import java.io.*;

public class Solution {
    public static class Activity {
        public int start;
        public int end;
        public String assignee;
        public int order;
        public Activity(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int oppPair = 0;
            int samePair = 0;
            int current = 1;
            boolean[] result = new boolean[b];
            int tryNumber = 1;
            while (current <= (b + 1)/ 2) {
                if (tryNumber % 10 != 0) {
                    System.out.println(current);
                    
                    System.out.flush();
                    boolean a1 = result[current - 1] = in.nextInt() == 1;
                    tryNumber++;
                    System.out.println(b + 1 - current);
                    
                    System.out.flush();
                    boolean a2 = result[b - current] = in.nextInt() == 1;
                    tryNumber++;
                    if (a1 ^ a2) {
                        oppPair = current;
                    } else {
                        samePair = current;
                    }
                    current++;
                } else {
                    System.out.println(1);
                    
                    System.out.flush();
                    in.nextInt();
                    tryNumber++;
                }
                if (tryNumber > 1 && tryNumber % 10 == 1) {
                    boolean oppSwap = false;
                    boolean sameSwap = false;
                    if (oppPair > 0) {
                        System.out.println(oppPair);
                        
                        System.out.flush();
                        boolean a1 = in.nextInt() == 1;
                        tryNumber++;
                        if (a1 != result[oppPair-1]) {
                            oppSwap = true;
                        }
                    }
                    if (samePair > 0) {
                        System.out.println(samePair);
                        
                        System.out.flush();
                        boolean a1 = in.nextInt() == 1;
                        tryNumber++;
                        if (a1 != result[samePair-1]) {
                            sameSwap = true;
                        }
                    }
                    
                    
                    
                    
                    if (oppSwap && sameSwap) {
                        for (int j = 0; j < b; j++) {
                            result[j] = !result[j];
                        }
                    } else if (oppSwap && !sameSwap) {
                        for (int j = 0; j < b / 2; j++) {
                            boolean prev = result[j];
                            result[j] = result[b - 1 - j];
                            result[b - 1 - j] = prev;
                        }
                    } else if (!oppSwap && sameSwap) {
                        for (int j = 0; j < b / 2; j++) {
                            boolean prev = result[j];
                            result[j] = !result[b - 1- j];
                            result[b - 1 - j] = !prev;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.length; j++) {
                sb.append(result[j] ? "1" : "0");
            }
            System.out.println(sb.toString());
            
            // System.out.println("Case #" + i + ": " + sb.toString());
            System.out.flush();
            
            
        }
        in.close();
    }
}