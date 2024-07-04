import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = new Integer(in.nextLine()).intValue();
    for (int i = 1; i <= t; i++) {
        int n = new Integer(in.nextLine()).intValue();
        int trace = 0;
        
        int all[][] = new int[n][n];
        int check[] = new int[n];
        int countRowRepeat = 0;
        int countColRepeat = 0;
        
        for (int j = 0; j < n; j++) {
            String temp1 = in.nextLine();
            String[] temp2 = temp1.split(" ");
            boolean rowRepeat = false;
            for (int k = 0; k < temp2.length; k++)  {
                int x = new Integer(temp2[k]).intValue();
                if (j == k)  {
                    trace += x;
                }
                check[x - 1] += 1;
                if (check[x - 1] > 1)  {
                	rowRepeat = true;
                }
                all[k][j] = x;
            }
            if (rowRepeat)  {
            	countRowRepeat++;
            }
            for (int z = 0; z < n; z++)  {
            	check[z] = 0;
            }
        }
        
        for (int w = 0; w < n; w++) {
        	boolean colRepeat = false;
        	for (int y = 0; y < n; y++)  {
        		check[all[w][y] - 1] += 1;
                if (check[all[w][y] - 1] > 1)  {
                	colRepeat = true;
                }
        	}
            if (colRepeat)  {
            	countColRepeat++;
            }
            for (int z = 0; z < n; z++)  {
            	check[z] = 0;
            }
        }
        System.out.println("Case #" + i + ": " + trace + " " + countRowRepeat + " " + countColRepeat);
    }
    in.close();
  }
}