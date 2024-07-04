import java.util.*;

class Pair {
    int s, e;
}

class Solution {
    
    static boolean overlaps(Pair p1, Pair p2) {
        return p1.s < p2.e && p1.e > p2.s;
    }
    
    static int color[];
    
    // start BFS from i
    static boolean solve(Set<Integer> G[], int i) {
        
        int n = G.length;
        LinkedList<Integer> q = new LinkedList();
        color[i] = 0;
        q.add(i);
        
        while(q.size() > 0) {
            int u = q.remove();
            
            for(int v : G[u]) {
                if(color[v] == -1) {    // unpainted
                    color[v] = color[u] ^ 1;
                    q.add(v);
                }
                else {
                    if(color[v] == color[u])
                        return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            
            int n = sc.nextInt();
            Pair nodes[] = new Pair[n];
            Set<Integer> G[] = new HashSet[n];
            color = new int[n];
            Arrays.fill(color, -1);
            
            for(int i = 0; i < n; i++) {
                G[i] = new HashSet();
                int s = sc.nextInt();
                int e = sc.nextInt();
                Pair p = new Pair();
                p.s = s;
                p.e = e;
                nodes[i] = p;
            }
            
            for(int i = 0; i < n; i++)
            for(int j = i+1; j < n; j++)
                if(overlaps(nodes[i], nodes[j])) {
                    G[i].add(j);
                    G[j].add(i);
                }
                
            boolean possible = true;
            for(int i = 0; i < n; i++) {
                if(color[i] == -1)
                    possible = possible && solve(G, i);
                if(!possible)
                    break;
            }
            
            if(!possible)
                System.out.printf("Case #%d: %s\n", t, "IMPOSSIBLE");
            else {
                StringBuilder ans = new StringBuilder();
                for(int i = 0; i < n; i++)
                    if(color[i] == 0)
                        ans.append('C');
                    else
                        ans.append('J');
                System.out.printf("Case #%d: %s\n", t, ans);
            }
        }
    }
}