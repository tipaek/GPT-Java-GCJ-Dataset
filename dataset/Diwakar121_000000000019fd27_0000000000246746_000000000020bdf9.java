import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
          int strt[]= new int[1000];
            int end[]=new int[1000];
            char per[]=new char[1000];
        int z=0;
        while(z<t)
        {
            int fail=0;
            int n=obj.nextInt();
          
            StringBuilder ans= new StringBuilder("");
            for(int i=0;i<n ;i++)
            {
             strt[i]= obj.nextInt();
             end[i]= obj.nextInt();
                 int fasa=0;
                 char sahi='C';
                 char banda='C';
                 if(fail==1)
               {continue;}
              for(int k=0;k<i;k++)
               {
                  
                   if((strt[i]<end[k] && strt[i]>=strt[k]) || (end[i]<=end[k] && end[i]>strt[k]) || (strt[k]==strt[i] ))
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
                         if(per[k] != banda)
                          {
                              fail=1;
                            break;
                          }                       
                        }
                   }
               }
               
               if(fail==1)
               {continue;}
               ans.append(sahi);
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