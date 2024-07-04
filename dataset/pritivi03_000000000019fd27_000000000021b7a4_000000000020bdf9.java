import java.util.*;
import java.io.*;
import javafx.util.Pair;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for (int i = 1; i <= tc; i++) {
            int numTasks = in.nextInt();
            ArrayList<Pair<Integer, Integer>> cList = new ArrayList<>();
            ArrayList<Pair<Integer, Integer>> jList = new ArrayList<>();
            boolean impossible = false;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < numTasks; j++) {
                Pair <Integer, Integer> newTask = new Pair <Integer, Integer> (in.nextInt(), in.nextInt());
                //System.out.println(newTask.getKey() + " " + newTask.getValue());
                if (overlap(cList, newTask)) {//try to assign to c
                    if (overlap(jList, newTask)) {
                        //this is impossible
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else {
                        //assign to j
                        //System.out.println("Assigning to J");
                        jList.add(newTask);
                        builder.append("J");
                        //System.out.println(cList);
                    }
                } else {
                    //assign to c
                    //System.out.println("Assigning to C");
                    cList.add(newTask);
                    builder.append("C");
                    //System.out.println(cList);
                }
            }
            if (!impossible)
                System.out.println("Case #" + i + ": " + builder.toString());
        }
    }

    static boolean overlap(ArrayList<Pair<Integer,Integer>> arr, Pair<Integer, Integer> pairAdd) {
        ArrayList<Pair<Integer,Integer>> copy = new ArrayList<>(arr);
        copy.add(pairAdd);
        Collections.sort(copy, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (int i = 1; i < copy.size(); i++)
            if (copy.get(i - 1).getValue() > copy.get(i).getKey())
                return true;

        return false;
    }
}

