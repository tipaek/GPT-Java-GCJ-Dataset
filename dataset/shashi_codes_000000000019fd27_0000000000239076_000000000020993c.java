import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(); int p=1;
        while(t-->0){
            int n=sc.nextInt();int sum=0;int countr=0,countc=0;
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                    if(i==j)
                        sum=sum+a[i][j];
                }
            }
            //int map[]=new int[n+1];
            for(int i=0;i<n;i++){
                int map[]=new int[n+1];
                for(int j=0;j<n;j++){
                    if(map[a[i][j]]==1){
                        countr++;
                        break;
                    }
                    map[a[i][j]]=1;
                }
            }
            for(int i=0;i<n;i++){
                int map[]=new int[n+1];
                for(int j=0;j<n;j++){
                    if(map[a[j][i]]==1){
                        countc++;
                        break;
                    }
                    map[a[j][i]]=1;
                }
            }
            System.out.println("Case #"+p+": "+sum+" "+countr+" "+countc);
            p++;
        }
    }
}