import java.util.*;

class Job{
    int pos;
    int start;
    int end;
    String person;
    Job(int pos, int start, int end){
        this.pos = pos;
        this.start = start;
        this.end = end;
        person = "";
    }
    public void setPerson(String p){
        person = p;
    }
}

class Sortbystart implements Comparator<Job>{
    public int compare(Job a, Job b){ 
        return a.start - b.start; 
    } 
} 

class Sortbypos implements Comparator<Job>{
    public int compare(Job a, Job b){ 
        return a.pos - b.pos; 
    } 
} 

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 1; t <= test; t++){
            int n = sc.nextInt();
            ArrayList<Job> jobs = new ArrayList<Job>(); 
            for(int i = 0; i < n; i++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                jobs.add(new Job(i,s,e));
            }
            Collections.sort(jobs, new Sortbystart());
            jobs.get(0).setPerson("C");
            int endtime1 = jobs.get(0).end;
            String endPerson1 = "C";
            jobs.get(1).setPerson("J");
            int endtime2 = jobs.get(1).end;
            String endPerson2 = "J";
            boolean isPossible = true;
            for(int i = 2; i < n; i++){
                if(jobs.get(i).start >= endtime1) {
                    jobs.get(i).setPerson(endPerson1);
                    endtime1 = jobs.get(i).end;
                } else if(jobs.get(i).start >= endtime2) {
                    jobs.get(i).setPerson(endPerson2);
                    endtime2 = jobs.get(i).end;
                } else {
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible){
                System.out.println("Case #"+t+": IMPOSSIBLE");
            } else {
                Collections.sort(jobs, new Sortbypos());
                String res = "";
                for(int i = 0; i < n; i++){
                    res += jobs.get(i).person;
                }
                System.out.println("Case #"+t+": "+res);
            }
        }
    }
}