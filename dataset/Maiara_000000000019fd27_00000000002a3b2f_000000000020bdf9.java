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
            
            List<int[]> cam = new LinkedList<>();
            List<int[]> jam = new LinkedList<>();
            StringBuilder sb = new StringBuilder(n);
            cam.add(new int[] {s[0], e[0]});
            sb.append('C');
            String ans = getSchedule(n, 1, s, e, cam, jam, sb) ? sb.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + (i+1) + ": " + ans);
        }
        
        in.close();
    }
    
    public static boolean getSchedule(int n, int i, int[] s, int[] e, List<int[]> cam, List<int[]> jam, StringBuilder sb) {
    	if (i == n) return true;
    	
        List<int[]> camCopy = new LinkedList(cam);
        List<int[]> jamCopy = new LinkedList(jam);
        boolean possible = false;
        
        if (assignTo(camCopy, s[i], e[i])) {
           possible = possible || getSchedule(n, i+1, s, e, camCopy, jam, sb);
           if (possible) sb.append('C');
        }
        
        if (!possible && assignTo(jamCopy, s[i], e[i])) {
        	sb.setLength(i);
            sb.append('J');
            possible = possible || getSchedule(n, i+1, s, e, cam, jamCopy, sb);
        }
        
        return possible;
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