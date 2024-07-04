import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int k = 1; k <= t;k++){
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n;i++){
                for(int j = 0; j < n;j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            sb.append("Case #"+k+":");
            int sum = mainDiagonal(matrix,n);
            sb.append(" " + sum);
            int r = findR(matrix,n);
            sb.append(" " + r);
            int c = findC(matrix,n);
            sb.append(" " + c + "\n");
        }
        System.out.println(sb.toString());
    }

    public static int findC(int[][] matrix, int n) {
        int result = 0;
        for(int i = 0; i < n;i++){
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int j = 0; j < n;j++){
                hs.add(matrix[j][i]);
            }
            if(hs.size() < n)
                result += 1;
        }
        return result;
    }


    public static int findR(int[][] matrix,int n){
        int result = 0;
        for(int i = 0; i < n;i++){
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int j = 0; j < n;j++){
                hs.add(matrix[i][j]);
            }
            if(hs.size() < n)
                result += 1;
        }
        return result;
    }

    public static int mainDiagonal(int[][] matrix,int n) {
        int sum = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                if(i == j){
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
