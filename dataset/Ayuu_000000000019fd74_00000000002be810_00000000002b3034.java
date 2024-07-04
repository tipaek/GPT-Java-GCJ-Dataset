import java.util.*;
import java.util.regex.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        String result = "";
        for(int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            for(int i = 0; i < n/2; i++) {
                String str1 = "."+sc.next();
                String str2 = "."+sc.next();
                boolean b3 = Pattern.matches(str1,str2);
                if(b3==true)
                    result=str2;
            }
            if(result=="") {
                System.out.println("*");
            }
            else {
                String s = result.substring(1,result.length());
                System.out.println(result);
            }
            result="";
        }
        System.exit(0);
    }
}