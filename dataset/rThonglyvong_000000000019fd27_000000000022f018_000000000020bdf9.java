import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
           int numEvents = in.nextInt();
           in.nextLine();
           String[] input = new String[numEvents];
           for (int j = 0; j < numEvents; j++) {
               input[j] = in.nextLine();
           }
           solve(input);
           System.out.println("Case #" + i + ": " + current);
        }
    }
    
    public static String current;

    public static void solve(String[] input) {
        current = "";
        if (input.length == 2) {
            current = "JC";
            return;
        }
        int[][] transformed = new int[input.length][2];
        for (int i = 0; i < input.length; i++) {
            String[] temp = input[i].split(" ");
            transformed[i][0] = Integer.parseInt(temp[0]);
            transformed[i][1] = Integer.parseInt(temp[1]);
        }
        String retValue = helper(transformed, 0, new HashSet<>(), new HashSet<>());
    }

    public static String helper(int[][] input, int event, HashSet<Integer> jamie, HashSet<Integer> carol) {
        if (current == "" || current == "IMPOSSIBLE") {

            if (event == input.length) {
                String retValue = "";
                for (int i = 0; i < input.length; i++) {
                    if (jamie.contains(i)) retValue += "J";
                    else if (carol.contains(i)) retValue += "C";
                    else return "";
                }
                if (current == "IMPOSSIBLE" || current == "") current = retValue;
                return retValue;
            }
            String retValue = "";
            for (int i = event; i < input.length; i++) {
                boolean jamieCan = isPossible(input, jamie, i);
                boolean carolCan = isPossible(input, carol, i);
                if (jamieCan) {
                    jamie.add(i);
                    helper(input, i + 1, jamie, carol);
                    jamie.remove(i);
                }
                else if (carolCan) {
                    carol.add(i);
                    helper(input, i + 1, jamie, carol);
                    carol.remove(i);
                }
                else {
                    if(current == "") current = "IMPOSSIBLE";
                    return "IMPOSSIBLE";
                }
            }
            if(current == "") current = "IMPOSSIBLE";
            return "IMPOSSIBLE";
        } else {
            return current;
        }
    }

    public static boolean isPossible(int[][] input, HashSet<Integer> person, int event) {
        int eventBegin = input[event][0];
        int eventEnd = input[event][1];
        for (Integer i : person) {
            int tempBegin = input[i][0];
            int tempEnd = input[i][1];

            if ((eventBegin > tempBegin && eventBegin < tempEnd) || (eventEnd > tempBegin && eventEnd < tempEnd)
                    ||(tempBegin == eventBegin)
                    ||(tempEnd == eventEnd)
                    ||(tempBegin > eventBegin && tempBegin < eventEnd)
                    ||(tempEnd > eventBegin && tempEnd < eventEnd)) {
                return false;
            }
        }
        return true;
    }
}

