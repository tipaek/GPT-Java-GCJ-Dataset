
package javaapplication25;


import java.util.*;

class Solution{
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            String s = sc.next();
            String res = "";
            res += new String(new char[s.charAt(0) - '0']).replace("\0", "(");
            res += s.charAt(0);
            for(int j = 1;j<s.length();j++){
                int diff = s.charAt(j)-s.charAt(j-1);
                if(diff<0){
                    diff = -diff;
                    res += new String(new char[diff]).replace("\0", ")");
                }
                else if(diff>0){
                    res += new String(new char[diff]).replace("\0", "(");
                }
                res+= s.charAt(j);
            }

            res += new String(new char[s.charAt(s.length()-1)-'0']).replace("\0", ")");
            
            System.out.println("Case #" + i + ": " + res);
        }

    }
    
    
}
