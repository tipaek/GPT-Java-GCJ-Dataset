

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String input = sc.next();

            int current = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < input.length(); i++) {
                Character c = input.charAt(i);
                int next = Integer.valueOf(c.toString());
                if (next < current) {
                    int diff = current - next;
                    for(int h = 0; h < diff; h++) sb.append(")");
                }
                else if( next > current) {
                    int diff = next - current;
                    for(int h = 0; h < diff; h++) sb.append("(");
                }
                sb.append(c);
                current = next;
            }
            while(current-->0) {
                sb.append(")");
            }

            System.out.println("Case #" + caseNum + ": " + sb.toString());
        }
    }
}
