
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for(int h=1;h<=t;h++)
        {
            str.append("Case #"+h+": ");
            int n = Integer.parseInt(br.readLine());
            Map<Integer, TreeSet<Integer>> row = new HashMap<>();
            Map<Integer, TreeSet<Integer>> col = new HashMap<>();
            int trace = 0;
            for(int i=1;i<=n;i++){
                String[] in = br.readLine().split(" ");
                TreeSet<Integer> valRow = row.getOrDefault(i, new TreeSet<>());
                for(int j=1;j<=n;j++){
                    int p = Integer.parseInt(in[j-1]);
                    valRow.add(p);
                    TreeSet<Integer> valCol = col.getOrDefault(j, new TreeSet<>());
                    valCol.add(p);
                    col.put(j, valCol);
                    if(i==j){
                        trace+=p;
                    }
                }
                row.put(i, valRow);
            }
            int r=0;
            int c=0;
            for(int i=1;i<=n;i++){
                TreeSet<Integer> cur = row.getOrDefault(i, new TreeSet<>());
                if(cur.size()==n && cur.last()==n){
                    r++;
                }
                cur = col.getOrDefault(i, new TreeSet<>());
                if(cur.size()==n && cur.last()==n){
                    c++;
                }
            }

            str.append((trace)+" "+(n-r)+" "+(n-c)+"\n");
        }
        out.print(str);
        out.flush();
        br.close();
    }
}




