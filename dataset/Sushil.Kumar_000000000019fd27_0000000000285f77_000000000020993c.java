package com.example.lib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


class Main {

    public static void main(String args[]) {
        try {

            StringBuffer sb = new StringBuffer();
//            new FileInputStream("filename.txt");
             try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
                int testCount = scanner.nextInt();
                for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                    int N = scanner.nextInt();
                    int[][] mat = new int[N][N];
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            mat[j][k] = scanner.nextInt();

                        }

                    }
                    sb.append(vestigium(mat, N, N,testNumber));
                }
                System.out.println(sb.toString());
                //writeOutFile(sb.toString());
            }


        } catch (Exception e) {

        }


    }

    public static void mainp(String[] args) {
        long beginTime = System.nanoTime();
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            StringBuffer sb = new StringBuffer();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                for (int i = 0; i < testCount; i++) {
                    int N = scanner.nextInt();
                    int[][] mat = new int[N][N];
                    int counter = 0;
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            mat[j][k] = scanner.nextInt();
                            counter++;
                        }

                    }
                    sb.append(vestigium(mat, N, N, testNumber));

                }}
            System.out.println(sb.toString());
        }catch (Exception e)
        {

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



//               System.out.println(mat[j][i]);
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



}
