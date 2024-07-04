import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =1; i<=t; i++){
            StringBuffer finalStr = new StringBuffer();
            String str = sc.next();
            StringBuffer s = new StringBuffer(); 
            for(int j =0; j<str.length()-1;j++)
            {
                if(str.charAt(j)==str.charAt(j+1)){
                    s.append(str.charAt(j));
                }
                else{
                    finalStr.append("(").append(s).append(")");
                    s = new StringBuffer();
                }
            }
            if(str.length()>=2){
                if(str.charAt(str.length()-1)==str.charAt(str.length()-2)){
                    s.append(str.charAt(str.length()-1));
                    finalStr.append("(").append(s).append(")");
                }
                else{
                    finalStr.append("(").append(str.charAt(str.length()-1)).append(")");
                }
            }
            System.out.println("Case #"+i+": "+finalStr);
        }
    }
}