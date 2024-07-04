import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=0; i < num; i++) {
            int len = sc.nextInt();
            int sum = 0;
            int[][] matrix = new int[len][len];
            int row = 0;
            int col = 0;

            for(int j=0; j < len; j++) {
                int[] visited = new int[len+1];
                boolean check = false;
                for(int k=0; k < len; k++) {
                    int value = sc.nextInt();
                    matrix[j][k] = value;
                    if(j == k) {
                        sum += value;
                    }

                    visited[value]++;

                    if(visited[value] > 1 && !check) {
                        row++;
                        check = true;
                    }
                }
            }

            for(int j=0; j < len; j++) {
                int[] visited = new int[len+1];
                boolean check = false;
                for (int k = 0; k < len; k++) {
                    visited[matrix[k][j]]++;

                    if(visited[matrix[k][j]] > 1 && !check) {
                        col++;
                        check = true;
                    }
                }
            }

            System.out.println("Case #"+(i+1)+": " + sum + " " +  row + " " + col);
        }
    }
}
