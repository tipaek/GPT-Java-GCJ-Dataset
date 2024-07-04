import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int T = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);

        for (int m = 0; m < T; ++m) {
            ArrayList<Pair>[] listas = new ArrayList[(B / 10) * 4];
            for (int i = 0; i < (B / 10) * 4; ++i) {
                listas[i] = new ArrayList<>();
            }

            for (int i = 0; i < B / 10; ++i) {
                for (int j = 5 * i + 1; j <= 5 * (i + 1); ++j) {
                    int a = query(br, j);
                    int b = query(br, B + 1 - j);
                    categorizePair(listas, 4 * i, a, b);
                }
            }

            ArrayList<Pair> listaDef00 = new ArrayList<>();
            ArrayList<Pair> listaDef01 = new ArrayList<>();
            ArrayList<Pair> listaDef10 = new ArrayList<>();
            ArrayList<Pair> listaDef11 = new ArrayList<>();
            int queries = 0;

            queries = processPairs(br, listas, B, listaDef00, listaDef11, queries, 0, 3);
            queries = processPairs(br, listas, B, listaDef01, listaDef10, queries, 1, 2);
            balanceQueries(br, queries);

            char[] res = new char[B];
            fillResults(br, res, listaDef00, listaDef11, listaDef01, listaDef10);
            System.out.println(new String(res));
            br.readLine();
        }
    }

    private static int query(BufferedReader br, int index) throws IOException {
        System.out.println(index);
        return Integer.parseInt(br.readLine());
    }

    private static void categorizePair(ArrayList<Pair>[] listas, int baseIndex, int a, int b) {
        if (a == b) {
            listas[baseIndex + (a == 0 ? 0 : 3)].add(new Pair(a, b));
        } else {
            listas[baseIndex + (a == 1 ? 2 : 1)].add(new Pair(a, b));
        }
    }

    private static int processPairs(BufferedReader br, ArrayList<Pair>[] listas, int B, ArrayList<Pair> listaDefA, ArrayList<Pair> listaDefB, int queries, int offsetA, int offsetB) throws IOException {
        for (int i = 0; i < B / 10; ++i) {
            if (listas[4 * i + offsetA].isEmpty() && listas[4 * i + offsetB].isEmpty()) continue;
            if (listaDefA.isEmpty() && listaDefB.isEmpty()) {
                listaDefA = listas[4 * i + offsetA];
                listaDefB = listas[4 * i + offsetB];
                continue;
            }
            queries = updateLists(br, listas, listaDefA, listaDefB, queries, 4 * i, offsetA, offsetB);
        }
        return queries;
    }

    private static int updateLists(BufferedReader br, ArrayList<Pair>[] listas, ArrayList<Pair> listaDefA, ArrayList<Pair> listaDefB, int queries, int baseIndex, int offsetA, int offsetB) throws IOException {
        if (listaDefA.isEmpty()) {
            queries = handleEmptyList(br, listas, listaDefB, listaDefA, queries, baseIndex, offsetA, offsetB);
        } else {
            queries = handleNonEmptyList(br, listas, listaDefA, listaDefB, queries, baseIndex, offsetA, offsetB);
        }
        return queries;
    }

    private static int handleEmptyList(BufferedReader br, ArrayList<Pair>[] listas, ArrayList<Pair> listaDefB, ArrayList<Pair> listaDefA, int queries, int baseIndex, int offsetA, int offsetB) throws IOException {
        if (listas[baseIndex + offsetA].isEmpty()) {
            queries = compareAndUpdate(br, listaDefB, listas[baseIndex + offsetB], listaDefA, queries);
        } else {
            queries = compareAndSwap(br, listaDefB, listas[baseIndex + offsetA], listas[baseIndex + offsetB], listaDefA, queries);
        }
        return queries;
    }

    private static int handleNonEmptyList(BufferedReader br, ArrayList<Pair>[] listas, ArrayList<Pair> listaDefA, ArrayList<Pair> listaDefB, int queries, int baseIndex, int offsetA, int offsetB) throws IOException {
        if (listas[baseIndex + offsetA].isEmpty()) {
            queries = compareAndUpdate(br, listaDefA, listas[baseIndex + offsetB], listaDefB, queries);
        } else {
            queries = compareAndSwap(br, listaDefA, listas[baseIndex + offsetA], listas[baseIndex + offsetB], listaDefB, queries);
        }
        return queries;
    }

    private static int compareAndUpdate(BufferedReader br, ArrayList<Pair> listaDefRef, ArrayList<Pair> listaToCompare, ArrayList<Pair> listaToUpdate, int queries) throws IOException {
        int tempo1 = query(br, listaDefRef.get(0).a);
        int tempo2 = query(br, listaToCompare.get(0).a);
        queries += 2;
        if (tempo1 == tempo2) {
            listaDefRef.addAll(listaToCompare);
        } else {
            listaToUpdate.addAll(listaToCompare);
        }
        return queries;
    }

    private static int compareAndSwap(BufferedReader br, ArrayList<Pair> listaDefRef, ArrayList<Pair> listaToCompareA, ArrayList<Pair> listaToCompareB, ArrayList<Pair> listaToUpdate, int queries) throws IOException {
        int tempo1 = query(br, listaDefRef.get(0).a);
        int tempo2 = query(br, listaToCompareA.get(0).a);
        queries += 2;
        if (tempo1 == tempo2) {
            listaDefRef.addAll(listaToCompareA);
            listaToUpdate.addAll(listaToCompareB);
        } else {
            listaToUpdate.addAll(listaToCompareB);
            listaDefRef.addAll(listaToCompareA);
        }
        return queries;
    }

    private static void balanceQueries(BufferedReader br, int queries) throws IOException {
        while (queries % 10 != 0) {
            query(br, 1);
            queries++;
        }
    }

    private static void fillResults(BufferedReader br, char[] res, ArrayList<Pair> listaDef00, ArrayList<Pair> listaDef11, ArrayList<Pair> listaDef01, ArrayList<Pair> listaDef10) throws IOException {
        if (!listaDef00.isEmpty()) {
            fillResult(br, res, listaDef00, listaDef00.get(0).a);
        }
        if (!listaDef11.isEmpty()) {
            fillResult(br, res, listaDef11, listaDef11.get(0).a);
        }
        if (!listaDef01.isEmpty()) {
            fillResultWithPair(br, res, listaDef01, listaDef01.get(0).a, listaDef11.get(0).b);
        }
        if (!listaDef10.isEmpty()) {
            fillResultWithPair(br, res, listaDef10, listaDef10.get(0).a, listaDef10.get(0).b);
        }
    }

    private static void fillResult(BufferedReader br, char[] res, ArrayList<Pair> listaDef, int index) throws IOException {
        String s = br.readLine();
        for (Pair c : listaDef) {
            res[c.a - 1] = s.charAt(0);
            res[c.b - 1] = s.charAt(0);
        }
    }

    private static void fillResultWithPair(BufferedReader br, char[] res, ArrayList<Pair> listaDef, int indexA, int indexB) throws IOException {
        String s = br.readLine();
        String t = br.readLine();
        for (Pair c : listaDef) {
            res[c.a - 1] = s.charAt(0);
            res[c.b - 1] = t.charAt(0);
        }
    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}