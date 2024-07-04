import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int k = 1; k <= t; ++k) {
        String s=sc.next();
        int l=s.length();
        int pos=0,i,j,z;
        String str="";
        if(l==1)
        {
            int star=s.charAt(0)-'0';
            for(i=0;i<star;i++)
            str=str+'(';
            str=str+s.charAt(0);
            int en=s.charAt(0)-'0';
            for(int x=0;x<en;x++)
            str=str+')';
             System.out.println("Case #" + k + ": " + str);
             continue;
        }
        for(z=0;z<l;z++)
        {
            if(s.charAt(z)=='0')
            {
                str=str+'0';
                pos++;
            }
            else
            break;
        }
        if(s.charAt(0)!='0')
        {
            int start=s.charAt(0)-'0';
            for(i=0;i<start;i++)
            str=str+'(';
            str=str+s.charAt(0);
            pos=1;
        }
        for(i=pos;i<l-1;i++)
        {
            
            int p=s.charAt(i)-s.charAt(i-1);
            if(s.charAt(i)=='0'){
                            if(p<0)
            {
                p=Math.abs(p);
                for(j=0;j<p;j++)
                str=str+')';
            }
            else{
                for(j=0;j<p;j++)
                str+='(';
            }
            
            str=str+'0';
            continue;
            }
            if(p<0)
            {
                p=Math.abs(p);
                for(j=0;j<p;j++)
                str=str+')';
            }
            else{
                for(j=0;j<p;j++)
                str+='(';
            }
            if(s.charAt(i)!='0')
            str+=s.charAt(i);
            }
            if(l>1){
                int y=s.charAt(l-1)-s.charAt(l-2);
             if(y<0)
            {
                y=Math.abs(y);
                for(j=0;j<y;j++)
                str=str+')';
            }
            else{
                for(j=0;j<y;j++)
                str+='(';
            }}
            str=str+s.charAt(l-1);
            int end=s.charAt(l-1)-'0';
            for(int x=0;x<end;x++)
            str=str+')';
             System.out.println("Case #" + k + ": " + str);
    }
    System.exit(0);
  }
}
            
            
            
            
            
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            
            
        
        
        
        
        
        
        
        
        