import java.io.*;
import java.util.*;

class Solution {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;

    int U;
    boolean hit;
    int x1, y1, x2, y2, x3, y3;

    static final int Z = (int) 1e4;

    int[] q;

    private void run() throws Exception {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i);
        }

        in.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

    long mul;
    Stack<Integer> values;
    HashMap<Character, Integer> map;
    boolean bpGraph[][];
    HashSet<Character> nonzero_holder;
    List<Character> list_of_char;

    int numOfDigits(long m) {
        int count = 0;
        while (m >= 10) {
            m = m / 10;
            count++;
        }

        count++;
        return count;
    }

    int firstDigit(long m) {
        while (m >= 10) {
            m = m / 10;
        }
        return m;
    }

    boolean bpm( int u,  
                boolean seen[], int matchR[]) 
    { 
        for (int v = 0; v < 10; v++) 
        { 
            if (bpGraph[u][v] && !seen[v]) 
            { 
                  
                seen[v] = true;  

                if (matchR[v] < 0 || bpm(matchR[v], 
                                         seen, matchR)) 
                { 
                    matchR[v] = u; 
                    return true; 
                } 
            } 
        } 
        return false; 
    } 

    int[] maxBPM() 
    { 
        int matchR[] = new int[10]; 
  
        for(int i = 0; i < 10; ++i) 
            matchR[i] = -1; 
  
        int result = 0;  
        for (int u = 0; u < 10; u++) 
        { 
            boolean seen[] =new boolean[10] ; 
            for(int i = 0; i < 10; ++i) 
                seen[i] = false; 
  
            if (bpm(u, seen, matchR)) 
                result++; 
        } 
        return matchR; 
    }

    void consbpGraph() {
        bpGraph = new boolean[10][10];
        list_of_char = new ArrayList<>(map.keySet());
        for (int i = 0; i < list_of_char.size(); i++) {
            if (!nonzero_holder.contains(list_of_char.get(i)))
                bpGraph[i][0] = true;
            for (int j = 1; j <= map.get(list_of_char.get(i)); j++) {
                bpGraph[i][j] = true;
            }
        }

        // for (int i = 0; i < list_of_char.size(); i++) {
        //     for (int j = 0; j <= map.get(list_of_char.get(i)); j++) {
        //         System.out.println( bpGraph[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
    }

    private void solve(int t) {
        U = in.nextInt();
        q = new int[Z];
        map = new HashMap<>();
        nonzero_holder = new HashSet<>();
        for (int i = 0; i < Z; i++) {
            long m = in.nextLong();
            String r = in.next();
            nonzero_holder.add(r.charAt(0));
            for (int j = 0; j < r.length(); j++) {
                int x;
                map.putIfAbsent(r.charAt(j), 9);
                x = map.get(r.charAt(j));
                x = Math.min(9, x);
                map.put(r.charAt(j), x);
            }

            if (numOfDigits(m) != r.length())
                continue;

            int x = map.get(r.charAt(0));
            x = Math.min(x, firstDigit(m));
            map.put(r.charAt(0), x);
        }

        // System.out.println(map);
        consbpGraph();
        int[] matchings = maxBPM();
        // CommonDebugCode.printArray(matchings);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < matchings.length;i++)
        {
            map.put(matchings[i],i);
        }

        String ans = "";
        for(int i = 0;i < matchings.length;i++)
        {
            ans += list_of_char.get(matchings[i]);
        }

        out.print("Case #" + t + ": "+ans);
        out.println();
    }

}
