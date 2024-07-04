import java.util.*;

class Solution {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        outer:
        for (int i = 0; i < t; i++) {
            int pieces = sc.nextInt();
            int diners = sc.nextInt();
            HashMap<Long, Integer> freq = new HashMap<>();
            for (int j = 0; j < pieces; j++) {
                long piece = sc.nextLong();
                if (freq.containsKey(piece)) {
                    freq.put(piece, freq.get(piece) + 1);
                } else {
                    freq.put(piece, 1);
                }
            }
            freq = sortByValue(freq);
            int maxFreq = 0;
            long mkey = 0;
            int secondmaxFreq = -1;
            long smk = 0;
            int ctr = 0;
            for (Map.Entry<Long, Integer> en : freq.entrySet()) {
                if (ctr == 0) {
                    maxFreq = en.getValue();
                    mkey = en.getKey();
                    ctr++;
                } else {
                    secondmaxFreq = en.getValue();
                    smk = en.getKey();
                    break;
                }
            }
            if (maxFreq >= diners) {
                System.out.println("Case #" + (i + 1) + ": 0");
            }
            else if (diners == 2) {
                System.out.println("Case #" + (i + 1) + ": 1");
            } else {
                for (Map.Entry<Long, Integer> en : freq.entrySet()) {
                    if (freq.containsKey(en.getKey() * 2)) {
                        System.out.println("Case #" + (i + 1) + ": 1");
                        continue outer;
                    }
                }
                if (secondmaxFreq >= 2) {
                    System.out.println("Case #" + (i + 1) + ": 1");
                    continue outer;
                }
                else {
                    System.out.println("Case #" + (i + 1) + ": 2");
                    continue outer;
                }
//                if (freq.size() >= 3) {
//                    System.out.println("Case #" + (i + 1) + ": 2");
//                    continue outer;
//                }
//                if (mkey > 2 * smk) {
//                    System.out.println("Case #" + (i + 1) + ": 2");
//                }
            }

        }
    }

    public static HashMap<Long, Integer> sortByValue(HashMap<Long, Integer> hm)
    {
        List<Map.Entry<Long, Integer> > list = new LinkedList<Map.Entry<Long, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, Integer> >() {
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Long, Integer> temp = new LinkedHashMap<Long, Integer>();
        for (Map.Entry<Long, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}