import java.util.Scanner;
class Solution
{
  static String fin="",st="";
 public static void main(String ar[])
 {
   int t=0,len=0,min=0,temp1=0,temp2=0,rem=0,temp=0,t1=0;
   Scanner sc=new Scanner(System.in);
   t=sc.nextInt();
   while(t--!=0)
   {
      t1=t1+1;
    st=sc.next();
    len=st.length();
    for(rem=0;rem<len;rem=rem+1)
    {
       if(st.charAt(rem)=='0')
       {
        fin=fin+'0';
       }
       else
       {
        break;
       }
    }
    if(rem!=len)
    {
      temp=Integer.parseInt(""+st.charAt(rem));
      open(temp);
      fin=fin+temp;
      for(int x=rem;x<len-1;x=x+1)
      {
        temp1=Integer.parseInt(""+st.charAt(x));
        temp2=Integer.parseInt(""+st.charAt(x+1));
        if(temp2>temp1)
        {
          open(temp2-temp1);
          fin=fin+temp2;
          continue;
        }
        if(temp2<temp1)
        {
          close(temp1-temp2);
          fin=fin+temp2;
          continue;
        }
        if(temp2==temp1)
        {
          fin=fin+temp2;
          continue;
        }
      }
      temp=Integer.parseInt(""+st.charAt(len-1));
      close(temp);
    }
    System.out.println("Case #"+t1+": "+fin);
    rem=0;
    fin="";
    st="";
   }
 }
 static void open(int n)
 {
   for(int x=0;x<n;x=x+1)
   {
     fin=fin+'(';  
   }
 }
 static void close(int n)
 {
  for(int x=0;x<n;x=x+1)
   {
     fin=fin+')';  
   }
 }
}