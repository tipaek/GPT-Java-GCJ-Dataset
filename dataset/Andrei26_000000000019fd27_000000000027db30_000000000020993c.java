
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

final class Solution {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       
     
        int cases = in.nextInt();
    
            
        
        int lines = 0;
        for (int i = 0; i < cases; i++) {
            boolean same = false;
            lines = in.nextInt();
            int[][] matrix = new int[lines][lines];
            int diagSum = 0;
            Set set = new HashSet<>();
            int nrRows = 0;
            for (int j = 0; j < lines; j++) {
                for (int j2 = 0; j2 < lines; j2++) {
                    matrix[j][j2] = in.nextInt();
                    if(j == j2){
                        diagSum+=matrix[j][j2];
                    }
                }    

               
                for (int j2 = 0; j2 < matrix[j].length; j2++) {
                    if(set.add(matrix[j][j2])== false){
                        same = true;
                    }
                }
                if(same){
                    nrRows++;
                }
                set.removeAll(set);
            }
            
           

            int nrCol =0;
            for (int j = 0; j < lines; j++) {
                same = false;
                for (int j2 = 0; j2 < lines; j2++) {
                    if(set.add(matrix[j2][j])== false){
                        same =true;
                    }
                }
                if(same){
                    nrCol++;
                }
                set.removeAll(set);
            }
            
            System.out.println("Case #" + (i+1)+ ": "+diagSum + " " + nrRows + " " + nrCol );
            set.removeAll(set);
        }
    }
    
}