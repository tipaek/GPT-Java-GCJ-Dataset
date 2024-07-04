import java.util.*;
public class Solution
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int trace=0,r=0,c=0;
            for(int i=0;i<n;i++)
            {
                int count=0;
                ArrayList <Integer> al=new ArrayList<>();
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                    if(al.contains(arr[i][j]))
                        count+=1;
                    else
                        al.add(arr[i][j]);
                    if(i==j)
                    trace+=arr[i][j];
                }
                if(count>0)
                r+=1;
            }
            for(int i=0;i<n;i++)
            {
                int count=0;
                ArrayList al=new ArrayList<Integer>();
                for(int j=0;j<n;j++)
                {
                    if(al.contains(arr[j][i]))
                        count+=1;
                    else
                        al.add(arr[j][i]);
                }
                if(count>0)
                    c+=1;
            }
            System.out.println("Case #"+k+": "+trace+" "+r+" "+c);
        }
    }
}