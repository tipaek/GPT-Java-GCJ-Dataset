import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #" + t + ": ");
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int N = sc.nextInt();
        long[] X = new long[N];
        long[] Y = new long[N];
        List<Poi> pois = new ArrayList<>();
        for(int i=0;i<N;i++){
            X[i] = sc.nextLong();
            Y[i] = sc.nextLong();
            pois.add(new Poi(X[i],Y[i]));
        }

        Map<Angle, Set<Integer>> mp = new HashMap<>();
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                Angle ang = new Angle(pois.get(i),pois.get(j));
                mp.putIfAbsent(ang, new HashSet<>());
                mp.get(ang).add(i);
                mp.get(ang).add(j);
            }
        }
        int max=0;
        for(Set<Integer> vsets:mp.values()){
            max = Math.max(vsets.size(), max);
        }
        max += 2;
        if(max > N){
            max = N;
        }
        System.out.println(max);
    }




    private static class Pair{
        int a, b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

    }

    private static class Angle{
        Poi ang;
        Angle(final Poi a,final Poi b){
            Poi p, q;
            if(a.x == b.x){
                ang = new Poi(0, 100);
                return;
            }
            if(a.y == b.y){
                ang = new Poi(100, 0);
                return;
            }
            if(a.x > b.x){
                p = b;
                q = a;
            }else{
                p = a;
                q = b;
            }
            boolean rev = false;
            long difx, dify;
            if(q.y-p.y < 0){
                rev = true;
                dify = p.y-q.y;
            }else{
                dify = q.y-p.y;
            }
            difx = q.x-p.x;
            long lcm = lcm(difx, dify);
            if(rev){
                ang = new Poi(difx / lcm, -dify / lcm);
            }else{
                ang = new Poi(difx/lcm, dify/lcm);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Angle angle = (Angle) o;
            return ang.equals(angle.ang);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ang);
        }

        private static long lcm(long a, long b){
            if(a > b){
                return lcm(b , a);
            }else{//a <= b
                if(b % a == 0){
                    return a;
                }else {
                    return lcm(b % a, a);
                }
            }
        }
    }
    private static class Poi{
        long x, y;
        Poi(long x,long y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Poi poi = (Poi) o;
            return x == poi.x &&
                    y == poi.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
