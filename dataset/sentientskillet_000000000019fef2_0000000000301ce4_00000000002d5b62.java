import java.io.*;
import java.util.*;

public class Solution {
    public static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static HashMap<String, String> invert = new HashMap<>(){{
        put("N","S");
        put("E","W");
        put("S","N");
        put("W","E");
    }};
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(f.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            out.printf("Case #%d: %s%n", i+1, get(x,y));
        }
        out.close();
    }
    public static String getCardinal(int xp, int xn, int xflip, int yp, int yn, int yflip) {
        if(xflip < 0) {
            int xt = xp;
            xp = xn;
            xn = xt;
        }
        if(yflip < 0) {
            int yt = yp;
            yp = yn;
            yn = yt;
        }
        int mask = 1;
        LinkedList<String> deque = new LinkedList<>();
        StringBuffer sb = new StringBuffer(30);
        while ((xp | xn | yp | yn)>0) {
            boolean toggle=false;
            if( (xp&mask) > 0) {
                xp = xp &~mask;
                deque.add("E");
                toggle=true;
            }
            if( (xn&mask) > 0) {
                if(toggle) return null;
                xn = xn &~mask;
                deque.add("W");
                toggle=true;
            }
            if( (yp&mask) > 0) {
                if(toggle) return null;
                yp = yp &~mask;
                deque.add("N");
                toggle=true;
            }
            if( (yn&mask) > 0) {
                if(toggle) return null;
                yn = yn &~mask;
                deque.add("S");
                toggle=true;
            }
            if(!toggle) {
                String last = deque.removeLast();
                deque.add(invert.get(last));
                deque.add(last);
            }
            mask = mask << 1;
        }
        for(String s : deque) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static String get(int x, int y) {
        int x_sgn = (int) Math.signum(x);
        x = Math.abs(x);
        int xprimep = 1 << (int)(Math.ceil(Math.log(x)/Math.log(2)));
        int xprimen = xprimep-x;

        int y_sgn = (int) Math.signum(y);
        y = Math.abs(y);
        int yprimep = 1 << (int)(Math.ceil(Math.log(y)/Math.log(2)));
        int yprimen = yprimep-y;

        String cardinal = null;
        ArrayList<String> sols = new ArrayList<>();
        if( (x&y) == 0 && (cardinal=getCardinal(x,0,x_sgn,y,0,y_sgn)) != null) {
            sols.add(cardinal);
        }
        cardinal = null;
        if( (x&yprimep&yprimen) == 0 && (cardinal=getCardinal(x,0,x_sgn,yprimep,yprimen,y_sgn)) != null) {
            sols.add(cardinal);
        }
        cardinal = null;
        if( (xprimep&xprimen&y) == 0 && (cardinal=getCardinal(xprimep,xprimen,x_sgn,y,0,y_sgn)) != null) {
            sols.add(cardinal);
        }
        cardinal = null;
        if( (xprimep&xprimen&yprimep&yprimen) == 0 && (cardinal=getCardinal(xprimep,xprimen,x_sgn,yprimep,yprimen,y_sgn)) != null) {
            sols.add(cardinal);
        }
        if(sols.size() == 0) return "IMPOSSIBLE";
        Collections.sort(sols);
        return sols.get(0);
    }
}
