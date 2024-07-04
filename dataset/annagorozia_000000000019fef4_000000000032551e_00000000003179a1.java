

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Pair {
        Long num;
        String val;

        public Pair(Long num, String val) {
            this.num = num;
            this.val = val;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File myObj = new File("input.txt");

//        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner myReader = new Scanner(myObj);

        int T = Integer.parseInt(myReader.nextLine());
        Map<Long, List<String>> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.num.compareTo(o2.num);
            }
        });
        Character[] res = new Character[10];
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < T; i++) {
            int u = myReader.nextInt();
            for (int j = 0; j < 10000; j++) {
                pq.add(new Pair(myReader.nextLong(), myReader.nextLine().replaceAll("\\s+","")));
            }

            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                if (pair.num / 10 == 0 && res[Math.toIntExact(pair.num)] != null) continue;
                if (pair.num == 1) {
                    res[1] = pair.val.charAt(0);
                    charSet.add(pair.val.charAt(0));
                    continue;
                }
                if (pair.num / 10 == 0 && notEqualToOthers(res, pair.val, pair.num)) {
                    charSet.add(pair.val.charAt(0));
                    res[Math.toIntExact(pair.num)] = pair.val.charAt(0);
                    continue;
                }
                char[] arr = pair.val.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    if (!charSet.contains(arr[j])) {
                        res[0] = arr[j];
                        break;
                    }
                }

            }
            String r = "";
            for (int j = 0; j < res.length; j++) {
                r += res[j];
            }
            System.out.println("Case #" + (i + 1) + ": " + r);
        }

        myReader.close();
    }

    private static boolean notEqualToOthers(Character[] res, String val, Long num) {
        for (int i = 0; i < num; i++) {
            if (res[i] != null && val.charAt(0) == res[i]) {
                return false;
            }
        }
        return true;
    }


}
