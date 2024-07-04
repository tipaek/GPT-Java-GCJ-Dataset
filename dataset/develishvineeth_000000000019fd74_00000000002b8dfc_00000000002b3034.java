import java.util.*;

import javax.lang.model.util.ElementScanner6;



class Solution
{

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int t=s.nextInt();
        int Case=1;
        while(t-->0)
        {
            int n=s.nextInt();
            String[] arr=new String[n];
            for(int i=0;i<n;i++)
                arr[i]=s.next();
            Arrays.sort(arr, (a, b)->Integer.compare(a.length(), b.length()));
            //System.out.println(Arrays.toString(arr));
            StringBuilder str=new StringBuilder();
            int prev=arr[0].length()-1;
            String ans=arr[0].substring(1);
            boolean flag=true;
            for(int i=1;i<n;i++)
            {
                if(arr[i].endsWith(ans))
                {
                    ans=arr[i].substring(1);
                }
                else
                {
                    flag=false;
                    break;
                }
            }
            System.out.print("Case #"+Case+": ");
            Case++;
            if(flag)
            System.out.println(ans);
            else
            System.out.println("*");
        }
        s.close();
    }

}