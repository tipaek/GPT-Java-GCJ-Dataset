import java.util.Scanner;

public class Solution {
    public static boolean check(int[][] arr, int i, int j) {
        int[] directions = {-1, 1};
        
        // Check vertical directions
        for (int dir : directions) {
            int i1 = i + dir;
            while (i1 >= 0 && i1 < arr.length) {
                if (arr[i1][j] == -1) {
                    i1 += dir;
                    continue;
                }
                if (arr[i1][j] > arr[i][j]) return false;
                break;
            }
        }

        // Check horizontal directions
        for (int dir : directions) {
            int j1 = j + dir;
            while (j1 >= 0 && j1 < arr[0].length) {
                if (arr[i][j1] == -1) {
                    j1 += dir;
                    continue;
                }
                if (arr[i][j1] > arr[i][j]) return false;
                break;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNum = 1;

        while (t > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] a = new int[r][c];
            int skill = 0;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j] = sc.nextInt();
                    skill += a[i][j];
                }
            }

            int no = r * c;
            int prev = 0;

            while (no > 1) {
                no = 0;
                int k = 0;
                int[][] b = new int[r * c][2];
                int sum = 0;

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (check(a, i, j)) {
                            skill += a[i][j];
                            sum += a[i][j];
                            no++;
                        } else {
                            b[k][0] = i;
                            b[k][1] = j;
                            k++;
                        }
                    }
                }

                for (int i = 0; i < k; i++) {
                    a[b[i][0]][b[i][1]] = -1;
                }

                if (no == prev) {
                    skill -= sum;
                    break;
                } else {
                    prev = no;
                }
            }

            System.out.println("Case #" + caseNum + ": " + skill);
            t--;
            caseNum++;
        }
        sc.close();
    }
}