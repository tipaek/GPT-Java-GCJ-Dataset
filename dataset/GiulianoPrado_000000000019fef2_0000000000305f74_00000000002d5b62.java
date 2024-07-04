import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static ArrayList<Character> caminho = new ArrayList<>();

    public static Set<Integer> getTwoBase (int number) {
        int absnumber = Math.abs(number);
        String binary = Integer.toBinaryString(absnumber);
        Set<Integer> output = new HashSet<>();
        int actual = 1;
        for (int i = binary.length()-1; i >= 0; i--) {
            if (binary.charAt(i) == '1') output.add(actual);
            actual *= 2;
        }
        return output;
    }

    public static int visit (int posx, int posy, int posxobj, int posyobj, char movement, int movqt, int actmov, int maxmov) {


        if (movement == 'S') posy -= movqt;
        if (movement == 'N') posy += movqt;
        if (movement == 'W') posx -= movqt;
        if (movement == 'E') posx += movqt;

        if (actmov > maxmov){
            return -1;
        }

        if (posx == posxobj && posyobj == posy) {
            return 1;
        }


        int nextMovQt = movqt;
        actmov += 1;
        if (movement != 'X')
            nextMovQt = movqt*2;

        if (visit(posx, posy, posxobj, posyobj, 'N', nextMovQt, actmov, maxmov) == 1) {
            caminho.add('N');
            return 1;
        } else if (visit(posx, posy, posxobj, posyobj, 'S', nextMovQt, actmov, maxmov) == 1) {
            caminho.add('S');
            return 1;
        } else if (visit(posx, posy, posxobj, posyobj, 'W', nextMovQt, actmov, maxmov) == 1) {
            caminho.add('W');
            return 1;
        } else if (visit(posx, posy, posxobj, posyobj, 'E', nextMovQt, actmov, maxmov) == 1) {
            caminho.add('E');
            return 1;
        }
        return -1;

    }
    public static int binlog( int bits ) // returns 0 for bits=0
    {
        int log = 0;
        if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
        if( bits >= 256 ) { bits >>>= 8; log += 8; }
        if( bits >= 16  ) { bits >>>= 4; log += 4; }
        if( bits >= 4   ) { bits >>>= 2; log += 2; }
        return log + ( bits >>> 1 );
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int prob = 1; prob <= N; ++prob) {
            int destx = in.nextInt();
            int desty = in.nextInt();
            caminho.clear();
            Set<Integer> setx = getTwoBase(destx);
            Set<Integer> sety = getTwoBase(desty);
            int maxx = 0;
            int maxy = 0;
            if (setx.size() > 0)
                maxx = Collections.max(setx);
            if (sety.size() > 0)
                maxy = Collections.max(sety);
            int binlogmaxx = binlog(maxx);
            int binlogmaxy = binlog(maxy);

            int result = -1;
            int tries = 0;
            while (result == -1 && tries++ < Math.max(destx, desty))    
                result = visit(0, 0, destx, desty, 'X', 1, 0, 2 + binlogmaxx + binlogmaxy);

            String output = "";
            if (result == 1){
                ArrayList<Character> caminhoCorreto = new ArrayList<>();
                for (int i=caminho.size()-1; i>=0; i--) {
                    caminhoCorreto.add(caminho.get(i));
                }
                for (Character elem : caminhoCorreto) {
                    output += elem;
                }
            } else {
                output = "IMPOSSIBLE";
            }

            System.out.println("Case #" + prob + ": " + output );
        }

    }
}
