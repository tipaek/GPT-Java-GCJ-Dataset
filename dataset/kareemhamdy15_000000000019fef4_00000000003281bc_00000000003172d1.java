/**
 * Created by kareem on 3/22/2020.
 */

import java.util.*;

/**
 * Created by kareem on 3/19/2020.
 */


public class Solution {
    //
    static long x, y, c, z ;
    static  int n, d;
    static long req;
    static int[] arr;
    static String in;
    static long[] intArr;
    static String[] strArr;
//    static HashMap<String, Integer> map;


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();


        for (int count = 0; count < testCases; count++) {
            n = s.nextInt();
            intArr = new long[n];
            d = s.nextInt();

            for (int i = 0; i < n; i++) {
                intArr[i] = s.nextLong();
            }
            testCase(count + 1);

//         System.out.println("---------------------");

        }

    }

    static void testCase(int caseNum) {
        HashMap<Long , Integer> map = new HashMap<Long, Integer>();

        int max = 0;
        long maxV = 0;

        long maxValue = 0;
        long minValue = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(intArr[i])){
                map.put(intArr[i], map.get(intArr[i])+1);
                if(map.get(intArr[i])> max){
                    max = map.get(intArr[i]);
                    maxV = intArr[i];
                }

            }
            else {
                map.put(intArr[i], 1);
            }
            if(intArr[i] > maxValue){
                maxValue = intArr[i];
            }
            if(intArr[i] < minValue){
                minValue  = intArr[i];
            }
        }

        int res = d-1;
        if(max >= d){
            System.out.println("Case #" + caseNum + ": " + 0);
        }else{
            if(minValue == maxValue){
                res = d -1;
            }else{
//                System.out.println("hello");
                for(int i = 0 ; i < n ; i++){
                    long curr = intArr[i];
                    for(int j = 0 ; j < n ; j++ ){
                        if(curr != intArr[j]){
                            if(curr > intArr[j]){
                                long div = curr / intArr[j];
                                if(div + map.get(intArr[j]) >= d){
                                    long currD = d - map.get(intArr[j]);
                                    if(div > currD){
                                        if(currD  <= res){
                                            res = (int) currD;
                                        }
                                    }else if(div == currD){

                                        int currRes = curr % intArr[j] == 0 ? (int)currD -1 :(int) currD;
                                        if(currRes   <= res)
                                        res = currRes ;
                                    }

                                }
                            }

                        }
                    }

                }

            }
            System.out.println("Case #" + caseNum + ": " + res);
        }




    }


}