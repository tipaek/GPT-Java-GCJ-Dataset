import java.util.*;
public class Solution{
   public static void main() {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int b=0,k=0;
        int c=0;
        while(b!=n)
        {   int x=in.nextInt();
            int y=in.nextInt();
            if(x%2!=0 && y%2!=0)
                System.out.println("Case #"+(++b)+" IMPOSSIBLE");
            else if(x%2==0 && y%2==0)
                System.out.println("Case #"+(++b)+" IMPOSSIBLE");
            else
            {
            String ans="";
            int xa=Math.abs(x);
            int ya=Math.abs(y);
            String s1=Integer.toBinaryString(xa);
            String s2=Integer.toBinaryString(ya);
            int l=(s1.length()>s2.length())?s1.length()-s2.length():s2.length()-s1.length();
            String z="";
            for(int i=0 ; i<l ; i++)
            {
                z+="0";
            }
            if(s1.length()>s2.length())
            {s2=z+s2;}else{s1=z+s1;}
            StringBuffer sb=new StringBuffer(s1);
            sb=sb.reverse();
            s1=sb+""; //reverse
            sb=new StringBuffer(s2);
            sb=sb.reverse();
            s2=sb+""; // reverse
            int flag=1;
            int hit;
            for(int i=0 ; i<s1.length() ; i++)
            {   if(s1.charAt(i)=='0' && s2.charAt(i)=='0')
                    {
                        flag=0;
                        break;
                    }
                else if(s1.charAt(i)=='1' && s2.charAt(i)=='1')
                    {
                        if(ans.charAt(i-1)=='E')
                        {
                            ans=ans.substring(0,i-1)+"W";
                            ans+="..";
                        }
                        else
                        {
                            ans=ans.substring(0,i-1)+"S";
                            ans+="..";
                        }
                        hit=i;
                    }
                else if(s1.charAt(i)=='1')
                    ans+="E";
                else if(s2.charAt(i)=='1')
                    ans+="N";
            }
            if(x<0)
            {
                ans=ans.replaceAll("E",".");
                ans=ans.replaceAll("W","E");
                ans=ans.replaceAll(".","W");
            }
            if(y<0)
            {
                ans=ans.replaceAll("N",".");
                ans=ans.replaceAll("S","N");
                ans=ans.replaceAll(".","S");
            }
             for(int i=0 ; i<ans.length() ; i++)
            {   if(ans.charAt(i)=='E')
                {
                    xa-=Math.pow(2,i);
                }
                else if(ans.charAt(i)=='W')
                {
                    xa+=Math.pow(2,i);
                }
                if(ans.charAt(i)=='N')
                {
                    ya-=Math.pow(2,i);
                }
                else if(ans.charAt(i)=='S')
                {
                    ya+=Math.pow(2,i);
                }
            }
            int yaa=Math.abs(ya);
            int xaa=Math.abs(xa);
            
            s1=Integer.toBinaryString(xaa);
            s2=Integer.toBinaryString(yaa);
            l=(s1.length()>s2.length())?s1.length()-s2.length():s2.length()-s1.length();
        z="";
            for(int i=0 ; i<l ; i++)
            {
                z+="0";
            }
            if(s1.length()>s2.length())
            {s2=z+s2;}else{s1=z+s1;}
            l=(s1.length()>s2.length())?s1.length():s2.length();
            String ans2="";
            sb=new StringBuffer(s1);
            sb=sb.reverse();
            s1=sb+""; //reverse
            sb=new StringBuffer(s2);
            sb=sb.reverse();
            s2=sb+""; // reverse
            for(int i=0 ; i<l ; i++)
            {  if(s1.charAt(i)=='1')
                    ans2+="E";
               else if(s2.charAt(i)=='1')
                    ans2+="N";
            }
            if(xa<0)
            {
                ans2=ans2.replaceAll("E",".");
                ans2=ans2.replaceAll("W","E");
                ans2=ans2.replaceAll(".","W");
            }
            if(ya<0)
            {
                ans2=ans2.replaceAll("N",".");
                ans2=ans2.replaceAll("S","N");
                ans2=ans2.replaceAll(".","S");
            }
            ans=ans.replace("..",ans2);
            if(flag==0)
                System.out.println("Case #"+(++b)+" IMPOSSIBLE");
            else
                System.out.println("Case #"+(++b)+" "+ans);           
        }
   }
}
}