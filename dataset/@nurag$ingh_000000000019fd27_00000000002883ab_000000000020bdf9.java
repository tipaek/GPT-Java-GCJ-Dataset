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
        
         int Sarr[]=S.clone();;
         int Earr[]=E.clone();
         
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n-1-i;j++)
             {
                 if(S[j]>S[j+1])
                 {
                     int temp=S[j+1];
                     S[j+1]=S[j];
                     S[j]=temp;
                     
                     temp=E[j+1];
                     E[j+1]=E[j];
                     E[j]=temp;
                     
                 }
             }
         }
         
         int C=0;
         int J=0;
         int flag=0;
         HashMap <String,Character> h=new HashMap<String,Character>();
         
         for(int i=0;i<n;i++)
         {
             if(S[i]>=C)
             {
                h.put((S[i]+""+E[i]),'C');
                C=E[i];
             }
             else if(S[i]>=J)
             {
                 h.put((S[i]+""+E[i]),'J');
                 J=E[i];
             }
             else
             {
                 flag=1;
                 break;
             }
         }
         
         
         
         if(flag==1)
         {
              System.out.println("Case #"+(rr+1)+": "+"IMPOSSIBLE");
         }
         else
         {
             String ans="";
             for(int i=0;i<n;i++)
             {
                 ans+=h.get(Sarr[i]+""+Earr[i]);
             }
             System.out.println("Case #"+(rr+1)+": "+ans);
         }
    
    }
  }
}

