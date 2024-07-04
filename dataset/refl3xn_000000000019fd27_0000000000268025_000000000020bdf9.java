import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
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

    private static boolean jisnotbusy(ArrayList<Integer> p) {
        for(int i=0;i<J.size();i++){
            if (p.get(0) > J.get(i).get(0) && p.get(0) < J.get(i).get(1)){
                return false;
            } else if (p.get(0) > J.get(i).get(0) && p.get(0) < J.get(i).get(1)){
                return false;
            }
        }
        return true;
    }

    private static boolean cisnotbusy(ArrayList<Integer> p) {
        for(int i=0;i<C.size();i++){
            if (p.get(0) > C.get(i).get(0) && p.get(0) < C.get(i).get(1)){
                return false;
            } else if (p.get(0) > C.get(i).get(0) && p.get(0) < C.get(i).get(1)){
                return false;
            }
        }
        return true;
    }
}
