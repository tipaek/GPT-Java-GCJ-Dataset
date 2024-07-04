
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static void main(String args[]) {
        try {
//            File file = new File("filename.txt");

            Scanner sc = new Scanner(System.in);
            StringBuffer stringBuffer = new StringBuffer();

            while (sc.hasNextLine()) {
                int no_of_test_case = sc.nextInt();
                 StringBuffer sb = new StringBuffer();
                for (int i = 0; i < no_of_test_case; i++) {

                    int N = sc.nextInt();
                    int M = sc.nextInt();
                    rows = new ArrayList<>();
                    matrix = new StringBuffer();
                    flag = false;
                     if(generateMatrix(N,M))
                     {
                         String f =  "Case #" + (i+1) + ": POSSIBLE" +"\n"+matrix;
                         sb.append(f);
                     }else
                     {
                         String f =  "Case #" + (i+1) + ": IMPOSSIBLE" +"\n";
//                         System.out.print(f);
                         sb.append(f);
                     }

                }
                  System.out.println(sb.toString());
                  System.exit(0);
//                  writeOutFile(sb.toString());

            }

        } catch (Exception e) {

        }


    }

    static int counter = 0;
    static ArrayList<String> rows = new ArrayList<>();

    public static boolean flag =false;
    static void findPermutations(int str[], int index, int n,boolean isCalculated,int K) {
        if (index >= n) {
            StringBuffer sb = new StringBuffer();
            for (int k = 0; k < str.length; k++) {
                sb.append(str[k]);
            }
            rows.add(sb.toString());
            if(rows.size()>=n) {
                //System.out.println(rows);
                String res = String.join(" ", rows);
                //System.out.println(res);
                List<String> permutes = PermuteWords(res, n);
                for (int i = 0; i < permutes.size(); i++) {
                    String integerStrings = permutes.get(i).replace(" ", "");
                     int[] digits = new int[integerStrings.length()];
                      for(int k=0; k<integerStrings.length(); k++){
                        digits[k] = Character.getNumericValue(integerStrings.charAt(k));
                      }
                       int[][] twoDArray = monoToBidi(digits, n, n);
                       if (calculatePossiblity(twoDArray, n, n, K,integerStrings) == true) {
                           flag = true;
                           isCalculated = true;
                           break;

                       }

                }

            }
        }

        if(flag!=true) {
            for (int i = index; i < n; i++) {
                boolean check = shouldSwap(str, index, i);
                if (check) {
                    swap(str, index, i);
                    findPermutations(str, index + 1, n, isCalculated, K);
                    swap(str, index, i);
                }
            }
        }

    }

    static boolean shouldSwap(int str[], int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (str[i] == str[curr]) {
                return false;
            }
        }
        return true;
    }

    static void swap(int[] str, int i, int j) {
        int c = str[i];
        str[i] = str[j];
        str[j] = c;
    }


    public static StringBuffer matrix = new StringBuffer();
    public  static boolean generateMatrix(int N, int K) {

        if(K<N)
        {
            flag = false;
            return  flag;
        }

        boolean isCaculated = false;
        int str[] = new int[N];
        for (int i = 1; i <= N; i++) {
            str[i - 1] = i;
        }
         findPermutations(str, 0, N,isCaculated,K);
        return  flag;

    }

    private static boolean calculatePossiblity(int[][] mat, int row, int col, int K,String itegerStirng) {
        int diagonaleftSum = 0;
        matrix = new StringBuffer();
        int diagonarightSum = 0;
        int dialgonal_index_row = 0;
        int diaglonal_index_coloum = 0;
        int rowRepated = 0;
        int columrepeaded = 0;
        HashMap<Integer, Integer> colohashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            boolean columflag = false;
            boolean rowFlag = false;
            for (int j = 0; j < col; j++) {
                if (i == dialgonal_index_row && j == diaglonal_index_coloum) //this condition checks for diagonal
                {
                    diagonaleftSum = diagonaleftSum + mat[i][j];

                }
                if ((i + j) == (row - 1)) {
                    diagonarightSum = diagonarightSum + mat[i][j];
                }
                if (colohashMap.containsKey(mat[i][j])) {

                    colohashMap.put(mat[i][j], colohashMap.get(mat[i][j] + 1));
                    columflag = true;
                } else {
                    colohashMap.put(mat[i][j], 0);

                }

                hashSet.add(mat[j][i]);
               if(j==(col-1)) {
                   matrix.append(mat[i][j]);
               }else
               {
                   matrix.append(mat[i][j] + " ");
               }


            }
            if (columflag) {
                rowRepated++;
            }
            if (hashSet.size() < row) {
                columrepeaded++;
            }
            if(i<(row)) {
                matrix.append("\n");
            }
            hashSet.clear();
            hashSet = new HashSet<>();
            colohashMap = new HashMap<>();
            diaglonal_index_coloum++;
            dialgonal_index_row = i + 1;
        }


        if (K == diagonaleftSum && diagonaleftSum == diagonarightSum && rowRepated==0 && columrepeaded==0) {
            return true;
        }
        return false;
