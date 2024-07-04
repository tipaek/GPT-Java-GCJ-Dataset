import java.util.*;
import java.io.*;

public class Solution {

    private static final char CHAR_ASTERISK = '*';

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testTotalCount = Integer.parseInt(in.nextLine());

        for (int testCase = 1; testCase <= testTotalCount; testCase++) {
            int inputCount = Integer.parseInt(in.nextLine());

            List<String> list = new ArrayList<>();
            while (inputCount-- > 0) {
                String input = in.nextLine();
                list.add(input);
            }

            System.out.println(new String().format("Case #%s: %s", testCase, new DTO(list).findResult()));
        }
    }

    static class DTO {
        private List<Character> startList = new ArrayList<>();
        private List<Character> endList = new ArrayList<>();

        private List<String> wordList;

        public DTO(List<String> wordList) {
            this.wordList = wordList;
//            this.wordList = removeDuplicateAsterisk(wordList);
        }

        private List<String> removeDuplicateAsterisk(List<String> wordList) {
            for (int i = 0; i < wordList.size(); i++) {
                String newWord = "";
                boolean isBeforeAsterisk = false;

                String word = wordList.get(i);
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(i) == CHAR_ASTERISK) {
                        if (isBeforeAsterisk) {
                            continue;
                        }
                        isBeforeAsterisk = true;
                        newWord += word.charAt(j);
                    } else {
                        isBeforeAsterisk = false;
                        newWord += word.charAt(j);
                    }
                }

                wordList.set(i, newWord);
            }

            return wordList;
        }

        private String findResult() {
            for (String word : this.wordList) {
                String[] splitWords = word.split("\\*");

                //start
                boolean isStartSuccess = process(splitWords[0], startList);
                if (!isStartSuccess) {
                    return String.valueOf(CHAR_ASTERISK);
                }

                //end
                boolean isEndSuccess = processReverse(splitWords[1], endList);
                if (!isEndSuccess) {
                    return String.valueOf(CHAR_ASTERISK);
                }
            }

            String result = "";
            for (Character c : startList) {
                result += c;
            }

            for (int i = endList.size() - 1 ; i >= 0 ; i--) {
                result += endList.get(i);
            }

            return result;
        }

        private boolean checkList(List<Character> tempList, List<Character> list) {
            int minSize = Math.min(tempList.size(), list.size());
            for (int i = 0; i < minSize; i++) {
                if (!list.get(i).equals(tempList.get(i))) {
                    return false;
                }
            }

            return true;
        }

        private boolean process(String splitWords, List<Character> list) {
            List<Character> tempList = new ArrayList<>();
            for (char c : splitWords.toCharArray()) {
                tempList.add(c);
            }

            boolean checkStart = checkList(tempList, list);
            if (!checkStart) {
                return false;
            }

            if (tempList.size() > list.size()) {
                list.addAll(tempList.subList(list.size(), tempList.size()));
            }

            return true;
        }

        private boolean processReverse(String splitWords, List<Character> list) {
            List<Character> tempList = new ArrayList<>();
            char[] chars = splitWords.toCharArray();
            for (int i = chars.length - 1 ; i >= 0 ; i--) {
                tempList.add(chars[i]);
            }

            boolean checkStart = checkList(tempList, list);
            if (!checkStart) {
                return false;
            }

            if (tempList.size() > list.size()) {
                list.addAll(tempList.subList(list.size(), tempList.size()));
            }

            return true;
        }
    }
}
