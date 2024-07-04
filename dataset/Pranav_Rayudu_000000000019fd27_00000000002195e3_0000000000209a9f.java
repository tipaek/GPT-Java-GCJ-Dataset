
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        
        for (int t = 0; t < T; t++) {
            
            String s = sc.nextLine();
            
            StringBuilder b = new StringBuilder();
    
            int depth = s.charAt(0) - '0';
            
//            if(depth > 0)
            b.append(new String(new char[depth]).replace('\0', '('));
            b.append(depth);
            
            for(int i = 1; i < s.length(); i++) {
                
                char c = s.charAt(i);
    
                int newDepth = c - '0';
                int diff = newDepth - depth;
                
                if(diff < 0)
                    b.append(new String(new char[-diff]).replace('\0', ')'));
                else if (diff > 0)
                    b.append(new String(new char[diff]).replace('\0', '('));
                
                b.append(c);
                depth = newDepth;
            }
    
            b.append(new String(new char[depth]).replace('\0', ')'));
    
            System.out.printf("Case #%d: %s\n", t + 1, b.toString());
        }
    }
}
