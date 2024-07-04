import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 0;
        while(t--!=0){
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<(s.charAt(0)-'0');j++){
                sb.append('(');
            }
            sb.append(s.charAt(0));
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i)<s.charAt(i+1)){
                    for(int j=s.charAt(i);j<s.charAt(i+1);j++){
                        sb.append('(');
                    }
                }
                else if(s.charAt(i)>s.charAt(i+1)){
                    for(int j=s.charAt(i+1);j<s.charAt(i);j++){
                        sb.append(')');
                    }
                }
                sb.append(s.charAt(i+1));
            }
            for(int j=0;j<(s.charAt(s.length()-1)-'0');j++){
                sb.append(')');
            }
            System.out.println("Case #"+(++c)+": "+sb.toString());
        }
    }
}