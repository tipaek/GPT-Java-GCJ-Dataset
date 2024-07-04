import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    LinkedList<Character> assigment = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= x; i++) {
            int n = Integer.parseInt(sc.nextLine());
            LinkedList<int[]> jobs = new LinkedList<>();
            LinkedList<int[]> jobsC = new LinkedList<>();
            LinkedList<int[]> jobsJ = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                String string = sc.nextLine();
                String[] arr = string.split(" ");
                int[] job = new int[2];
                job[0] = Integer.parseInt(arr[0]);
                job[1] = Integer.parseInt(arr[1]);
                jobs.add(job);
            }
            LinkedList<int[]> unsortedJobs = new LinkedList<>(jobs);
            jobs.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0] - t1[0];
                }
            });
            int endC = 0;
            int endJ = 0;
            boolean notPossible = false;
            StringBuilder str = new StringBuilder();
            for (int[] arr : jobs) {
                if (arr[0] >= endC) {
                    jobsC.add(arr);
                    endC = arr[1];
                } else if (arr[0] >= endJ) {
                    jobsJ.add(arr);
                    endJ = arr[1];
                } else {
                    notPossible = true;
                    break;
                }
            }
            if (notPossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                for(int [] arr: unsortedJobs){
                    int k = contains(arr, jobsC);
                    if(k  != -1){
                        str.append('C');
                        jobsC.remove(k);
                    }else {
                        int m = contains(arr, jobsJ);
                        str.append('J');
                        jobsJ.remove(m);
                    }
                }
                System.out.println("Case #" + i + ": "+str.toString());
            }
        }
    }
    
    public static int contains(int[]arr, LinkedList<int[]> jobs){
        for (int [] ar: jobs){
            if(ar[0] == arr[0] && ar[1] == arr[1]){
                return jobs.indexOf(ar);
            }
        }
        return -1;
    }
}