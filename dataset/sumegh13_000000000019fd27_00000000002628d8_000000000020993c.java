import java.util.*;
public class vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),s;
        int [][]mat;
        ArrayList<String> out = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            s=sc.nextInt();
            mat = new int[s][s];
            for (int j = 0; j < mat.length; j++) {
                for (int j2 = 0; j2 < mat[j].length; j2++) {
                    mat[j][j2]=sc.nextInt();
                }
            }
            out.add("Case #"+(i+1)+": "+gettraanddub(mat));
        }
        for (String str : out) {
            System.out.println(str);
        }
    }
    public static String gettraanddub(int [][]mat) {
        int trace=0,rowrep=0,colrep=0;
        for (int i = 0; i < mat.length; i++) {
            trace+=mat[i][i];
            if(repinrow(mat[i]))
            rowrep++;
            if(repincol(mat,i))
            colrep++;
        }
        return trace+" "+rowrep+" "+colrep;
    }
    public static boolean repinrow(int []arr) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i : arr) {
            hs.add(i);
        }
        if(hs.size()<arr.length)
        return true;
        return false;
    }
    public static boolean repincol(int [][]mat,int i) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int j = 0; j < mat.length; j++) {
            hs.add(mat[j][i]);
        }
        if(hs.size()<mat.length)
        return true;
        return false;
    }
}