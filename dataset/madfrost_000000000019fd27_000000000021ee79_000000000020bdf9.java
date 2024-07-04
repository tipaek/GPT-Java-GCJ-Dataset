
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class Pair<U extends Comparable<U>, V extends Comparable<V>>
            implements Comparable<Pair<U,V>>{

        public final U a;
        public final V b;

        private Pair(U a, V b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;
            if (!a.equals(pair.a))
                return false;
            return b.equals(pair.b);
        }

        @Override
        public int hashCode() {
            return 31 * a.hashCode() + b.hashCode();
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }

        @Override
        public int compareTo(Pair<U, V> o) {
            if(this.a.equals(o.a)){
                return getV().compareTo(o.getV());
            }
            return getU().compareTo(o.getU());
        }
        private U getU() {
            return a;
        }
        private V getV() {
            return b;
        }
    }
    static BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {
            Map<Pair<Integer,Integer>,String> map = new HashMap<>();
            int size = Integer.parseInt(inp.readLine());
            ArrayList<Pair<Integer,Integer>> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                String[] s1 = inp.readLine().split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);
                list.add(new Pair<>(a,b));
                map.put(list.get(i),"");
            }
            ArrayList<Pair<Integer,Integer>> ori = new ArrayList<>(list);
            Collections.sort(list);
//            System.out.println(list);
//            System.out.println(ori);
            String ans = "";
            Pair<Integer,Integer> pairJ = new Pair<>(0,0);
            Pair<Integer,Integer> pairC = new Pair<>(0,0);

            for(int i=0;i<size;i++){
                if(pairC.b<=list.get(i).a && !map.get(list.get(i)).equals("C")){
                    pairC = list.get(i);
                    map.put(pairC,"C");
                }
                else if(pairJ.b<=list.get(i).a && !map.get(list.get(i)).equals("J")){
                    pairJ = list.get(i);
                    map.put(pairJ,"J");
                }
                else{
                    break;
                }
            }

            boolean check = true;
            for(int i=0;i<size;i++){
                if(map.get(ori.get(i))!="") {
                    ans += map.get(ori.get(i));
                }
                else{
                    check = false;
                }
            }

            if(!check){
                out.write("Case #"+(t+1)+":"+" "+"IMPOSSIBLE"+"\n");
            }
            else{
                out.write("Case #"+(t+1)+":"+" "+ans+"\n");
            }

        }
        out.flush();
    }
}
