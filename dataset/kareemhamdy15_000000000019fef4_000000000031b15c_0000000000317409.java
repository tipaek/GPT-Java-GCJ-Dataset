/**
 * Created by kareem on 3/22/2020.
 */

import java.util.*;

/**
 * Created by kareem on 3/19/2020.
 */
public class Solution {
    //
    static long x, y, c, z;
    static long req;
    static int[] arr;
    static String in;
//    static HashMap<String, Integer> map;


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();


        for (int count = 0; count < testCases; count++) {
            x= s.nextLong();
            y= s.nextLong();
            in = s.next();
            testCase(count+1);

//         System.out.println("---------------------");

        }

    }
    static void testCase(int caseNum) {
        boolean flag = false;

        long mx = 0;
        long my = 0;
        long min = 1;
        char [] arr = in.toCharArray();
        for(int i = 0 ; i < in.length(); i++){
            if(arr[i] == 'N'){
                y++;
            }
            if(arr[i] == 'E'){
                x++;
            }
            if(arr[i] == 'S'){
                y--;
            }
            if(arr[i] == 'W'){
                x--;
            }

            if(Math.abs((x - mx)) + Math.abs((y- my)) <= min){
                flag = true;
                break;
            }
            min++;
        }

        if(flag)
             System.out.println("Case #" + caseNum + ": " + min);
        else
            System.out.println("Case #" + caseNum + ": " + "IMPOSSIBLE");
    }


}
