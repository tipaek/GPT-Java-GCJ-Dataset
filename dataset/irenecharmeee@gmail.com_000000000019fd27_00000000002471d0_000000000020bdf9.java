import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int T = Integer.parseInt(input);
        String onDuty = "C";
        int overlaps = 0;
        String output;
        for (int i = 0; i < T; i++) {
            output = "";
            int Cam = 0;
            int Jes = 0;
            boolean poss= true;
            int tasksNum = Integer.parseInt(reader.readLine());
            ArrayList<Pair<Integer,Integer>> tasks = new ArrayList<>();
            Comparator<Pair<Integer,Integer>> comparator = new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                    if (a.getValue() > b.getValue()) {
                        return 1;
                    } else if (a.getValue() == b.getValue()){
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
                tasks.add(temp);
            }
            tasks.sort(comparator);
            for(Pair<Integer,Integer> p: tasks) {
                if (p.getKey()  >= Cam && p.getKey() >= Jes) {
                    if (Cam >= Jes) {
                        Cam = p.getValue();
                        output += "C";
                    } else {
                        Jes =p.getValue();
                        output = "J";
                    }
                } else if (p.getKey() >= Cam) {
                    Cam = p.getValue();
                    output +="C";
                } else if (p.getKey() >= Jes) {
                    Jes = p.getValue();
                    output += "J";
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
                System.out.printf("Case #%d: %s\n", (i+1), output);
            }

        }


    }
}
