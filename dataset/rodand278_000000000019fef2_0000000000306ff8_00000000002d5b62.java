import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
  public static void main(String[] args)throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  int t=Integer.parseInt(br.readLine());
  int count=1;
  while(t>0)
  {
    String[] s=br.readLine().split("\\s+");
    int x=Integer.parseInt(s[0]);int y=Integer.parseInt(s[1]);
    HashSet<Integer> set=new HashSet<Integer>();
    int initx=0,inity=0;
    if((x+y)%2==0)
    {
     System.out.println("Case #"+count+": IMPOSSIBLE");
    }else
    {
      int max=0;
      max=x>y?x:y;
    max=findbin(max);
    String[] str=new String[max+1];

    int even =x%2==0?x:y;
    int odd=x%2!=0?x:y;
    int flag=x%2==0?0:1;

   str=getEven(even,str,flag,max);
   str=getOdd(odd,str,flag,max);
  String st=getString(str,max);
System.out.println(Arrays.toString(str));
 System.out.println("Case #"+count+": "+st);
    }
    t--;
  }

  }
  static int findbin(int n) 
    { 
        int p = 1; 
        if (n > 0 && (n & (n - 1)) == 0) 
            return n; 
  
        while (p < n)  
            p <<= 1; 
      
        return p; 
    } 
  static String[] getEven(int e,String[] s,int flag,int m){
     while(e!=0)
     {
       if(e>=m)
       {
         if(flag==0){
            s[m]="E";
         }else
         {
            s[m]="N";
         }
         e-=m;
       }
       m/=2;
     }
    return s;
  }
  static String[] getOdd(int o,String[] s,int flag,int m){
    int t=0;
    while(m!=0)
    {
      if(o>t && s[m]==null){
        t+=m;
        if(flag==0)
        {
          s[m]="N";
        }else
        {
         s[m]="E";
        }
      }else if(o<t&&s[m]==null){
       t-=m;
       if(flag==0)
        {
          s[m]="S";
        }else
        {
         s[m]="W";
        }
      }
     m/=2;
    }
    return s;
  }
  static String getString(String[] s,int m){
   String st="";
   int c=1;
   while(c<=m){
     st+=s[c];
     c*=2;
   }
    return st;
  }

}