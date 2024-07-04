import java.io.*;
import java.util.*;

public class Solution {

    void solve(FastReader reader, PrintStream out) {
        int t = reader.nextInt();
        for(int tc=1; tc<=t; tc++) {
            int n = reader.nextInt();
            HashSet[] colSets = new HashSet[n];
            int trace = 0;
            int rowCount = 0;
            for(int i=0; i<n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for(int j=0; j<n; j++) {
                    if(i==0)
                        colSets[j] = new HashSet<Integer>();
                    int val = reader.nextInt();
                    rowSet.add(val);
                    colSets[j].add(val);
                    if(i == j)
                        trace += val;
                }
                rowCount += rowSet.size()==n ? 0 : 1;
            }
            int colCount = 0;
            for(int j=0; j<n; j++)
                colCount += colSets[j].size() == n ? 0 : 1;
            out.println(String.format("Case #%d: %d %d %d", tc, trace, rowCount, colCount));
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        new Solution().solve(reader, System.out);

        reader.close();
    }
    
    
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    public FastReader(String filename) {
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FastReader(File outFile) {
        try {
            br = new BufferedReader(new FileReader(outFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt()
    {
        return Integer.parseInt(next());
    }

    public long nextLong()
    {
        return Long.parseLong(next());
    }

    public double nextDouble()
    {
        return Double.parseDouble(next());
    }

    public String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public void close() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}