import java.io.*;
import java.util.*;


public class Solution{
    StringBuilder sb = new StringBuilder();
    static HashMap <Character, Integer> map = new HashMap();
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int off = -1000000000;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -------------------------------------
        long MOD = 1000000007;
        int t = sc.nextInt();
        int tt = 0;
        map.put('N', 0);
        map.put('E', 1);
        map.put('S', 2);
        map.put('W', 3);
        Solution sol = new Solution();
        while(tt++ < t)
        {
            String res = sol.solve(sc);
            out.flush();
            out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public String solve(MyScanner sc){
        int n = sc.nextInt();
        int cnt = 0;
        String [] M = new String[10000];
        String [] str = new String[10000];
        HashMap<Character, Integer> Letters = new HashMap();
        HashSet<Character> imposZero = new HashSet();
        int [] posStart = new int[10];
        Arrays.fill(posStart, 10);
        boolean T3 = false;
        for(int i = 0; i < 10000; i++)
        {
            M[i] = sc.next();
            if(M[i].equals("-1")) T3 = true;
            String tmp = sc.next();
            for(char c : tmp.toCharArray())
                if(!Letters.containsKey(c))
                    Letters.put(c, cnt++);
            imposZero.add(tmp.charAt(0));
            str[i] = tmp;
        }
        char [] res = new char[10];
        if(!T3)
        {
            for(int i = 0; i < 10000; i++)
            {
                if(M[i].length() == str[i].length())
                {
                    int pos = Letters.get(str[i].charAt(0));
                    posStart[pos] = Math.min(posStart[pos], M[i].charAt(0) - '0');
                }
            }
            for(int i = 0; i < 26; i ++)
            {
                char tmp = (char)('A' + i);
                if(Letters.containsKey(tmp))
                {
                    res[posStart[Letters.get(tmp)] % 10] = tmp;
                }
            }
            return new String(res);
        }
        else
        {
            for(int i = 0; i < 10000; i++)
            {
                int pos = Letters.get(str[i].charAt(0));
                posStart[pos]++;
            }
            int[] sorted = posStart.clone();
            Arrays.sort(sorted);
            for(int i = 0; i < 26; i ++)
            {
                char tmp = (char)('A' + i);
                if(Letters.containsKey(tmp))
                {
                    for(int j = 0; j < 10; j ++)
                    {
                        if(posStart[Letters.get(tmp)] == sorted[j])
                            res[(10 - j) % 10] = tmp;
                    }
                }
            }
            return new String(res);
        }
    }
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    //--------------------------------------------------------
}