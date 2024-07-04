import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String sIn = sc.next();
            String sOut = "";
            for (int j = 0; j < sIn.length(); j++) {
                char ch = sIn.charAt(j);
                int num = Integer.parseInt(ch + "");
                if (num == 0) {
                    sOut = sOut + num;
                } else {
                    String str="";
                    while (j+1<sIn.length() && sIn.charAt(j)==sIn.charAt(j+1)){
                        str=str+num;
                        j++;
                    }
                    for (int k = 1; k <= num; k++) {
                        sOut = sOut + "(";
                    }

                    sOut = sOut + num+str;
                    for (int k = 1; k <= num; k++) {
                        sOut = sOut + ")";
                    }
                }
            }
            System.out.println("Case #" + i + ": " + sOut);
        }
    }
}