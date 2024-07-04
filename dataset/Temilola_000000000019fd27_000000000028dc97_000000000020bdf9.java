import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static class Data
    {

        int start, end;
        char assigne;

        Data (int x, int y)
        {
            this.start = x;
            this.end = y;
        }
        Data (int x, int y, char z) {
            this.start = x;
            this.end = y;
            this.assigne = z;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public char getAssigne() {
            return assigne;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "start=" + start +
                    ", end=" + end +
                    ", assigne=" + assigne +
                    '}';
        }
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int rowLength, testCases = in.nextInt();

        for(int testCase = 0; testCase < testCases; testCase++){
            rowLength = in.nextInt();
            ArrayList<Data> activities = new ArrayList<>();

            for (int i = 0; i < rowLength; i++){
                activities.add(new Data(in.nextInt(),in.nextInt()));
            }

            ArrayList<Data> assigned = new ArrayList<>();
            char assignee = 'C';
            if (activities.size() <= 1){
                return;
            }

            assigned.add(new Data(activities.get(0).getStart(),activities.get(0).getEnd(),assignee));
            activities.remove(0);
            boolean flag = true;
            for (Data activity : activities) {
//                System.out.println(assigned);
                Data added = overLap(assigned, activity);
                if (added == null){
                    System.out.println("Case #"+(testCase+1)+": IMPOSSIBLE");
                    flag = false;
                    break;
                }
                assigned.add(added);
            }

            if(flag) {
                System.out.print("Case #"+(testCase+1)+": ");
                for (int i = 0; i < assigned.size(); i++) {
                    System.out.print(assigned.get(i).getAssigne());
                }
                System.out.println();
            }

//            return;


//            for (int i = 0; i < activities.size(); i++){
//                System.out.println(activities.get(i).getStart()+" "+activities.get(i).getEnd());
//            }



//            print2D(matrix);
//            System.out.println("Case #"+(testCase+1)+": ");
        }
    }

    /**
     * - return default = null which means impossible
     * - declare object new activity
     * - set switches to 0
     * - get toBeAssigned from the last current assignee
     * - check for overlaps
     *      - backtrace loop (check for overlaps starting from x.length - 1):
     *          - if overlapped
 *                  - if current assignee == toBeAssignee
     *                  - switch toBeAssigned
     *                  -
     *                  - increment switch
 *              - if(switch > 1)
     *              - return default
     *     - put toBeAssigned to new Activity
     *     - return new activity
     *
     * - save # of switches =
     *  - add +1 for every switch you make
     *  - if switch is equal to 2 return impossible
     *
     * @param assigned
     * @param current
     */
    private static Data overLap(ArrayList<Data> assigned, Data current){
        int s = current.getStart(), e = current.getEnd(), swap=0, counter=1;
        char toBeAssigned = assigned.get(assigned.size()-1).getAssigne();
        Data activity;
        for (int i = assigned.size()-1; i >= 0; i--) {
            activity = assigned.get(i);

            if((activity.getStart() < s && activity.getEnd() > s) || (activity.getStart() < e && activity.getEnd() > e) || (activity.getStart() == s) || (activity.getEnd() == e) || (s < activity.getStart() && e > activity.getEnd())){
                if (s < activity.getStart() && e > activity.getEnd()){
                    if(counter==2){
                        return null;
                    }
                    counter++;
                }

                if(activity.getAssigne() == toBeAssigned){
                    toBeAssigned = swapAssignee(activity.getAssigne());
                    swap++;
                }
            }
            if (swap>1){
                return null;
            }
        }
        activity = new Data(current.getStart(),current.getEnd(), toBeAssigned);
        return activity;
    }

    private static char swapAssignee(char assignee) {
        if (assignee == 'C'){
            return 'J';
        }
        return 'C';
    }
}