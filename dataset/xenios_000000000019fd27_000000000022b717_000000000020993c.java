import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
/**
 * @author Steve Mwangi
 * 8:59:28 PM
 * 2020
 */
public class Solution{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for(int iii = 0; iii < t; iii++){
        	String oneRow = in.nextLine();
        	//System.out.println(" One Row1: " + oneRow);
            String[] temp = oneRow.split(" ");
            int x = iii+1;
            int r = 0;
            int c = 0;
            int n = Integer.parseInt(temp[0]);
            oneRow = in.nextLine();
            //System.out.println(" One Row2: " + oneRow);
            temp = oneRow.split(" ");
            int columns = temp.length;
            int[][] matrix = new int[n][columns];
            int trace = 0;
            HashSet[] rowss = new HashSet[n];
            for(int ri = 0; ri < n; ri++){
                rowss[ri] = new HashSet<Integer>();
            }
            HashSet[] columnss = new HashSet[columns];
            for(int ci = 0; ci < columns; ci++){
                columnss[ci] = new HashSet<Integer>();
            }
            for(int jj =0; jj < n; jj++){
                for(int kk =0; kk < columns; kk++){
//                	System.out.println("n: " + n);
//                	System.out.println("c: " + columns);
//                	System.out.println("Temp Length: " + temp.length + " Value: " + temp[j]);
                	matrix[jj][kk] = Integer.parseInt(temp[kk]);
                	//System.out.print(" " + matrix[jj][kk]);
                    rowss[jj].add(Integer.valueOf(matrix[jj][kk]));
                    columnss[kk].add(Integer.valueOf(matrix[jj][kk]));
                    if(jj - kk == 0){
                        trace += matrix[jj][kk];
//                        System.out.println("jj==kk: " + jj + " : " + kk);
//                        System.out.println("matrix[jj][kk]: " + matrix[jj][kk]);
                    }
                }
                //System.out.println();
                if(jj < n-1) {
                	oneRow = in.nextLine();
                    //System.out.println(" One Row3: " + oneRow);
                    temp = oneRow.split(" ");
                }
            }
            for(int ri = 0; ri < n; ri++){
                if(rowss[ri].size() < columns){
                    r++;
                }
            }
            for(int ci = 0; ci < columns; ci++){
                if(columnss[ci].size() < n){
                    c++;
                }
            }
//            int countR = 0;
//            for(HashSet<Integer> sss: rowss) {
//            	Iterator<Integer> rowsI = sss.iterator(); 
//            	System.out.println(" Rows: " + countR);
//                while (rowsI.hasNext()) 
//                    System.out.println(rowsI.next()); 
//                countR++;
//                System.out.println();
//            }
//            
//            int countC = 0;
//            for(HashSet<Integer> ccc: columnss) {
//            	Iterator<Integer> colsI = ccc.iterator(); 
//            	System.out.println(" Columns: " + countC);
//                while (colsI.hasNext()) 
//                    System.out.print(" " + colsI.next());
//                countC++;
//                System.out.println();
//            }
            System.out.println("Case #" + x + ": " + trace + " " + r + " " + c);
        }
    }
}