import java.util.*;

class intersections{
    int a;
    int b;

    intersections(int A, int B){
        a = A;
        b = B;
    }

}
class time{
    int start;
    int end;

    public time(int s, int e){
        start = s;
        end = e;

    }
    public boolean intersects(time b){
        if((b.end > start && b.end < end) || (b.start >= start && b.start < end) || (end > b.start && end < b.end) || (start >= b.start && start < b.end)){
            return true;
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int T = input.nextInt();
        int N = 0;

        for(int i = 0; i < T; i ++) {
            ArrayList<time> timeSlots = new ArrayList<>();
            ArrayList<intersections> intersecting = new ArrayList<>();
            ArrayList<Integer> C = new ArrayList<>();
            ArrayList<Integer> J = new ArrayList<>();

            N = input.nextInt();

            //get timeSlots
            for (int j = 0; j < N; j++) {
                timeSlots.add(new time(input.nextInt(), input.nextInt()));
            }

            //for(int blah = 0; blah < timeSlots.size(); blah ++){
                //System.out.println("start: " + timeSlots.get(blah).start + " end: " + timeSlots.get(blah).end);
            //}

            //get all intersecting
            for (int a = 0; a < N; a++) {
                for (int b = a + 1; b < N; b++) {
                    if (timeSlots.get(a).intersects(timeSlots.get(b))) {
                        intersecting.add(new intersections(a, b));
                    }

                }
            }

            //for(int blah = 0; blah < intersecting.size(); blah ++){
                //System.out.println("a: " + intersecting.get(blah).a + " b: " + intersecting.get(blah).b);
            //}

            boolean impossible = false;
            //loop through intersecting

                for (int c = 0; c < intersecting.size(); c++) {
                    if ((C.contains(intersecting.get(c).a) && C.contains(intersecting.get(c).b) || (J.contains(intersecting.get(c).a) && J.contains(intersecting.get(c).b)))) {
                        impossible = true;
                        c = intersecting.size();
                    }
                    else {
                        if (C.contains(intersecting.get(c).a)) {
                            J.add(intersecting.get(c).b);

                        } else if (J.contains(intersecting.get(c).a)) {
                            C.add(intersecting.get(c).b);

                        } else {
                            C.add(intersecting.get(c).a);
                            J.add(intersecting.get(c).b);
                        }
                    }
                }

            /*for(int e = 0; e < C.size(); e ++){
                System.out.println("C: " + C.get(e));
            }
            for(int e = 0; e < J.size(); e ++){
                System.out.println("J: " + J.get(e));
            }*/


            //putting it together
            if (impossible == true) {
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
            }
            else {

                String output = "";
                for (int f = 0; f < N; f++) {
                    if (J.contains(f)) {
                        output = output + "J";
                    } else if (C.contains(f)) {
                        output = output + "C";
                    } else {
                        output = output + "C";
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + output);
            }
        }


    }
}
