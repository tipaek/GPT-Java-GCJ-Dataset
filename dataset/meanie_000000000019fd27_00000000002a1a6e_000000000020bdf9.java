import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int noOfTests = Integer.parseInt(scanner.nextLine());
        for (int caseNo = 1; caseNo <= noOfTests; caseNo++)
        {
            // Parse in task into
            int noOfTasks = Integer.parseInt(scanner.nextLine());
            HouseTask[] tasks = new HouseTask[noOfTasks];
            List<HouseTask> sortedTasks = new LinkedList<>();
            for (int i = 0; i < noOfTasks; i++)
            {
                String[] taskInfo = scanner.nextLine().split(" ");
                HouseTask task = new HouseTask(Integer.parseInt(taskInfo[0]), Integer.parseInt(taskInfo[1]));
                tasks[i] = task;
                sortedTasks.add(task);

            }
            Collections.sort(sortedTasks);

            // Schedule tasks
            int cNextStart = 0;
            int jNextStart = 0;
            StringBuilder result = new StringBuilder();
            for (HouseTask task : sortedTasks)
            {
                int start = task.getStart();
                int end = task.getEnd();

                // Work out who takes the task
                if (cNextStart <= start)
                {
//                    result.append("C");
                    task.setAssignedTo("C");
                    cNextStart = end;
                }
                else if (jNextStart <= start)
                {
//                    result.append("J");
                    task.setAssignedTo("J");
                    jNextStart = end;
                }
                else {
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            // Get schedule if possible
            if (result.length() == 0)
            {
                for (HouseTask task : tasks) {
                    result.append(task.getAssignedTo());
                }
            }

            System.out.println("Case #" + caseNo + ": " + result);
        }
    }
}

class HouseTask implements Comparable
{
    private int start;
    private int end;
    private String assignedTo;

    public HouseTask(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getAssignedTo()
    {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    @Override
    public int compareTo(Object o) {
        if (start < ((HouseTask) o).getStart())
        {
            return -1;
        }
        else if (start == ((HouseTask) o).getStart())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}