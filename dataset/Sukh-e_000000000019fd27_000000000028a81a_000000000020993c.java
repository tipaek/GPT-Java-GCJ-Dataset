import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int f=1;f<=t;f++){
            int n=s.nextInt();
            int a[][]=new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=s.nextInt();
                    if(i==j)
                    sum+=a[i][j];
                }
            }
            int r=0,c=0;
            HashSet<Integer> hs;
            for(int i=0;i<n;i++){
                hs=new HashSet<>();
                for(int j=0;j<n;j++)
                hs.add(a[i][j]);
                if(hs.size()!=n)r++;
            }
            for(int i=0;i<n;i++){
                hs=new HashSet<>();
                for(int j=0;j<n;j++)
                hs.add(a[j][i]);
                if(hs.size()!=n)c++;
            }
            System.out.println("Case #"+f+": "+sum+" "+r+" "+c);
        }
    }
}