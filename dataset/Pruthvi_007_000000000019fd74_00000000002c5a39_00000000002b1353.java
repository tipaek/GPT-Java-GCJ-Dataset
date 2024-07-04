package com.jackson;


import java.util.*;

public class Solution_PascalWalk {
    private static String output1 = "Case #%d: %s";
    public static void main(String[] args) {
        try {
            pascal[1][1] = 1;
            for (int i = 2 ; i <= 500 ; i++) {
                for (int j = 1 ; j <= i ; j++) {
                    if (j-1 > 0) {
                        pascal[i][j] +=  pascal[i-1][j-1];
                    }
                    if (j < i) {
                        pascal[i][j] +=  pascal[i-1][j];
                    }
                }
            }
            for (int i = 1 ; i <= 10 ; i++) {
                for (int j = 1 ; j <= i ; j++) {
                    System.out.print(pascal[i][j] + " ");
                }
                System.out.println();
            }
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution_PascalWalk().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int[][] pascal = new int[501][501];

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int sum = 0;
        String result = "";
        int cnt = 0;
        if (n <= 500) {
            for (int i = 1 ; i <= n ; i++) {
                result += String.format(("\n%d 1"),i);
                sum += pascal[i][1];
                cnt++;
            }
            System.out.println(String.format("cnt = %d", cnt));
        }
        else if (n == 501) {
            result += "\n1 1";
            sum += pascal[1][1];
            result += "\n2 1";
            sum += pascal[2][1];
            result += "\n3 2";
            sum += pascal[3][2];
            result += "\n3 1";
            sum += pascal[3][1];

            cnt = 4;
            for (int i = 4 ; i <= 499 ; i++) {
                result += String.format(("\n%d 1"),i);
                sum += pascal[i][1];
                cnt++;
            }
            System.out.println(String.format("cnt = %d", cnt));
        }
        else if (n <= 998) {
            result += "\n1 1";
            sum += pascal[1][1];
            cnt++;
            int level = n/2+1;
            if (n%2 == 1) {
                result += "\n2 1";
                sum += pascal[2][1];
                level = n/2 +1;
                cnt++;
            }
            for (int i = 2 ; i < level ; i++) {
                result += String.format(("\n%d 1"),i);
                sum += pascal[i][1];
                cnt++;
            }
            result += String.format(("\n%d 2"),level);
            sum += pascal[level][2];
            System.out.println(String.format("cnt = %d , level = %d", cnt , level));
        }
        else if (n == 999) {
            for (int i = 1 ; i < 4 ; i++) {
                result += String.format(("\n%d 1"),i);
                sum += pascal[i][1];
                cnt++;
            }
            result += "\n4 2";
            sum += pascal[4][2];
            cnt++;
            for (int i = 4 ; i <= 498 ; i++) {
                result += String.format(("\n%d 1"),i);
                sum += pascal[i][1];
                cnt++;
            }
            result += "\n499 2";
            sum += pascal[499][2];
            cnt++;
        }
        else if (n == 1000) {
            for (int i = 1 ; i < 5 ; i++) {
                result += String.format(("\n%d 1"),i);
                sum += pascal[i][1];
                cnt++;
            }
            result += "\n5 2";
            sum += pascal[5][2];
            cnt++;
            for (int i = 5 ; i <= 498 ; i++) {
                result += String.format(("\n%d 1"),i);
                sum += pascal[i][1];
                cnt++;
            }
            result += "\n499 2";
            sum += pascal[499][2];
            cnt++;
        }
        System.out.println(String.format("cnt = %d , sum = %d , n = %d", cnt, sum, n));

//        System.out.println(String.format(output1, caseNum, result));
    }

}