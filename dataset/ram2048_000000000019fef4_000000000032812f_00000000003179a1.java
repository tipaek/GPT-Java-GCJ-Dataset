import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int U = in.nextInt();
            String[] Q = new String[10000];
            String[] R = new String[10000];
            for (int i = 0; i < 10000; i++) {
                Q[i] = in.next();
                R[i] = in.next();

            }
            System.out.println("Case #" + t + ": " + decode(U, Q, R));
        }
    }

    public static String decode(int U, String[] Q, String[] R) {
        Map<Character, Integer> map = new HashMap<>();
        int[] max = new int[10];
        Arrays.fill(max, 9);
        int[] min = new int[10];

        List<String> qlist = new ArrayList<>();
        List<String> rlist = new ArrayList<>();
        int minusCount = 0;
        for (int i = 0; i < Q.length; i++) {
            for (char ch: R[i].toCharArray()) {
                if (!map.containsKey(ch)) {
                    map.put(ch, map.size());
                }
            }

            char first = R[i].toCharArray()[0];
            int findex = map.get(first);
            min[findex] = 1;

            if (Q[i].equals("-1")) {
                minusCount++;
            } else if (Q[i].length() == R[i].length()) {
                max[findex] = Math.min(max[findex], Q[i].toCharArray()[0]-'0');

                qlist.add(Q[i]);
                rlist.add(R[i]);
            }
        }
        Map<Integer, Character> characterMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            characterMap.put(entry.getValue(), entry.getKey());
        }
        Map<Character, Integer> valueMap = new HashMap<>();

        StringBuilder result = new StringBuilder();
        boolean[] placed = new boolean[10];
        for (int i = 0; i < 10; i++) {
            if (min[i] == 0) {
                result.append(characterMap.get(i));
                placed[i] = true;
                valueMap.put(characterMap.get(i), 0);
            }
        }
        if (minusCount == Q.length) {
            int[] counts = new int[10];
            for (String q: Q) {
                if (q.length() == U) {
                    char first = q.toCharArray()[0];
                    int findex = map.get(first);
                    counts[findex]++;
                }
            }
            while (result.length() < 10) {
                int next = -1;
                int mx = -1;
                for (int i = 0; i < 10; i++) {
                    if (placed[i]) continue;
                    if (counts[i] > mx) {
                        mx = counts[i];
                        next = i;
                    }
                }
                valueMap.put(characterMap.get(next), result.length());
                result.append(characterMap.get(next));
                placed[next] = true;
            }
        } else {
            while (result.length() < 10) {
                List<Integer> indexList = new LinkedList<>();
                for (int i = 0; i < 10; i++) {
                    if (placed[i]) continue;
                    if (max[i] == result.length()) {
                        indexList.add(i);
                    }
                }
                if (indexList.size() == 1) {
                    // great!
                    int ind = indexList.get(0);
                    valueMap.put(characterMap.get(ind), result.length());
                    result.append(characterMap.get(ind));
                    placed[ind] = true;
                } else {
                    List<String> nqlist = new LinkedList<>();
                    List<String> nrlist = new LinkedList<>();
                    for (int i = 0; i < qlist.size(); i++) {
                        char[] qchars = qlist.get(i).toCharArray();
                        char[] rchars = rlist.get(i).toCharArray();
                        int ci = 0;
                        while (ci < qchars.length) {
                            char rch = rchars[ci];
                            if (valueMap.containsKey(rch)) {
                                if (valueMap.get(rch) < (qchars[ci]-'0')) {
                                    break;
                                }
                            } else {
                                max[map.get(rch)] = Math.min(max[map.get(rch)], qchars[ci]-'0');
                                if (ci < qchars.length-1) {
                                    nqlist.add(qlist.get(i));
                                    nrlist.add(rlist.get(i));
                                }
                                break;
                            }
                            ci++;
                        }
                    }
                    qlist = nqlist;
                    rlist = nrlist;
                }
            }
        }

        return result.toString();
    }
}
