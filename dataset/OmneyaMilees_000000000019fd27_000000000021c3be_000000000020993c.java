import java.io.*;
import java.util.*;

public class Solution {
    
    @SuppressWarnings("unchecked")
    
	static String problemSolving(String[][] m) {
    	Set<?>[] columns = new HashSet<?>[m.length];
        for (int i = 0; i < columns.length; ++i)
        	columns[i] = new HashSet<String>();

        int repetedRows = 0;
        int repetedColumn = 0;
        int sum = 0;

        for (int i=0; i< m.length; i++) {
            sum += Integer.parseInt(m[i][i]);
            Set<String> row = new HashSet<String>();
            for(int j=0; j<m.length; j++) {
                row.add(m[i][j]);
                ((HashSet<String>)columns[j]).add(m[i][j]);
            }
            if (row.size() < m.length) {
                repetedRows += 1;
            }
        }

       for (int i=0; i< columns.length; i++) {
           if (columns[i].size() < m.length) {
               repetedColumn += 1;
           }
       }

        return sum + " " + repetedRows + " " + repetedColumn;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(scanner.nextLine().trim());
        for (int i=0; i <t; i++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            String[][] m = new String[n][n];
            for(int j=0; j< n; j++) {
                String[] row = scanner.nextLine().split(" ");
                m[j] = row;
            }
            String answer =  problemSolving(m);
            System.out.println("Case #"+ (i+1) + ": " +  answer);
        }
    }
}