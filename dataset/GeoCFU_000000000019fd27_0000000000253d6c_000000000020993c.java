import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(System.in);
        Integer T = s.nextInt();
        for(Integer t = 0 ; t < T ;t++){
            Integer sum = 0;
            Integer n = s.nextInt();
            Integer rowsDuplicate = 0;
            Integer columnsDuplicate = 0;
            boolean[] columnDuplicate = new boolean[n];
            Set<Integer>[] columnSet = new HashSet[n];
            for(Integer i = 0; i < n; i++){
                Boolean rowDuplicate = false;
                Set<Integer> rowSet = new HashSet<Integer>();
                for(Integer j = 0; j < n; j++){

                    Integer val = s.nextInt();
                    if(i == j){
                        sum += val;
                    }
                    Boolean rowAdded = rowSet.add(val);
                    if(!rowAdded && !rowDuplicate){
                        rowsDuplicate++;
                        rowDuplicate = true;
                    }

                    columnSet[j] = columnSet[j] == null? new HashSet<Integer>() : columnSet[j];
                    Boolean columnAdded = columnSet[j].add(val);
                    if(!columnAdded && !columnDuplicate[j]){
                        columnsDuplicate++;
                        columnDuplicate[j] = true;
                    }
                }
                
            }
            System.out.println("Case #" + (t+1) + ": " + sum + ' ' + rowsDuplicate + ' ' + columnsDuplicate);
        }

    }
}