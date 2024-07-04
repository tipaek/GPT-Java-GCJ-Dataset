
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author qboiler
 */
public class Solution{

  public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        main(reader);

    }

    public static void main(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }

    }
    private static final HashMap<String,Integer> u = new HashMap<>();


    public static void processCase(BufferedReader reader, int caseN) throws IOException {

        u.clear();
        String[] xyS= reader.readLine().split(" ");

        long x = Long.parseLong(xyS[0]);
        long y = Long.parseLong(xyS[1]);
        if(x+y<50){
            pDepth=7;
        }
        pDepth = (int)Math.log10(x+y) + 10;

        Path p = new Path(0,0,1, "");
        ArrayList<Path> result = new ArrayList<>();
        nextCandidates(result, p);

        String finalResult = "IMPOSSIBLE";
        while(!result.isEmpty()){

            Path pne = result.remove(0);
            //System.out.println("Insepcting : "+ pne.x +": "+ pne.y + ": "+pne.depth +": " + pne.path );
            if(pne.x==x && pne.y==y){
                finalResult = pne.path;
                break;
            }
            nextCandidates(result, pne);
        }





        System.out.println("Case #"+caseN+": " +finalResult);

    }


    static void nextCandidates(ArrayList<Path> result,Path p ){
        long jumpSize = (long)Math.pow(2, (p.depth-1));



        Path north = new Path(p.x,p.y-jumpSize,p.depth +1,p.path+"S");
        Path south = new Path(p.x,p.y+jumpSize,p.depth+1,p.path+"N");
        Path east = new Path(p.x+jumpSize,p.y,p.depth+1,p.path+"E");
        Path west = new Path(p.x-jumpSize,p.y,p.depth+1,p.path+"W");


        add(result,north);
        add(result,south);
        add(result,east);
        add(result,west);
    }

    public static final long limit = (long)Math.pow(10, 9) +1;
    public static void add(ArrayList<Path> r , Path p){
        if(Math.abs(p.x)<limit && Math.abs(p.y)<limit && p.depth<pDepth){
            String pString = p.x+""+p.y;
            if(!u.containsKey(pString)){
                r.add(p);
                u.put(pString, 1);
            }
        }
    }


    private static int pDepth = 10;
    public static class Path{
        long x;
        long y;

        int depth;
        String path;

        public Path(long pX, long pY, int d, String s){
           x=pX;
           y=pY;
           depth=d;
           path = s;
        }
    }


}
