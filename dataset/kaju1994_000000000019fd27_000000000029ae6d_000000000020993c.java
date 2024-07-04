import java.util.*;

public class Solutions{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            int expectedSum = n*(n+1)/2;
            int matrix[][]=new int[n][n];
            int row=0;
            int col=0;
            int trace=0;
            for(int k=0;k<n;k++){
                int sum = 0;
                for(int j=0;j<n;j++){
                    matrix[k][j] = sc.nextInt();
                    if(k==j){
                        trace+=matrix[k][j];
                    }
                    sum+=matrix[k][j];
                    if(k!=0){
                        matrix[k][j]+=matrix[k-1][j];
                    }
                    if(k==n-1 && matrix[k][j]!= expectedSum){
                        col++;
                    }
                }
                if(sum != expectedSum){
                    row++;
                }
            }
            System.out.println("Case #"+i+": "+trace+" "+row+" "+col);
        }
    }
}