import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private void printAnswer(int T,String ans){
        System.out.println("Case #" + T + ": " +ans);
    }

    private static class Task implements Comparable<Task>{
        int start;
        int end;
        int pos;

        public Task(int start, int end, int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

        @Override
        public int compareTo(Task other) {
            return this.start - other.start;
        }
    }

    private String findAnswer(List<Task> tasks){
        Collections.sort(tasks);

        Character c = 'C';
        boolean isCFree = true;
        int cEnd = 0;

        Character j = 'J';
        boolean isJFree = true;
        int jEnd = 0;

        Character[] ans = new Character[tasks.size()];


        for(Task t: tasks){
            int curr = t.start;

            if(curr >= cEnd)
                isCFree = true;

            if(curr >= jEnd)
                isJFree = true;

            if(isCFree){
                ans[t.pos] = 'C';
                cEnd = t.end;
                isCFree = false;
            }

            else if(isJFree){
                ans[t.pos] = 'J';
                jEnd = t.end;
                isJFree = false;
            }
            else
                return "IMPOSSIBLE";
        }

        StringBuilder temp = new StringBuilder();

        for(int i = 0; i < ans.length; i++)
            temp.append(ans[i]);

        return temp.toString();
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        Solution s1 = new Solution();
        int count = 1;

        while(count <= T) {
            int N = sc.nextInt();
            List<Task> tasks = new ArrayList<>(N);
            for(int i = 0; i < N; i++){
                Task t1= new Task(sc.nextInt(), sc.nextInt(), i);
                tasks.add(t1);
            }

            s1.printAnswer(count, s1.findAnswer(tasks));

            count++;
        }
    }
}
