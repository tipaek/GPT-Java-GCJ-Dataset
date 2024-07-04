import java.io.*;
import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int T=1;
        while(T<=t){
            String n=sc.next();
            
            StringBuffer s=new StringBuffer();
            int o=0;
    
            for(int i=0;i<n.length();i++){
                while((int)n.charAt(i)-48>o){
                    s.append('(');
                    o++;
                }
                while((int)n.charAt(i)-48<o){
                    s.append(')');
                    o--;
                }
                s.append(n.charAt(i));
            }
            while(o>0){
            	s.append(')'); 
            	o--;}
            System.out.println("Case #"+T+": "+s.toString());
            T++;
        }
        sc.close();
    }
}
