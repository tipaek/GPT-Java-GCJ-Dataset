import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];
            
            for (int j = 0; j < n; j++) {
                s[j] = in.nextInt();
                e[j] = in.nextInt();
            }
            
            System.out.println("Case #" + (i+1) + ": " 
                            + getSchedule(n, s, e));
        }
        
        in.close();
    }
    
    public static String getSchedule(int n, int[] s, int[] e) {
        List<int[]> cam = new LinkedList<>();
        List<int[]> jam = new LinkedList<>();
        StringBuilder sb = new StringBuilder(n);
        
        for (int i = 0; i < n; i++) {
            if (assignTo(cam, s[i], e[i])) {
                sb.append('C');
            } else if (assignTo(jam, s[i], e[i])) {
                sb.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return sb.toString();
    }
    
    private static boolean assignTo(List<int[]> person, int s, int e) {
        boolean canDo = true;
        
        if (person.isEmpty()) {
            person.add(new int[]{s, e});
            return true;
        }
        
        ListIterator<int[]> it = person.listIterator();
        while (it.hasNext()) {
            int[] timeSlot = it.next();
            if (e <= timeSlot[0]) {
                if (e == timeSlot[0]) {
                    timeSlot[0] = s;
                } else {
                    it.previous();
                    it.add(new int[]{s, e});
                }
                break;
            } else if (s >= timeSlot[1]) {
                if (s == timeSlot[1]) {
                    if (!it.hasNext()) {
                        timeSlot[1] = e;
                    } else {
                        int[] nextTimeSlot = it.next();
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
                        it.add(new int[]{s, e});
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