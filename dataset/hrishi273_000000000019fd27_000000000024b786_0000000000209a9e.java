import java.util.*;

public class Solution {
    
    
    public static void main(String[] args) {
        int t, b;
        Scanner sc = new Scanner(System.in);
        
        t = sc.nextInt();
        b = sc.nextInt();
        
        while (t-- != 0) {
            int[] barr = new int[b];
            
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                int p = sc.nextInt();
                
                barr[i-1] = p;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int n : barr) {
                sb.append(n);
            }
            
            System.out.println(sb);
            sc.next();
        }
    }
}