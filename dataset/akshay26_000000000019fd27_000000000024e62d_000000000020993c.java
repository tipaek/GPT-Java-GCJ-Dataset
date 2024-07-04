import java.util.Scanner;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=1;t<=test;t++){
            int n=sc.nextInt();
            int fre[][]=new int[n+1][101];
            int arr[][]=new int[n+1][n+1];
            int r=0,c=0;
            boolean flag=false;
            long sum=0l;
            for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
            arr[i][j]=sc.nextInt();
            
            for(int i=1;i<=n;i++){
                flag=false;
                for(int j=1;j<=n;j++){
                    int temp=arr[i][j];
                    fre[i][temp]++;
                    if(fre[i][temp] >1)
                    flag=true;
                    if(i == j) sum+=temp;
                }
                if(flag) r++;
            }
            fre=new int[n+1][101];
             for(int i=1;i<=n;i++){
                flag=false;
                for(int j=1;j<=n;j++){
                    int temp=arr[j][i];
                    fre[i][temp]++;
                    if(fre[i][temp] >1)
                    flag=true;
                }
                if(flag) c++;
            }
            System.out.println("Case #"+t+": "+sum+" "+r+" "+c);
        }
    }
}