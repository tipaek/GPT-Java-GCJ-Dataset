import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Random;

/**
 *
 * @author qboiler
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }
    }

    public static void main2(String args) throws IOException {

        BufferedReader reader = new BufferedReader(new StringReader(args));
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }
    }

    private static final Random r = new Random();
    public static void processCase(BufferedReader reader, int caseN) throws IOException {
        long start = System.currentTimeMillis();

        String[] sizeRank = reader.readLine().split(" ");
        int size = Integer.parseInt(sizeRank[0]);
        int rank = Integer.parseInt(sizeRank[1]);

        int[][] matrix = new int[size][size];
        for(int i=0;i<size;++i){
            int first = i+1;
            for(int j=0;j<size;++j){
                matrix[i][j] = (first+j)%(size)+1;
            }
        }
        long end = start + (long)(150*size);

        int cycles = 0;

        if(size==2){
            if(rank==2){
                System.out.println("Case #"+caseN+": POSSIBLE");
                System.out.println("1 2");
                System.out.println("2 1");
            }else if(rank==4){
                System.out.println("Case #"+caseN+": POSSIBLE");
                System.out.println("2 1");
                System.out.println("1 2");
            }else{
                System.out.println("Case #"+caseN+": IMPOSSIBLE");
            }
            return;
        }
        if(size==3){
            if(rank==3){
                System.out.println("Case #"+caseN+": POSSIBLE");
                System.out.println("1 2 3");
                System.out.println("3 1 2");
                System.out.println("2 3 1");
            }else if(rank==6){
                System.out.println("Case #"+caseN+": POSSIBLE");
                System.out.println("2 3 1");
                System.out.println("3 1 2");
                System.out.println("1 2 3");

            }else if(rank==9){
                System.out.println("Case #"+caseN+": POSSIBLE");
                System.out.println("3 1 2");
                System.out.println("2 3 2");
                System.out.println("1 2 3");

            }else{
                System.out.println("Case #"+caseN+": IMPOSSIBLE");
            }
            return;
        }

        while(System.currentTimeMillis()<end){
            ++cycles;
            int cRank = rValue(matrix, size);
            if( cRank == rank){
                System.out.println("Case #"+caseN+": POSSIBLE");
                print(matrix);
                return;
            }

            int row1 = r.nextInt(size);
            if(cRank>rank){
                row1=maxRowCol;
                // find largest value...
            }else{
                row1=minRowCol;
                // find smallest value...
            }
            int row2 = r.nextInt(size);
            switchRow(matrix, row1, row2);
            cRank = rValue(matrix, size);
            if(cRank == rank){
                System.out.println("Case #"+caseN+": POSSIBLE");
                print(matrix);
                return;
            }
            int col1 = r.nextInt(size);
            if(cRank>rank){
                col1=maxRowCol;
                // find largest value...
            }else{
                col1=minRowCol;
                // find smallest value...
            }
            int col2 = r.nextInt(size);
            switchCol(matrix, col1, col2);
        }
        System.out.println("Case #"+caseN+": IMPOSSIBLE");
    }

    public static void print(int[][] r){
        for(int i=0;i<r.length;++i){
            for(int j=0;j<r.length;++j){
                System.out.print(r[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void switchRow(int[][] r, int row1, int row2){
        for(int i=0;i<r.length;++i){
            int t = r[row1][i];
            r[row1][i] = r[row2][i];
            r[row2][i] = t;
        }
    }

    public static void switchCol(int[][] r, int row1, int row2){
        for(int i=0;i<r.length;++i){
            int t = r[i][row1];
            r[i][row1] = r[i][row2];
            r[i][row2] = t;
        }
    }

    static int maxRowCol =0;
    static int minRowCol = 0;
    public static int rValue(int[][] r, int size){
        int result =0;
        int min = size+1;
        int max =0;
        for(int i=0;i<size;++i){
            int v = r[i][i];
            result += v;
            if(v>max){
                maxRowCol=i;
                max=v;
            }
            if(v<min){
                minRowCol =i;
                min=v;
            }
        }
        return result;
    }



}
