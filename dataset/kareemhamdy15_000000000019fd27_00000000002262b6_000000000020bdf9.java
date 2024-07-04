import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        if ( (s1 < s2 && e1 > s2) ||
                (s1 == s2 && e1 == e2) ||
                (s2 < s1 && e2 > s1 )||
                ( s1 < e2 && e1 > e2)||
                ( s2 < e1 && e2 > e1)
                )
        {
            return  true;
        }

            return false;
    }

    static void testCase(int caseNum) {

        char[] result = new char[n];
        boolean flagImp = false;
        for (int i = 0; i < n; i++) {
            if (result[i] == 'C'|| result[i] == 'J') continue;

            List<String> list = new ArrayList<String>();
            for (int j = i + 1; j < n; j++) {

                if (isOverLap(arr[i], arr[j])) {
                    for (String s : list) {
                        if (isOverLap(arr[j], s)) {
                            flagImp = true;
                            break;
                        }
                    }
                    if (flagImp) break;


                    list.add(arr[j]);
                    result[j] = 'J';
                }
                if(result[j] != 'J') result[j] = 'C';

            }
            result[i] = 'C';
            if (flagImp) break;
        }
        if (flagImp)
            System.out.println("Case #" + caseNum + ": " + "IMPOSSIBLE");
        else {

            String res = String.valueOf(result) ;
            System.out.println("Case #" + caseNum + ": " + res);
        }
    }

}
