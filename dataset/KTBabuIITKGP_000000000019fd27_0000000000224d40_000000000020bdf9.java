import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            Job[] jobs = new Job[N];
            List<Job>[] start = new List[24*60+1];
            List<Job>[] end = new List[24*60+1];

            for(int i=0; i<N; i++){
                jobs[i] = new Job(sc.nextInt(), sc.nextInt());
                if (start[jobs[i].s] == null){
                    start[jobs[i].s] = new ArrayList<>();
                }
                if (end[jobs[i].s] == null){
                    end[jobs[i].s] = new ArrayList<>();
                }
                start[jobs[i].s].add(jobs[i]);
                end[jobs[i].e].add(jobs[i]);
            }

            boolean C_is_free = false;
            boolean J_is_free = false;
            boolean isImpossible = false;

            for(int i=0; i<start.length && !isImpossible; i++){
                if (end[i] != null){
                    for (Job job: end[i]){
                        if (job.isAssignedToC()){
                            C_is_free = true;
                        }else {
                            J_is_free = true;
                        }
                    }
                }

                if (start[i] != null) {
                    for (Job job: start[i]) {
                        if (C_is_free) {
                            job.assignToC();
                            C_is_free = false;
                        }else if (J_is_free) {
                            job.assignToJ();
                            J_is_free = false;
                        }else {
                            isImpossible = true;
                            break;
                        }
                    }
                }
            }
            StringBuilder s = new StringBuilder("Case #").append(t).append(": ");
            if (isImpossible) {
                System.out.println(s.append("IMPOSSIBLE"));
            }else {
                for (Job job: jobs){
                    if (job.isAssignedToC()){
                        s.append('C');
                    }else {
                        s.append('J');
                    }
                }
                System.out.println(s);
            }
        }
    }
}

class Job{
    int s;
    int e;
    private boolean assigned;
    private boolean assignedToC;

    Job(int s, int e) {
        this.s = s;
        this.e = e;
    }

    void assignToC(){
        assigned = true;
        this.assignedToC = true;
    }

    void assignToJ(){
        assigned = true;
        this.assignedToC = false;
    }

    boolean isAssignedToC(){
        return assigned && assignedToC;
    }
}
