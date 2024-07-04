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
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    arr[j][k]=sc.nextInt();
                    if(j==k)trace+=arr[j][k];
                    if(row[j]==0){
                        for(int l=0;l<k;l++){
                            if(arr[j][l]==arr[j][k]){
                                row[j]=1;
                                r++;
                                break;
                            }
                        }
                    }
                    if(col[k]==0){
                        for(int l=0;l<j;l++){
                            if(arr[l][k]==arr[j][k]){
                                col[k]=1;
                                c++;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
        }
    }
}