import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++){
            String str = random(br);
            System.out.format("Case #%d: %s\n", j, str);
        }
    }

    public static String random(BufferedReader br) throws IOException {
        int U = Integer.parseInt(br.readLine());
        List<Query> list = new ArrayList<>();

        for(int i=0; i<10000; i++) {
            String[] line = br.readLine().split(" ");
            String q = line[0];
            String r = line[1];

            if(q.length() != r.length()){
                continue;
            }

            if(!q.equals("-1")){
                list.add(new Query(q, r));
            }
        }

        char[] mapping = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        list.sort(Comparator.comparing(a -> a.q));
        while(mapping[0] == ' ') {
            for (Query q : list) {
                int firstDigit = q.q.charAt(0) - '0';
                char firstChar = q.r.charAt(0);

                if (mapping[9] == ' ') {
                    boolean con = false;
                    for (int i = 1; i < firstDigit; i++) {
                        if (mapping[i] == ' ' || mapping[i] == firstChar) {
                            con = true;
                            break;
                        }
                    }
                    if (con)
                        continue;

                    mapping[firstDigit] = q.r.charAt(0);
                } else {
                    for (char c : q.r.toCharArray()) {
                        if (!arrayContains(mapping, c)) {
                            mapping[0] = c;
                            return new String(mapping);
                        }
                    }
                }
            }
        }

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
