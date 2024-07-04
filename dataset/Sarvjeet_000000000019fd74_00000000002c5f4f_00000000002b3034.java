import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        for(int ii=0;ii<t;ii++)
        {
            int flag=0;
            int n=sc.nextInt();
            StringBuilder[] arr=new StringBuilder[n];

            for(int i=0;i<n;i++)
            {
                StringBuilder sb=new StringBuilder(sc.next());//.substring(1));
                arr[i]=new StringBuilder(sb.substring(1));

            }

            StringBuilder temp=new StringBuilder(arr[0]);

           Arrays.sort(arr, new Comparator<StringBuilder>() {
               @Override
               public int compare(StringBuilder o1, StringBuilder o2) {
                   return o1.length()-o2.length();
               }
           });
           String res=arr[n-1].toString();
            for(int i=0;i<n;i++)
            {
                StringBuilder t1=arr[i];
                for(int j=i+1;j<n;j++)
                {
                    int t2=arr[j].length()-t1.length();
                   // System.out.print(arr[j].substring(t2)+" "+t1.toString()+" "+t2+" ");
                    if(arr[j].substring(t2).equals(t1.toString()))
                    {
                        arr[j]=new StringBuilder(arr[j].substring(0,t2));
                        continue;
                    }
                    else
                    {
                        flag=1;
                               break;
                    }
                }
                if(flag==1) break;

            }
            if(flag==1)
            {
                System.out.println("Case #"+(ii+1)+": *");
            }
            else
                System.out.println("Case #"+(ii+1)+": "+res);
        }
    }
}