import java.util.*;
import java.io.*;
public class solution{
    public static void main(String []a){
        Scanner in=new Scanner(System.in);
        int t,n;
        t=in.nextInt();
        while(t-->0){
            n=in.nextInt();
            int [][]arr=new int[n][n];
            Set<Integer>set=new HashSet<Integer>();
            Set<Integer>set1=new HashSet<Integer>();
            int sum=0,r=0,c=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=in.nextInt();
                    if(i==j)sum+=arr[i][j];
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    set.add(arr[j][i]);
                    set1.add(arr[i][j]);
                }
                c+=set.size()!=n ? 1 : 0;
                r+=set1.size()!=n ? 1 : 0;
                set.clear();
                set1.clear();
            }
            System.out.println(sum+" "+r+" "+c);
        }
        in.close();
    }
}