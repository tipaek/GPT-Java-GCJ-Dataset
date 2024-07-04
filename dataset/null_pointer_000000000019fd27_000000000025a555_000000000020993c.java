import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        int num;
        int n, k, r, c;
        int[][] arr;
        
        while(t > 0) {
            k = 0;
            r = 0;
            c = 0;
            n = sc.nextInt();

            arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < n; i++) {
                k += arr[i][i];
            }

            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    num = arr[row][col];
                    for (int otherRow = row + 1; otherRow < n; otherRow++) {
                        if (num == arr[otherRow][col]) {
                            c++;
                            row = n;
                            break;
                        }
                    }

                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    num = arr[row][col];
                    for (int otherCol = col + 1; otherCol < n; otherCol++) {
                        if (num == arr[row][otherCol]) {
                            r++;
                            col = n;
                            break;
                        }
                    }

                }
            }



            System.out.println("Case #"+ t + ": " + k + " " + r + " " + c);

            t--;
        }
    }
}

