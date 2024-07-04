import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int tcases = sin.nextInt();
        for ( int k = 0;k < tcases; k++){
            int sizen = sin.nextInt();
            int rowcount = 0;
            int colcount = 0;
            int trace = 0;
            int[][] mat = new int[sizen][sizen];
            for (int i = 0; i < sizen ; i++) {
                ArrayList<Integer> rowbuf = new ArrayList();
                for(int j = 0; j < sizen; j++){
                    mat[i][j] = sin.nextInt();
                    rowbuf.add(mat[i][j]);
                }
                List<Integer> rowdist = rowbuf.stream().distinct().collect(Collectors.toList());
                if(rowbuf.size() - rowdist.size() != 0)
                    rowcount++;
                rowbuf.clear();
                rowdist.clear();
            }
            for(int i = 0; i < sizen; i++){
                ArrayList<Integer> colbuf = new ArrayList();
                for(int j =0; j < sizen; j++)
                    colbuf.add(mat[j][i]);
                List<Integer> coldist = colbuf.stream().distinct().collect(Collectors.toList());
                if(colbuf.size() - coldist.size() != 0)
                    colcount++;
                colbuf.clear();
                coldist.clear();
            }
            for(int i = 0; i < sizen; i++)
                trace+=mat[i][i];
            System.out.println("Case #"+(k+1)+": "+trace+" "+rowcount+" "+colcount);
        }

    }
}
