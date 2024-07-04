import java.util.*;

class Task{
    int start;
    int finish;
    int index;
    char partner;

    public Task(int start, int finish, int index, char partner){
        this.start = start;
        this.finish = finish;
        this.index = index;
        this.partner = partner;
    }

    public void change(char partner){
        this.partner = partner;
    }
}

class SortbyFinish implements Comparator<Task>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Task a, Task b)
    {
        return a.finish - b.finish;
    }
}

class SortbyIndex implements Comparator<Task>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Task a, Task b)
    {
        return a.index - b.index;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        int cases = fileScanner.nextInt();
        fileScanner.nextLine();


        for (int i = 0; i < cases; i++) {
            int J = 0;
            int C = 0;
            
            int tasks = fileScanner.nextInt();
            fileScanner.nextLine();
            boolean impossible = false;
            Task[] sortedTask = new Task[tasks];
            //System.out.println("finish");

            for (int j = 0; j < tasks; j++){
                int start = fileScanner.nextInt();
                int finish = fileScanner.nextInt();
                if(fileScanner.hasNextLine()){
                    fileScanner.nextLine();
                }
                Task task = new Task(start, finish, j, 'J');
                sortedTask[j] = task;
            }

            Arrays.sort(sortedTask, new SortbyFinish());
            for (Task t: sortedTask) {
                if (t.start >= C ){
                    t.change('C');
                    C = t.finish;
                    continue;
                } else if(t.start >= J){
                    J = t.finish;
                    continue;
                } else{
                    impossible = true;
                    break;
                }
            }

            if (impossible){
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            } else{
                Arrays.sort(sortedTask, new SortbyIndex());
                System.out.print("Case #" + (i+1) + ": ");
                for(Task t:sortedTask){
                    System.out.print(t.partner);
                }
                System.out.println();
                //System.out.println();
            }
        }
        fileScanner.close();
    }
}