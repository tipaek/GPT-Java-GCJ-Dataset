
package javaapplication25;


import java.util.*;

class Solution{
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            String s = sc.next();
            String res = "";
            for(int j = 0;j<s.charAt(0) - '0';j++){
                res += "(";
            }
            res += s.charAt(0);
            int len = s.length();
            for(int j = 1;j<len;j++){
                int diff = s.charAt(j)-s.charAt(j-1);
                if(diff<0){
                    diff = -diff;
                    for(int b = 0;b<diff;b++){
                        res +=")";
                    }
                }
                else if(diff>0){
                    for(int b = 0;b<diff;b++){
                        res +="(";
                    }
                }
                res+= s.charAt(j);
            }
            for(int j = 0;j<s.charAt(len-1)-'0';j++){
                res += ")";
            }
            System.out.println("Case #" + i + ": " + res);
        }

    }
    
    
}
