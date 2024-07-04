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
         HashMap <String,LinkedList<String>> h=new HashMap<String,LinkedList<String>>();
         
         for(int i=0;i<n;i++)
         {
             if(S[i]>=C)
             {
                if(h.containsKey(S[i]+""+E[i])==true)
                { 
                  LinkedList<String> temp= h.get((S[i]+""+E[i]));
                  temp.add("C");
                  h.put((S[i]+""+E[i]),temp);
                }
                else
                {
                    LinkedList<String> kkk=new LinkedList<String>();
                        kkk.add("C");
                    h.put((S[i]+""+E[i]),kkk);
                }
                C=E[i];
             }
             else if(S[i]>=J)
             {
                if(h.containsKey(S[i]+""+E[i])==true)
                { 
                  LinkedList<String> temp= h.get((S[i]+""+E[i]));
                  temp.add("J");
                  h.put((S[i]+""+E[i]),temp);
                }
                else
                {
                    
                        LinkedList<String> kkk=new LinkedList<String>();
                        kkk.add("J");
                    h.put((S[i]+""+E[i]),kkk);
                }
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
                 LinkedList <String> temp=h.get(Sarr[i]+""+Earr[i]);
                 String ch=temp.getFirst();
                 temp.removeFirst();
                 h.put((Sarr[i]+""+Earr[i]),temp);
                 ans+=ch;
             }
             System.out.println("Case #"+(rr+1)+": "+ans);
         }
    
    }
  }
}
