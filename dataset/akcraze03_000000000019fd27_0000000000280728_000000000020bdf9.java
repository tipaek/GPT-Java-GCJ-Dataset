import java.util.*;
import java.io.*;

public class parentingPartner {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("parenting.in"));
        int tc = in.nextInt();
        for (int i = 1; i <= tc; i++) {
            int numTasks = in.nextInt();
            ArrayList<Pair> cList = new ArrayList<>();
            ArrayList<Pair> jList = new ArrayList<>();
            boolean impossible = false;
            StringBuilder builder = new StringBuilder();
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

    static boolean overlap(ArrayList<Pair> arr, Pair pairAdd) {
        ArrayList<Pair> copy = new ArrayList<>(arr);
        copy.add(pairAdd);
        //Collections.sort(copy, new PairCompare());
        for (int i = 1; i < copy.size(); i++)
            if (copy.get(i - 1).getValue() > copy.get(i).getKey())
                return true;

        return false;
    }
}

class Pair {
    int key = 0;
    int value = 0;
    Pair (int key, int value) {
        this.key = key;
        this.value = value;
    }
    int getKey() { return this.key; }
    int getValue() { return this.value; }
}

/*class PairCompare implements Comparator<Pair> {
    public int compare(Pair o1, Pair o2) {
        return o1.getKey() - o2.getKey();
    }
}*/
