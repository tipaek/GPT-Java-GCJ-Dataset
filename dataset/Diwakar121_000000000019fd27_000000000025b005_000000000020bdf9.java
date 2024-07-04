import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
          int strt[]= new int[1000];
            int end[]=new int[1000];
        
        int z=0;
        while(z<t)
        {
            
            int n=obj.nextInt();
          
            for(int i=0;i<n ;i++)
            {
             strt[i]= obj.nextInt();
             end[i]= obj.nextInt();
            }  
               
                 
            
            
            System.out.print("Case #"+(z+1)+": ");
            print(strt,end,n,"",0);
            System.out.println();
            z++;
        }
    }
        public static boolean print(int []ar1,int []ar2,int n, String str ,int i)
    {  if(i==n)
          { 
            System.out.print(str);
            return true;
          }
        
        boolean a=    isafe('C',ar1,ar2,i,str);
        boolean b=isafe('J',ar1,ar2,i,str);
        if(!( a || b))
        {return false;}
          boolean a1=true;
          boolean b1 =true;
        if(a)
        {
             a1=    print(ar1,ar2,n,str+"C",i+1);
             if(a1)
             {return true;}
        }
        
        if(  b)
        {
            b1= print(ar1,ar2,n,str+"J",i+1);
            if(b1)
            {return true;}
        }
        if(i==0)
        {System.out.print("IMPOSSIBLE");}
        return false;
            
     }
     
     public static boolean isafe(char s,int strt[],int end[],int i ,String str)
     {
         for(int k=0;k<i;k++)
         {
             if((end[i]<=strt[k]) || (strt[i]>=end[k]  ))
                   {
                       //some work
                   }
                   else
                   {
                       if(str.charAt(k)==s)
                       {return false;}
                   }
         }
         return true;
     }
        
        
        }
        
        

