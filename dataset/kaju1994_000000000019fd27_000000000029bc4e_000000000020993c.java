import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            int matrix[][]=new int[n+1][n];
            boolean colFlag[]=new boolean[n];
            int row=0;
            int col=0;
            int trace=0;
            int input=0;
            for(int k=0;k<n;k++){
                int arr[]=new int[n+1];
                boolean rowFlag=true;
                for(int j=0;j<n;j++){
                    input = sc.nextInt();
                    if(k==j){
                        trace+=input;
                    }
                    if(rowFlag && arr[input]++ == 1){
                        row++;
                        rowFlag=false;
                    }
                    if(matrix[input][j]++ == 1 && !colFlag[j]){
                        colFlag[j]=true;
                        col++;
                    }
                }
            }
            System.out.println("Case #"+i+": "+trace+" "+row+" "+col);
        }
    }
}