

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        List<String> results = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int numberOfCases = in.nextInt();

        for (int i = 0; i < numberOfCases; i++) {

            int x=i+1,k=0,r=0,c=0;
            int matrixSize = in.nextInt();
            int matrix[][] = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col]=in.nextInt();
                    if(row==col){
                        k+=matrix[row][col];
                    }
                }
            }
            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> presentValue = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if(presentValue.contains(matrix[row][col])){
                        r++;
                        break;
                    }else{
                        presentValue.add(matrix[row][col]);
                    }
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> presentValue = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if(presentValue.contains(matrix[row][col])){
                        c++;
                        break;
                    }else{
                        presentValue.add(matrix[row][col]);
                    }
                }


            }
            results.add(outputFormatter(x,k,r,c));

        }
        for(String r: results){
            System.out.println(r);
        }
    }

    public static String outputFormatter(int x,int k,int r,int c){
        return "#"+x+": "+k+" "+" "+r+" "+c+" \n";
    }

}


