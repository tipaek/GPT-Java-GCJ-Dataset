import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer; 
  
class Solution 
{ 
    public static void main(String[] args) throws IOException
    { 
  
        Scanner in = new Scanner(new BufferedReader( 
                              new InputStreamReader(System.in))); 
  
        int testCases = Integer.parseInt(in.nextLine());
        
        int[][] resArray = new int[testCases][3];

        for(int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(in.nextLine());
            ArrayList<HashSet<Integer>> myList = new ArrayList<HashSet<Integer>>();

            for(int j = 0; j < n; j++) {
                String res = in.nextLine();
                //System.out.println(res);
                HashSet<Integer> row_set = new HashSet<Integer>();
                
                StringTokenizer st = new StringTokenizer(res);
                for(int k = 0; k < n; k++) {

                    int val = Integer.parseInt(st.nextToken());
                    row_set.add(val);
                    
                    if(j == k) {
                        resArray[i][0] += val;
                    }
                    
                    //Initializing col_set for all columns in first row
                    if(j == 0) {
                        HashSet<Integer> col_set = new HashSet<Integer>();
                        myList.add(col_set);
                    }

                    myList.get(k).add(val);

                    
                }

                if(row_set.size() != n) {
                    resArray[i][1] += 1;
                }

                //System.out.println(myList);
            }

            for (Set s : myList) {
                if (s.size() != n) {
                    resArray[i][2] += 1;
                }
            }
        }
        
         
        for (int i = 0; i < resArray.length; i++) {
            System.out.printf("Case No #%d: %d %d %d\n", i+1, resArray[i][0], resArray[i][1], resArray[i][2]); 
        }
        
    } 
} 