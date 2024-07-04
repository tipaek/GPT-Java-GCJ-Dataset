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
            int resultR = 0;
            int resultC = 0;
            int sum = 0;
            HashSet<Integer> h1 = new HashSet<>();
            HashSet<Integer> h2 = new HashSet<>();
            int[] arr = new int[3];
            for(int i = 0; i < n;i++){

                for(int j = 0; j < n;j++){
                    if(i == j)
                        sum += matrix[i][j];
                    h1.add(matrix[i][j]);
                    h2.add(matrix[j][i]);
                }
                if(h1.size() < n)
                    resultR += 1;
                if(h2.size() < n)
                    resultC += 1;
                h1.clear();
                h2.clear();
            }
            arr[0] = sum;
            arr[1] = resultR;
            arr[2] = resultC;
            sb.append("Case #"+k+":" + " " + sum + " " + resultR + " " + resultC + "\n");
        }
        System.out.println(sb.toString());
    }
}