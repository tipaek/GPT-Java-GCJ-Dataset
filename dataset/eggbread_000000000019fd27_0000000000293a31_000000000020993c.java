import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++){
            int N = scanner.nextInt();
            //init
            int[][] arr = new int[N][N];
            int sum = 0;
            int row = 0;
            int col = 0;
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    int temp = scanner.nextInt();
                    if(j==k){
                        sum += temp;
                    }
                    arr[j][k] = temp;
                }
            }

            for(int j=0;j<N;j++){
                int[] arrTemp = new int[N];
                boolean found = false;
                for(int k=0;k<N;k++){
                    for(int q=0;q<k;q++){
                        if(arrTemp[q]==arr[j][k]){
                            found= true;
                            break;
                        }
                    }
                    if (!found){
                        arrTemp[k]=arr[j][k];
                    }else{
                        break;
                    }
                }
                if (found){
                    row++;
                }
            }
            for(int j=0;j<N;j++){
                int[] arrTemp = new int[N];
                boolean found = false;
                for(int k=0;k<N;k++){
                    for(int q=0;q<k;q++){
                        if(arrTemp[q]==arr[k][j]){
                            found= true;
                            break;
                        }
                    }
                    if (!found){
                        arrTemp[k]=arr[k][j];
                    }else{
                        break;
                    }
                }
                if (found){
                    col++;
                }
            }
            System.out.println("Case #"+i+": "+sum+" "+row+" "+col);
        }
    }
}