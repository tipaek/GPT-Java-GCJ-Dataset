
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;

/**
 *
 * @author lap13310
 */
public class Solution {

    public static void main(String[] args)  {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner((new File("/home/lap13310/NetBeansProjects/CodeJam2020/input/qualification/test3")));
        int numTest = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int n = 1; n <= numTest; ++n) {
            int numJob = in.nextInt();
            List<Job> listJob = new ArrayList<>();
            for (int i = 0; i < numJob; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                listJob.add(new Job(i, startTime, endTime));
            }
            Comparator<Job> sortByEndtime = (Job j1, Job j2) -> {
                if (j1.startTime == j2.startTime) {
                    return j1.endTime - j2.endTime;
                } else {
                    return j1.startTime - j2.startTime;
                }
            };
            Collections.sort(listJob, sortByEndtime);
            listJob.get(0).owner = "C";
            boolean isPossible = assignJob(listJob);
//            System.out.println(listJob);
            if (isPossible) {
                Comparator<Job> sortByIndex = (Job j1, Job j2) -> {
                    return j1.index - j2.index;
                };
                Collections.sort(listJob, sortByIndex);
                String ret = "";
                for (Job job : listJob) {
                    ret += job.owner;
                }
                System.out.println("Case #" + n + ": " + ret);
            } else {
                System.out.println("Case #" + n + ": " + "IMPOSSIBLE");
            }
        }
    }

    static boolean assignJob(List<Job> listJob) {
        int cCurrentJobIndex = 0;
        int jCurrentJobIndex = -1;
        int numJobAssigned = 1;
        for (int i = 1; i < listJob.size(); i++) {
            if (listJob.get(i).startTime >= listJob.get(cCurrentJobIndex).endTime) {
                listJob.get(i).owner = "C";
                cCurrentJobIndex = i;
                numJobAssigned++;
                continue;
            }
            if (jCurrentJobIndex == -1 && listJob.get(i).owner.isEmpty()) {
                listJob.get(i).owner = "J";
                jCurrentJobIndex = i;
                numJobAssigned++;
                continue;
            }
            if (listJob.get(i).startTime >= listJob.get(jCurrentJobIndex).endTime) {
                listJob.get(i).owner = "J";
                jCurrentJobIndex = i;
                numJobAssigned++;
                continue;
            }
        }
        return numJobAssigned == listJob.size();
    }

    static class Job {

        int startTime;
        int endTime;
        int index;
        String owner = "";

        public Job(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "startTime: " + startTime + " endTime: " + endTime + " owner: " + owner; //To change body of generated methods, choose Tools | Templates.
        }

    }
}
