import java.util.Scanner;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            long trace =0;int r=0,c=0;
            int row[]=new int[n];
            int col[]=new int[n];
            int val=(n*(n+1))/2;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    arr[j][k]=sc.nextInt();
                    if(j==k)trace+=arr[j][k];
                    row[j]+=arr[j][k];
                    col[k]+=arr[j][k];
                }
            }
            for(int j=0;j<n;j++){
                if(row[j]!=val)r++;
                if(col[j]!=val)c++;
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
        }
    }
}