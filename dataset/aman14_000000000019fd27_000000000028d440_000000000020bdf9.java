import java.util.Scanner;
class Solution
{
  public static void main(String ar[])
  {
   int t=0,n=0,over=0,t1=0;
   char curch='J',prech='J';
   String out="";
   int mn[][];
   Scanner sc=new Scanner(System.in);
   t=sc.nextInt();
   while(t--!=0)
   {
     t1=t1+1;
     n=sc.nextInt();
     mn=new int[n][2];
    
     for(int x=0;x<n;x=x+1)
     {
       mn[x][0]=sc.nextInt();
       mn[x][1]=sc.nextInt();
     }
     out=out+'J';
     for(int x=1;x<n;x=x+1)
     {
        over=0;
      for(int y=0;y<x;y=y+1)
      {
        if((mn[x][0]>mn[y][0]&&mn[x][0]<mn[y][1])||(mn[x][1]>mn[y][0]&&mn[x][1]<mn[y][1])||(mn[y][0]>mn[x][0]&&mn[y][0]<mn[x][1])||(mn[y][1]>mn[x][0]&&mn[y][1]<mn[x][1]))
        {
          over=over+1;
          curch=out.charAt(y);
        }
        if(over>=2&&curch!=prech)
        {
          over=-1;
          break;
        }
        prech=curch;
      }
      if(over==-1)
      {
        out="IMPOSSIBLE";
        break;
      }
      if(over>=1)
      {
        if(curch=='J')
        {
          out=out+'C'; 
          
        }
        else
        {
          out=out+'J';
          
        }
      }
      if(over==0)
      {
        out=out+out.charAt(x-1);  
      }
      
     }
     System.out.println("Case #"+t1+": "+out);
     out="";
   }
  }
}