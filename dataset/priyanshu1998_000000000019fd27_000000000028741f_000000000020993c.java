import java.util.*;

public class Solution{
    static String solve(int arr[][],int n)
    {
        if(n==0)
        {
            return "0 0 0";
        }
        int diag=0;int r=0;int c=0;
        for(int i=0;i<n;i++)
        {
            diag=diag+arr[i][i];
            HashMap<Integer,Boolean> mapr=new HashMap<>();
            HashMap<Integer,Boolean> mapc=new HashMap<>();
            for(int j=0;j<n;j++)
            {
                if(!mapr.containsKey(arr[i][j]))
                {
                    mapr.put(arr[i][j],true);
                }
                else
                {
                    r++;
                    break;
                }
            }
            for(int j=0;j<n;j++)
            {
                if(!mapc.containsKey(arr[j][i]))
                {
                    mapc.put(arr[j][i],true);
                }
                else
                {
                    c++;
                    break;
                }
            }
        }
        return diag+" "+r+" "+c;
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();int k=1;
        ArrayList<String> small=new ArrayList<String>();
        while(k<=t)
        {
            int n=s.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=s.nextInt();
                }
            }
            String ans="Case #"+(k)+": "+solve(arr,n);
            small.add(ans);
            k++;
        }
        for(int i=0;i<small.size();i++)
        {
            System.out.println(small.get(i));
        }
    }
}