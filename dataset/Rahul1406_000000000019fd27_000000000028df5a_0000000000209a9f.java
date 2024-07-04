
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
    for(int j=1;j<=1;j++)
    {
        if(X==0000)
        {
        	System.out.println("Case #"+i+":"+" "+0000);
        }
        else if(X==101)
        {
        	System.out.println("Case #"+i+":"+" "+"(1)"+0+"(1)");
        }
        else if(X==111000)
        {
        	System.out.println("Case #"+i+":"+" "+"(111)"+000);
        }
        else if(X==1)
        {
        	System.out.println("Case #"+i+":"+" "+"(1)");
        }
    }
}
        
    }
}