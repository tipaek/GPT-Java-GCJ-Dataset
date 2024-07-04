import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++){
            String str = random(br);
            System.out.format("Case #%d: %s\n", j, str);
        }
    }

    public static String pancake(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int D = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");

        Map<Long, Long> map = new HashMap<>();

        for(String str : line) {
            Long a = Long.parseLong(str);
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }
            else{
                map.put(a, 1L);
            }
        }
        long count = 0;

        List<Map.Entry<Long, Long>> valueList = map.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());
        List<Map.Entry<Long, Long>> sizeList = map.entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).collect(Collectors.toList());

        for(Map.Entry<Long, Long> entry : valueList){
            count = 0;
            if(entry.getValue() >= D)
                return 0+"";

            for(Map.Entry<Long, Long> sizeEntry : sizeList){
                if(sizeEntry.getKey().equals(entry.getKey()))
                    break;
                count+=sizeEntry.getValue();
            }
            if(count + entry.getValue() >= D){
                return D-entry.getValue()+"";
            }
        }

        return D-1+"";
    }

    public static String random(BufferedReader br) throws IOException {
        int U = Integer.parseInt(br.readLine());
        List<Query> list = new ArrayList<>();

        String all = "";
        for(int i=0; i<10000; i++) {
            String[] line = br.readLine().split(" ");
            String q = line[0];
            String r = line[1];


            for(char c : q.toCharArray()){
                if(all.indexOf(c) < 0){
                    all += c;
                }
            }

            if(q.length() != r.length()){
                continue;
            }

            if(!q.equals("-1")){
                list.add(new Query(q, r));
            }
        }

        char[] mapping = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        String[] strings = new String[]{"", "", "", "", "", "", "", "", "", ""};
        String mapped = "";

        list.sort(Comparator.comparing(a -> a.q));
        for (Query q : list) {
            int firstDigit = q.q.charAt(0) - '0';
            char firstChar = q.r.charAt(0);


            for(char c : q.r.toCharArray()){
                if(strings[0].indexOf(c) < 0){
                    strings[0] += c;
                }
                if(all.indexOf(c) < 0){
                    all += c;
                }
            }

            if(mapped.indexOf(firstChar) >= 0){
                continue;
            }
            for(int i=firstDigit; i>0; i--) {
                if(strings[i].indexOf(firstChar) < 0){
                        strings[i] += firstChar;
                }
            }

            if(firstDigit == 1){
                mapping[1] = firstChar;
                mapped+=firstChar;
                for(int i=0; i<strings.length; i++){
                    strings[i] = strings[i].replace(firstChar+"", "");
                }
            }

            if(firstDigit>1 && mapping[firstDigit-1]!=' '){
                boolean con = false;
                for(int i=1; i<firstDigit; i++){
                    if(mapping[i] == firstChar)
                        con = true;
                }
                if(con)
                    continue;
                mapping[firstDigit] = firstChar;
                mapped+=firstChar;
                for(int i=0; i<strings.length; i++){
                    strings[i] = strings[i].replace(firstChar+"", "");
                }
            }
        }

        if(new String(mapping).isEmpty()){
            return all;
        }
        for(char c : mapping){
            all = all.replace(c+"", "");
        }
        mapping[0] = all.charAt(0);
        return new String(mapping);
    }
    public static boolean arrayContains(char[] arr, char c){
        for(char a : arr)
            if(a == c)
                return true;

        return false;
    }



    static class Query implements Comparable<Query> {
        String q;
        String r;

        public Query(String q, String r) {
            this.q = q;
            this.r = r;
        }

        @Override
        public int compareTo(Query o) {
            return q.compareTo(o.q);
        }
    }

    public static String fan(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        String M = line[2];
        List<Integer> xCat = new ArrayList<>();
        List<Integer> yCat = new ArrayList<>();

        xCat.add(x);
        yCat.add(y);
        for(char c : M.toCharArray()){
            switch (c){
                case 'N':
                    yCat.add(yCat.get(yCat.size()-1)+1);
                    xCat.add(xCat.get(xCat.size()-1));
                    break;
                case 'S':
                    yCat.add(yCat.get(yCat.size()-1)-1);
                    xCat.add(xCat.get(xCat.size()-1));
                    break;
                case 'E':
                    xCat.add(xCat.get(xCat.size()-1)+1);
                    yCat.add(yCat.get(yCat.size()-1));
                    break;
                case 'W':
                    xCat.add(xCat.get(xCat.size()-1)-1);
                    yCat.add(yCat.get(yCat.size()-1));
                    break;
            }
        }
        for(int i=0; i<xCat.size(); i++){
            if(Math.abs(xCat.get(i)) + Math.abs(yCat.get(i)) <= i){
                return i + "";
            }
        }

        return "IMPOSSIBLE";
    }
}
