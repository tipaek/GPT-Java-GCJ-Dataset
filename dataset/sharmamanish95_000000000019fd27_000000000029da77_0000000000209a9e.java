import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        int[] bits = new int[b];
        for(int j = 1; j<=t; j++) {
            for(int i = 0; i<b; i++) {
                System.out.println(i+1);
                bits[i] = sc.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            for(int x: bits)
                sb.append(x);
            System.out.println(new String(sb));
            String res = sc.next();
            if(res.equals("N")) {
                return;
            }            
        }
    }
}
    