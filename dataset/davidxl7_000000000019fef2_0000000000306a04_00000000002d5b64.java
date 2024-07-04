import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.print("Case #"+i+": ");
            solve(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }
    public static void solve(int R, int S){
        pair[]start = new pair[R*S];
        int loc = 0;
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < R; j++) {
                start[loc]=new pair(j,i);
                loc++;
            }
        }
        int size = R*S;
        LinkedList<state>Q = new LinkedList<>();
        Q.add(new state(R,S, new ArrayList<>(),start));
        while(true){
            state temp = Q.poll();
            //System.out.println(temp.path.size());
            if(done(R,S,temp.situation)){
                System.out.println(temp.path.size());
                for (int i = 0; i < temp.path.size(); i++) {
                    System.out.println(temp.path.get(i).a+" "+temp.path.get(i).b);
                }
                return;
            }
            //System.out.println("YAY");
            for(int a = 1;a<size;a++) {
                for (int b = 1; a + b < size; b++){
                    ArrayList<pair> temppath = new ArrayList<>(temp.path);
                    temppath.add(new pair(a,b));
                    Q.add(new state(R,S,temppath,swap(a,b,temp.situation)));
                    //System.out.println(a+" "+b);
                }
            }
        }

    }
    public static pair[] swap(int a, int b, pair[]tempsits){
        pair[]tempsit = new pair[tempsits.length];
        int loc = 0;
        for (int i = 0; i < b; i++) {
            tempsit[loc]=tempsits[a+i];
            loc++;
        }
        for (int i = 0; i < a; i++) {
            tempsit[loc]=tempsits[i];
            loc++;
        }
        int i = 0;
        while(loc<tempsit.length){
            tempsit[loc]=tempsits[a+b+i];
            loc++;
            i++;
        }
        return tempsit;
    }
    public static boolean done(int R, int S, pair[]check){
        int loc = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if(check[loc].a!=i){
                    return false;
                }
                loc++;
            }
        }
        return true;
    }
    static class state{
        int r, s;
        ArrayList<pair>path;
        pair[]situation;
        public state(int R, int S, ArrayList<pair>Path, pair[]sit){
            r = R;
            s = S;
            path = Path;
            situation = sit;
        }
    }
    static class pair{
        int a, b;
        public pair(int A, int B){
            a = A;
            b = B;
        }
    }

}
