import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numcases = in.nextInt();
        int numTasks;
        Integer start,end;
        Integer jval, cval;
        for(int tc = 0; tc < numcases; tc++) {
            HashMap<Character, Integer> myhash = new HashMap<Character, Integer>();
            StringBuilder resultstr = new StringBuilder();
            boolean impossible = false;

            myhash.put('C',null);
            myhash.put('J',null);
            numTasks = in.nextInt();

            Node[] tasks = new Node[numTasks];
            for(int i=0; i<numTasks; i++){
                tasks[i] = new Node(in.nextInt(), in.nextInt());
            }

            //sort tasks
            Arrays.sort(tasks, Comparator.comparing(a -> a.start));

            for(int i = 0; i<numTasks; i++){
                start = tasks[i].start;
                end = tasks[i].end;

                jval = myhash.get('J');
                cval = myhash.get('C');
                
                if(cval == null || (cval !=null && cval <= start)){
                    myhash.put('C', end);
                    resultstr.append('C');
                }else if(jval == null || (jval !=null && jval <= start)){
                    myhash.put('J', end);
                    resultstr.append('J');
                }else{
                    impossible = true;
                    break;
                }
            }
            if(impossible){
                System.out.println("Case #"+(tc+1)+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+(tc+1)+": "+resultstr.toString());
            }
        }
    }

    static class Node{
        Integer start;
        Integer end;

        public Node(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }
}