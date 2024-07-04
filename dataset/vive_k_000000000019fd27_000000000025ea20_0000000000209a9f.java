import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        int t;
        String s;
        t=in.nextInt();
        in.nextLine();
        for(int a=1;a<=t;a++){
            StringBuilder res=new StringBuilder();
            int m=0,n=0;
            s=in.nextLine();
            System.out.println(s);
            for(char c:s.toCharArray()){
                n=Character.getNumericValue(c)-m;
                while(n<0){
                    res.append(')');
                    m--;
                    n++;
                }
                for(int i=0;i<n;i++){
                    res.append('(');
                    m++;
                }
                res.append(c);
                }
                while(m>0){
                    res.append(')');
                    m--;
                }
            System.out.println("Case #"+a+": "+res);
        }
        
    }
}