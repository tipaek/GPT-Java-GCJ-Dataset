import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numOfText = in.nextInt();

        for(int i = 0; i<numOfText; i++){

            int size = in.nextInt();

            int [][] matrix = new int [size][size];


            //filled matrix
            for(int r = 0; r< size; r++){

                for(int c = 0; c<size;c++){
                    Integer num = in.nextInt();
                    matrix[r][c] = num;

                }
            }


            //diagonal sum
            int diaagonalSum = 0;
            for(int di = 0;di<size;di++){

                diaagonalSum += matrix[di][di];

            }

            int numOfFaultyColumn = 0;
            int numOfFaultyRow = 0;
            //check repeated elements
            for(int num=0;num<size;num++){


                //check column
                Set<Integer> columnSet = new HashSet<>();
                for(int r1 = 0; r1< size; r1++){

                    if(!columnSet.add(matrix[num][r1])){
                        numOfFaultyRow ++;
                        break;
                    }

                }

                //check row
                Set<Integer> rowSet = new HashSet<>();
                for(int c1 = 0; c1< size; c1++){

                    if(!rowSet.add(matrix[c1][num])){
                        numOfFaultyColumn ++;
                        break;
                    }

                }



            }

            System.out.println("Case #"+(i+1)+": "+diaagonalSum+" "+numOfFaultyRow+" "+numOfFaultyColumn);


        }




    }
}
