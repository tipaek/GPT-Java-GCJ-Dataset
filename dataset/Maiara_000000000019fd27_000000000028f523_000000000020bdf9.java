import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            List<Integer[]> cam = new LinkedList<>();
            List<Integer[]> jam = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            boolean impossible = false;
            int s, e;
            
            for (int j = 0; j < n; j++) {
                s = in.nextInt();
                e = in.nextInt();
                
                if (!impossible) {
                    if (assignTo(cam, s, e)) {
                        sb.append('C');
                    } else if (assignTo(jam, s, e)) {
                        sb.append('J');
                    } else {
                        impossible = true;
                    }
                }
            }
            
            String ans = impossible ? "IMPOSSIBLE" : sb.toString();
            System.out.println("Case #" + (i+1) + ": " 
                            + ans);
        }
        
    }
    
    private static boolean assignTo(List<Integer[]> person, int s, int e) {
        boolean canDo = true;
        
        if (person.isEmpty()) {
            person.add(new Integer[]{s, e});
            return true;
        }
        
        ListIterator<Integer[]> it = person.listIterator();
        while (it.hasNext()) {
            Integer[] timeSlot = it.next();
            if (e <= timeSlot[0]) {
                if (e == timeSlot[0]) {
                    timeSlot[0] = s;
                } else {
                    it.previous();
                    it.add(new Integer[]{s, e});
                }
                break;
            } else if (s >= timeSlot[1]) {
                if (s == timeSlot[1]) {
                    if (!it.hasNext()) {
                        timeSlot[1] = e;
                    } else {
                        Integer[] nextTimeSlot = it.next();
                        if (e < nextTimeSlot[0]) {
                            timeSlot[1] = e;
                        } else if (e == nextTimeSlot[0]) {
                            timeSlot[1] = nextTimeSlot[1];
                            it.remove();
                        } else {
                            canDo = false;
                        }
                    }
                    break;
                } else {
                    if (!it.hasNext()) {
                        it.add(new Integer[]{s, e});
                    }
                }
            } else {
                canDo = false;
                break;
            }
        }
        
        return canDo;
    }
}