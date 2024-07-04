import java.util.*;
class Solution{
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=1;i<=T;i++)
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
            
            
        }
        
    }
}