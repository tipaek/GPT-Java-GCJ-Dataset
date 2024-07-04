import java.util.*;
public class Solution{
    static boolean match(String s,String k)
    {
        int l1=s.length();
        int l2=k.length();
        int t=l1;
        for(int i=l2-1;i>=0;i--)
        {
            t--;
            if(k.charAt(i)=='*'||s.charAt(t)=='*')
            return true;
            else if(k.charAt(i)==s.charAt(t))
            continue;
            else
            return false;
           
        }
        return false;
        
    }
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int k=1;k<=T;k++)
        {
            int N=sc.nextInt();
            String maxS="";
            int maxlen=-1;
            String arr[]=new String[N];
            for(int i=0;i<N;i++)
            {
                arr[i]=sc.next();
                if(arr[i].length()>maxlen)
                {
                    maxlen=arr[i].length();
                    maxS=arr[i];
                }
            }
            int fl=0;Arrays.sort(arr);
           for(int j=0;j<N;j++)
            {
             int t=arr[j].length();
              for(int i=maxlen-1;i>=0;i--)
               {
                 t--;
                 if(maxS.charAt(i)=='*'||arr[j].charAt(t)=='*')
                  break;
                        else if(maxS.charAt(i)==arr[j].charAt(t))
                    continue;
                        else
                      {
                      fl=1;break;
                      }
           
                  }
             
            }   
            if(fl==0)
            {
                System.out.println("Case #"+k+": "+maxS.substring(1)); 
            }
            else
            System.out.println("Case #"+k+": *");
            
        }
        
    }
}

/*
2
5
*CONUTS
*US
*OCONUTS
*CONUTS
*S
2
*XZ
*XYZ*/