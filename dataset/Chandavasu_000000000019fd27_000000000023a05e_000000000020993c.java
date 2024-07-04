import java.lang.*;
import java.util.*;
public class Solution{

     public static void main(String []args){
        Scanner in = new Scanner(System.in);
        
        int noOfTest = in.nextInt();
        
        for(int n = 0; n < noOfTest; n++) {
            int m = in.nextInt();
            
            
            int diagonal = 0;
            int row = 0;
            int col = 0;
            
            List<HashSet<Integer>> uniqueColVal = new ArrayList<HashSet<Integer>>();
            for(int i = 0; i < m; i++) {
                
                HashSet<Integer> uniqueRowVal = new HashSet<Integer>();
                for(int j = 0; j < m; j++) {
                    
                    int val = in.nextInt();
                    
                    
                    uniqueRowVal.add(val);
                    
                    if(uniqueColVal.size() < (j+1)) {
                        HashSet<Integer> colHashSet = new HashSet<Integer>();
                        uniqueColVal.add(colHashSet);
                    }
                    uniqueColVal.get(j).add(val);
                    
                    if(i == j) {
                        diagonal = diagonal + val;
                    }
                }
                
                if(uniqueRowVal.size() < m) {
                    
                    row++;
                }
            }
            
            for(int i = 0; i < uniqueColVal.size(); i++) {
                
                if(uniqueColVal.get(i).size() < m) {
                    col++;
                }
            }
            System.out.println("Case #" + (n+1) + ": " + diagonal + " " + row + " " + col);
        }
     }
}