package Main;

import java.io.*;

import java.util.LinkedHashSet;

import java.util.Set;

class ArUIdiot {
    static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException,  NullPointerException, ArrayIndexOutOfBoundsException {

        int trace=0;
        int text = Integer.parseInt(reader.readLine());
        for(int koll=0; koll<text;koll++){
            int matrixsize = Integer.parseInt(reader.readLine());
            int sqsize = matrixsize * matrixsize;
            int[][] matrix = new int[matrixsize][matrixsize];
            String[] chast ;
            int incr=0;
            int totalstrings=+matrixsize;

            while (incr!=matrixsize){
                    chast = reader.readLine().split(" ");
                    for (int j = 0; j < matrixsize; j++) {
                        matrix[incr][j] = Integer.parseInt(chast[j]);
                        if (j == incr)
                            trace = trace + matrix[incr][incr];
                    }
                    incr++;
                            }


            Set<Integer> brows=new LinkedHashSet<>();
            Set<Integer> bcol=new LinkedHashSet<>();
            boolean[][] foundInRow = new boolean[matrixsize][matrixsize];
            boolean[][] foundInCol = new boolean[matrixsize][matrixsize];
            for (int row = 0; row < matrixsize; row++) {
                for (int col = 0; col < matrixsize; col++) {
                    int idx = matrix[row][col] - 1;
                    if (foundInRow[row][idx] )
                        brows.add(row);
                    if (foundInCol[col][idx])
                        bcol.add(col);
                    foundInRow[row][idx] = foundInCol[col][idx] = true;
                }
            }
            System.out.println();
            System.out.println("Case #"+(koll+1)+ " "+ trace+" "+ brows.size()+" "+bcol.size());
            bcol.clear();
            brows.clear();
            trace=0;

        }
    }
}

