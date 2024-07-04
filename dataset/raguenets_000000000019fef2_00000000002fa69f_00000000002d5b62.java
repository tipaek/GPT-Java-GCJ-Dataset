import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            System.out.println("Case #"+t+": "+getAnswer(X,Y));
        }
    }

    public static String best = "";
    public static String visit(int level,int X,int Y,int XTarget,int YTarget,List<String> choices) {
        int pathSize = (int)Math.pow(2,level);
        if (level > 10) {
            return "STOP";
        }
//        StringBuilder sb2 = new StringBuilder();
//        for (String s : choices) sb2.append(s);
//        System.out.println(sb2.toString()+" "+X+" "+Y);
        if (X == XTarget && Y == YTarget) {
            StringBuilder sb = new StringBuilder();
            for (String s : choices) sb.append(s);
            if (best.equals("")) {
                best = sb.toString();
            } else {
                if (sb.toString().length() < best.length()) {
                    best = sb.toString();
                }
            }
            return sb.toString();
        }
        choices.add("N");
        String northPath = visit(level+1,X,Y+pathSize,XTarget,YTarget,choices);
//        if (!northPath.equals("STOP")&& !northPath.equals("IMPOSSIBLE")) return northPath;
        choices.remove(choices.size()-1);
        choices.add("S");
        String southPath = visit(level+1,X,Y-pathSize,XTarget,YTarget,choices);
//        if (!southPath.equals("STOP") && !southPath.equals("IMPOSSIBLE")) return southPath;
        choices.remove(choices.size()-1);
        choices.add("W");
        String westPath = visit(level+1,X-pathSize,Y,XTarget,YTarget,choices);
//        if (!westPath.equals("STOP") && !westPath.equals("IMPOSSIBLE")) return westPath;
        choices.remove(choices.size()-1);
        choices.add("E");
        String eastPath = visit(level+1,X+pathSize,Y,XTarget,YTarget,choices);
//        if (!eastPath.equals("STOP") && !eastPath.equals("IMPOSSIBLE")) return eastPath;
        choices.remove(choices.size()-1);
        return "IMPOSSIBLE";
    }
    public static String getAnswer(int X,int Y) {
        best = "";
        List<String> choices = new ArrayList<>();
        String v =  visit(0,0,0,X,Y,choices);
        if (!best.equals("")) {
            return best;
        }
        return v;
    }
}
