

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = input.nextInt();

        input.nextLine();
        for (int i = 0; i < testCases; i++){
            int matrixLength = input.nextInt();
            input.nextLine();

            int k1 = 0, valueNow = 0;
            int rows = 0, columns = 0;
            boolean[] columnsBooleans = new boolean[matrixLength];
            HashMap<Integer,HashMap<Integer,Boolean>> checkColumns = new HashMap<>();
            for (int l = 0; l < matrixLength; l++) {
                HashMap<Integer,Boolean> checkRows = new HashMap<>();
                boolean flagRow = false;
                for (int k = 0; k < matrixLength; k++) {
                    if (input.hasNextLine()){
                        valueNow = input.nextInt();
                    }else{
                        input.nextInt();
                    }

                    if (checkRows.containsKey(valueNow)){
                        flagRow = true;
                    }
                    if (!checkColumns.containsKey(k)){
                        HashMap<Integer,Boolean> map = new HashMap<>();
                        map.put(valueNow,true);
                        checkColumns.put(k,map);
                    }else{

                        if (checkColumns.get(k).containsKey(valueNow) && columnsBooleans[k] == false){
                            columns++;
                            columnsBooleans[k] = true;
                        }else{
                            checkColumns.get(k).put(valueNow,true);
                        }
                    }
                    checkRows.put(valueNow,true);
                    if (l == k){
                        k1 += valueNow;
                    }

                }



                if (flagRow == true){
                    rows++;
                }


            }

            System.out.println("Case #"+(i+1)+": "+k1+ " "+rows+" "+columns);


        }

    }


}
