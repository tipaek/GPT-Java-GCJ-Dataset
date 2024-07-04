    

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

    class Solution {
        
         
        public static void main(String[] args) {
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            String text = scanner.nextLine();
            int tests = Integer.parseInt(text);
            int N = 0;


            for(int i=1; i<=tests; i++) {
                text = scanner.nextLine();
                N = Integer.parseInt(text);
                int[][] inputMatrix = new int[N][N];
                for( int j =0; j< N; j++) {
                   text = scanner.nextLine();
                   String[] elems = text.split("[\\s]+");
                   for(int col=0; col < N ; col++) {
                       inputMatrix[j][col] = Integer.parseInt(elems[col]);
                   }
                }

                printrepeatedRowColumns(inputMatrix, N, i);

            }
        }

        private static void printrepeatedRowColumns(int[][] inputMatrix, int N, int caseNo) {
            int rows[] = new int[N];
            int cols[] = new int[N];
            int trace = 0;
            int rowCount =0, colCount =0;

            for(int i =0 ; i<N; i++) { //row

                rows = new int[N];
                for(int j=0; j<N; j++) { //column
                    if (i == j)
                        trace += inputMatrix[i][j];

                    rows[inputMatrix[i][j] -1] = inputMatrix[i][j];
                }

                for(int j=0; j<N; j++) {
                    if (rows[j] == 0) {
                       rowCount++;
                       break;
                    }
                }
            }

            for(int i=0; i< N ; i++) {
                cols = new int[N];
                for(int j=0; j<N; j++) {

                    cols[inputMatrix[j][i]-1] = inputMatrix[j][i];
                }

                for(int j=0; j<N; j++) {
                    if (cols[j] == 0) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #"+caseNo+": "+trace+" "+rowCount+" "+colCount);
        }
    
    }