import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tAsString = br.readLine();
        int t = Integer.parseInt(tAsString);
        int[] ns = new int[t];
        int[][][] matrices = new int[t][][];
        for(int i = 0; i < t; ++i) {
            String nAsString = br.readLine();
            int n = Integer.parseInt(nAsString);
            ns[i] = n;
            matrices[i] = new int[n][n];
            for(int j = 0; j < n; ++j) {
                String line = br.readLine();
                String[]elems = line.split(" ");
                for(int k = 0; k < n; k++) {
                    matrices[i][j][k] = Integer.parseInt(elems[k]);
                }
            }
        }
        
        for(int i = 0; i < t; ++i) {
            int[] result = testMatrix(matrices[i]);
            System.out.println("Case #"+ (i+1) +": "+traceMatrix(matrices[i])+" "+result[0]+" "+result[1]);
        }

    }
    
    public static int traceMatrix(int[][] matrix) {
        int size = matrix[0].length;
        int trace = 0;
        for(int i = 0; i < size; ++i) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    public static int[] testMatrix(int[][] matrix) {
        int size = matrix[0].length;
        int[] result = new int[2];
        int badLines = 0;
        int badColoumns = 0;
        for(int i = 0; i < size; ++i) {
            Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
            for(int j = 0; j < size; ++j) {
                Integer val = hashtable.get(matrix[i][j]);
                if(val == null) {
                    val = new Integer(0);
                }
                if(val == 1) {
                    ++badLines;
                    break;
                }
                ++val;
                hashtable.put(matrix[i][j], val);
            }
        }
  
        for(int i = 0; i < size; ++i) {
            Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
            for(int j = 0; j < size; ++j) {
                Integer val = hashtable.get(matrix[j][i]);
                if(val == null) {
                    val = new Integer(0);
                }
                if(val == 1) {
                    ++badColoumns;
                    break;
                }
                ++val;
                hashtable.put(matrix[j][i], val);
            }
        }
        result[0] = badLines;
        result[1] = badColoumns;
        return result;
    }

}
