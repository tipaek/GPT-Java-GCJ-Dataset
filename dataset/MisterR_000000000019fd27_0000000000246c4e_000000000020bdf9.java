import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Pair>> lists = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        for(int j = 0; j < n; j++) {
            List<Pair> list = new ArrayList<>();
            int nn = sc.nextInt();
            for (int i = 0; i < nn; i++) {
                list.add(new Pair(sc.nextInt(), sc.nextInt(), '0', i));
            }
            sort(list);
            lists.add(list);
        }
        for(int i = 0; i < lists.size(); i++){
            int cc = 0;
            int jj = 0;
            for(int j = 0; j < lists.get(i).size(); j++){
                if(cc <= lists.get(i).get(j).s){
                    cc = lists.get(i).get(j).e;
                    lists.get(i).get(j).chart = 'C';
                }else if(jj  <= lists.get(i).get(j).s){
                    jj = lists.get(i).get(j).e;
                    lists.get(i).get(j).chart = 'J';
                }else break;
            }
            Pair.changer = false;
            sort(lists.get(i));
            Pair.changer = true;
            String s = "";
            for(int j = 0; j < lists.get(i).size(); j++){
                s += lists.get(i).get(j).chart;
                if(lists.get(i).get(j).chart == '0'){
                    s = "IMPOSSIBLE";
                    break;
                }
            }
            answers.add(s);
        }
        for(int i = 0; i < n; i++){
            System.out.println("Case #" + (i + 1) + ": " + answers.get(i));
        }
    }
}


class Pair implements Comparable{
    Integer s;
    Integer e;
    Character chart;
    Integer num;
    static Boolean changer = true;

    public Pair(Integer s, Integer e, Character chart, Integer num) {
        this.s = s;
        this.e = e;
        this.chart = chart;
        this.num = num;
    }

    public Pair() {
    }

    @Override
    public int compareTo(Object o) {
        if(changer) {
            Pair c = (Pair) o;
            if (c.s < this.s) {
                return 1;
            }
            if (c.s > this.s) {
                return -1;
            }
            return 0;
        }else {
            Pair c = (Pair) o;
            if (c.num < this.num) {
                return 1;
            }
            if (c.num > this.num) {
                return -1;
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Pair{" +
                "s=" + s +
                ", e=" + e +
                ", chart=" + chart +
                ", num=" + num +
                '}';
    }
}
