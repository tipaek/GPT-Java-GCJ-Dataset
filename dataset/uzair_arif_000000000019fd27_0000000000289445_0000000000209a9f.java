import java.util.*;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        test temp = null;
        for (int i = 1; i <= t; ++i) {
            String val = in.next();
            temp = new test(i, val);
            temp.solvetestcase();
        }
    }
}

class test {
    int id;
    String input; // val => 021, 312, 4, 221, 111000 Output => 0((2)1), (((3))1(2)), ((((4)))),
                  // ((2))((2))(1)
    String solution;
    int[] arr;
    int[] visited;
    String openpar = "(";
    String closepar = ")";

    test(int id, String val) {
        this.id = id;
        this.input = val;
        solution = val;
        arr = new int[input.length()];
        visited = new int[input.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.getNumericValue(input.charAt(i));
            visited[i] = 0;
        }
    }

    void solvetestcase() {
        int gdepth = 0;
        int ldepth = 0;
        for (int i = 0; i < arr.length; i++) {

            int minpos = getminPos();
            if (minpos == -1) break;
            // System.out.println("minpos = " + String.valueOf(minpos));
            int val_at_min = arr[minpos];
            // System.out.println("val at min = " + String.valueOf(val_at_min));

            if (visited[minpos] == 0 && val_at_min - ldepth != 0) {

                int diff = findlocaldepth(minpos);
                ldepth = findldepth(minpos);
                if (ldepth == 0) {ldepth = gdepth;}
                // System.out.println("Local Depth = " + String.valueOf(ldepth));
                // getString();
                int posA = getleftside(minpos);
                // System.out.println("posA = " + String.valueOf(posA));

                int posB = getrightside(minpos);
                // System.out.println("posB = " + String.valueOf(posB));

                int pars = val_at_min - ldepth;
                // System.out.println("Diff = "+String.valueOf(diff));
                String t1 = "";
                String t2, t3 = "";
                if (posA != 0 || ldepth != 0) {
                    t1 = solution.substring(0, posA + ldepth);
                }
                String t4 = solution.substring(posA + ldepth, posB + ldepth);
                t2 = getNewString(t4, pars);
                if (posB != visited.length - 1 || ldepth != 0) {
                    t3 = solution.substring(posB + ldepth, solution.length());
                }
                solution = t1 + t2 + t3;


                // System.out.println("solution = " + solution);
                // System.out.println("END");
                gdepth = arr[minpos];

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == val_at_min){
                        visited[j] = val_at_min;
                        arr[j] = Integer.MAX_VALUE;
                    }
                }
                // visited[minpos] = val_at_min;
                // arr[minpos] = Integer.MAX_VALUE;

            }
        }
        solution = "Case #" + String.valueOf(id) + ":" + solution;
        System.out.println(solution);
    }

    int findldepth (int minpos){
        if (minpos + 1 < visited.length && minpos-1 >= 0){
            if (visited[minpos+1] > visited[minpos-1]){
                return visited[minpos+1];
            }
            else return visited[minpos-1];
        }
        else if (minpos + 1 < visited.length){
            return visited[minpos+1];
        }
        else return visited[minpos-1];
    }

    int findlocaldepth(int minpos) {

        // rightside
        int rightside = 0;
        for (int i = minpos + 1; i < visited.length; i++) {
            if (visited[i] != 0) {
                rightside = rightside + visited[i];
            } else {
                break;
            }
        }

        // leftside
        int leftside = 0;
        for (int i = minpos - 1; i >= 0; i--) {
            if (visited[i] != 0) {
                leftside = leftside + visited[i];
            } else {
                break;
            }
        }

        if (rightside > leftside){
            return rightside;
        }
        else {
            return leftside;
        }
    }

    String getNewString(String str, int t1) {
        for (int i = 0; i < t1; i++) {
            str = openpar + str;
        }
        for (int i = 0; i < t1; i++) {
            str = str + closepar;
        }
        // System.out.println("STR ="+str);
        return str;
    }

    int getminPos() {
        int min = Integer.MAX_VALUE;
        int minpos = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                minpos = i;
                min = arr[i];
            }
        }
        return minpos;
    }

    int getleftside(int pos) {
        boolean found = false;
        int posA = pos;
        for (int i = pos; i >= 0; i--) {
            if (visited[i] >= 1) {
                posA = i + 1;
                found = true;
                break;
            }
        }
        if (found) {
            return posA;
        } else
            return 0;
    }

    int getrightside(int pos) {
        boolean found = false;
        int posB = pos;
        for (int i = pos; i < visited.length; i++) {
            if (visited[i] >= 1) {
                posB = i;
                found = true;
                break;
            }
        }
        if (found)
            return posB;
        else
            return visited.length;
    }

    void getString() {
        String a = "";
        for (int i = 0; i < visited.length; i++) {
            a = a + visited[i];
        }
        // System.out.println("Visited Array = " + a);
    }

}
