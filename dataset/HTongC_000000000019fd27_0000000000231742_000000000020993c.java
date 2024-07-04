import java.util.Arrays;
import java.util.Scanner;

class Vestigium{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int k = 0;
        int r = 0;
        int c = 0;

        for(int i = 1; i <= T; i++){
            int N = input.nextInt();
            int[] arr = new int[N^2];
            for(int j = 0; j < N; j++) {
                int a = input.nextInt();
                arr[j] = a;
            }

            //calculate k
            for(int m = 0; m < N; m = m+N+1 ){
                k += arr[m];
            }

            //calculate r
            for(int p = 0; p < N; p += N){
                int[] row = Arrays.copyOfRange(arr,p,p+N);
                r += repeated(row);
            }

            //calculate c
            int[] column = new int[N];

            for (int q = 0; q < N; q ++) {
                   for(int h = 0; h< N; h++){
                       column[h] = arr[q];
                       q += N;
                   }
                   c += repeated(column);
                }

            System.out.println("Case #"+T+": "+k+" "+r+" "+c);
        }
    }
    public static int repeated(int[] arr){
        int count = 0;
        for(int m = 0; m<arr.length; m++){
            for(int n = m + 1; n < arr.length; n++){
                if(arr[m]==arr[n]){
                    count ++;
                }
            }
        }
        return count;
    }


}