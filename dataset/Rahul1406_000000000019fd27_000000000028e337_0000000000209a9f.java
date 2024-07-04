
import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args) {
    Scanner inp=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int T=inp.nextInt();
    inp.nextLine();
    for(int i=1;i<=T;i++)
{
    String S=inp.nextLine();
    int X=Integer.parseInt(S);
    
        if(X==0)
        {
        	System.out.println("Case #"+i+":"+" "+0);
        }
        else if(X==1)
        {
        	System.out.println("Case #"+i+":"+" "+"(1)");
        }
        
        
    
}
        
    }
}