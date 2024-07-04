package com.example.lib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Main {

    public static void main(String args[]) {
        try {
//            File file = new File("filename.txt");

           // Scanner sc = new Scanner(file);
             Scanner sc = new Scanner(System.in);
             while (sc.hasNextLine()) {
                int no_of_test_case = sc.nextInt();
                int testCase  = 1;
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
                    sb.append(vestigium(mat, N, N,testCase));
                    testCase ++;


                }
               System.out.println(sb.toString());
                //writeOutFile(sb.toString());

            }

        } catch (Exception e) {

        }


    }

    private  static String vestigium(int[][] mat, int row, int col, int TestCase) {
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

                    colohashMap.put(mat[i][j], colohashMap.get(mat[i][j]+1));
                    columflag = true;
                }
                else {
                    colohashMap.put(mat[i][j],0);

                }

                    hashSet.add(mat[j][i]);



               System.out.println(mat[j][i]);
            }
            if(columflag)
            {
                rowRepated ++;
            }
            if(hashSet.size()<row)
            {
                columrepeaded ++;
            }
            hashSet.clear();
            hashSet = new HashSet<>();
            colohashMap = new HashMap<>();
            diaglonal_index_coloum++;
            dialgonal_index_row = i + 1;
        }


        return  "Case #" + TestCase + ": " + sum +" "+rowRepated+" "+columrepeaded+"\n";


    }


    public static void writeOutFile(String str) {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(str);
            myWriter.close();
            System.out.println(str);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
