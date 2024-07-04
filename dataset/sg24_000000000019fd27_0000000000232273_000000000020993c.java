import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<BigInteger[]> l = new ArrayList<>();
        
        for(int testIndex = 0 ;testIndex < testCount ; testIndex++){
            int rowCount = in.nextInt();
            
            List<Set<Integer>> table = new ArrayList<>();
            List<Set<Integer>> table1 = new ArrayList<>();
            int trace =  0;
            for(int rowIndex = 0 ; rowIndex < rowCount ; rowIndex++){
                table.add(new HashSet<>());
                for(int columnIndex = 0 ; columnIndex < rowCount ;columnIndex++){
                    int n =     in.nextInt();
                    if(rowIndex == 0){
                        table1.add(new HashSet<>());
                    }
                    if(rowIndex == columnIndex){
                        trace = trace + (n);
                    }
                    table.get(rowIndex).add(n);
                    table1.get(columnIndex).add(n);
                }
                
            }
            int r = 0;
            for(Set<Integer> set : table){
                if(set.size() < rowCount){
                    r++;
                }
            }
            int c = 0;
            for(Set<Integer> set : table1){
                if(set.size() < rowCount){
                    c++;
                }
            }
            System.out.println("Case #"+(testIndex+1)+": "+trace+" "+r+" "+c);
        }
        
        
        /*  
        for(int i =0 ; i<l.size();i++){
            System.out.println("Case #"+(i+1)+": "+l.get(i)[0]+" "+l.get(i)[1]);
        }*/
        
        
        
    }
    
}
