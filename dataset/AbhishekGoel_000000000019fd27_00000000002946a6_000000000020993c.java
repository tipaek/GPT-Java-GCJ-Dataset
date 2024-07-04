import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
    class Simple{  
        public static void main(String args[]){  
           try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int testcasecount = Integer.parseInt(line);
        HashMap<String, String> map = new HashMap<>();
        for (int i = 1; i <= testcasecount; i++) {
            line = br.readLine();
            int matrixsize = Integer.parseInt(line);
            int r = 0;
            int c = 0;
            int k = 0;
            int[][] matrix = new int[matrixsize][matrixsize];
            for (int j = 0; j < matrixsize; j++) {
                line = br.readLine();
                String[] elements = line.split(" ");
                for (int ii = 0; ii < elements.length; ii++) {
                    matrix[j][ii] = Integer.parseInt(elements[ii]);
                }

            }
            for (int j = 0; j < matrixsize; j++) {
                boolean rowtest = true;
                boolean coltest = true;
                for (int jj = 0; jj < matrixsize; jj++) {
                    for (int jjj = jj+1; jjj < matrixsize; jjj++) {
                        if (matrix[j][jj] == matrix[j][jjj]) {
                            rowtest = false;
//                            System.out.println(matrix[jj].toString());
//                            System.out.println("row fail "+matrix[j][jj] +"  and "+matrix[j][jjj]);
                            break;
                        }
                    }
                }
                for (int jj = 0; jj <= matrixsize; jj++) {
                    for (int jjj = jj+1; jjj < matrixsize; jjj++) {
                        if (matrix[jj][j] == matrix[jjj][j]) {
                            coltest = false;
                        }
                    }
                }
                if (!coltest) {
                    c++;

                }
                if (!rowtest) {
//                    System.out.println("row failtst");
                    r++;

                }
                k = k + matrix[j][j];
            }
            System.out.println("Case #"+i+": "+k+" "+r+" "+c+"");

        }}
        catch(Exception e){
            
        }

        }  
    }  