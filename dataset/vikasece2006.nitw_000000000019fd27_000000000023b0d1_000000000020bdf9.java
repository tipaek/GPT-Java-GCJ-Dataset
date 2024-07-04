
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        outer:for (int t = 0; t < test; t++) {
            int no = Integer.parseInt(br.readLine());
            int[][] date = new int[no][];
            List<Pair> pairs = new ArrayList<>();
            for (int index = 0; index < no; index++) {
                date[index] = getArray(br.readLine());
                pairs.add(new Pair(date[index][0], date[index][1], index));
            }
            Collections.sort(pairs);
            if(pairs.size()==1){
                System.out.println("J");
                continue outer;
            }
            int JEnd = pairs.get(0).end;
            int CEnd = pairs.get(1).end;
            pairs.get(0).owner = 'J';
            pairs.get(1).owner='C';
            for(int index=2;index < pairs.size();index++){
                Pair p = pairs.get(index);
                if(p.start < JEnd && p.start < CEnd){
                    System.out.println("IMPOSSIBLE");
                    continue outer;
                }else if(p.start < JEnd){
                    p.owner = 'C';
                    CEnd = p.end;
                }else{
                    p.owner = 'J';
                    JEnd = p.end;
                }
            }
            Collections.sort(pairs, new Comparator<Pair>() {
                @Override
                public int compare(Pair pair, Pair t1) {
                    return Integer.compare(pair.index,t1.index);
                }
            });
            StringBuilder builder = new StringBuilder();
            for(Pair p : pairs){
                builder.append(p.owner);
            }
            System.out.println(builder.toString());
        }
    }

    private static class Pair implements Comparable<Pair> {
        int start;
        int end;
        int index;

        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        char owner;

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(this.start, pair.start);
        }
    }

    private static int[] getArray(String line) {
        String[] s = line.split(" ");
        int[] array = new int[s.length];
        int index = 0;
        for (String temp : s) {
            array[index++] = Integer.parseInt(temp);
        }
        return array;
    }
}
