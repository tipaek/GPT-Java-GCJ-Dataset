/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        int total=t;
        while (t-- >0) {
            int size = in.nextInt();
            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            int rowDupCount=0,colDupCount=0,trace=0;
            Set<Integer> rowDupSet = new HashSet<>();
            Set<Integer> colDupSet = new HashSet<>();
            for (int i=0;i<size;i++) {
                for (int j=0;j<size;j++) {
                    int input = in.nextInt();
                    if (i==j) trace+=input;
                    if (rowMap.containsKey(i)) {
                        boolean whatHappnd = rowMap.get(i).add(input);
                        if (!whatHappnd && rowDupSet.add(i)) rowDupCount++;
                    } else {
                        Set<Integer> set = new HashSet<>();
                        set.add(input);
                        rowMap.put(i,set);
                        //rowDupSet.add(i);
                    }
                    if (colMap.containsKey(j)) {
                        boolean whatHppnd = colMap.get(j).add(input);
                        if (!whatHppnd && colDupSet.add(j)) colDupCount++;
                    } else {
                        Set<Integer> set = new HashSet<>();
                        set.add(input);
                        colMap.put(j,set);
                        //colDupSet.add(j);
                    }
                }
            }
            System.out.println("Case #"+(total-t) +": " + trace + " " + rowDupCount + " " + colDupCount);
        }
    
    }
}
