import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static ArrayList<Pair<Integer, Integer>> C = new ArrayList<>();
    static ArrayList<Pair<Integer, Integer>> J = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0;
        while (t-- > 0){
            C.clear();
            J.clear();
            count++;
            int n = sc.nextInt();
            ArrayList<Pair<Integer, Integer>> arr = new ArrayList<>();
            for (int i=0;i<n;i++){
                Pair<Integer, Integer> p = new Pair<>(sc.nextInt(), sc.nextInt());
                arr.add(p);
            }
            String assign = "";
            for (int i=0;i<n;i++){
                if (cisnotbusy(arr.get(i))){
                    assign += "C";
                    C.add(arr.get(i));
                } else if (jisnotbusy(arr.get(i))){
                    assign += "J";
                    J.add(arr.get(i));
                } else {
                    assign = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + count + ": " + assign);
        }
    }

    private static boolean jisnotbusy(Pair<Integer, Integer> p) {
        for(int i=0;i<J.size();i++){
            if (p.getKey() > J.get(i).getKey() && p.getKey() < J.get(i).getValue()){
                return false;
            } else if (p.getValue() > J.get(i).getKey() && p.getValue() < J.get(i).getValue()){
                return false;
            }
        }
        return true;
    }

    private static boolean cisnotbusy(Pair<Integer, Integer> p) {
        for(int i=0;i<C.size();i++){
            if (p.getKey() > C.get(i).getKey() && p.getKey() < C.get(i).getValue()){
                return false;
            } else if (p.getValue() > C.get(i).getKey() && p.getValue() < C.get(i).getValue()){
                return false;
            }
        }
        return true;
    }
}
