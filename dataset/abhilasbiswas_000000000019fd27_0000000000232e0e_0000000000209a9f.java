


import java.util.*;
import java.io.*;

public class Solution
{   
    static String brace[]=
    {
        ")))))))))",
        "))))))))",
        ")))))))",
        "))))))",
        ")))))",
        "))))",
        ")))",
        "))",
        ")",
        "",
        "(",
        "((",
        "(((",
        "((((",
        "(((((",
        "((((((",
        "(((((((",
        "((((((((",
        "((((((((("
        
    };
    
    
    
    
    public static void main(String s[])
    {
    Scanner input= new Scanner( new BufferedReader(new InputStreamReader(System.in)));
    int T=input.nextInt();
    for (int i=1;i<=T; i++)
    {
        String result=test(input);
        System.out.println("Case #"+i+": "+result);
    }
    }
    
    public static String test(Scanner input) 
    {
        String s=input.next();
        int l=s.length();
        
        
        
        int n[]=new int[l+1];
        for (int i=0;i<l; i++)
            n[i]=s.charAt(i)-'0';
            
        String result=brace[n[0]+9];
        
        for (int i=0;i<l;++i)
        {
            int b=(n[i+1]-n[i])+9;
            result+=n[i]+brace[b];
        }
        
        
        return result; 
        
        
    }
    
}