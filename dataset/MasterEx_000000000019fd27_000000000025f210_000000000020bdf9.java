
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Periklis Ntanasis <pntanasis@gmail.com>
 */
public class Solution {
    
    static class Assignment {
        public LocalTime start;
        public LocalTime end;
        public String Assigned = "";
        public int order;
        
        public boolean overlapse(Assignment a) {
            return start.isBefore(a.end) && a.start.isBefore(end);
        }
        
        public void setStart(int minutes) {
            start = LocalTime.of(minutes/60, minutes%60);
        }
        
        public void setEnd(int minutes) {
            if(minutes/60 == 24) {
                end = LocalTime.of(23, 59);                
            } else {
                end = LocalTime.of(minutes/60, minutes%60);                
            }
        }
    }

    static class Case {
        public List<Assignment> schedule = new ArrayList<>();

        @Override
        public String toString() {
            return schedule.stream().sorted((c1, c2) -> Integer.compare(c1.order, c2.order))
                    .map(c -> c.Assigned).collect(Collectors.joining());
        }
        
        
    }

    public static void main(String[] args) {
        List<Case> cases = readCases();
        int i = 1;
        for (Case c : cases) {
            System.out.println("Case #"+(i++)+": "+solve(c));
        }
    }
    
    static List<Case> readCases() {
        List<Case> cases = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Case c = new Case();
            int N = in.nextInt();
            for (int s=0; s<N; s++) {
                Assignment a = new Assignment();
                a.setStart(in.nextInt());
                a.setEnd(in.nextInt());
                a.order = s;
                c.schedule.add(a);
            }
            c.schedule.sort((c1, c2) -> c1.start.compareTo(c2.start));
            cases.add(c);
        }
        return cases;
    }
    
    static String solve(Case c) {
        for(int i=0; i<c.schedule.size(); i++) {
            Assignment current = c.schedule.get(i);
            if (i == 0) {
                current.Assigned = "C";
            } else {
                Assignment previousJ = getLastJ(c);
                Assignment previousC = getLastC(c);
                 if (previousC != null && !previousC.overlapse(current)) {
                    current.Assigned = "C";                    
                } else if (previousJ == null || !previousJ.overlapse(current)) {
                    current.Assigned = "J";
                } else{
                    return "IMPOSSIBLE";
                }
            }
        }
        return c.toString();
    }
    
    static Assignment getLastJ(Case c) {
        Assignment a = null;
        for(Assignment as : c.schedule) {
            if(as == null)
                break;
            if(as.Assigned.equals("J")) {
                a = as;
            }
        }
        return a;
    }
    
    static Assignment getLastC(Case c) {
        Assignment a = null;
        for(Assignment as : c.schedule) {
            if(as == null)
                break;
            if(as.Assigned.equals("C")) {
                a = as;
            }
        }
        return a;
    }
    
}
