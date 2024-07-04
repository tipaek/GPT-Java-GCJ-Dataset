import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int k = 0; k<t; k++){
            int n=sc.nextInt();
            int[][] arr = new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j){
                        sum=sum+arr[i][j];
                    }
                }
            }
            int rCount=0;int flag=0;
            for(int i=0;i<n;i++){
                int z=0;
                for(int j=1;j<n;j++){
                    if(arr[i][0]==arr[i][j] || arr[i][z]==arr[i][j]){
                        flag=1;
                        break;
                    }
                }
                if(flag==1){
                    rCount++;
                }
                flag=0;
            }
            flag=0;int cCount=0;
            for(int i=0;i<n;i++){
                int f=0;
                for(int j=1;j<n;j++){
                    if(arr[0][i]==arr[j][i] || arr[f][i]==arr[j][i]){
                        flag=1;
                        break;
                    }
                    f++;
                }
                if(flag==1){
                    cCount++;

                }
                flag=0;
            }
            System.out.print("Case#"+(k+1) +": " + (sum)+ " " + (rCount) + " "+ (cCount)+ "\n");
        }
    }
}