import java.util.*;
import java.io.*;

//INDICIUM
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num_cases = Integer.parseInt(in.nextLine());
        ArrayList<String> outputs = new ArrayList<>();
        for(int n=0; n<num_cases; n++) {
            String[] info = in.nextLine().split(" ");
            int dim = Integer.parseInt(info[0]);
            int trace = Integer.parseInt(info[1]);
            if(trace % dim != 0) {
                String out = "Case #" + (n + 1) + ": IMPOSSIBLE";
                outputs.add(out);
                continue;
            }
            String out = "Case #" + (n+1) + ": POSSIBLE";
            outputs.add(out);
            int mid = trace / dim;
            int offset = 0;
            for(int i=0; i<dim; i++) {
                String row = "";
                int curr = (mid-1 + offset + dim)%dim;
                for(int j=0; j<dim; j++) {
                    row += (curr + 1) + " ";
                    curr = (curr + 1)%dim;
                }
                offset -= 1;
                outputs.add(row);
            }
        }
        for(String s : outputs) {
            System.out.println(s);
        }
    }
}
