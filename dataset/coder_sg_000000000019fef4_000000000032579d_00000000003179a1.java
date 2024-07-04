import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            int u = Integer.parseInt(br.readLine());
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int total[] = new int[10];

            for(int d = 0; d < 10; d++) {
                Map<Integer, Integer> tempMap = new HashMap<>();
                for(int c = 0; c < 26; c++) 
                    tempMap.put(c, 0);
                map.put(d, tempMap);
            }

            for(int q = 0; q < 10000; q++) {
                String[] query = br.readLine().split(" ");
                String m = query[0];
                String response = query[1];
                if(m.length() != response.length())
                    continue;
                boolean digitsVisited[] = new boolean[10];    
                for(int j = 0; j < m.length(); j++) {
                    char d = m.charAt(j);
                    if(!digitsVisited[d]) {
                        int digit = Integer.parseInt(String.valueOf(d));
                        total[digit]++;
                        Map<Integer, Integer> tempMap = map.get(digit);
                        char ch = response.charAt(j);
                        int c = ch-'A';
                        tempMap.put(c, tempMap.get(c)+1);
                        map.put(digit, tempMap);
                        digitsVisited[d] = true;
                    }
                }
            }

            StringBuilder ans = new StringBuilder();
            boolean taken[] = new boolean[26];

            for(int d = 0; d < 10; d++) {
                Map<Integer, Integer> tempMap = map.get(d);
                double max = 0.0D;
                char ch = 'A';
                for(int c = 0; c < 26; c++) {
                    if(taken[c])
                        continue;
                    double p = tempMap.get(c) / (double)total[d];
                    if(p > max) {
                        max = p;
                        ch = (char)('A'+c);
                    }
                }
                taken[ch-'A'] = true;
                ans.append(ch);
            }

            sb.append("Case #"+(i+1)+": "+ans+"\n");
        }
        System.out.print(sb);
    } 
}
