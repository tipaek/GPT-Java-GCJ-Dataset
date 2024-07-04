import java.io.*;
import java.util.*;
public class Solution
{
 public static void main(String gg[])
 {
  Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int tests=sc.nextInt();
  int t=0;
  while(t<tests)
  {
   int e=sc.nextInt();
   int n=sc.nextInt();
   String dir=sc.next();
   int x=0,y=0;
   int i=0;
   char d;
   boolean check=false;
   while(i<dir.length())
   {
    d=dir.charAt(i);
    if(d=='S')
    {
     n--;
     check=check(n,e,i+1);
    }
    else if(d=='N')
    {
     n++;
     check=check(n,e,i+1);
    }
    else if(d=='E')
    {
     e++;
     check=check(n,e,i+1);
    }
    else
    {
     e--;
     check=check(n,e,i+1);
    }
    i++;
    if(check==true)
    {
     break;
    }
   }
   if(check==true)
   {
    System.out.println("Case #"+(t+1)+": "+i);
   }
   else if(i==dir.length()) System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
   t++;
  }
 }
 public static boolean check(int r,int c,int steps)
 {
  int x=0;
  int y=0;
  int i=0;
  while(i<steps)
  {
   if(x<r) x++;
   else if(y<c) y++;
   else if(y==c && x>r) x--;
   else if(x==r && y>c) y--;
   i++;
  }
  if(x==r && y==c) return true;
  return false;
 }
}