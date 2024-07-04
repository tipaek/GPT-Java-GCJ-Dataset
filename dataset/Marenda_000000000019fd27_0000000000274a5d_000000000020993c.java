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
            int sum = 0;
            for(int i = 0; i < n;i++){
                for(int j = 0; j < n;j++){
                    if(i == j){
                        sum += matrix[i][j];
                    }
                }
            }
            sb.append(" " + sum);
            int r = 0;
            for(int z = 0; z < n;z++){
                int res = 1;
                for(int i = 1; i < n;i++){
                    int j = 0;
                    for(j = 0; j < i;j++){
                        if(matrix[z][i] == matrix[z][j]){
                            break;
                        }
                    }
                    if(i == j)
                        res++;
                }
                if(res < n)
                    r+=1;
            }
            sb.append(" " + r);
            int c = 0;
            for(int z = 0; z < n;k++){
                int res = 1;
                for(int i = 1; i < n;i++){
                    int j = 0;
                    for(j = 0; j < i;j++){
                        if(matrix[i][z] == matrix[j][z]){
                            break;
                        }
                    }
                    if(i == j)
                        res++;
                }
                if(res < n){
                    c+=1;
                }
            }
            sb.append(" " + c + "\n");
        }
        System.out.println(sb.toString());
    }
    
}