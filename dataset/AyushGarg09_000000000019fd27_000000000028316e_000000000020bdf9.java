import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

public class Solution {

    private static String schedule(ArrayList<Integer[]> x){
        StringBuilder result = new StringBuilder();
        ArrayList<Integer[]> arrayListClone =  (ArrayList<Integer[]>)x.clone();
        HashMap<Integer[], Character> map = new HashMap();
        x.sort(new Comparator<Integer[]>(){ 
            public int compare(Integer[] i1,Integer[] i2) 
            { 
                return i1[0]-i2[0]; 
            } 
        });

        int jameFreeat = -1;
        int cameFreeAt = -1;
        
        for(int i = 0; i < x.size(); i++){
            Integer[] curr = x.get(i);

            //System.out.println("START: "+curr[0]+ " END: "+curr[1]);

            if(jameFreeat == -1) {
                map.put(curr,'J');
                jameFreeat = curr[1];
            }
            else{
                if(curr[0] < jameFreeat){
                    if(curr[0] >= cameFreeAt){
                        map.put(curr,'C');
                        cameFreeAt = curr[1];
                    }
                    else return "IMPOSSIBLE";
                }
                else{
                    map.put(curr,'J');
                    jameFreeat = curr[1];
                }
            }
        }

        for(int i = 0 ; i < arrayListClone.size();i++){
            result.append(map.get(arrayListClone.get(i)));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

       
        for (int i = 1; i <= t; ++i) {
            int all = in.nextInt();
            ArrayList<Integer[]> inputList = new ArrayList<Integer[]>();
            for(int j = 0 ; j < all; j++){
                Integer[] x = {in.nextInt(),in.nextInt()};
                inputList.add(x);
        }
            String result = Solution.schedule(inputList);
            System.out.println("Case #" + i + ": " + result);
        }
        in.close();
    }
}