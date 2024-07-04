import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        int[][] pascal = new int[32][32];
        pascal[0][0] = 1;
        for(int i = 1; i < 32; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                }
            }
        }

        for(int t = 1; t <= numTests; t++){
            int n = sc.nextInt();
            System.out.println("Case #" + t + ":");

            if(n == 1){
                System.out.println("1 1");
                continue;
            }

            int sum = 0;

            // true == right, false == left
            boolean dir = true;

            int rowsRequired = 0;

            for(int i = 1; Math.pow(2, i) <= n; i++){
                rowsRequired++;
                sum += Math.pow(2, i-1);
                if(dir){
                    for(int j = 1; j <= i; j++){
                        System.out.println(i + " " + j);
                    }
                    dir = false;
                } else {
                    for(int j = i; j >= 1; j--){
                        System.out.println(i + " " + j);
                    }
                    dir = true;
                }
            }

            int curR;
            int curC;

            if(rowsRequired % 2 == 1){
                curR = rowsRequired + 1;
                curC = rowsRequired + 1;
            } else {
                curR = rowsRequired + 1;
                curC = 1;
            }


            while(sum < n){
                System.out.println(curR + " " + curC);
                sum += 1;
                if(curR == curC){
                    curR++;
                    curC++;
                } else {
                    curR++;
                }
            }
        }
    }
}


