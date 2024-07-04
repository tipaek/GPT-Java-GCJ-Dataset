import java.io.*;
import java.util.*;

class Solution{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int c = 1; c <= t; c++){
            int n = sc.nextInt();
            
            ArrayList<HashSet<Integer>> rowArray = new ArrayList<HashSet<Integer>>();
            ArrayList<HashSet<Integer>> colArray = new ArrayList<HashSet<Integer>>();
            
            
            for(int i = 0; i< n; i++){
                rowArray.add(new HashSet<Integer>());
                colArray.add(new HashSet<Integer>());
    
            }
            
            int trace = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int val = sc.nextInt();
                    if(i == j){
                        trace += val;
                    }
                    
                    rowArray.get(i).add(val);
                    colArray.get(j).add(val);
                }
                
            }
            int rc = 0;
            int cc = 0;
            int sum = (n*(n+1))/2;
            for(int i = 0; i < n; i++){
                if(rowArray.get(i).size() != n)
                    rc++;
                if(colArray.get(i).size() != n)
                    cc++;
            }
            
            System.out.printf("Case #%d: %d %d %d\n", c, trace, rc, cc );
            
        
        }
    }
}