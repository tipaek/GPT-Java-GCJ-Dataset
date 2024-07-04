import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution{
    public static void main(String [] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine()), n = 0;
        int[] ivl;
        ArrayList<Integer>[] ends;
        String res= "";
        for (int i= 1; i < t+1; i++){
            ends = new ArrayList[1440];
            n = Integer.parseInt(in.readLine());
            for (int j=0; j < n; j++){
                ivl = getIvl(in.readLine());
                if (ends[ivl[0]] == null) ends[ivl[0]] = new ArrayList<>();
                ends[ivl[0]].add(ivl[1]);
            }
            res = solve(ends);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    public static int[] getIvl(String line){
        String[] sp = line.split(" ");
        int start = Integer.parseInt(sp[0]);
        int end = Integer.parseInt(sp[1]);
        return new int[]{start, end};
    }

    public static String solve(ArrayList<Integer>[] ends){
        StringBuilder ans = new StringBuilder();
        int c= 0, j= 0;
        for (int i= 0; i < ends.length; i++){
            if(ends[i] != null){
                for (Integer time : ends[i]){
                    if (j > 0 && c > 0) return "IMPOSSIBLE";
                    if (j == 0){
                        j = time - i;
                        ans.append('J');
                    }
                    else{
                        c = time - i;
                        ans.append('C');
                    }
                }
            }
            c = Math.max(0, c - 1);
            j = Math.max(0, j - 1);
        }
        return ans.toString();
    }
}