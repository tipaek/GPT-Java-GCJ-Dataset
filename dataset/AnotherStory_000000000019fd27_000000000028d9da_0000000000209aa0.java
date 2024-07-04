import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int ts = 0; ts < t; ts++) {
            int n = sc.nextInt();
            int reqSum = sc.nextInt();

            int generateArr[] = new int[n];

            for(int i = 0; i < n; i++)
                generateArr[i] = (i + 1);

            int arr[][][] = new int[n][n][n * 2];

            for(int k = 0; k < n; k++){
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++)
                        arr[i][j][k] = generateArr[(i + j + k) % n];
                }
            }

            for(int i = 0; i < n; i++)
                generateArr[i] = (n - i);

            for(int k = n; k < n*2; k++){
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++)
                        arr[i][j][k] = generateArr[(i + j + k) % n];
                }
            }

            boolean answerFound = false;
            for(int k = 0; k < n*2; k++){
                int sum = 0;
                for(int i = 0; i < n; i++) {
                    sum += arr[i][i][k];
                }

                if(sum == reqSum) {
                    System.out.println("Case #" + (ts + 1) + ": " + "POSSIBLE");
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < n; j++) {
                            System.out.print(arr[i][j][k] + " ");
                        }
                        System.out.println();
                    }

                    answerFound = true;
                    break;
                }
            }
            
            if(!answerFound)
                System.out.println("Case #" + (ts + 1) + ": " + "IMPOSSIBLE");
        }
    }
}