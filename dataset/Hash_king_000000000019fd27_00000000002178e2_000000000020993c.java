import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int tr=0,r=0,c=0;
            for(int j=0;j<n;j++)
            for(int k=0;k<n;k++)
            {
                a[j][k]=sc.nextInt();
                if(j==k)
                tr+=a[j][k];
            }
            for(int j=0;j<n;j++){
                if(isR(a[j]))
                r++;
            }
            for(int j=0;j<n;j++){
                int tt[]=new int[n];
                for(int k=0;k<n;k++)
                tt[k]=a[k][j];
                if(isR(tt))
                c++;
            }
            System.out.println("Case #"+(i+1)+": "+tr+" "+r+" "+c);
            
        }


        sc.close();
    }
    public static boolean isR(int a[]){
        HashSet<Integer> s=new HashSet<>();
        for(int i=0;i<a.length;i++)
        {
            if(s.contains(a[i]))
            return true;
            s.add(a[i]);
        }
        return false;
    }
}