import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int k = 1; k <= x; k++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][2];
            for (int j = 0; j < n; j++) {
                mat[j][0] = sc.nextInt();
                mat[j][1] = sc.nextInt();
            }
            System.out.println("Case #" + k + ": " + findSched(mat, n));
        }
    }


        public static String findSched(int[][] mat, int n) {
            StringBuilder str = new StringBuilder();
            node cHead = null;
            node jHead = null;
            List<Integer> cList = new ArrayList<>(), jList = new ArrayList<>();
            int start, end;
            for (int i = 0; i < n; i++) {
                start = mat[i][0];
                end = mat[i][1];
                if (cList.size() == 0) {
                    cList.add(start);
                    cList.add(end);
                    str.append("C");
                } else if (jList.size() == 0) {
                    jList.add(start);
                    jList.add(end);
                    str.append("J");
                } else {
                    if (check(cList, start, end))
                        str.append("C");
                    else if (check(jList, start, end))
                        str.append("J");
                    else return "IMPOSSIBLE";
                }
            }
            return str.toString();
        }

        public static boolean check(List<Integer> cHead, int start, int end) {
            int i = 0;
            while (i < cHead.size()) {
                if (cHead.get(i) > start) {
                    if (cHead.get(i) >= end) {
                        cHead.add(i,start);
                        cHead.add(i+1,end);
                        return true;
                    } else return false;
                } else if (cHead.get(i) == start)
                    return false;
                else {
                    i++;
                    if (cHead.get(i) <= start) {
                        if(i+1 ==cHead.size()){
                            cHead.add(i,start);
                            cHead.add(i+1,end);
                            return true;
                        }
                        i++;
                    } else return false;
                }
            }
            return false;
        }


}