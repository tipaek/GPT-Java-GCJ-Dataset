import java.io.*;
import java.util.*;

class Solution{
    public static int getMaxVal(int[][] arr, int r, int c) {
        int roundCount = 0, rSum, iSum = 0;
        int[][] nArr;

        while (true) {
            roundCount = 0;
            nArr = new int[r][c];
            rSum = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] == 0)
                        continue;
                    rSum += arr[i][j];
                    int nCount = 0;
                    int nSum = 0;
                    for (int k = i - 1; k >= 0; k--) {
                        if (arr[k][j] != 0) {
                            nSum += arr[k][j];
                            nCount++;
                            break;
                        }
                    }
                    for (int k = i + 1; k < r; k++) {
                        if (arr[k][j] != 0) {
                            nSum += arr[k][j];
                            nCount++;
                            break;
                        }
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (arr[i][k] != 0) {
                            nSum += arr[i][k];
                            nCount++;
                            break;
                        }
                    }
                    for (int k = j + 1; k < c; k++) {
                        if (arr[i][k] != 0) {
                            nSum += arr[i][k];
                            nCount++;
                            break;
                        }
                    }
                    if (nCount > 0) {
                        double avg = nSum / (nCount * 1.0);
                        if (avg > arr[i][j]) {
                            nArr[i][j] = 0;
                            roundCount++;
                        } else
                            nArr[i][j] = arr[i][j];
                    }
                }
            }
            iSum += rSum;
            if (roundCount <= 0)
                break;
            else {
                arr = nArr;
            }
        }
        return iSum;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tItr = 1; tItr <= t; tItr++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] arr = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    arr[i][j] = sc.nextInt();
            }

            System.out.println("Case #" + tItr + ": " + getMaxVal(arr, r, c));
        }
        sc.close();
    }
}