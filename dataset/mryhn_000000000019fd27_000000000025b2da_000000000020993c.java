package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        TestFileReader reader = new TestFileReader();

        int numberOfTests = reader.numberOfTests;

        for(int x=0; x<numberOfTests; x++){
            int[][] data = reader.getTestSetByIndex(x);
            int n = data.length;
            int diagonalSum = 0;
            int repeatedRows=0;
            int repeatedCols=0;

            for(int i=0; i<n; i++){
                boolean isSimilarRow = false;
                for(int j=0; j<n; j++){
                    if(i==j)
                        diagonalSum += data[i][j];

                    for(int k=0; k<n && !isSimilarRow; k++){
                        if(j!= k && data[i][j] == data[i][k]){
                            repeatedRows++;
                            isSimilarRow = true;
                            break;
                        }
                    }
                }
            }

            for(int i=0; i<n; i++){
                boolean isSimilarCol = false;
                for(int j=0; j<n; j++){
                    for(int k=0; k<n && !isSimilarCol; k++){
                        if(j!= k && data[j][i] == data[k][i]){
                            repeatedCols++;
                            isSimilarCol = true;
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #"+(x+1)+" "+ diagonalSum +" "+ repeatedRows + " "+ repeatedCols);
        }
    }
}

class TestFileReader{
    private ArrayList<int[][]> arrays = null;
    public int numberOfTests = 0;

    public ArrayList<int[][]> read(){

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:/Users/reyha/IdeaProjects/testapp/src/com/company/test.txt"));
            String line = reader.readLine();
            numberOfTests = Integer.parseInt(line);
            arrays = new ArrayList<>();

            for(int i=0; i<numberOfTests; i++){
                int n = Integer.parseInt(reader.readLine());
                int[][] incomingArray = new int[n][n];

                for(int j=0; j<n; j++){
                    line = reader.readLine();
                     String[] temp = line.split(" ");
                     for(int k=0; k<n; k++){
                         incomingArray[j][k] = Integer.parseInt(temp[k]);
                     }
                }

                arrays.add(incomingArray);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrays;
    }

    public int[][] getTestSetByIndex(int index){
        return arrays.get(index);
    }

}



