import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int test = 1; test<=t; test++){
            int n = in.nextInt();
            List<String> words = new ArrayList<>();
            boolean type1 = true;
            for(int i=0; i<n; i++){
                String word = in.next();
                if(word.charAt(0)!='*'){
                    type1=false;
                }
                words.add(word);
            }
            if(type1) {
                solveType1(words, test, n);
            }
            else {
                solveType2(words, test, n);
            }
        }
    }

    private static void solveType2(List<String> words, int test, int n) {
        String answerPrefix = "";
        String answerSuffix = "";
        boolean possible = true;
        for (String word: words){
            int astIndex = word.indexOf('*');
            String wordPrefix = "";
            String wordSuffix = "";
            if(astIndex==0){
                wordPrefix = "";
                wordSuffix = word.substring(1);
            } else if(astIndex == word.length()-1){
                wordPrefix = word.substring(0, word.length()-1);
                wordSuffix = "";
            }
            else{
                wordPrefix = word.substring(0, astIndex);
                wordSuffix = word.substring(astIndex+1);
            }
            if(compatible(wordPrefix, answerPrefix) && compatible(wordSuffix, answerSuffix)){
                if(wordPrefix.length()>answerPrefix.length()){
                    answerPrefix=wordPrefix;
                }
                if(wordSuffix.length() > answerSuffix.length()){
                    answerSuffix=wordSuffix;
                }
            }
            else {
                possible = false;
            }


        }
        if (possible) System.out.println(String.format("Case #%d: %s", test, answerPrefix+answerSuffix));
        else {
            System.out.println(String.format("Case #%d: *", test));
        }
    }

    private static boolean compatible(String wordPrefix, String answerPrefix) {
        if(wordPrefix.length() > answerPrefix.length()){
            return wordPrefix.contains(answerPrefix);
        }
        else return answerPrefix.contains(wordPrefix);
    }

    private static void solveType1(List<String> words, int test, int n) {
        PriorityQueue<String> pq = new PriorityQueue<String>(Comparator.comparing(String::length).reversed());
        pq.add(words.get(0));
        boolean possible = true;
        for(int i = 1; i<n; i++){
            String next = words.get(i);
            String head = pq.peek();
            for(int j=0; j<Math.min(next.length(), head.length())-1;j++){
                if(next.charAt(next.length()-1-j) != head.charAt(head.length()-1-j)){
                    possible = false;
                }
            }
            pq.add(next);
        }
        if(possible){
            String answer = pq.poll().substring(1);
            System.out.println(String.format("Case #%d: %s", test, answer));
        }
        else {
            System.out.println(String.format("Case #%d: *", test));
        }
    }
}
