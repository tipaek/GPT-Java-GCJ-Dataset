import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class TestCase{
        int n;
       // int [][]p;
        Job[] p;
        TestCase(){
            this.n=0;
            this.p=null;
        }
    }

    static class Job{
        int start, finish, id;
        Job(){
            this.start=0;
            this.finish=0;
            this.id = -1;
        }
        Job(int start, int finish, int id){
            this.start=start;
            this.finish=finish;
            this.id = id;
        }
    }

    static class SortJobs implements Comparator<Job>{
        public int compare(Job a, Job b){
            if(a.start < b.start){
                return -1;
            }
            else{
                if(a.start == b.start){
                    return 0;
                }
                else{
                    return 1;
                }
            }
           //return a.start;
        }
    }

    public static void findSchedule(int index, int n, Job[] job)
    {
        Arrays.sort(job, new SortJobs());
        int lastEndTime_C = -1;
        int lastEndTime_J = -1;

        StringBuilder sr = new StringBuilder();

        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                sr.append('C');
                lastEndTime_C = i;
            }
            else
            {
                if (job[i].start >= job[i - 1].finish)
                {
                    if (sr.charAt(i - 1) == 'C')
                    {
                        sr.append('C');
                        lastEndTime_C = i;
                    }
                    else if (sr.charAt(i - 1) == 'J')
                    {
                        sr.append('J');
                        lastEndTime_J = i;
                    }
                }
                else
                {
                    if (sr.charAt(i - 1) == 'C')
                    {
                        if((lastEndTime_J < 0) ||
                            (job[i].start >= job[lastEndTime_J].finish))
                        {
                            sr.append('J');
                            lastEndTime_J = i;
                        }
                        else
                        {
                            sr.setLength(0);
                            sr.append("IMPOSSIBLE");
                            break;
                        }
                    }
                    else if (sr.charAt(i - 1) == 'J')
                    {
                        if((lastEndTime_C < 0) ||
                                (job[i].start >= job[lastEndTime_C].finish))
                        {
                            sr.append('C');
                            lastEndTime_C = i;
                        }
                        else
                        {
                            sr.setLength(0);
                            sr.append("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }
        }
//        System.out.println("Case #" + index + ": " + sr);

        if(sr.charAt(0) != 'I')
        {
            char[] result = new char[n];
            for (int z = 0; z < n; z++) {
                result[job[z].id] = sr.charAt(z);
            }
            sr = new StringBuilder(new String(result));
        }
        int indexNum = index+1;
        System.out.println("Case #" + indexNum + ": " + sr);
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        TestCase[] tc = new TestCase[t];
        for(int i=0; i<t;i++){
            tc[i] = new TestCase();
            tc[i].n = sc.nextInt();

            tc[i].p = new Job[tc[i].n];
            for(int j=0; j<tc[i].n;j++)
            {
                tc[i].p[j] = new Job();
                tc[i].p[j].start=sc.nextInt();
                tc[i].p[j].finish=sc.nextInt();
                tc[i].p[j].id = j;
            }
        }

        for(int i=0;i<t;i++){
            findSchedule(i,tc[i].n,tc[i].p);
        }
    }
}
