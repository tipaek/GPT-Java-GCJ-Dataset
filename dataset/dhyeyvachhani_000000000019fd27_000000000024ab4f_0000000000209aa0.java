import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();

        for(int i=0;i<total;i++){

            int n = in.nextInt();
            int k = in.nextInt();

            if((k/3)>n){
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
            else{
                int matrix[][] = new int[n][n];
                int arr[] = new int[n];
                int arrayFill = k/3,arrayCount=1;

                arr[0]=arrayFill;
                for(int j=1;j<n;j++){
                    if(arrayCount!=arrayFill){arr[j]=arrayCount;arrayCount++;}
                }

                int result[] =  new int[n];
                for(int j=0;j<n;j++){
                    System.arraycopy(arr,0,result,1,arr.length-1);
                    result[0]=arr[arr.length-1];
                    for(int l=0;k<n;l++){
                        matrix[j][l]=result[l];
                    }
                    arr=result;
                }

                System.out.println("Case #" + i + ": " + "POSSIBLE");
                for(int j=0;j<n;j++){
                    for(int l=0;l<n;l++){
                        System.out.print(matrix[j][l]+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
