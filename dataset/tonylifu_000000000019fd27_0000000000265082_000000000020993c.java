package condej;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedHashSet;

/**
 *
 * @author Lifu
 */
public class CodeJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        if(testCases < 1 || testCases > 100)
            return;
        
        List<int[][]> list = new ArrayList<>();
        
        for(int tc = 1; tc <= testCases; tc++){
            Scanner scan2 = new Scanner(System.in);
            int arraySize = scan2.nextInt();
            if(arraySize < 2 || arraySize > 100)
                return;
            
            int[][] array = new int[arraySize][arraySize];
            
            for(int ar = 0; ar < arraySize; ar++){
                
                Scanner scan3 = new Scanner(System.in);
                String input = scan3.nextLine();
                
                String[] split = input.split(" ");
                
                for(int sp = 0; sp < split.length; sp++){
                    int num = Integer.valueOf(split[sp]);
                    if(num < 1 || num > arraySize)
                        return;
                    array[ar][sp] = num;
                }
                
            }
            
            list.add(array);
        }
        
        /*for (int ar[][] : list){
            for(int i = 0; i < ar.length; i++){
                for(int j = 0; j < ar.length; j++){
                    System.out.print(ar[i][j]);
                }
                System.out.println();
            }
        }*/
        
        for(int test = 0; test < testCases; test++){
            int[][] ar = list.get(test);
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            
            for(int i = 0; i < ar.length; i++){
                HashSet<Integer> row = new LinkedHashSet<>();
                HashSet<Integer> col = new LinkedHashSet<>();
                for(int j = 0; j < ar.length; j++){
                    row.add(ar[i][j]);
                    if(i == j)
                        col.add(ar[i][j]);
                    //System.out.print(ar[i][j]);
                }
                int rowC = row.size() < ar.length? 1 : 0;
                rowCount = rowCount + rowC;
                trace = trace + ar[i][i];
                if(i == ar.length - 1){
                    int colC = col.size() < ar.length? 1 : 0;
                    colCount = colCount + colC;
                }
                //System.out.println();
            }
            int caseNum = test + 1;
            System.out.println("Case #"+caseNum +": "+ trace +" "+rowCount+" "+colCount);
            
        }
        
    }
   
}
