import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Job {
    public int jobID;
    public int start;
    public  int end;
    public  char assignment ;

    public Job(int jobID, int start, int end) {
        this.jobID = jobID;
        this.start = start;
        this.end = end;
    }


}
class SortByStartValue implements Comparator<Job>
{
    @Override
    public int compare(Job o1, Job o2) {
        return o1.start - o2.start;
    }
}
class SortById implements Comparator<Job>
{
    @Override
    public int compare(Job o1, Job o2) {
        return o1.jobID - o2.jobID;
    }
}

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int len = scanner.nextInt();
        scanner.nextLine();
       ArrayList< ArrayList<Job>> scenarios = new ArrayList<>();
        for(int i = 0; i < len ; i++)
        {
            scenarios.add(getJobs());
        }



        StringBuilder report = new StringBuilder();

        for(int j = 0; j < scenarios.size() ; j++) {

            scenarios.get(j).sort(new SortByStartValue());
            boolean impossible = false;
            int jamesIndex = 0, cameronIndex = 0;
            for (int i = 0; i < scenarios.get(j).size(); i++) {

                if (jamesIndex <= scenarios.get(j).get(i).start) {
                    jamesIndex = scenarios.get(j).get(i).end;
                    scenarios.get(j).get(i).assignment = 'J';

                } else if (cameronIndex <= scenarios.get(j).get(i).start) {
                    cameronIndex = scenarios.get(j).get(i).end;
                    scenarios.get(j).get(i).assignment = 'C';
                } else {

                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                report.append("Case #").append(j + 1).append(": IMPOSSIBLE\n");
            }
            else {
                scenarios.get(j).sort(new SortById());
                report.append("Case #").append(j + 1).append(": ");

                for(int k = 0; k < scenarios.get(j).size() ; k++)
                    report.append(scenarios.get(j).get(k).assignment);
                report.append("\n");
            }
        }

        System.out.println(report.toString());


    }

    public  static  ArrayList<Job> getJobs()
    {
        int jobsCount = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i = 0; i < jobsCount ; i++)
        {
            String [] piece = scanner.nextLine().split(" ");
            jobs.add(new Job(i,Integer.parseInt(piece[0]),Integer.parseInt(piece[1])));
        }

        return jobs;
    }
}