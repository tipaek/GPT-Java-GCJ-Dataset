import java.util.*;

class Solution
{
    public static void main (String [] args) {
        Scanner s = new Scanner (System.in);
        
        int t = s.nextInt();
        s.nextLine();
        for (int k = 0; k < t; k++) {
            
            String str = s.nextLine();
            solve (k + 1, str);
        }
    }
    
    private static void solve (int caseNum, String s) {
        int open = 0, i = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i < s.length()) {
            int num = s.charAt(i) - '0';
            while (open > num) {
                sb.append(")");
                open--;
            }
            while (open < num) {
                sb.append("(");
                open++;
            }
            
            sb.append(""+num);
            i++;
        }
        
        while (open-- > 0)
            sb.append(")");
        
        System.out.println ("Case #"+caseNum+": "+sb.toString());
        
    }
}