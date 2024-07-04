import java.util.Scanner;
class Solution
{
  public static void main(String ar[])
  {
   int t=0,n=0,q=0,ol=0,t1=0;
   char ch[];
   char opch1='0',opch2='0';
   String out="";
   int mn[][];
   Scanner sc=new Scanner(System.in);
   t=sc.nextInt();
   while(t--!=0)
   {
     t1=t1+1;
     n=sc.nextInt();
     mn=new int[n][2];
     ch=new char[n];
     for(int x=0;x<n;x=x+1)
     {
       mn[x][0]=sc.nextInt();
       mn[x][1]=sc.nextInt();
     }
     ch[0]='J';
     for(int x=1;x<n;x=x+1)
     {
      for(int y=0;y<x;y=y+1)
      {
        if((mn[x][0]>mn[y][0]&&mn[x][0]<mn[y][1])||(mn[x][1]>mn[y][0]&&mn[x][1]<mn[y][1])||(mn[y][0]>mn[x][0]&&mn[y][0]<mn[x][1])||(mn[y][1]>mn[x][0]&&mn[y][1]<mn[x][1]))
        {
          ol=ol+1;
          opch1=ch[y];
          q=q+1;
        }
        if(ol>=2&&opch1!=opch2)
        {
          q=-1;
          break;
        }
        opch2=opch1;
      }
      ol=0;
      if(q>=1)
      {
        if(opch1=='J')
        {
          ch[x]='C';
        }
        else
        {
         ch[x]='J';
        }
      }
      else
      {
       if(q==-1)
       {
        out="IMPOSSIBLE";
        break;
       }
       else
       {
          ch[x]=ch[x-1];
       }
      }
      q=0;
     }
     if(out.equals("IMPOSSIBLE"))
     {
      System.out.println("Case #"+t1+" "+out);
     }
     else
     {
      out="";
      for(int x=0;x<n;x=x+1)
      {
        out=out+ch[x];
      }
      System.out.println("Case #"+t1+" "+out); 
     }
     out="";
   }
  }
}