import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // write your code here
        long T, t, cut, N, D, i, s, count;
        TreeMap<Long, Long> freqMap = new TreeMap<>();
        TreeMap<Long, List<Long>> countMap = new TreeMap<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        T = sc.nextLong();
        for(t = 1; t <= T; t++) {
            N = sc.nextLong();
            D = sc.nextLong();
            freqMap.clear();
            countMap.clear();
            cut = D - 1;

            for(i = 0; i < N; i++) {
                s = sc.nextLong();
                count = 1L;
                if(freqMap.containsKey(s)) {
                    count = freqMap.get(s) + 1;
                }
                freqMap.put(s, count);
                if(count >= D) {
                    cut = 0;
                    break;
                }
            }

            if(cut > 0) {
                for (Map.Entry<Long, Long> me : freqMap.entrySet()) {
                    if(!countMap.containsKey(me.getValue())) countMap.put(me.getValue(), new LinkedList<>());
                    countMap.get(me.getValue()).add(me.getKey());
                }

                for(Map.Entry<Long, List<Long>> me : countMap.entrySet()) {
                    for(Long key : me.getValue()) {
                        SortedMap<Long, Long> tailMap = freqMap.tailMap(key);
                        for(Map.Entry<Long, Long> entry : tailMap.entrySet()) {
                            if(entry.getKey().equals(key)) continue;
                            if(entry.getKey() % key == 0) {
                                long curCut = (entry.getKey() / key - 1);
                                if(curCut < cut) cut = curCut;
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + t + ": " + cut);
        }
    }
}