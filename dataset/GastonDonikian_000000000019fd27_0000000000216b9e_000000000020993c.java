import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for(int i = 1; i <= T; i++) {
            int N = scan.nextInt();
            Integer[][] matrix = new Integer[N][N];
            for(int a = 0; a < N; a++) {
                for (int j = 0; j < N; j++)
                    matrix[a][j] = scan.nextInt();
            }
            System.out.print("Case #" + i + ": ");
            solution(N,matrix);
        }
    }



    public static void solution(int N,Integer[][] matrix) {
        int k = 0;
        int r = 0;
        int c = 0;
        for(int i = 0; i < N; i++) {
            k += matrix[i][i];
            if(hasRepeat(N,takeRow(N,i,matrix)))
                r++;
            if(hasRepeat(N,takeColumn(N,i,matrix)))
                c++;
        }
        System.out.println(k + " " + r + " " + c);
    }

    private static Boolean hasRepeat(int size, Integer[] vector) {
        for(int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++)
                if (vector[i] == vector[j])
                    return true;
        }
        return false;

    }

    private static Integer[] takeRow(int size, int pos, Integer[][] matrix) {
        Integer[] answer = new Integer[size];
        for(int i = 0; i < size; i++) {
            answer[i] = matrix[pos][i];
        }
        return answer;
    }

    private static Integer[] takeColumn(int size, int pos, Integer[][] matrix) {
        Integer[] answer = new Integer[size];
        for(int i = 0; i < size; i++)
            answer[i] = matrix[i][pos];
        return answer;
    }
}
