import java.io.*;
import java.util.*;

public class LatinMatrix {
    public static void main(String[] args) throws Exception {
        FileWriter out = new FileWriter("./output.txt");
        FileReader in = new FileReader("./input.txt");
        BufferedReader bin = new BufferedReader(in);
        int cases = Integer.valueOf(bin.readLine());

        for (int z=0;z < cases;++z) {
            int mSize = Integer.valueOf(bin.readLine());
            int[][] m = new int[mSize][mSize];

            int k = 0, r = 0, c = 0;
            Map<Integer, Set<Integer>> cMap = new HashMap<>();
            int[] col = new int[mSize];
            int[] row = new int[mSize];

            for (int i=0;i < mSize;i++) {
                String[] tokens = bin.readLine().split(" ");
                Set<Integer> s = new HashSet<>();
                for (int j=0;j < mSize;j++) {
                    m[i][j] = Integer.valueOf(tokens[j]);
                    //column checking
                    if (cMap.containsKey(j) && cMap.get(j).contains(m[i][j])) {
                        col[j] = 1;
                    } else {
                        if (!cMap.containsKey(j)) cMap.put(j, new HashSet<Integer>());
                        cMap.get(j).add(m[i][j]);
                    }

                    //row checking
                    if (s.contains(m[i][j])) {
                        row[i] = 1;
                    } else {
                        s.add(m[i][j]);
                    }
                }
                k += m[i][i];
            }

            c = Arrays.stream(col).reduce(0, Integer::sum);
            r = Arrays.stream(row).reduce(0, Integer::sum);
            out.write("Case #" + (z + 1) + ": " + k + " " + r + " " + c + "\n");
            out.flush();
        }

    }
}