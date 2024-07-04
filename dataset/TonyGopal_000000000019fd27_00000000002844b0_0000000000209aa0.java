import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int iteration=0; iteration<T; iteration++){
            int n = sc.nextInt();
            int[][] output = new int [n][n];
            int trace = sc.nextInt();

            if(trace%n !=0 || trace/n > n){
                System.out.println("Case #" + (iteration+1) +": IMPOSSIBLE");
                continue;
            }
            else{
                System.out.println("Case #" + (iteration+1) +": POSSIBLE");
            }
            int start = (trace/n) - 1;
            int[] naturalNumbers = new int[n];
            for(int i=1; i<=n; i++){
                naturalNumbers[i-1] = i;
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    output[i][j] = naturalNumbers[(start + j)%n];
                    if(j!=n-1)
                        System.out.print(output[i][j] + " ");
                    else
                    System.out.println(output[i][j]);
                }
                start = start + n - 1;
            }
        }
        sc.close();
    }
}