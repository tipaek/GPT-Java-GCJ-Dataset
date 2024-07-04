import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfTestCase = Integer.valueOf(br.readLine());
        int caseNumber = 1;
        if (numOfTestCase >= 1 && numOfTestCase <= 100){
            while (numOfTestCase > 0) {
                try {
                    int N = Integer.valueOf(br.readLine());
                    if (N >= 2 && N <= 100) {
                        int trace = 0;
                        int rowRepeat = 0;
                        long colRepeat = 0;
                        int j = 0;

                        Map<Integer, Set<Integer>> columnMap = new HashMap<>();

                        boolean fail = false;

                        boolean colDup = false;
                        Map<Integer, Boolean> map = new HashMap<>();
                        for (int i = 0; i < N; i++) {
                            String[] dataValues = br.readLine().split(" ");
                            Set<Integer> rowSet = new HashSet<>();
                            boolean rowDup = false;
                            if (dataValues.length == N) {
                                trace += Integer.valueOf(dataValues[j++]);
                                for (int k = 0; k < N; k++) {
                                    if (Integer.valueOf(dataValues[k]) >= 1 && Integer.valueOf(dataValues[k]) <= N) {
                                        if (!rowSet.add(Integer.valueOf(dataValues[k])))
                                            rowDup = true;
                                        if (!columnMap.containsKey(k)) {
                                            columnMap.put(k, new HashSet<>());
                                            colDup = !(columnMap.get(k).add(Integer.valueOf(dataValues[k])));
                                        } else {
                                            colDup = !(columnMap.get(k).add(Integer.valueOf(dataValues[k])));
                                        }

                                        if (map.containsKey(k) && !map.get(k) && colDup) {
                                            map.put(k, colDup);
                                        } else if (!map.containsKey(k)) {
                                            map.put(k, colDup);
                                        }
                                    } else {
                                        fail = true;
                                        break;
                                    }
                                }
                                rowRepeat = rowDup ? rowRepeat+1 : rowRepeat;
                                if (fail) {
                                    trace = rowRepeat = 0;
                                    colRepeat = 0l;
                                    break;
                                }
                            }
                        }
                        colRepeat = map.values().stream().filter(k -> k.equals(Boolean.TRUE)).count();
                        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeat + " " + colRepeat);

                    } else {
                        System.out.println("Case #" + caseNumber + ": 0 0 0");
                    }

                    caseNumber++;
                    numOfTestCase--;
                } catch (Exception ex) {
                    System.out.println("Case #" + caseNumber + ": 0 0 0");
                }
            }
            br.close();
        }



    }
}
