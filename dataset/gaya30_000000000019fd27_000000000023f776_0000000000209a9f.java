import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt(),tt=1;
        sc.nextLine();
        while(tt<=test)
        {
            String s=sc.nextLine();int max=-1,pos=-1;
        for(int i=0;i<s.length();i++)
        {
            if(Integer.parseInt(String.valueOf(s.charAt(i)))>max)
            {
                max=Integer.parseInt(String.valueOf(s.charAt(i)));
                pos=i;
            }
        }
        String res=String.valueOf(max);
        for(int i=0;i<max;i++)
        {
            res="("+res+")";
        }
        for(int i=pos-1;i>=0;i--)
        {
           int n=Integer.parseInt(String.valueOf(s.charAt(i))),temp=0,braket=0,flag=0;
           while(temp<n)
           {
               if(res.charAt(temp)>=48 && res.charAt(temp)<=57)
               {
                   flag=1;
                   break;
               }
               else if(res.charAt(temp)=='(')
               braket++;
               temp++;
           }
           if(flag==0)
           res=res.substring(0,temp)+String.valueOf(s.charAt(i))+res.substring(temp);
           else{
               String str=res.substring(0,temp),stemp=String.valueOf(s.charAt(i));
               //System.out.println("left = "+str);
               int ttt=1;
               while(ttt<=n-braket)
               {
                   stemp="("+stemp+")";
                   ttt++;
               }
               res=str+stemp+res.substring(temp);
           }
        }
        //System.out.println("pos= "+pos);
        for(int i=pos+1;i<s.length();i++)
        {
            int n=Integer.parseInt(String.valueOf(s.charAt(i)));
           int temp=res.length()-1,end=res.length()-n,braket=0,flag=0;
           while(temp>=end)
           {
               if(res.charAt(temp)>=48 && res.charAt(temp)<=57)
               {
                   flag=1;
                   break;
               }
               else if(res.charAt(temp)==')')
               braket++;
               temp--;
           }
           //System.out.println("n = "+n+" temp = "+temp);
           if(flag==0)
           res=res.substring(0,temp+1)+String.valueOf(s.charAt(i))+res.substring(temp+1);
           else{
               String str=res.substring(0,temp+1),stemp=String.valueOf(s.charAt(i));
               int ttt=1;
               while(ttt<=n-braket)
               {
                   stemp="("+stemp+")";
                   ttt++;
               }
               //System.out.println(stemp);
               res=str+stemp+res.substring(temp+1);
           }
           //System.out.println(res);
        }
        System.out.println("Case #"+tt+": "+res);
            tt++;
        }
    }
}