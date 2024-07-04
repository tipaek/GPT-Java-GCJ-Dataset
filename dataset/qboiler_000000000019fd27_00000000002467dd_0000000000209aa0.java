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

        if (rank % size != 0) {
            System.out.println("Case #" + caseN + ": IMPOSSIBLE");
            return;
        }

        int diag = rank/size;
        int[][] result = new int[size][size];
        for(int i =0;i<size;++i){
            int startv = diag -i;
            if(startv<1){
                startv=size+startv;
            }
            for(int j=0;j<size;++j){
                result[i][j]=startv;
                startv=startv+1;
                if(startv>size){
                    startv=1;
                }
            }
        }

        System.out.println("Case #" + caseN + ": POSSIBLE");
        print(result);


    }

    public static void print(int[][] r){
        for(int i=0;i<r.length;++i){
            String line = "";
            for(int j=0;j<r.length;++j){
                line +=(r[i][j] + " ");
            }
            System.out.println(line.trim());
        }
    }

}
