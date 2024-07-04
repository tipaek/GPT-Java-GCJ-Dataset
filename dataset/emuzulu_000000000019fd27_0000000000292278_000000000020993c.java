import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution
{
	public static void main(String[] args)throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
    for(int k = 0; k < tests; k++){
		    int col = in.nextInt();
		    int table[][] = new int[col][col];
		    for(int i = 0; i < col; i++){
		        for(int j = 0; j < col; j++){
		            table[i][j] = in.nextInt(); 
		        }
		    }
        int trace = 0;
        int r = 0;
        int c = 0;

        // Calculating the trace
        for(int t = 0; t < col; t++){
          trace += table[t][t];
        }

        //Rows
        for (int rw = 0; rw < col; rw++){
          int row[] = table[rw];
          Set<Integer> rowset = new HashSet<Integer>(); 
          for(int elem = 0; elem < col; elem++){
            rowset.add(row[elem]);
          }
          if (col != rowset.size()){
            r++;
          }
        }
        //Columms
        for (int cl = 0; cl < col; cl++){
          int column[] = getColumn(table, cl);
          Set<Integer> colset = new HashSet<Integer>();
          for(int ele = 0; ele < col; ele++){
            colset.add(column[ele]);
          }
          if (col != colset.size()){
            c++;
          }
        }



      System.out.printf("Case #%d: %d %d %d%n", k+1, trace, r, c);
		}
	}

  public static int[] getColumn(int[][] array, int index){
    int column[] = new int[array[0].length];
    for(int i=0; i<column.length; i++){
       column[i] = array[i][index];
    }
    return column;
}
}