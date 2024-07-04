import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            if(K % N == 0) {
                System.out.println("Case #" + (i + 1)+ ": POSSIBLE");
                matrixPrint(N,solution(N,K/N));
            }
            else
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
        }
    }

    public static Integer[][] solution(int size, int diagonal) {
        Integer[][] answer = new Integer[size][size];
        Integer[] dataSet = new Integer[size - 1];
        for(int i = 0; i < size - 1; i++) {
            if(i + 1 < diagonal)
                dataSet[i] = i +1;
            else
                dataSet[i] = i + 2;
        }
        dataSet[size - 2] = size;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i ==j)
                    answer[i][i] = diagonal;
                else if(j > i)
                    answer[i][j] = dataSet[j - i -1];
                else if(j < i) {
                    answer[i][j] = dataSet[size - i + j -1];
                }
            }
        }
        return answer;
    }


    public static void matrixPrint(int size,Integer[][] matrix) {
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
