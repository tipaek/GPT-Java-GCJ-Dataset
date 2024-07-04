package Codejam_2020.Round1.NestingDepth;

import java.util.Scanner;

public class Solution {
    public static void solve(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for(int i = 0; i<s.length(); i++) {
            int d = s.charAt(i)-'0';
            while(level<d) {
                sb.append('(');
                level++;
            }
            while(level>d) {
                sb.append(')');
                level--;
            }
            sb.append(d);
        }
        while(level-->0) {
            sb.append(')');
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int t = 1; t<=T; t++) {
            String s = sc.nextLine();
            System.out.print("Case #"+t+": ");
            solve(s);
        }
    }
}
