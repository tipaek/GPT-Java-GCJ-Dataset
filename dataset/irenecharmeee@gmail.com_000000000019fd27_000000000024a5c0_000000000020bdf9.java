
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pair<T, E> {
    private T data1;
    private E data2;
    Pair(T data1, E data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    T getKey(){
        return data1;
    }
    E getValue(){
        return data2;
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int T = Integer.parseInt(input);
        String onDuty = "C";
        int overlaps = 0;
        for (int i = 0; i < T; i++) {
            char[] output;
            int Cam = 0;
            int Jes = 0;
            boolean poss= true;
            int tasksNum = Integer.parseInt(reader.readLine());
            ArrayList<Pair<Pair<Integer,Integer>, Integer> >tasks = new ArrayList<>();
            output = new char[tasksNum];
            Comparator<Pair<Pair<Integer,Integer>, Integer>> comparator = new Comparator<Pair<Pair<Integer, Integer>, Integer>>() {
                @Override
                public int compare(Pair<Pair<Integer, Integer>, Integer> a, Pair<Pair<Integer, Integer>, Integer> b) {
                    if ((a.getKey()).getValue() > b.getKey().getValue()) {
                        return 1;
                    } else if (a.getKey().getValue() == b.getKey().getValue()){
                        return 0;
                    } else {
                        return -1;
                    }
                }
            };
            for (int j = 0; j < tasksNum; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                Pair<Integer, Integer> temp = new Pair<>(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()
                ));
                tasks.add(new Pair<Pair<Integer, Integer>,Integer>(temp,j));
            }
            tasks.sort(comparator);
            for(Pair<Pair<Integer,Integer>, Integer> p: tasks) {
                if (p.getKey().getKey()  >= Cam && p.getKey().getKey() >= Jes) {
                    if (Cam >= Jes) {
                        Cam = p.getKey().getValue();
                        output[p.getValue()] = 'C';
                    } else {
                        Jes =p.getKey().getValue();
                        output[p.getValue()] = 'J';
                    }
                } else if (p.getKey().getKey() >= Cam) {
                    Cam = p.getKey().getValue();
                    output[p.getValue()] = 'C';
                } else if (p.getKey().getKey() >= Jes) {
                    Jes = p.getKey().getValue();
                    output[p.getValue()] = 'J';
                } else {
                    poss = false;
                }

                if (!poss) {
                    break;
                }

            }
            if (!poss) {
                System.out.printf("Case #%d: %s\n", (i+1), "IMPOSSIBLE");
            } else {
                String s = new String(output);
                System.out.printf("Case #%d: %s\n", (i+1), s);
            }

        }


    }
}
