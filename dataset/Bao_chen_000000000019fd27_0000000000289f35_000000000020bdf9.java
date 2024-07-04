import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int activities = in.nextInt();
        int[][] a = new int[activities][2];
        for(int j = 0; j < activities; j++) {
            a[j][0] = in.nextInt();
            a[j][1] = in.nextInt();
        }
        Arrays.sort(a, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
        });
        solve(a, i);
    }
  }
  
    static Stack<String> stack = new Stack<>();
    static int[] stackA = new int[2];
    //C, J
    //480, 540

    private static void init() {
        stack.push("J");
        stack.push("C");
        stackA[0] = 0;
        stackA[1] = 0;
    }

    private static void solve(int[][] a, int caseNum) {
        init();
        int length = a.length;
        StringBuilder answer = new StringBuilder();
        int start = 0;
        while(start < length) {
            if (start == 0) {
                answer.append(stack.pop());
                stackA[0] = (a[start][1]);
                start++;
            } else {
                if(stack.size() >= 1) {
                    String cur = stack.pop();
                    if(cur == "J") {
                        stackA[1] = a[start][1];
                    }else {
                        stackA[0] = a[start][1];
                    }
                    answer.append(cur);
                    start++;
                }else {
                    if(stackA[0] <= a[start][0]) {
                        stack.push("C");
                        stackA[0] = 0;
                        continue;
                    }
                    if(stackA[1] <= a[start][0]) {
                        stack.push("J");
                        stackA[1] = 0;
                        continue;
                    }
                    break;
                }
            }
        }
        if (answer.length() == length) {
            System.out.println("Case #" + caseNum + ": " + answer.toString());
        } else {
            System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
        }
    }
}