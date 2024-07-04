import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {



    static Scanner scanner;

    public static void main(String[] args)
    {
//        try {scanner = new Scanner(new File("list.in.txt"));} catch (FileNotFoundException e) {return;}
        scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; ++t)
        {
        		int sum = 0, row_duplicates = 0, coll_duplicates = 0;
        	
        		int n = scanner.nextInt();
        		int[][] row = new int[n+1][n+1];
        		int[][] coll = new int[n+1][n+1];
        		
        		boolean[] isRowB = new boolean[n+1];
        		boolean[] isCollB = new boolean[n+1];
        		
        		
        		
        		for (int i = 1; i <= n; i++){
        		
        			
        			for (int j = 1; j <= n; j++){
        				int k = scanner.nextInt();
        				       				
        				if(!isCollB[j]) {
            				if(coll[j][k] == 1) {
            					isCollB[j] = true;
            					coll_duplicates++;
            				}else {
            					coll[j][k] = 1;
            				}	
        				}

	       				
					if(!isRowB[i]) {
						if(row[i][k] == 1) {
							isRowB[i] = true;
							row_duplicates++;
						}else {
							row[i][k] = 1;
						}	
					}

     				
        				
        				if(i == j) {
        					sum+=k;
        				}
            		}	
        		}	
        	
        		System.out.printf("Case #" + t +": " + sum +" " + row_duplicates  + " " + coll_duplicates);
        }
    }

}
