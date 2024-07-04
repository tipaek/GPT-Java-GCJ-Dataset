import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int check = 0;

        String[] answer = new String[t];

        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            answer[i] = "";

            boolean[] cameron = new boolean[1440];
            boolean[] jamie = new boolean[1440];

            String[] value = new String[n];

            for(int j = 0; j < n; j++){
                String s = in.next();
                String e = in.next();

                value[j] = s + "/" + e + String.valueOf((char)(65+j));
            }
            Arrays.sort(value);
            String[] sort = new String[n];

            for(int j = 0; j < n; j++){
                int s = Integer.parseInt(value[j].substring(0,value[j].indexOf("/")));
                int e = Integer.parseInt(value[j].substring(value[j].indexOf("/")+1,value[j].length()-1));

                sort[j] = String.valueOf(value[j].charAt(value[j].length()-1));

                for (int k = s; k < e; k++) {
                    if (cameron[k] == false) check++;
                    else {
                        check = 0;
                        break;
                    }
                }
                if (check == e - s) {
                    for (int k = s; k < e; k++) {
                        cameron[k] = true;
                    }
                    sort[j] = sort[j] + "C";
                    check = 0;
                } else {
                    for (int k = s; k < e; k++) {
                        if (jamie[k] == false) check++;
                        else {
                            check = 0;
                            break;
                        }
                    }
                    if (check == e - s) {
                        for (int k = s; k < e; k++) {
                            jamie[k] = true;
                        }
                        sort[j] = sort[j] + "J";
                        check = 0;
                    } else sort[j] = "IMPOSSIBLE";
                }
            }
            Arrays.sort(sort);

            for(int j = 0; j<sort.length; j++){
                if(sort[j] == "IMPOSSIBLE") {
                    answer[i] = "IMPOSSIBLE";
                    break;
                }
                answer[i] = answer[i] + sort[j].charAt(1);
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answer[i]);
        }
    }
}