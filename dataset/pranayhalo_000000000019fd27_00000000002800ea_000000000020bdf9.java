import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner std = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = std.nextInt();
        std.nextLine();
        int caseN = 0;
        while (caseN++ < t) {
            int n = std.nextInt();
            HashSet<Integer> C = new HashSet<>();
            TreeMap<Integer, ArrayList<Integer>> allJobs = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int s = std.nextInt();
                int e = std.nextInt();
                if (allJobs.get(s) == null) {
                    allJobs.put(s, new ArrayList<>());
                }
                allJobs.get(s).add(i);

                if (allJobs.get(e) == null) {
                    allJobs.put(e, new ArrayList<>());
                }
                allJobs.get(e).add(i);
            }
            TreeSet<Integer> currentJobs = new TreeSet<>();
            boolean terminate = false;

            while(!allJobs.isEmpty()) {
                int val = allJobs.firstKey();
                ArrayList<Integer> elems = allJobs.get(val);
                boolean[] remElemed = new boolean[elems.size()];
                //System.out.println("elems: " + elems);
                allJobs.remove(val);
                for (int i = 0; i < elems.size(); i++) {
                    int elem = elems.get(i);
                    if (currentJobs.contains(elem)) {
                        currentJobs.remove(elem);
                        remElemed[i] = true;
                    }
                }
                for (int i = 0; i < elems.size(); i++) {
                    int elem = elems.get(i); //the job I am trying to add or remove, depending if it already exists...
                    //System.out.println("trying: " + elem);
                    if (!remElemed[i]) {
                         //add a job... First of all, if there are already two jobs, it is impossible
                        if (currentJobs.size() == 0) {
                            C.add(elem);
                        } else if (currentJobs.size() == 2) {
                            terminate = true;
                            break;
                        } else {
                            if (!C.contains(currentJobs.first())) {
                                C.add(elem);
                            }
                        }
                        currentJobs.add(elem);
                    }
                    //System.out.println(currentJobs);
                }
                if (terminate) {
                    break;
                }
            }
            if (terminate) {
                log.write("Case #" + caseN + ": IMPOSSIBLE" + "\n");
            } else {
                log.write("Case #" + caseN + ": ");
                for (int i = 0; i < n; i++) {
                    if (C.contains(i)) {
                        log.write("C");
                    } else {
                        log.write("J");
                    }
                }
                log.write("\n");
            }
        }
        log.flush();
    }
}
