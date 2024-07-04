import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int nbLigne = fr.nextInt();

        for (int i = 0; i < nbLigne; i++) {

            int taille = fr.nextInt();
            int diago = fr.nextInt();

            int[][] matrice = new int[taille][taille];

            for (int y = 0; y < taille; y++) {
                for (int z = 0; z < taille; z++) {
                    matrice[y][z] = (z + y) % taille + 1;
                }
            }
            ArrayList<ArrayList<int[]>> m = permute(matrice);
            /*for (ArrayList<int[]> m : permute(tmp)) {
                System.out.println("-----");
                for (int y = 0; y < m.size(); y++) {
                    for (int z = 0; z < m.size(); z++) {
                        System.out.print(m.get(y)[z]);
                    }
                    System.out.println("");
                }
            }*/

            for (ArrayList<int[]> m_m : m) {

            }

            int cpt = 0;
            boolean trouve = false;
            while (cpt < m.size() && !trouve) {
                if(getSommeDiago(m.get(cpt)) == diago) {
                    trouve = true;
                } else cpt++;
            }

            if (trouve) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int y = 0; y < taille; y++) {
                    for (int z = 0; z < taille; z++) {
                        System.out.print(m.get(cpt).get(y)[z]);
                    }
                    System.out.println("");
                }
            } else System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");

        }
    }

    public static ArrayList<ArrayList<int[]>> permute(int[][] num) {
        ArrayList<ArrayList<int[]>> result = new ArrayList<ArrayList<int[]>>();

        //start from an empty list
        result.add(new ArrayList<int[]>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<int[]>> current = new ArrayList<ArrayList<int[]>>();

            for (ArrayList<int[]> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<int[]> temp = new ArrayList<int[]>(l);
                    current.add(temp);

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<int[]>>(current);
        }

        return result;
    }

    public static int getSommeDiago(ArrayList<int[]> matrice) {
        int res = 0;

        for (int y = 0; y < matrice.size(); y++) {
            res += matrice.get(y)[y];
        }

        return res;
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    /*
    def permutation(liste):
    	taille = len(liste)
    	if taille == 1:
    		return [liste]
    	else:
    		res = []
	    	for cpt in range(taille):
	    		tmp = liste[0:cpt]+liste[cpt+1:taille]
	    		perm = GameState.permutation(tmp)
	    		for cpt2 in range(len(perm)):
	    			res.append([liste[cpt]]+perm[cpt2])
    	return res
     */

    /*public static int[][][] permutation(int[][] matrice) {
        int[][][] res = new int[factorial(matrice.length)][][];
        if (matrice.length == 1) res[0] = matrice;
        else {
            for (int i=0; i<matrice.length; i++) {
                int[][][] tmp = Arrays.copyOf(matrice, i) + Arrays.copyOf(matrice, matrice.length);
            }
        }
        return res;
    }*/

    public static int[][] generatePermutations(int N) {
        int[][] a = new int[factorial(N)][N];
        for (int i = 0; i < N; i++) a[0][i] = i;
        for (int i = 1; i < a.length; i++) {
            a[i] = Arrays.copyOf(a[i - 1], N);
            int k, l;
            for (k = N - 2; a[i][k] >= a[i][k + 1]; k--) ;
            for (l = N - 1; a[i][k] >= a[i][l]; l--) ;
            swap(a[i], k, l);
            for (int j = 1; k + j < N - j; j++) swap(a[i], k + j, N - j);
        }
        return a;
    }

    private static void swap(int[] is, int k, int l) {
        int tmp_k = is[k];
        int tmp_l = is[l];
        is[k] = tmp_l;
        is[l] = tmp_k;
    }
}
