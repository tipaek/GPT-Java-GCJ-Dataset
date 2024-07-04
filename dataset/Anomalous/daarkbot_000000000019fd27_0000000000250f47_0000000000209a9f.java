import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String s = sc.nextLine() + "0";
            char[] carr = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            int currDepth = 0;
            
            for (int i = 0; i < carr.length; i++) {
                int v = carr[i] - '0';
                
                while (currDepth < v) {
                    sb.append('(');
                    currDepth++;
                }
                
                while (currDepth > v) {
                    sb.append(')');
                    currDepth--;
                }
                
                if (i != carr.length - 1) {
                    sb.append(v);
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + sb.toString());
        }
        
        sc.close();
    }
}