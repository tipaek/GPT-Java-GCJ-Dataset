import java.util.*;


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
        boolean flagImp = false;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < n; i++){
            map.put(arr[i], i );
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] a1 = o1.split(":");
                String[] a2 = o2.split(":");

                int s1 = Integer.parseInt(a1[0]);
                int s2 = Integer.parseInt(a2[0]);

                if(s1 > s2 )return 1;
                else if (s1 < s2) return -1;
                return 0;
            }
        });

//        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i]);
//        }

//        for(int i = 0; i < n ; i++){
//            result[map.get(arr[i])] = 'J';
//            if(i < n -1 ){
//                if(isOverLap(arr[i],arr[i]+1)){
//                    if(i < n -2){
//                        if(isOverLap(arr[i], arr[i+2])&& isOverLap(arr[i+1] , arr[i +2])){
//                            flagImp =true;
//                            break;
//                        }
//                    }
//
//                    i++;
//                }
//            }
//
//        }
//        for(int i = 0; i < n ; i++){
//            if(result[i] != 'J') result[i] = 'C';
//        }


////        System.out.println("-------------");
//
        Set<Integer> set = new HashSet<Integer>();
        result[map.get(arr[0])] = 'J';
        set.add(map.get(arr[0]));
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {


                if (isOverLap(arr[i], arr[j])) {
                    if (result[map.get(arr[j])] == result[map.get(arr[i])]) {
                        if (set.contains(map.get(arr[j]))) {
                            set.remove(map.get(arr[j]));
                            if (result[map.get(arr[j])] == 'C') {
                                result[map.get(arr[j])] = 'J';
                            } else {
                                result[map.get(arr[j])] = 'C';
                            }
                        } else {
                            flagImp = true;
                            break;
                        }
                    } else {
                        if (set.contains(map.get(arr[j]))) {
                            set.remove(map.get(arr[j]));
                        }
                        if (result[map.get(arr[j])] == 'J') {
                            result[map.get(arr[i])] = 'C';
                        } else {
                            result[map.get(arr[i])] = 'J';
                        }

                    }

                }
            }
            if (flagImp) break;
            if (result[map.get(arr[i])] != 'J' && result[map.get(arr[i])] != 'C') {
                result[map.get(arr[i])] = 'J';
                set.add(map.get(arr[i]));
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