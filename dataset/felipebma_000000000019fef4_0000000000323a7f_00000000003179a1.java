import java.util.*;

public class Solution {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int nCases = in.nextInt();
        for(int i=1;i<=nCases;i++){
            solve(i);
        }
    }

    private static void solve(int nCase){
        System.out.printf("Case #%d: ", nCase);
        long u = in.nextLong();
        long n = (long)1e4, m;
        String r;
        HashSet<Character>[] map = new HashSet[10];
        HashSet<Character> letters = new HashSet<Character>();
        for(int i=0;i<10;i++){
            map[i] = new HashSet<Character>();
            for(char c='A';c<='Z';c++){
                map[i].add(c);
            }
        }
        for(int i=0;i<n;i++){
            m = in.nextInt();
            r = in.next();
            compute(m,r,map,letters);
        }
        char[] ans = new char[10];
        Arrays.fill(ans,'a');
        for(int h=0;h<10;h++){
            for(int i=0;i<10;i++){
                Iterator it = map[i].iterator();
                while(it.hasNext()){
                    if(!letters.contains(it.next())){
                        it.remove();
                    }
                }
                if(map[i].size()==1){
                    char c = map[i].iterator().next();
                    ans[i] = c;
                    for(int j=0;j<10;j++){
                        map[j].remove(c);
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(char c:ans) result.append(c);
        System.out.println(result.toString());
    }

    public static void compute(long m, String r, HashSet<Character>[] map, HashSet<Character> letters){
        if(m==-1) return;
        for(int i=0;i<26 && i<r.length();i++){
            char c = r.charAt(i);
            letters.add(c);
        }
        long pot = 0, aux = m;
        int last = 0;
        while(aux>0){
            pot++;
            last = (int)(aux % 10);
            aux/=10;
        }
        char c = r.charAt(0);
        if(r.length()<pot){
            return;
        }
        for(int i=last+1;i<10;i++){
            map[i].remove(c);
        }
        if(pot>0){
            map[0].remove(c);
        }

    }


}