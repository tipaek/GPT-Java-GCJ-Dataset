import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by kareem on 3/19/2020.
 */
public class Solution {

    static int n, start, end;
    static String[] arr;
//    static int[][] arr;

//    static String in;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();

        for (int i = 1; i <= testCases; i++) {
            n = s.nextInt();
            arr = new String[n];
            for (int j = 0; j < n; j++) {
                start = s.nextInt();
                end = s.nextInt();
                arr[j] = start + ":" + end;
            }

            testCase(i);
        }

    }


    static boolean isOverLap(String p1, String p2) {
        String[] a1 = p1.split(":");
        String[] a2 = p2.split(":");

        int s1 = Integer.parseInt(a1[0]);
        int e1 = Integer.parseInt(a1[1]);
        int s2 = Integer.parseInt(a2[0]);
        int e2 = Integer.parseInt(a2[1]);

//        System.out.println("s1  " + s1 + " e1 " + e1 + " s2 "+ s2 + " e2 " + e2 );

        if ((s1 < s2 && e1 > s2) ||
                (s1 == s2 && e1 == e2) ||
                (s2 < s1 && e2 > s1) ||
                (s1 < e2 && e1 > e2) ||
                (s2 < e1 && e2 > e1)
                ) {
            return true;
        }

        return false;
    }

    static void testCase(int caseNum) {

        char[] result = new char[n];

//        for(int i = 0 ; i < n ; i++){
//            System.out.println(arr[i]);
//        }
//        System.out.println("-------------");
        boolean flagImp = false;
        Set<Integer> set = new HashSet<Integer>();
        result[0] = 'J';
        set.add(0);
        for (int i = 1; i < n; i++) {

//            System.out.println(String.valueOf(result));
            
            for (int j = i - 1; j >= 0; j--) {


                if (isOverLap(arr[i], arr[j])) {
                    if (result[j] == result[i]) {
                        if (set.contains(j)) {
                            set.remove(j);
                            if (result[j] == 'C') {
                                result[j] = 'J';
                            } else {
                                result[j] = 'C';
                            }
                        } else {
                            flagImp = true;

                        }

                    } else {
                        if (set.contains(j)) {
                            set.remove(j);
                        }

//                        System.out.println("----------" + i + "------------------"+ j +"---------");
                        if (result[j] == 'J') {
                            result[i] = 'C';
                        } else {
                            result[i] = 'J';
                        }

                    }

                }
            }

            if (result[i] != 'J' && result[i] != 'C') {
                result[i] = 'J';
                set.add(i);
            }


        }
        if (flagImp)
            System.out.println("Case #" + caseNum + ": " + "IMPOSSIBLE");
        else {

            String res = String.valueOf(result);
            System.out.println("Case #" + caseNum + ": " + res);
        }
    }

}
