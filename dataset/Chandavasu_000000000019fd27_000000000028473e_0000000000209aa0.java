import java.lang.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        int numOfTest = in.nextInt();
        
        for(int i = 0; i < numOfTest; i++) {
            
            int n = in.nextInt();
            int trace = in.nextInt();
            
            new Solution().createMatrix(i+1, n, trace);
        }
    }
    
    public void createMatrix(int test, int n, int trace) {
        
        ArrayList<Integer> vals = new ArrayList<Integer>();
        ArrayList<Integer> traces = new ArrayList<Integer>();
        
        boolean impossible = false;
        
        if(trace < n) {
           
           impossible = true;
        } else if(trace % n == 0) {
            
            int d = trace/n;
            for(int i = 0; i < n; i++) {
                traces.add(d);
            }
        } else {
            
            int sum = 0; 
  
            for (int i = 1; sum < trace; i++)  { 
                sum += i; 
                traces.add(i);
                if (sum == trace) { 
                    break; 
                }
            } 
            
            if(traces.size() < n) {
                int diff = n-traces.size();
                for(int i = diff ; i >= 0 ; i--) {
                    
                    int val = traces.remove(i);
                    traces.add(val/2);
                    traces.add(val/2);
                }
            } else if(traces.size() > n) {
                
                int diff = traces.size() - n;
                for(int i = 0 ; i <= n ; i+=2) {
                    
                    int val = traces.remove(i);
                    int val2 = traces.remove(i+1);
                    traces.add(val + val2);
                }
            }
            
        }
        
        StringBuilder strb = new StringBuilder();
        if(impossible) {
            
            strb.append("Case #" + test + ": IMPOSSIBLE\n"); 
            return;
        } else {
            strb.append("Case #" + test + ": POSSIBLE\n");
        
            for(int i = 1; i <= n; i++) {
                vals.add(i);
            }
                    
            int[][] matrix = new int[n][n];
            int dIndex = 0;
            
            for(int i = 0; i < n; i++) {
                int index = 0;
                int d = traces.get(dIndex);
                for(int j = 0; j < n; j++) {
                    
                    
                    if(i == j) {
                        
                        matrix[i][j] = d;
                        dIndex++;
                        
                    } else {
                        
                        int ip = vals.get(index);
                        if(ip == d) {
                            index++;
                            ip = vals.get(index);
                        }
                        matrix[i][j] = ip;
                        index++;
                    }
                    
                    strb.append(matrix[i][j] + " ");
                }
                
                //shifts by one digit
                int r = vals.remove(0);
                if((dIndex < traces.size()) && (r == traces.get(dIndex))) {
                    vals.add(r);
                    r = vals.remove(0);
                }
                vals.add(r);
                strb.append("\n");
            }
            
            for(int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for(int j = 0; j < n; j++) {
                    
                    set.add(matrix[j][i]);
                }
                
                if(set.size() != n) {
                    
                    strb.delete(0, strb.length());
                    strb.append("Case #" + test + ": IMPOSSIBLE");
                    break;
                }
            }
            
        }
        System.out.println(strb.toString());
    }
}