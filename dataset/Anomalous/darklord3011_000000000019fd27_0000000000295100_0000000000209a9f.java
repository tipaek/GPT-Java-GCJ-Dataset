import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        
        for (int l = 0; l < t; l++) {
            String s = scan.nextLine();
            StringBuilder ans = new StringBuilder();
            int lcount = 0;

            for (char c : s.toCharArray()) {
                int a = Character.getNumericValue(c);
                
                while (lcount < a) {
                    ans.append('(');
                    lcount++;
                }
                
                while (lcount > a) {
                    ans.append(')');
                    lcount--;
                }
                
                ans.append(c);
            }
            
            while (lcount > 0) {
                ans.append(')');
                lcount--;
            }
            
            System.out.println(ans);
        }
        
        scan.close();
    }
}