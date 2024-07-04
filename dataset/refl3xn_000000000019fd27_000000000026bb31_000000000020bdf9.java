import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static ArrayList<ArrayList<Integer>> C = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> J = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0;
        while (t-- > 0){
            C.clear();
            J.clear();
            count++;
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (int i=0;i<n;i++){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(sc.nextInt());
                temp.add(sc.nextInt());
                arr.add(temp);
            }
            String assign = calculate(arr, 0);
            if (assign.contains("IMPOSSIBLE")) {
                System.out.println("Case #" + count + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + count + ": " + assign);
            }
        }
    }

    private static String calculate(ArrayList<ArrayList<Integer>> arr, int i) {
        if (arr.size() == i){
            return "";
        }
        if (cisnotbusy(arr.get(i))){
            C.add(arr.get(i));
            String temp = calculate(arr, i+1);
            if (!temp.contains("IMPOSSIBLE")){
                return "C" + temp;
            } else {
                C.remove(C.size()-1);
            }
        }
        if (jisnotbusy(arr.get(i))){
            J.add(arr.get(i));
            String temp = calculate(arr, i+1);
            if (!temp.contains("IMPOSSIBLE")){
                return "J" + temp;
            } else {
                J.remove(J.size()-1);
            }
        }
        return "IMPOSSIBLE";
    }

    private static boolean jisnotbusy(ArrayList<Integer> p) {
        for(int i=0;i<J.size();i++){
            if ((p.get(0) > J.get(i).get(0) && p.get(0) < J.get(i).get(1)) || (p.get(1) > J.get(i).get(0) && p.get(1) < J.get(i).get(1))){
                return false;
            } else if (p.get(0) == J.get(i).get(0) || p.get(1) == J.get(i).get(1)){
                return false;
            }
        }
        return true;
    }

    private static boolean cisnotbusy(ArrayList<Integer> p) {
        for(int i=0;i<C.size();i++){
            if ((p.get(0) > C.get(i).get(0) && p.get(0) < C.get(i).get(1)) || (p.get(1) > C.get(i).get(0) && p.get(1) < C.get(i).get(1))){
                return false;
            } else if (p.get(0) == C.get(i).get(0) || p.get(1) == C.get(i).get(1)){
                return false;
            }
        }
        return true;
    }
}
