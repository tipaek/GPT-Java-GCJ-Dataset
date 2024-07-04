import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
        int z=0;
        while(z<t)
        {
            int fail=0;
            int n=obj.nextInt();
            int strt[]= new int[n];
            int end[]=new int[n];
            char per[]=new char[n];
            String ans="";
            for(int i=0;i<n ;i++)
            {
             strt[i]= obj.nextInt();
             end[i]= obj.nextInt();
                 int fasa=0;
                 char sahi='C';
                 char banda='C';
              for(int k=0;k<i;k++)
               {
                  
                   if(strt[i]<end[k] && strt[i]>=strt[k])
                   {if(fasa==0)
                     {banda=per[k];
                         fasa=1;
                         if(per[k]=='C')
                         sahi='J';
                         else
                         sahi='C';
                     }
                     else if(fasa==1)
                     {
                         if(per[i] != banda)
                          {
                              fail=1;
                             break;
                          }                       
                        }
                   }
               }
               
               if(fail==1)
               {break;}
               ans=ans+sahi;
               per[i]=sahi;
               
               
                   
               }
                 
            if(fail==1)
            {System.out.println("Case #"+(z+1)+": "+"IMPOSSIBLE");}
            else
            {
            System.out.println("Case #"+(z+1)+": "+ans);}
            
            z++;
        }
    }
}