//        return


    }

    public static int[][] monoToBidi(final int[] array, final int rows, final int cols) {
        if (array.length != (rows * cols))
            throw new IllegalArgumentException("Invalid array length");

        int[][] bidi = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            System.arraycopy(array, (i * cols), bidi[i], 0, cols);

        return bidi;
    }

    public static List<String> PermuteWords(String s, int Max) {
        String[] ss = s.split(" ");
        boolean[] used = new boolean[ss.length];
        String res = "";
        ArrayList<String> list = new ArrayList<>();
        permute(ss, used, res, 0, list, Max);
        return list;
    }

    private static void permute(String[] ss, boolean[] used, String res, int level, List<String> list, int max) {
        if (level == max && res != "") {
            list.add(res);
            return;
        }
        for (int i = 0; i < ss.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            permute(ss, used, res + " " + ss[i], level + 1, list, max);
            used[i] = false;
        }
    }

    public static void maink(String args[]) {
        try {
            File file = new File("filename.txt");

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                int no_of_test_case = sc.nextInt();
                int testCase = 1;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < no_of_test_case; i++) {
                    int N = sc.nextInt();
                    int[][] mat = new int[N][N];
                    int counter = 0;
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            mat[j][k] = sc.nextInt();
                            counter++;
                        }

                    }
                    sb.append(vestigium(mat, N, N, testCase));
                    testCase++;


                }
                writeOutFile(sb.toString());

            }

        } catch (Exception e) {

        }


    }

    private static String vestigium(int[][] mat, int row, int col, int TestCase) {
        int sum = 0;
        int dialgonal_index_row = 0;
        int diaglonal_index_coloum = 0;
        int rowRepated = 0;
        int columrepeaded = 0;
        HashMap<Integer, Integer> colohashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            boolean columflag = false;
            boolean rowFlag = false;
            for (int j = 0; j < col; j++) {
                if (i == dialgonal_index_row && j == diaglonal_index_coloum) //this condition checks for diagonal
                {
                    sum = sum + mat[i][j];

                }
                if (colohashMap.containsKey(mat[i][j])) {

                    colohashMap.put(mat[i][j], colohashMap.get(mat[i][j] + 1));
                    columflag = true;
                } else {
                    colohashMap.put(mat[i][j], 0);

                }

                hashSet.add(mat[j][i]);


               // System.out.println(mat[j][i]);
            }
            if (columflag) {
                rowRepated++;
            }
            if (hashSet.size() < row) {
                columrepeaded++;
            }
            hashSet.clear();
            hashSet = new HashSet<>();
            colohashMap = new HashMap<>();
            diaglonal_index_coloum++;
            dialgonal_index_row = i + 1;
        }


        return "Case #" + TestCase + ": " + sum + " " + rowRepated + " " + columrepeaded + "\n";


    }


    public static void writeOutFile(String str) {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(str);
            myWriter.close();
            ///System.out.println(str);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
