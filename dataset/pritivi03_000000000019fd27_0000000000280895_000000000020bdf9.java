import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for (int i = 1; i <= tc; i++) {
            int numTasks = in.nextInt();
            ArrayList<Pair> cList = new ArrayList<>();
            ArrayList<Pair> jList = new ArrayList<>();
            boolean impossible = false;
            String builder = "";
            for (int j = 0; j < numTasks; j++) {
                Pair newTask = new Pair (in.nextInt(), in.nextInt());
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
                        builder += "J";
                        //System.out.println(cList);
                    }
                } else {
                    //assign to c
                    //System.out.println("Assigning to C");
                    cList.add(newTask);
                    builder += "C";
                    //System.out.println(cList);
                }
            }
            if (!impossible)
                System.out.println("Case #" + i + ": " + builder.toString());
        }
    }

    static boolean overlap(ArrayList<Pair> arr, Pair pairAdd) {
        ArrayList<Pair> copy = new ArrayList<>(arr);
        copy.add(pairAdd);
        for (int i = 0; i < copy.size(); i++) {
          for (int j = i+1; j < copy.size(); j++) {
            if (copy.get(i).getEnd() > copy.get(j).getStart() && copy.get(i).getStart() < copy.get(j).getEnd())
              return true;
          }
        }
        return false;
    }
    
    class Pair {
        int start = 0;
        int end = 0;
        Pair (int start, int end) {
            this.start = start;
            this.end = end;
        }
        int getStart() { return this.start; }
        int getEnd() { return this.end; }
    }
}



