

import java.util.*;

class Solution{
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            String s = sc.next();
            StringBuilder res = new StringBuilder(100);
            for(int j = 0;j<s.charAt(0) - '0';j++){
                res.append("(");
            }
            res.append(s.charAt(0));
            int len = s.length();
            for(int j = 1;j<len;j++){
                int diff = s.charAt(j)-s.charAt(j-1);
                if(diff<0){
                    diff = -diff;
                    for(int b = 0;b<diff;b++){
                        res.append(")");
                    }
                }
                else{
                    for(int b = 0;b<diff;b++){
                        res.append("(");
                    }
                }
                res.append(s.charAt(j));
            }
            for(int j = 0;j<s.charAt(len-1)-'0';j++){
                res.append(")");
            }
            System.out.println("Case #" + i + ": " + res);
        }

    }
    
    
}
