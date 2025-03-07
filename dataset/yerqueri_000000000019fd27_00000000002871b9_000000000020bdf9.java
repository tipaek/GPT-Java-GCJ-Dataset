import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Tuple{
    int start;

    public Tuple(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Tuple() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    int end;
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        for(int x=0;x<size;x++) {
            in.nextLine();
            int ntasks = in.nextInt();
            List<Tuple> taskList= new ArrayList<>();
            for(int i=0;i<ntasks;i++){
                in.nextLine();
                int a = in.nextInt();
                int b = in.nextInt();
                taskList.add(new Tuple(a,b));
            }
            Collections.sort(taskList, Comparator.comparing(Tuple::getStart));
            StringBuilder sol= new StringBuilder();
            int a =0;
            int b=0;
            for(Tuple tuple:taskList){
                if(tuple.getStart()>=a){
                    a= tuple.getEnd();
                    sol.append("C");
                    continue;
                }else if(tuple.getStart()>=b){
                    b = tuple.getEnd();
                    sol.append("J");
                    continue;
                }else{
                    sol = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #"+(x+1)+": "+sol.toString());
        }
    }
}
