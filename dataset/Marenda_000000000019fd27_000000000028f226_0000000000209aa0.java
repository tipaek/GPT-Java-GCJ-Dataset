import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        String s1 = "";
        for(int l = 1; l <= t;l++){
            s1 += "Case #" + l+ ": ";
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(k >= n && k<= n *n && k % n == 0){
                s1 += "POSSIBLE\n";
                String matrica = "";
                int[] arr = new int[n];
                int mainDiagonalElement = k / n;
                arr[0] = mainDiagonalElement;
                matrica += "" + mainDiagonalElement+ " ";
                for(int i = 1; i < n;i++){
                    if (i + 1 == mainDiagonalElement) {
                        arr[i] = mainDiagonalElement - 1;
                        matrica += arr[i] + " ";
                    }else{
                        arr[i] = i + 1;
                        matrica += arr[i] + " ";
                    }
                }

                matrica += "\n";

                for(int i = 0; i < n - 1;i++){
                    int temp = arr[n - 1];
                    int j;
                    for(j = n - 1;j > 0;j--){
                        arr[j] = arr[j-1];
                    }
                    arr[j] = temp;
                    for(int s = 0; s < n;s++){
                        matrica += arr[s] +" ";
                    }
                    matrica += "\n";
                }
                s1 += matrica;
            }else{
                s1 += "IMPOSSIBLE\n";
            }
        }
        System.out.println(s1);
    }
}