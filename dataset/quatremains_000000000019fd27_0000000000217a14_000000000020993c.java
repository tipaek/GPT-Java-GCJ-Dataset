import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {

            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    arr[a][b] = sc.nextInt();
                }
            }
            int traceNum = 0;
            for (int y = 0; y < n; y ++) {
                traceNum += arr[y][y];
            }


            int colCount = 0;
            int rowCount = 0;

            int[] checkArr = new int[n];
            int[] saveArr = new int[n];
                for (int a = 0; a < n; a++) {
                boolean isVestigium = true;
                    for (int b = 0; b < n; b++) {
                        checkArr[arr[a][b]-1]--;
                        if (checkArr[arr[a][b]-1] < -1) isVestigium = false;
                    }
                    checkArr = saveArr.clone();
                    if (!isVestigium) colCount++;
                }
                for (int b = 0; b < n; b++) {
                boolean isVestigium = true;
                    for (int a = 0; a < n; a++) {
                        checkArr[arr[a][b]-1]--;
                        if (checkArr[arr[a][b]-1] < -1) isVestigium = false;
                    }
                    checkArr = saveArr.clone();
                    if (!isVestigium) rowCount++;
            }
            System.out.println("Case #"+(k+1)+": "+traceNum+" "+colCount+" "+rowCount);
        }

    }
}
