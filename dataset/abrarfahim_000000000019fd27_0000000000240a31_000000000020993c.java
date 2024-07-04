import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            //logic
            int trace = 0;
            int row = 0;
            int col = 0;

            //trace
            for(int l = 0; l < n; l++) {
                trace += arr[l][l];
            }

            boolean[] rowsChecked = new boolean[n];
            boolean[] colsChecked = new boolean[n];


            for(int a = 0; a < n; a++) {
                for(int b = 0; b < n; b++) {
                    for(int c = b + 1; c < n; c++) {
                        //row
                        if(rowsChecked[a]) continue;
                        if(arr[a][b] == arr[a][c]) {
                            row++;
                            rowsChecked[a] = true;
                            break;
                        }
                    }
                    //col
                    for(int d = a + 1; d < n; d++) {
                        //col
                        if(colsChecked[b]) continue;
                        if(arr[a][b] == arr[d][b]) {
                            col++;
                            colsChecked[b] = true;
                            break;
                        }
                    }
                }

            }



            //output
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + col);
        }


    }
}
