

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


    public static void processCase(BufferedReader reader, int caseN) throws IOException {

        int rows = Integer.parseInt(reader.readLine());
        int[][] columnwise = new int[rows + 1][rows + 1];
        boolean[] colwise = new boolean[rows];
        int rowsWithDups =0;
        int trace =0;
        for(int i =0; i< rows; ++i) {
            String[] nr = reader.readLine().split(" ");
            int[] records = new int[rows + 1];
            boolean foundDup = false;
            for(int j=0;j<nr.length;++j){
                int record = Integer.parseInt(nr[j]);
                if(records[record] !=0){
                    foundDup = true;
                }
                records[record]+=1;
                columnwise[i][j]=record;
                if(i==j){
                    trace += record;
                }
            }
            if(foundDup){
                rowsWithDups++;
            }
        }

        int columsWithDups = 0;
        for(int i=0;i<rows;++i){
            int[] records = new int[rows + 1];
            boolean foundDup = false;
            for(int j=0;j<rows;++j){

                if(records[columnwise[j][i]]!=0){
                    foundDup= true;
                }
                records[columnwise[j][i]]+=1;

            }
            if(foundDup) {
                ++columsWithDups;
            }

        }

        System.out.println("Case #"+caseN+": "+trace+" "+rowsWithDups+" "+columsWithDups);
    }
}
