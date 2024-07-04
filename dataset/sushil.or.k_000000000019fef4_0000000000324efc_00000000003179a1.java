import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int bound = scanner.nextInt();
                List<Map<Character, Integer>> data = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    data.add(new HashMap<>());
                }
                for (int i=0;i<10000;++i) {
                    char[] t = String.valueOf(scanner.nextLong()).toCharArray();
                    char[] s = scanner.next().toCharArray();
                    for (int j = 0; j < s.length; j++) {
                        Map<Character, Integer> temp = data.get(t[i] + '0');
                        temp.put(s[i], temp.getOrDefault(s[i], 0) + 1);
                    }
                }
                
                String result = "";
                for (int i=0;i<10;++i) {
                    Map<Character, Integer> temp = data.get(i);
                    Map.Entry<Character, Integer> entry = temp
                                                            .entrySet()
                                                            .stream()
                                                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                                            .findFirst().get();
                    result += entry.getKey();
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