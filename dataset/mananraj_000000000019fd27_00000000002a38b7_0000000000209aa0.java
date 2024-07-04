import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt(); int tt=1;
        while(t-->0)
        {
            int n=in.nextInt();int i,j,k,l,m;
            int trace=in.nextInt();
            if(n==2)
            {
                if(trace==2)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("1 2");
                    System.out.println("2 1");
                }
                else if(trace==4)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("2 1");
                    System.out.println("1 2");
                }
                else
                System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
            }
            else if(n==3)
            {
                if(trace==3)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("1 2 3");
                    System.out.println("3 1 2");
                    System.out.println("2 3 1");
                }
                else if(trace==6)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("2 3 1");
                    System.out.println("1 2 3");
                    System.out.println("3 1 2");
                }
                else if(trace==9)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("3 1 2");
                    System.out.println("2 3 1");
                    System.out.println("1 2 3");
                }
                else
                System.out.println("Case #"+tt+": "+"IMPOSSIBLE");

            }
            else if(n==4)
            {
                if(trace==4)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("1 2 3 4");
                    System.out.println("4 1 2 3");
                    System.out.println("3 4 1 2");
                    System.out.println("2 3 4 1");
                }
                else if(trace==8)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("2 3 4 1");
                    System.out.println("1 2 3 4");
                    System.out.println("4 1 2 3");
                    System.out.println("3 4 1 2");                    
                }
                else if(trace==16)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("4 1 2 3");
                    System.out.println("3 4 1 2");  
                    System.out.println("2 3 4 1");
                    System.out.println("1 2 3 4");                     
                }
                else if(trace==12)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("3 4 1 2");  
                    System.out.println("2 3 4 1");
                    System.out.println("1 2 3 4");  
                    System.out.println("4 1 2 3");                   
                }
                else
                System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
            }
            else
            {
                if(trace==5)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("1 2 3 4 5");  
                    System.out.println("5 1 2 3 4");
                    System.out.println("4 5 1 2 3");  
                    System.out.println("3 4 5 1 2");
                    System.out.println("2 3 4 5 1");
                }
                else if(trace==10)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("2 3 4 5 1");
                    System.out.println("1 2 3 4 5");  
                    System.out.println("5 1 2 3 4");
                    System.out.println("4 5 1 2 3");  
                    System.out.println("3 4 5 1 2");
                }
                else if(trace==15)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");  
                    System.out.println("3 4 5 1 2");
                    System.out.println("2 3 4 5 1");
                    System.out.println("1 2 3 4 5");  
                    System.out.println("5 1 2 3 4");
                    System.out.println("4 5 1 2 3");
                }
                else if(trace==25)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");  
                    System.out.println("5 1 2 3 4");
                    System.out.println("4 5 1 2 3");  
                    System.out.println("3 4 5 1 2");
                    System.out.println("2 3 4 5 1");
                    System.out.println("1 2 3 4 5");
                }
                else if(trace==20)
                {
                    System.out.println("Case #"+tt+": "+"POSSIBLE");
                    System.out.println("4 5 1 2 3");  
                    System.out.println("3 4 5 1 2");
                    System.out.println("2 3 4 5 1");
                    System.out.println("1 2 3 4 5");  
                    System.out.println("5 1 2 3 4");
                }
                else
                System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
            }
            tt++;
        }
    }
}