import java.util.*;
import java.io.*;

import static java.util.stream.Collectors.toList;

//PARENTING PARTNERING RETURNS
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num_cases = Integer.parseInt(in.nextLine());
        ArrayList<String> outputs = new ArrayList<>();
        for(int n=0; n<num_cases; n++) {
            int tasks = Integer.parseInt(in.nextLine());
            int C = 0;
            int J = 0;
            String out = "Case #" + (n+1) + ": ";
            ArrayList<String> task_list = new ArrayList<>();
            for(int i=0; i<tasks; i++) {
                task_list.add(in.nextLine());
            }
            task_list = (ArrayList<String>) task_list.stream()
                    .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.split(" ")[0])))
                    .collect(toList());
            for(String t : task_list) {
                int min = Integer.parseInt(t.split(" ")[0]);
                int max = Integer.parseInt(t.split(" ")[1]);
                if(min >= C) {
                    out += "C";
                    C = max;
                } else if(min >= J) {
                    out += "J";
                    J = max;
                } else {
                    out = "Case #" + (n+1) + ": " + "IMPOSSIBLE";
                    outputs.add(out);
                    break;
                }
            }
            if(!out.contains("IMPOSSIBLE")) {
                outputs.add(out);
            }
        }
        for(String s : outputs) {
            System.out.println(s);
        }
    }
}
