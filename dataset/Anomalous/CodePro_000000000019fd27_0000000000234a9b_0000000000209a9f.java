import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            String x = in.next();
            Stack<Integer> stack = new Stack<>();
            StringBuilder y = new StringBuilder();
            
            for (int j = 0; j < x.length(); j++) {
                int w = Character.getNumericValue(x.charAt(j));
                
                if (w > 0) {
                    if (stack.isEmpty()) {
                        stack.push(w);
                        for (int e = 0; e < w; e++) {
                            y.append("(");
                        }
                        y.append(w);
                    } else {
                        int f = stack.peek();
                        if (f > w) {
                            stack.pop();
                            stack.push(w);
                            for (int e = 0; e < f - w; e++) {
                                y.append(")");
                            }
                            y.append(w);
                        } else if (w > f) {
                            for (int e = 0; e < w - f; e++) {
                                y.append("(");
                            }
                            y.append(w);
                            for (int e = 0; e < w - f; e++) {
                                y.append(")");
                            }
                        } else {
                            y.append(w);
                        }
                    }
                } else {
                    if (!stack.isEmpty()) {
                        while (!stack.isEmpty()) {
                            int p = stack.pop();
                            for (int r = 0; r < p; r++) {
                                y.append(")");
                            }
                        }
                    }
                    y.append("0");
                }
            }
            
            while (!stack.isEmpty()) {
                int p = stack.pop();
                for (int j = 0; j < p; j++) {
                    y.append(")");
                }
            }
            
            System.out.println("Case #" + i + ": " + y.toString());
        }
    }
}