import java.util.*;
import java.io.*;
class main { 

  
    static int max(String[] S) { 
        int current_max = 0; 
        int max = 0; 
        int n = S.length(); 
  
        
        for (int i = 0; i < n; i++) { 
            if (S.charAt(i) == '(') { 
                current_max++; 
  
            
                if (current_max > max) { 
                    max = current_max; 
                } 
            } else if (S.charAt(i) == ')') { 
                if (current_max > 0) { 
                    current_max--; 
                } else { 
                    return -1; 
                } 
            } 
        } 
  
        if (current_max != 0) { 
            return -1; 
        } 
  
        return max; 
    }
    public static void main(String[] args)
    {
    int n;
    String b="";
    String s[]=new String[10];
    Scanner scan=new Scanner(System.in);
    n=scan.nextInt();
    for(int i=1;i<=n;i++)
    {
    s[i]=scan.nextLine();
    }
     for(int i=1;i<=n;i++)
    {
   
   System.out.println("Case #"+i+": "+max(s[i]));
    }
    }}