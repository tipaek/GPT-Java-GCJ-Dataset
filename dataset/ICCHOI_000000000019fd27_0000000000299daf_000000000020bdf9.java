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
                Integer si = in.nextInt();
                String s = String.format("%04d",si);
                Integer ei = in.nextInt();
                String e = String.format("%04d",ei);

                value[j] = s + "/" + e + "#" + new String(String.format("%04d",j));
            }

            Arrays.sort(value);

            String[] sort = new String[n];

            for(int j = 0; j < n; j++){
                int s = Integer.parseInt(value[j].substring(0,value[j].indexOf("/")));
                int e = Integer.parseInt(value[j].substring(value[j].indexOf("/")+1,value[j].lastIndexOf("#")));


                sort[j] = value[j].substring(value[j].indexOf("#")+1);

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
                else if(sort[j].contains("C")) answer[i] = answer[i] + "C";
                else if(sort[j].contains("J")) answer[i] = answer[i] + "J";
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answer[i]);
        }
    }
}
