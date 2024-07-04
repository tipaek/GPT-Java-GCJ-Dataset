//package Codejam.Year2020.Qualification;

import java.io.*;
import java.util.*;

public class Vestigium {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException   {

        boolean fileInOut = Vestigium.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Vestigium.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 1; i <= testCase; i++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int val = sc.nextInt();
                    mat[j][k] = val;
                }
            }
            new Vestigium().solution(i, mat, n);
        }

        if (fileInOut) {
            verify(Vestigium.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if (line1 == null || line2 == null) {

                areEqual = false;
                break;
            } else if (!line1.equals(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {

            System.out.println("All Test Cases Passed !");
        } else {

            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }

    public void solution(int x, int[][] mat, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        int r = 0;
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for (int row = 0; row < n; row++) {
            hashMap.clear();
            for (int col = 0; col < n; col++) {
                if (hashMap.getOrDefault(mat[row][col], false)) {
                  ++r;
                  break;
                }
                else {
                    hashMap.put(mat[row][col], true);
                }
            }
        }

        int c = 0;

        for (int col = 0; col < n; col++) {
            hashMap.clear();
            for (int row = 0; row < n; row++) {
                if (hashMap.getOrDefault(mat[row][col], false)) {
                    ++c;
                    break;
                }
                else {
                    hashMap.put(mat[row][col], true);
                }
            }
        }

        out.println("Case #" + x + ":" + " " + trace+ " " + r + " " + c);
    }
}
