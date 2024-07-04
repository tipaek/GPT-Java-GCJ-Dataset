import java.util.*;
import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int caseNo = 1;
        while(t-->0){
            int n = in.nextInt();
            int row = 0, col = 0, sum = 0;
            Map<Integer, HashSet<Integer>> cSet = new HashMap<Integer, HashSet<Integer>>(n);
            
            
            for(int i=0; i<n; i++){
                Set<Integer> rSet = new HashSet<Integer>(n);
                for(int j=0; j<n; j++){
                    int num = in.nextInt();
                    if(i== j){
                        sum +=num;
                    }
                    rSet.add(num);
                    cSet.getOrDefault(i, new HashSet<Integer>()).add(num);
                }
                if(rSet.size() != n){
                    row++;
                }                
            }
            for (Map.Entry<Integer, HashSet<Integer>> entry : cSet.entrySet()){
                if(entry.getValue().size() != n){
                    col++;
                }
            }
            System.out.println("Case #" + caseNo++ + ": " + (sum) + " " + (row) + " " + (col));
            
        }
        
      }
    }