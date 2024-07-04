import java.util.Arrays;
import java.util.Scanner;

class Vestigium{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for(int i = 1; i <= T; i++){
            int k = 0;
            int r = 0;
            int c = 0;
            int N = input.nextInt();

            int[] arr = new int[N*N];


            for(int j = 0; j < N*N; j++) {
                int a = input.nextInt();
                arr[j] = a;
            }


            //calculate k
            for(int m = 0; m < N*N; m = m+N+1 ){
                k += arr[m];
            }

            //calculate r
            for(int p = 0; p < N*N; p += N){
                int[] row = Arrays.copyOfRange(arr,p,p+N-1);
                r += repeated(row);
            }

            //calculate c
            for (int q = 0; q < N; q ++) {
                int[] column = new int[N];
                int w = q;
                   for(int h = 0; h < N; h++){
                       column[h] = arr[w];
                       w += N;
                   }
                c += repeated(column);
                }

            System.out.println("Case #"+i+": "+k+" "+r+" "+c);

        }
    }

    public static int repeated(int[] arr){
        for(int m = 0; m<arr.length; m++){
            for(int n = m + 1; n < arr.length; n++){
                if(arr[m]==arr[n]){
                    return 1;
                }
            }
        }
        return 0;
    }

}
