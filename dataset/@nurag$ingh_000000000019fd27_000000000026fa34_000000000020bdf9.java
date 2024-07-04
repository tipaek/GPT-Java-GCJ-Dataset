import java.util.*;

public class Solution
{
   public static void main(String args[])
   {
      Scanner in=new Scanner(System.in);
      int t=in.nextInt();
      for(int rr=0;rr<t;rr++)
      {
         int n=in.nextInt();
         int S[]=new int[n];
         int E[]=new int[n];
         for(int i=0;i<n;i++)
         {
             S[i]=in.nextInt();
             E[i]=in.nextInt();
         }
        
         int Sarr[]=new int[n];
         int Earr[]=new int[n];
         int ans[]=new int[n];

         Sarr[0]=S[0];
         Earr[0]=E[0];
         ans[0]=10;
         int k=1;
         ArrayList<Integer> assign=new ArrayList<Integer>();
         int flag=0;
         
         
         
         
         int flag2=0;
         int check[]=new int[1442];
         for(int i=0;i<n;i++)
         {
             for(int j=S[i];j<=(E[i]-1);j++)
             {
                 check[j]+=1;
             }
         }
         
         for(int j=0;j<1440;j++)
         {
              if(check[j]>2)
              {
                flag2=1;
                break;
              }
         }
         
         if(flag2==0)
         {
         
         for(int i=1;i<n;i++)
         {
              assign=new ArrayList<Integer>();
              assign.add(10);
              assign.add(11);
              for(int j=0;j<k;j++)
              {
                  if((((S[i]<Earr[j])&&(S[i]>=Sarr[j]))||((E[i]<=Earr[j])&&(E[i]>Sarr[j]))||((S[i]>=Sarr[j])&&(E[i]<=Earr[j])))||(S[i]<=Sarr[j] && E[i]>=Earr[j]))
                  {
                     int get_ans=ans[j];     
                     if((assign.size()<1) || (assign.contains(get_ans)!=true))
                     {
                         flag=1;
                         break;
                     }
                     else
                     {
                         assign.remove(new Integer(get_ans));
                     }
                  }
              }
              if(flag==1 || assign.size()<1)
              {
                  flag=1;
                break;
              }
              Sarr[k]=S[i];
              Earr[k]=E[i];
              ans[k]=assign.get(0);
              k++;
         }
         
      }
         if(flag==1 || flag2==1)
         {
              System.out.println("Case #"+(rr+1)+": "+"IMPOSSIBLE");
         }
         else
         {
             System.out.print("Case #"+(rr+1)+": ");
             for(int i=0;i<k;i++)
             {
               if(ans[i]==10)     
               System.out.print("C");
               else
                System.out.print("J");
             }
             System.out.println();
         }
    
    }
  }
}

