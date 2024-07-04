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

            for(int j = 0; j<n; j++) {

                int s = in.nextInt();
                int e = in.nextInt();

                for (int k = s; k < e; k++) {
                    if(cameron[k]==false) check ++;
                    else {
                        check = 0;
                        break;
                    }
                }
                if (check == e-s){
                    for (int k = s; k < e; k++) {
                        cameron[k] = true;
                    }
                    answer[i] = answer[i] + "C";
                    check = 0;
                }

                else {
                    for (int k = s; k < e; k++) {
                        if(jamie[k]==false) check ++;
                        else {
                            check = 0;
                            break;
                        }
                    }
                    if (check == e-s) {
                        for (int k = s; k < e; k++) {
                            jamie[k] = true;
                        }
                        answer[i] = answer[i] + "J";
                        check = 0;
                    }
                    else answer[i] = "IMPOSSIBLE";
                }

                }

        }
     
        for(int i = 0; i < t; i++){
            System.out.println("Case #" + (i+1) + ": " + answer[i]);
        }
    }
}