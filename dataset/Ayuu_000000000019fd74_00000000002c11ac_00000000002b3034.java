import java.util.*;
import java.util.regex.*;
import java.lang.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        String result = "";
        for(int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            for(int i = 0; i < n/2; i++) {
                String str1 = sc.next();
                str1=str1.replace('*','.*');
                String str2 = sc.next();
                str2=str2.replace('*','.');
                boolean b3 = Pattern.matches(str1,str2);
                if(b3==true)
                    result=str2;
            }
            if(result=="") {
                System.out.println("Case #"+k+": "+"*");
            }
            else {
                String s = result.substring(1,result.length());
                System.out.println("Case #"+k+": "+s);
            }
            result="";
        }
        System.exit(0);
    }
}