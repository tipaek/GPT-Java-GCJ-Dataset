import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner Sc = new Scanner(System.in);
        int tests = Sc.nextInt();
        for(int i=0;i<tests;i++)
        {
            int n=Sc.nextInt();
            boolean ispossible=true;
            String sol="";
            for(int j=0;j<n;j++)
            {
                String temp=Sc.next();
                if(temp.equals("*"))
				{
					continue;
				}
                String subtemp=temp.substring(1);
                if(sol.length()==0)
                {
                    sol=subtemp;
                }
                else if(subtemp.length()>=sol.length())
                {
                    if(subtemp.indexOf(sol)!=-1)
                    {
                       sol=subtemp; 
                    }
                    else
                    {
                        ispossible=false;
                    }
                }
                else
                {
                    if(sol.indexOf(subtemp)!=-1)
                    {
                        
                    }
                    else
                    {
                        ispossible=false;
                    }
                }
                if(ispossible==false)
                {
                    break;
                }
            }
            if(ispossible)
            {
                System.out.println("Case #"+(i+1)+": "+sol);
            }
            else
            {
               System.out.println("Case #"+(i+1)+": *"); 
            }
            
        }
    }
}