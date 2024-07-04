import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int d = 1; d <=t;++d) {
            String s = sc.next();
            int n = s.length();
            String str = "";
            char bracF = '(', bracB = ')';
            for(int i = 0; i<n;++i) {
                int j = Integer.parseInt(String.valueOf(s.charAt(i))); // 1
                String tempF = "", tempB = "";
                for(int k = 0; k<j;++k) {
                    tempF += bracF;
                }
                for(int k = 0; k<j;++k) {
                    tempB += bracB;
                }
                str += tempF + s.charAt(i) + tempB; 
            }
            StringBuilder str2 = new StringBuilder(str);
            // String str1 = String.valueOf(str.charAt(0)); // (
            while(str2.indexOf(")(") != -1) {
                int ind = str2.indexOf(")(");
                    if(ind+2 < str2.length())
                        str2 = str2.delete(ind, ind+2);
                    else
                        break;
            }
            System.out.println("Case #"+d+": "+str2.toString());
            
            
        }
    }
}