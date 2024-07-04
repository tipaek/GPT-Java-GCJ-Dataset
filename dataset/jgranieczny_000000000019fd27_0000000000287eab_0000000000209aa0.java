import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();//test cases
        for(int i=0;i<T;i++){
            int N = scanner.nextInt();// square N-matrix
            int K = scanner.nextInt();//trace
            int[][] matrix = new int[N][N];
            boolean possible = solution(N,0,0,K,matrix);
            System.out.println("Case #"+(i+1)+": "+(possible?"POSSIBLE":"IMPOSSIBLE"));
            if(possible){
                for(int a=0;a<matrix.length;a++){
                    for(int b=0;b<matrix.length;b++){
                        System.out.print(matrix[a][b]+ " ");
                    }
                    System.out.println();
                }
            }


        }
    }

    private static boolean solution(int n,int i,int j, int k,int[][] matrix) {
//        for(int p=0;p<matrix.length;p++){
//            System.out.println(Arrays.toString(matrix[p]));
//        }
//        System.out.println();
        if(!check(matrix,k)){
            return false;
        }
        if(j>=matrix.length) {
            return (trace(matrix) == k);
        }
        if(i>=matrix.length)
            return solution(n,0,j+1,k,matrix);

        for(int t=1;t<=n;t++) {

            matrix[i][j] = t;

            if(solution(n, i + 1, j, k, matrix)){
                return true;

        }
        }
        matrix[i][j]=0;

        return false;
    }

    private static int trace(int[][] matrix) {
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            sum+=matrix[i][i];
        }
        return sum;
    }
    private static boolean check(int[][] matrix,int k){
        if(trace(matrix)>k)
            return false;
        for(int i=0;i<matrix.length;i++){
            boolean[] duplicatesR = new boolean[matrix.length+1];
            boolean[] duplicatesC = new boolean[matrix.length+1];
            for(int j=0;j<matrix.length;j++){

                if(matrix[i][j]!=0&&duplicatesC[matrix[i][j]]==true)
                    return false;
                if(matrix[j][i]!=0&&duplicatesR[matrix[j][i]]==true)
                    return false;
                duplicatesC[matrix[i][j]]=true;
                duplicatesR[matrix[j][i]]=true;

            }
        }
        return true;
    }
}