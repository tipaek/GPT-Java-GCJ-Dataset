import java.util.LinkedList;

public class NestingDepth {

    public static void main(String[] args) {
        String str = "221";
        LinkedList<Character> list = new LinkedList<>();

        int initialDepth = Character.getNumericValue(str.charAt(0));
        appendCharacters(list, '(', initialDepth);
        list.add(str.charAt(0));

        for (int i = 0; i < str.length() - 1; i++) {
            int current = Character.getNumericValue(str.charAt(i));
            int next = Character.getNumericValue(str.charAt(i + 1));

            if (current > next) {
                appendCharacters(list, ')', current - next);
            } else if (current < next) {
                appendCharacters(list, '(', next - current);
            }
            list.add(str.charAt(i + 1));
        }

        int finalDepth = Character.getNumericValue(str.charAt(str.length() - 1));
        appendCharacters(list, ')', finalDepth);

        for (char c : list) {
            System.out.print(c);
        }
    }

    private static void appendCharacters(LinkedList<Character> list, char ch, int count) {
        for (int i = 0; i < count; i++) {
            list.add(ch);
        }
    }
}