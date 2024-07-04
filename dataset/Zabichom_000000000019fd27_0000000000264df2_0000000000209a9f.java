import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String string = in.next();

            String nestring = Process(string);

            System.out.println("Case #" + i + ": "+nestring);
        }
    }

    public static String Process(String str){
        String[] split = str.split("");

        int[] nums = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            ArrayList<Integer> element = new ArrayList<>();
            if(i == nums.length-1){
                element.add(nums[i]);
                element.add(count);
                list.add(element);
                break;
            }if(nums[i] == nums[i+1]){
                count++;
            }else {
                if(list.isEmpty()){
                    element.add(nums[i]);
                    element.add(count);
                    count = 1;
                    list.add(element);
                    continue;
                }
                element.add(nums[i]);
                element.add(count);
                count = 1;
                list.add(element);
            }
        }

        String nesting = "";
        String breaket = "(";
        for(int i = 0; i < list.size(); i++){
            int n = 0;
            if(i == 0){
                n = list.get(i).get(0) - 0;
            }else {
                n = list.get(i).get(0)-list.get(i-1).get(0);
                if(n > 0) {
                    breaket = "(";
                }else if(n < 0) {
                    n = n*(-1);
                    breaket = ")";
                }
            }



            for(int j = 0; j < n; j++) {
                nesting+=breaket;
            }

            for(int k = 0; k < list.get(i).get(1); k++) {
                nesting+=Integer.toString(list.get(i).get(0));
            }

            if(i == list.size()-1){
                n = list.get(i).get(0) - 0;
                for(int j = 0; j < n; j++) {
                    nesting+=")";
                }
            }
        }
        return nesting;
    }
}