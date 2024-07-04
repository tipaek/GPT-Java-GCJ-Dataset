// 
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.math.*;
import java.util.*;
import java.io.*;
  
public class Solution { 
  
    static int test = 10; // 0 for local testing, 1 for std input
	static int[][] dirs = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);
    static String file = "../in";
    static int inf = 1_000_000;

    static void swap(int[]ary, int i, int j)
    {
        int t = ary[i];
        ary[i] = ary[j];
        ary[j] = t;
    }
    
    static String[] split() throws Exception
    {
        return in.readLine().split(" ");
    }

    static int readInt() throws Exception
    {
        return Integer.valueOf(in.readLine());
    }

    static int[] toIntArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        int[] ary = new int[n];
        for(int i = 0; i < n; i++) ary[i] = Integer.valueOf(sp[i]);
        return ary;
    }

    static long[] toLongArray() throws Exception
    {
        String[] sp = split();
        int n = sp.length;
        long[] ary = new long[n];
        for(int i = 0; i < n; i++) ary[i] = Long.valueOf(sp[i]);
        return ary;
    }    

    public static void main(String[] args) throws Exception
    {
        int _k = Integer.valueOf("1");
        if(test > 0) in = new BufferedReader(new InputStreamReader(System.in));
        else in = new BufferedReader(new FileReader(file));
        if(test < 0) {String[] str = in.readLine().split(" ");}

        
        
        /****************************************************/  
        /****************************************************/
        /****************************************************/
        /****************************************************/

        int t = readInt();
        
        for(int tt = 1; tt <= t; tt++)
        {
            
            int N = readInt();
            //System.out.println(N);
            int[][] arr = new int[N+2][N+2];
            arr[1][1] = 1; arr[2][1] = 1;
            Set<Integer> unvit = new HashSet<>();
            // Set<int[]> unvit = new HashSet<>();
            // unvit.add(new int[] {1, 1}); unvit.add(new int[] {1, 1}); 
            unvit.add(N+1); unvit.add(N+2); 
            for (int i = 2; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                	// unvit.add(new int[]{i, j});
                	// unvit.add(i*N+j);
                	if (j == 1) arr[i][j] = 1;
                    else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                	unvit.add(i*N+j);
                }
            }
            // for (int i = 1; i <= N; i++) {
            //     for (int j = 1; j <= i; j++) {
            //         if (arr[i][j] == 0) {
            //             System.out.print("  ");
            //         } else {
            //             System.out.print(arr[i][j] + " ");
            //         }
            //     }
            //     System.out.println();
            // }
            // for (int[] a : unvit) {
            // 	System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
            // }
			// System.out.println(unvit);
            
            List<int[]> list = new ArrayList<>();
            Deque<int[]> q = new ArrayDeque<>();
            q.offerLast(new int[]{1, 1});
            list.add(new int[]{1, 1});
        	// unvit.remove(new int[]{1, 1});
        	unvit.remove(N+1);
        	int sum = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = q.pollFirst();
                    // list.add(cur);
                    if (sum == N) break;
                    sum += arr[cur[0]][cur[1]];
                    
                    for (int[] dir : dirs) {
                        int x = dir[0] + cur[0], y = dir[1] + cur[1];
                        if(x < 1 || y < 1 || x >= N+1 || y >= N+1 || arr[x][y] == 0) continue;
                        int[] newarr = {x, y};
                        if (unvit.contains(x*N+y)) {
                        	q.offerLast(newarr);
                        	list.add(newarr);
                        	unvit.remove(x*N+y);
                        	//unvit.remove(newarr);
                  
                        }
                    }
                }
            }
            // for (int[] a : list) {
            // 	System.out.print(Arrays.stream(a).boxed().collect(Collectors.toList()) + " ");
            // }
            // System.out.println(sum);
            List<int[]> res = new ArrayList<>();
            res.add(list.get(list.size()-1));
            for (int i = list.size()-1; i >= 1; i--) {
            	int[] bef = list.get(i - 1); int[] aft = list.get(i);
            	if (isNeig(bef[0], bef[1], aft[0], aft[1])){
            		res.add(bef);
            	}
            }
            Collections.reverse(res);
			// for (int[] a : res) {
   //         	System.out.print(Arrays.stream(a).boxed().collect(Collectors.toList()) + " ");
   //         }
                
            String ss = "\n";
            for (int[] a : res) {
            	//ss += Arrays.stream(a).boxed().collect(Collectors.toList()).toString();
            	// ss += a[0];
            	// ss += " ";
            	// ss += a[1];
            	// ss += '\n';
            	ss += (a[0] + " " + a[1] + '\n');
            }
            out.printf("Case #%d: %s\n", tt, ss);
        }
        /****************************************************/
        /****************************************************/
        /****************************************************/
        /****************************************************/
        out.flush();
    }
    static boolean isNeig(int x1, int y1, int x2, int y2) {
    	for (int[] dir : dirs) {
    		if (dir[0] + x1 == x2 || dir[1] + y1 == y2) return true;
    	}
    	return false;
    }

    static int dfs(Trie root, int len, int k)
    {
        
        if(root == null) return 0;
        int count = root.strCount;
        int re = 0;

        for(int i = 0; i < 26; i++)
        {
            int ans = dfs(root.child[i], len + 1, k);
            if(ans > 0)
            {
                count -= (root.child[i].strCount / k) * k;
                re += ans;
            }
        }
        
        re += len * (count / k);
        return re;
    }

    static class Trie
    {
        Trie[] child = new Trie[26];
        int strCount = 0;

        void insert(String str)
        {
            Trie root = this;
            for(char c : str.toCharArray())
            {
                if(root.child[c - 'A'] == null) root.child[c - 'A'] = new Trie();
                root = root.child[c - 'A'];
                root.strCount++;
            }
        }
    }
}