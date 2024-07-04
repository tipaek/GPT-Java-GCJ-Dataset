import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //int trace=0;
        int t=in.nextInt();
        for(int k=0;k<t;k++){
        int N=in.nextInt();
        int trace=0;
        int[][] arr1=new int[N][N],arr2 =new int[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                arr1[i][j]=in.nextInt();
                arr2[i][j]=arr1[i][j];
                if(i==j){
                    trace+=arr1[i][j];
                }
            }
        }
        int r=0;
        for(int j=0;j<N;j++) {
            for (int i = 0; i < N; i++) {
                if (arr1[j][Math.abs(arr1[j][i]) - 1] >= 0)
                    arr1[j][Math.abs(arr1[j][i]) - 1] = -arr1[j][Math.abs(arr1[j][i]) - 1];
                else{
                    r++;
                break;}
            }
        }
        int c=0;
        for(int i=0;i<N;i++){
            for (int j = 0; j < N; j++)
            {
                if (arr2[Math.abs(arr2[j][i])-1][i]>= 0)
                    arr2[Math.abs(arr2[j][i])-1][i] = -arr2[Math.abs(arr2[j][i])-1][i];
                else{
                    c++;
                    break;}
            }
        }
        System.out.println("Case #"+(k+1)+": "+ trace +" "+r+" "+c);
        }
    }
}

