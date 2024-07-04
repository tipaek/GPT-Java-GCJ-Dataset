package Qualification;

import java.lang.reflect.Array;
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
        if((b.end > start && b.end < end) || (b.start > start && b.start < end)){
            return true;
        }
        return false;
    }
}

public class CJ1 {
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

            //get all intersecting
            for (int a = 0; a < N; a++) {
                for (int b = a + 1; b < N; b++) {
                    if (timeSlots.get(a).intersects(timeSlots.get(b))) {
                        intersecting.add(new intersections(a, b));
                    }

                }
            }

            boolean impossible = false;
            //loop through intersecting
            if(intersecting.size() == 1 && N == 2){
                impossible = true;
            }
            for (int c = 0; c < intersecting.size(); c++) {
                if((C.contains(intersecting.get(c).a) && C.contains(intersecting.get(c).b) || (J.contains(intersecting.get(c).a) && J.contains(intersecting.get(c).b)))){
                    impossible = true;
                }
                if (c == 0) {
                    C.add(intersecting.get(0).a);
                    J.add(intersecting.get(0).b);
                } else {
                    if (C.contains(intersecting.get(c).a)) {
                        if (!(J.contains(intersecting.get(c).b))) {
                            J.add(intersecting.get(c).b);
                        }
                    }
                    else if (J.contains(intersecting.get(c).a)) {
                        if (!(C.contains(intersecting.get(c).b))) {
                            C.add(intersecting.get(c).b);
                        }
                    }
                    else {
                        C.add(intersecting.get(c).a);
                        J.add(intersecting.get(c).b);
                    }
                }
            }

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
