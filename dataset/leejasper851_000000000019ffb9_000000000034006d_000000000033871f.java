import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int numComps = Integer.parseInt(st.nextToken());
            int numCons = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(reader.readLine());
            int[] info = new int[numComps];
            for (int i = 1; i < numComps; i++) {
                info[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer>[] cons = new ArrayList[numComps];
            for (int i = 0; i < numComps; i++) {
                cons[i] = new ArrayList<>();
            }
            Con[] conOrder = new Con[numCons];
            Con[][] conSet = new Con[numComps][numComps];
            for (int i = 0; i < numCons; i++) {
                st = new StringTokenizer(reader.readLine());
                int compA = Integer.parseInt(st.nextToken())-1;
                int compB = Integer.parseInt(st.nextToken())-1;
                cons[compA].add(compB);
                cons[compB].add(compA);
                Con con = new Con(compA, compB);
                conOrder[i] = con;
                conSet[compA][compB] = con;
                conSet[compB][compA] = con;
            }
            
            int[] vals = new int[numComps];
            ArrayList<Comp> numBefs = new ArrayList<>();
            PriorityQueue<Comp> unorder = new PriorityQueue<>();
            for (int i = 1; i < numComps; i++) {
                if (info[i] < 0) {
                    numBefs.add(new Comp(i, -info[i], 0));
                } else {
                    vals[i] = info[i];
                    unorder.add(new Comp(i, 0, vals[i]));
                }
            }
            Collections.sort(numBefs);

            numBefs.add(0, new Comp(0, 0, 0));
            for (int i = 1; i < numBefs.size(); i++) {
                if (numBefs.get(i).bef != numBefs.get(i - 1).bef && numBefs.get(i).bef != i) {
                    numBefs.add(i, unorder.remove());
                }
            }
            while (!unorder.isEmpty()) {
                numBefs.add(unorder.remove());
            }
            
            for (int i = 1; i < numBefs.size(); i++) {
                if (numBefs.get(i).val == 0) {
                    if (numBefs.get(i - 1).bef == 0) {
                        numBefs.get(i).val = numBefs.get(i - 1).val + 1;
                    } else {
                        if (numBefs.get(i).bef == numBefs.get(i - 1).bef) {
                            numBefs.get(i).val = numBefs.get(i - 1).val;
                        } else {
                            numBefs.get(i).val = numBefs.get(i - 1).val + 1;
                        }
                    }
                }
            }
            
            for (int i = 1; i < numBefs.size(); i++) {
                vals[numBefs.get(i).num] = numBefs.get(i).val;
            }
            
            vals[0] = 0;
            boolean[] visited = new boolean[numComps];
            traverse(0, visited, cons, conSet, vals);
            System.out.print("Case #" + caseN + ":");
            for (int i = 0; i < numCons; i++) {
                System.out.print(" " + conOrder[i].lat);
            }
            System.out.println();
        }
        reader.close();
        writer.close();
    }
    
    private static class Con {
        public int compA;
        public int compB;
        public int lat;
        
        public Con(int cA, int cB) {
            compA = cA;
            compB = cB;
            lat = 1000000;
        }
        
        public boolean equals(Con other) {
            if (compA == other.compA && compB == other.compB) {
                return true;
            }
            if (compA == other.compB && compB == other.compA) {
                return true;
            }
            return false;
        }
    }
    
    private static class Comp implements Comparable<Comp> {
        public int num;
        public int bef;
        public int val;
        
        public Comp(int n, int b, int v) {
            num = n;
            bef = b;
            val = v;
        }
        
        public int compareTo(Comp other) {
            if (bef != other.bef) {
                return bef - other.bef;
            }
            return val - other.val;
        }
    }
    
    private static void traverse(int num, boolean[] visited, ArrayList<Integer>[] cons, Con[][] conSet, int[] vals) {
        visited[num] = true;
        for (int adj : cons[num]) {
            if (!visited[adj]) {
                conSet[num][adj].lat = vals[adj] - vals[num];
                if (conSet[num][adj].lat == 0) {
                    conSet[num][adj].lat = 1;
                }
                traverse(adj, visited, cons, conSet, vals);
            }
        }
    }
}