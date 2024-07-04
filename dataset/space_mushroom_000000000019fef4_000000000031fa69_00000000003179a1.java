import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Use this in Google Code Jam/Google KickStart
public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String solve(List<Couple> couples) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for(Couple couple : couples){
            for(int i=0; i< couple.str.length(); i++){
                char c = couple.str.charAt(i);
                if(!map.containsKey(c))
                    initializeChar(c, map);
            }
        }

        for(int i=0; i<couples.size(); i++){
            updateMap(couples.get(i), map);
            autoUpdateMap(map);
            if(checkIfFound(map))
                break;
        }

        return mapValues(map);
    }

    private static void autoUpdateMap(Map<Character, List<Integer>> map) {
        for(char c : map.keySet()){
            if(map.get(c).size() == 1){
                for(char c1 : map.keySet()){
                    if(c1 == c)
                        continue;
                    map.get(c1).remove(Integer.valueOf(map.get(c).get(0)));
                }
            }
        }
    }

    private static String mapValues(Map<Character, List<Integer>> map) {
        String resultingKey = "";
        for(int i=0; i<10; i++){
            for(char c: map.keySet()){
                if(map.get(c).get(0) == i) {
                    resultingKey += c;
                    break;
                }
            }
        }

        return resultingKey;
    }

    private static void updateMap(Couple couple, Map<Character, List<Integer>> map) {
        char firstChar = couple.str.charAt(0);
        map.get(firstChar).remove(Integer.valueOf(0));

        String numAsString = String.valueOf(couple.num);
        if(numAsString.length() != couple.str.length())
            return;

        for(int i = 9; i> (int) numAsString.charAt(0)-'0'; i--){
            map.get(firstChar).remove(Integer.valueOf(i));
        }
    }

    private static void initializeChar(char c, Map<Character, List<Integer>> map) {
        map.put(c, new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9)));
    }

    private static boolean checkIfFound(Map<Character, List<Integer>> map) {
        if(map.size() != 10)
            return false;
        for(char c : map.keySet()){
            if(map.get(c).size() == 0)
                System.out.println("ERROR!");
            if(map.get(c).size() != 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            int U = input.nextInt();
            input.nextLine();

            String s;
            List<Couple> couples = new ArrayList<>();
            for(int j=0; j<10000; j++){
                s = input.nextLine();
                String[] split = s.split(" ");
                int num = Integer.parseInt(split[0]);
                String str = split[1];
                couples.add(new Couple(num, str));
            }

            System.out.println("Case #" + (i + 1) + ": " + solve(couples));
        }
    }

    private static class Couple{
        private int num;
        private String str;

        public Couple(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}