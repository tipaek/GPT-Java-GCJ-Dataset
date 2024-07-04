import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author adarshbhattarai on 2020-04-04
 * @project untitled
 */
public class Solution {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        String[] output = new String[testcases];
        for(int i=0;i<testcases;i++){
            //System.out.println("Provide N");
            int N = sc.nextInt();
            int[][] M =  new int[N][N];
            for(int j=0;j<N;j++){
                M[j] =  readNextIntArray(sc,N);
            }
            output[i]="Case #"+(i+1)+": "+ solve(M);

        }

        for(String s : output)
            System.out.println(s);


    }

    private static String solve(int[][] m) {
        int[] krc = new int[3];
        for(int i=0;i<m.length;i++){

            boolean foundRowDup =false;
            boolean foundColDup = false;

            Set row = new HashSet();
            Set col = new HashSet();
            for(int j=0;j<m[0].length;j++){
                if(i==j){
                    krc[0]+=m[i][j];
                }
                if(!row.add(m[i][j]))
                    foundRowDup=true;
            }
            for(int k=0;k<m.length;k++){
                if(!col.add(m[k][i]))
                    foundColDup=true;
            }
            if(foundRowDup){
                krc[1]++;
            }
            if(foundColDup){
                krc[2]++;
            }
        }

        return krc[0]+ " "+krc[1]+" "+krc[2];
    }

    private static int[] readNextIntArray(Scanner sc, int N) {
        int[] read = new int[N+1];
        for(int i=0;i<N;i++){
            String s = sc.next();
            read[i] = Integer.parseInt(s);
        }
        return read;
    }
}
