import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();
        int matrixSize;

        for(int i=0;i<total;i++){
            matrixSize = in.nextInt();in.nextLine();
            int matrix [][] = new int[matrixSize][matrixSize];
            String line[]=new String[matrixSize];

            // getting data in string

            for(int j=0;j<matrixSize;j++){
                line[j]=in.nextLine();
            }

            // string data in matrix

            for(int j=0;j<matrixSize;j++){
                String[] temp = line[j].split(" ");
                for(int k=0;k<matrixSize;k++){
                    matrix[j][k] = Integer.parseInt(temp[k]);
                }
            }

            int trace=0;
            // finding trace of the matrix
            for(int j=0;j<matrixSize;j++){
                trace += matrix[j][j];
            }

            //finding rows containing repeated elements

            int rowCount=0,flag=0;
            for(int j=0;j<matrixSize;j++) {
                for (int k = 0; k < matrixSize; k++) {
                    int a = matrix[j][k];
                    for (int l = 0; l < matrixSize; l++) {
                        if ( k!=l && a == matrix[j][l]) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag != 0) {rowCount++;flag=0;break;}
                }
            }

            //finding cloumns containing repeated elements
            int colCount=0;flag=0;
            for(int j=0;j<matrixSize;j++){
                for(int k=0;k<matrixSize;k++){
                    int a=matrix[k][i];
                    for(int l=0;l<matrixSize;l++){
                        if(k!=l && a==matrix[l][k]){
                            flag=1;
                            break;
                        }
                    }
                    if(flag!=0){colCount++;flag=0;break;}
                }
            }

            System.out.println("Case #" + i + ": " + total + " " + rowCount + " " + colCount);
            //System.out.println("Case #"+i+":"+" ");

        }


    }
}
