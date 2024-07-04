
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] solutions = new String[T];
        for (int i = 0; i < T; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();


            solutions[i] = expogo(x, y);
//            System.out.println(solutions[i]);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String expogo(int x, int y) {

        Map<List<Integer>,String> m = new HashMap<>();
        String res = helper(Math.abs(x), Math.abs(y), new StringBuilder(),m);
        if (res.equals("IMPOSSIBLE")) return res;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length(); i++) {
            Character c = res.charAt(i);
            char n = c;
            if (x < 0) {
                if (c == 'W') n = 'E';
                else if (c == 'E') n = 'W';
            }
            if (y < 0) {
                if (c == 'N') n = 'S';
                else if (c == 'S') n = 'N';
            }
            sb.append(n);
        }
        return sb.toString();

    }

    private static String helper(int x, int y, StringBuilder sb, Map<List<Integer>,String> m) {
        if (x == 0 && y == 0) {
            m.put(Arrays.asList(x,y,sb.length()),sb.toString());
            m.put(Arrays.asList(y,x,sb.length()),sb.toString());
            return sb.toString();
        }

        int jump = sb.length() + 1;
        int dist = (int) Math.pow(2, jump - 1);

        final String IMPOSSIBLE = "IMPOSSIBLE";
        if ((x != 0 && x!=dist && x < dist) ||
                (y != 0 && y!=dist && y <  dist)) return IMPOSSIBLE;
        if (x != 0) {
            String res = m.get(Arrays.asList(x-dist,y,jump));
            String east = res!=null? res :helper(x - dist, y, sb.append("E"),m);
            m.put(Arrays.asList(x-dist,y,jump),east);
            m.put(Arrays.asList(y,x-dist,jump),east);
            if (!east.equals(IMPOSSIBLE)) return east;
            if(res==null)sb.setLength(sb.length()-1);

            res = m.get(Arrays.asList(x+dist,y,jump));
            String west =  res!=null? res :helper(x + dist, y, sb.append("W"),m);
            m.put(Arrays.asList(x+dist,y,jump),west);
            m.put(Arrays.asList(y,x+dist,jump),west);
            if (!west.equals(IMPOSSIBLE)) return west;
            if(res==null)sb.setLength(sb.length()-1);


        }
        if (y != 0) {
            String res = m.get(Arrays.asList(x, y - dist,jump));

            String north = res!=null? res :helper(x, y - dist, sb.append("N"),m);
            m.put(Arrays.asList(x, y - dist,jump),north);
            m.put(Arrays.asList(y-dist,x,jump),north);

            if(res==null)sb.setLength(sb.length()-1);

            if (!north.equals(IMPOSSIBLE)) return north;

            res = m.get(Arrays.asList(x, y + dist,jump));
            String south = res!=null? res :helper(x, y + dist, sb.append("S"),m);
            m.put(Arrays.asList(x, y + dist,jump),south);
            m.put(Arrays.asList(y+dist,x,jump),south);
            if(res==null)sb.setLength(sb.length()-1);

            if (!south.equals(IMPOSSIBLE)) return south;
        }
        return IMPOSSIBLE;
    }
}
