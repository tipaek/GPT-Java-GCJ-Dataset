import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));   
            //scanner = new Scanner(new BufferedReader(new FileReader("/Users/macbook/Coding/codejam/src/year2020/round1C/input")));     	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int bound = scanner.nextInt();
                List<Map<Character, Long>> data = new ArrayList<>(10);
                for (int i = 0; i < 10; i++) {
                    data.add(new HashMap<>());
                }
                
                for (int i=0;i<10000;++i) {
                    char[] t = String.valueOf(scanner.nextLong()).toCharArray();
                    char[] s = scanner.next().toCharArray();
                    for (int j = 0; j < s.length; j++) {
                        Map<Character, Long> temp = data.get(Integer.parseInt(t[j] + ""));
                        temp.put(s[j], temp.getOrDefault(s[j], 0L) + 1);
                    }
                }
                
                String result = "";
                Set<Character> set = new HashSet<>();
                for (int i=0;i<10;++i) {
                    Map<Character, Long> temp = data.get(i);
                    LinkedHashMap<Character, Long> map = new LinkedHashMap<>();
                    temp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                    .forEachOrdered(x -> map.put(x.getKey(), x.getValue()));
                                                    
                    for (Map.Entry<Character, Long> entry: map.entrySet()) {
                        if (!set.contains(entry.getKey())) {
                            result += entry.getKey();
                            set.add(entry.getKey());
                            break;
                        }
                    }
                }

                System.out.println("Case #" + (idx+1) + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}