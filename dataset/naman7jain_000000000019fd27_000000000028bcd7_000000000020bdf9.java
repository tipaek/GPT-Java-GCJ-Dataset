import java.util.*;

public class Solution
{
   public static void main(String args[])
   {
      Scanner in=new Scanner(System.in);
      int t=in.nextInt();
      for(int x=0;x<t;x++)
      {
         int n=in.nextInt();
         int Start[]=new int[n];
         int End[]=new int[n];
         int abc[]= new int[n];
         
         for(int i=0;i<n;i++)
         {
             Start[i]=in.nextInt();
             End[i]=in.nextInt();
             abc[i]=i;
         }
       
         int Startarr[]=Start.clone();;
         int Endarr[]=End.clone();
         
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n-1-i;j++)
             {
                 if(Start[j]>Start[j+1])
                 {
                     int temp=Start[j+1];
                     Start[j+1]=Start[j];
                     Start[j]=temp;
                     
                     temp=End[j+1];
                     End[j+1]=End[j];
                     End[j]=temp;
                     
                     temp=abc[j+1];
                     abc[j+1]=abc[j];
                     abc[j]=temp;
                 }
             }
         }
         
         int C=0;
         int J=0;
         int flag=0;
         HashMap <String,Character> hm=new HashMap<String,Character>();
         
         for(int i=0;i<n;i++)
         {
             if(Start[i]>=C)
             {
                hm.put((Start[i]+""+End[i]+""+abc[i]),'C');
                C=End[i];
             }
             else if(Start[i]>=J)
             {
                 hm.put((Start[i]+""+End[i]+""+abc[i]),'J');
                 J=End[i];
             }
             else
             {
                 flag=1;
                 break;
             }
         }
         if(flag==1)
         {
              System.out.println("Case #"+(x+1)+": "+"IMPOSSIBLE");
         }
         else
         {
             String ans="";
             for(int i=0;i<n;i++)
             {
                 ans+=hm.get(Startarr[i]+""+Endarr[i]+""+i);
             }
             System.out.println("Case #"+(x+1)+": "+ans);
         }
   
    }
  }
}