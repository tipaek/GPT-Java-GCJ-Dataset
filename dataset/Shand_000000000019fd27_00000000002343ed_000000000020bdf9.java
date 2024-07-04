import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int tests;
        Scanner s = new Scanner(System.in);
        tests = s.nextInt();
        for(int t=0;t<tests;t++) {
            int n = s.nextInt();
            ArrayList<Pair<Integer,Integer>> jobs = new ArrayList<>();
            ArrayList<Pair<Integer,Integer>> c = new ArrayList<>(), j = new ArrayList<>();
            for(int i=0;i<n;i++) {
                int start = s.nextInt();
                int end = s.nextInt();
                jobs.add(new Pair<>(start,end));
            }
            Comparator<Pair<Integer,Integer>> byName =
                    (Pair<Integer,Integer> o1, Pair<Integer,Integer> o2)->o1.getValue() - (o2.getValue());
            ArrayList<Pair<Integer,Integer>> jobsCopy = (ArrayList<Pair<Integer,Integer>>)jobs.clone();
            jobs.sort(byName);
            int index=0;
            c.add(jobs.remove(0));
            while(index<jobs.size()) {
                if(c.get(c.size()-1).getValue() <= jobs.get(index).getKey())
                    c.add(jobs.remove(index));
                else
                    index++;
            }
            index=0;
            if(jobs.size()>0) {
                j.add(jobs.remove(0));
                while (index < jobs.size()) {
                    if (j.get(j.size() - 1).getValue() <= jobs.get(index).getKey())
                        j.add(jobs.remove(index));
                    else
                        index++;
                }
            }
            if(jobs.size()>0) {
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
                return;
            }

            System.out.print("Case #"+(t+1)+": ");
            for(int i =0;i<jobsCopy.size();i++) {
                if(c.contains(jobsCopy.get(i)))
                    System.out.print("C");
                else
                    System.out.print("J");
            }
        }
    }
}
