import java.util.*;

public class Solution
{
   public static void main(String args[])
   {
      Scanner in=new Scanner(System.in);
      int t=in.nextInt();
      int b=in.nextInt();
      for(int l=0;l<t;l++)
      {
          int arr[]=new int[10];
          for(int i=0;i<=9;i++)
          {
              if(i!=1)
                 System.out.println(i);
              System.out.flush();
              arr[i]=in.nextInt();
          }
          System.out.println(1);
          System.out.flush();
          int one=in.nextInt();
          
          int temparr[]=new int[10];
          for(int i=2;i<=9;i++)
          {
              System.out.println(i);
              System.out.flush();
              temparr[i]=in.nextInt();
          }
          
          int arrComp[]=new int[10];
          int arrRev[]=new int[10];
          int arrRevComp[]=new int[10];
          
          //comp
          for(int i=2;i<=9;i++)
          {
              int lelo=arr[i];
              if(lelo==1)
              arrComp[i]=0;
              else
              arrComp[i]=1;
          }
          
          //rev
          arrRev=arr.clone();
          for(int i=2;i<=4;i++)
          {
              int lelo=arrRev[i];
              arrRev[i]=arrRev[9-i];
              arrRev[9-i]=lelo;
          }
          
          //rev+comp
          arrRevComp=arrRev.clone();
          for(int i=2;i<=9;i++)
          {   
              int lelo=arrRevComp[i];
              if(lelo==1)
              arrRevComp[i]=0;
              else
              arrRevComp[i]=1;
          }
          
          int matching=-1;
          for(int i=2;i<=9;i++)
          {
              if(temparr[i]==arrComp[i])
              {
                  matching=1;
              }
              else
              {
                  matching=0;
                  break;
              }
          }
          if(matching==1)
          {
              if(one==1)
                arr[1]=0;
              else
                arr[1]=1;
                
              String ans="";
              for(int i=0;i<=9;i++)
              {
                 ans=ans+arr[i];
              }
              System.out.println(ans);
              System.out.flush();
              String ch=in.next();
              if(ch.equals("Y"))
              {
                  continue;
              }
          }
          
          
          for(int i=2;i<=7;i++)
          {
              if(temparr[i]==arrRev[i])
              {
                  matching=1;
              }
              else
              {
                  matching=0;
                  break;
              }
          }
          if(matching==1)
          {
              arr[1]=temparr[8];
              String ans="";
              for(int i=0;i<=9;i++)
              {
                 ans=ans+arr[i];
              }
              System.out.println(ans);
              System.out.flush();
              String ch=in.next();
              if(ch.equals("Y"))
              {
                  continue;
              }
          }
          
          for(int i=2;i<=7;i++)
          {
              if(temparr[i]==arrRevComp[i])
              {
                  matching=1;
              }
              else
              {
                  matching=0;
                  break;
              }
          }
          if(matching==1)
          {
              int lelo=temparr[8];
              if(lelo==1)
                arr[1]=0;
              else
                arr[1]=1;
              //arr[1]=!temparr[8];
              String ans="";
              for(int i=0;i<=9;i++)
              {
                 ans=ans+arr[i];
              }
              System.out.println(ans);
              System.out.flush();
              String ch=in.next();
              if(ch.equals("Y"))
              {
                  continue;
              }
          }
          if(l==(t-1))
          {
              return 0;
          }
      }     
  }
}

