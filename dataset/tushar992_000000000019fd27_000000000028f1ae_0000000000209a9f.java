import java.util.*;

class Solution {

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        for(int m=0; m<t; m++) {
            String n = sc.nextLine();
            String res = "";
            int num = n.charAt(0) - '0';
            for(int i=0;i<num;i++) {
        res+="(";
    }
res+=num;
for(int i=1; i<n.length();i++) {
                int num2 = n.charAt(i)-'0';
                if (num2<num) {
                 for(int j=0;j<num-num2;j++) {
        res+=")";
    }
                } else if (num2>num) {
                 for(int j=0;j<num2-num;j++) {
        res+="(";
    }
                }
res+=num2;                num=num2;
            }
            for(int j=0;j<num;j++) {
        res+=")";
    }
            System.out.println("Case #"+(m+1)+": "+res);
        }
    }
}