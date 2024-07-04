
import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int totalCase = sc.nextInt();
            if (totalCase >= 1 && totalCase <= 100) {
                Matrix m[] = new Matrix[totalCase];
                for (int k = 0; k < totalCase; k++) {

                    m[k] = new Matrix();
                    m[k].N = sc.nextInt();
                    if (m[k].N >= 2 && m[k].N <= 100) {
                        m[k].matrix = new int[m[k].N][m[k].N];
                        m[k].traceOfMatrix = 0;

                        for (int i = 0; i < m[k].N; i++) {
                            for (int j = 0; j < m[k].N; j++) {
                                m[k].matrix[i][j] = sc.nextInt();
                                if (i == j) {
                                    m[k].traceOfMatrix = m[k].traceOfMatrix + m[k].matrix[i][j];
                                }
                            }
                        }

                        m[k].rows = new int[m[k].N];
                        m[k].duplicateRows = 0;
                        m[k].columns = new int[m[k].N];
                        m[k].duplicateColumns = 0;

                        for (int i = 0; i < m[k].N; i++) {
                            m[k].rows[i] = 0;
                            m[k].columns[i] = 0;
                        }

                        for (int i = 0; i < m[k].N; i++) {
                            for (int j = 0; j < m[k].N; j++) {
                                int num = m[k].matrix[i][j];
                                for (int l = j + 1; l < m[k].N; l++) {
                                    if (num == m[k].matrix[i][l]) {
                                        //Check Duplicate Values in Rows
                                        m[k].rows[i] = 1;
                                        break;
                                    }
                                }
                            }
                        }

                        for (int i = 0; i < m[k].N; i++) {
                            if (m[k].rows[i] == 1) {
                                m[k].duplicateRows++;
                            }
                        }

                        for (int i = 0; i < m[k].N; i++) {
                            for (int j = 0; j < m[k].N; j++) {
                                int num = m[k].matrix[j][i];
                                for (int l = j + 1; l < m[k].N; l++) {
                                    if (num == m[k].matrix[l][i]) {
                                        //Check Duplicate Values in Columns
                                        m[k].columns[i] = 1;
                                        break;
                                    }
                                }
                            }
                        }

                        for (int i = 0; i < m[k].N; i++) {
                            if (m[k].columns[i] == 1) {
                                m[k].duplicateColumns++;
                            }
                        }
                    }
                }
                for (int k = 0; k < totalCase; k++) {
                    System.out.print("Case #:" + (k + 1) + " " + (m[k].traceOfMatrix) + " " + (m[k].duplicateRows) + " " + (m[k].duplicateColumns));
                    if(k!=totalCase)
                        System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Matrix {

    int N;
    int matrix[][];
    int traceOfMatrix;
    int rows[];
    int duplicateRows;
    int columns[];
    int duplicateColumns;

}
