import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author qboiler
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }
    }

    public static void main2(String args) throws IOException {

        BufferedReader reader = new BufferedReader(new StringReader(args));
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }
    }





    private static final Random r = new Random();

    static final TreeMap<Integer,TreeMap<Integer,int[][]>> opaqueCache = new TreeMap<>();
    public static void processCase(BufferedReader reader, int caseN) throws IOException {
        String[] sizeRank = reader.readLine().split(" ");
        int size = Integer.parseInt(sizeRank[0]);
        int rank = Integer.parseInt(sizeRank[1]);

        TreeMap<Integer,int[][]> cacheValues = new TreeMap<>();

        if(opaqueCache.containsKey(size)){

            cacheValues = opaqueCache.get(size);
            if(cacheValues.containsKey(rank)){
                System.out.println("Case #"+caseN+": POSSIBLE");
                print(cacheValues.get(rank));
            }else{
                System.out.println("Case #"+caseN+": IMPOSSIBLE");
            }
        }else {

            int[] ii = new int[size];
            for (int i = 0; i < size; ++i) {
                ii[i] = i + 1;
            }
            ArrayList<int[]> perms = perms(ii);
            //System.out.println("Perms for Size: " + size);
            //print(perms);

            ArrayList<int[][]> ls = latinSquares(perms, new int[size][size]);
            TreeMap<Integer, Integer> distro = new TreeMap<>();
            TreeMap<Integer, int[][]> retValue = new TreeMap<>();
            for (int[][] lsR : ls
            ) {


                int t = trace(lsR);
                Integer yyz = distro.get(t);
                if (yyz == null) {
                    //System.out.println("----------------------------");
                    //print(lsR);
                    //System.out.println("Trace: " + t);
                    yyz = 1;
                    retValue.put(t, lsR);

                } else {
                    yyz += 1;
                }
                distro.put(t, yyz);
            }
            opaqueCache.put(size, retValue);

//            System.out.println("TRACE distro for size: " + size);
//            for (Map.Entry<Integer, Integer> kv : distro.entrySet()) {
//
//                System.out.println(kv.getKey() + " : " + kv.getValue());
//
//            }
            cacheValues = retValue;
            if(cacheValues.containsKey(rank)){
                System.out.println("Case #"+caseN+": POSSIBLE");
                print(cacheValues.get(rank));
            }else{
                System.out.println("Case #"+caseN+": IMPOSSIBLE");
            }
        }



    }

    public static int trace(int[][] a){
        int r = 0;
        for(int i=0;i<a.length;++i){
            r += a[i][i];
        }
        return r;
    }


    public static void processCase2(BufferedReader reader, int caseN) throws IOException {




        long start = System.currentTimeMillis();

        String[] sizeRank = reader.readLine().split(" ");
        int size = Integer.parseInt(sizeRank[0]);
        int rank = Integer.parseInt(sizeRank[1]);
        int[][] matrix = new int[size][size];


        int rankAverage = rank/size;
        int rankRemaining = rank;
        int sizeRemaining = size;
        int[] diag = new int[size];
        for(int i =0; i<diag.length;++i){
            diag[i]= rankAverage;
            matrix[i][i] = rankAverage;
            rankRemaining -= rankAverage;
            --sizeRemaining;
            if(sizeRemaining>0) {
                rankAverage = rankRemaining / sizeRemaining;
            }
        }
        if(rankRemaining==1){
            diag[diag.length-1] +=1 ;
            matrix[diag.length-1][diag.length-1] +=1;
        }
        print(matrix);
        int maxIndex = diag.length-1;
        for(int i=0;i<=maxIndex;++i){
            int startV = matrix[i][i];
            if(i<maxIndex) {
                int posConflict = matrix[i + 1][i + 1];
                if (startV != posConflict) {
                    if(i==0){
                        startV=posConflict;
                        // Special Case of Row 1....
                    }else{
                        startV=matrix[0][i+1];
                    }
                    //startV=0;
                }
            }
            for(int j=0;j<=maxIndex;++j){
                if(i<j){
                    matrix[i][j]= startV+1;
                    ++startV;
                    if(startV==size){
                        startV=0;
                    }
                }
            }
        }
        System.out.println("Upper half....");
        print(matrix);
        System.out.println("Upper half....");


    }

    public static void print(int[][] r){
        for(int i=0;i<r.length;++i){
            String line = "";
            for(int j=0;j<r.length;++j){
                line +=(r[i][j] + " ");
            }
            System.out.println(line.trim());
        }
    }

    public static void print(ArrayList<int[]> rs){
        int pNum =1;
        for(int[] r:rs){
            System.out.print(pNum+": ");
            pNum++;
            for(int i:r){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<int[]> perms(int[] a){
        ArrayList<int[]> result = new ArrayList<>();
        if(a.length==1){
            result.add(a);
        }else{
            for (int i=0; i<a.length; ++i) {
                int[] ne = new int[a.length-1];
                if(i>0) {
                    System.arraycopy(a, 0, ne, 0, i);
                }
                if(i<a.length-1) {
                    System.arraycopy(a, i +1, ne, i, a.length - i - 1);
                }
                ArrayList<int[]> permRes = perms(ne);
                for(int[] pr : permRes){
                    int[] nr = new int[a.length];
                    nr[0] = a[i];
                    System.arraycopy(pr, 0, nr, 1, pr.length);
                    result.add(nr);

                }

            }
        }
        return result;
    }


    public static ArrayList<int[][]> latinSquares(ArrayList<int[]> s, int[][] cMat){
        ArrayList<int[][]> results = new ArrayList<int[][]>();
        for(int[] ia : s){
            for(int i=0;i<cMat.length;++i){
                if(cMat[i][i]==0){
                    int[][] kMat = dup(cMat);
                    // found the row..
                    for(int j=0;j<cMat.length;++j){
                        kMat[i][j]=ia[j];
                    }
                    ArrayList<int[]> jj = remove(ia,s);
                    if(!jj.isEmpty() && i < cMat.length-1){
                        results.addAll(latinSquares(jj, kMat));
                    }
                    if(i==cMat.length-1){
                        results.add(kMat);
                    }
                    break;
                }
            }
        }
        return results;
    }
    public static ArrayList<int[]> remove(int[] ia, ArrayList<int[]> s){
        ArrayList<int[]> res = new ArrayList<int[]>();
        for(int[] nia:s){
            boolean add=true;
            for(int i=0;i<nia.length;++i){
                if(nia[i]==ia[i]){
                    add=false;
                }
            }
            if(add){
                int[] nnia = new int[nia.length];
                System.arraycopy(nia, 0, nnia, 0, nia.length);
                res.add(nnia);
            }
        }
        return res;
    }

    public static int[][] dup(int[][] a){
        int[][] res = new int[a.length][ a.length] ;
        for(int i=0;i<a.length;++i){
            for(int j=0;j<a.length;++j){
                res[i][j] = a[i][j];
            }
        }
        return res;
    }



}
