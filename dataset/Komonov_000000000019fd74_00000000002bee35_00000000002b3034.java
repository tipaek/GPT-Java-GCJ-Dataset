import java.text.CharacterIterator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Problem p1 = new Problem();
    }
}

class Problem {
    LinkedList<Character> start;
    LinkedList<Character> tail;
    LinkedList<LinkedList<Character>> middle = new LinkedList<>();

    public Problem() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            System.out.println("Case #" + (i + 1) + ": " + solve(sc));
        }
    }

    String solve(Scanner sc) {
        boolean correct=true;
        int N = sc.nextInt();
        start = new LinkedList<>();
        tail = new LinkedList<>();
        for (int i = 0; i < N; ++i) {
            LinkedList<Character> start_l = new LinkedList<>();
            LinkedList<Character> tail_l = new LinkedList<>();
            String s = sc.next();
            boolean start_ast = false;
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == '*') {
                    if (!start_ast) {
                        start_ast = true;
                    } else {
                        add_to_middle(tail_l);
                        tail_l = new LinkedList<>();
                    }
                } else {
                    if (!start_ast)
                        start_l.addLast(s.charAt(j));
                    else {
                        tail_l.addLast(s.charAt(j));
                    }
                }
            }
            if (start_ast) {
                if (!update_start(start_l)) correct=false;
                if (!update_tail(tail_l)) correct=false;
            }
        }
        if(correct) {
            char[] merged = mix();
            if (merged != null) return print(merged, true);
            else return print(null, false);
        }
        else{
            return print(null, false);
        }
    }

    private char[] mix() {
        int sum = 0;
        for (LinkedList<Character> s : middle) sum += s.size();
        int over = start.size() + tail.size() + sum;
        if (over > 10000) {
            for (LinkedList<Character> word : middle) {
                int economy = try_to_insert(word, over - 10000);
                if (economy != 0) word.clear();
                over -= economy;
                if(over<=10000) break;
            }
            if(over>10000) return null;
            sum = 0;
            for (LinkedList<Character> s : middle) sum += s.size();
        }
        char[] res = new char[over];
        int i = 0;
        for (char c : start) res[i++] = c;
        for (LinkedList<Character> s : middle) {
            for (char c : s) res[i++] = c;
        }
        for (char c : tail) res[i++] = c;
        return res;
    }

    private int try_to_insert(LinkedList<Character> word, int need_economy) {
        LinkedList<Character> best_word = null;
        boolean as_start = true;
        int economy = 0;
        for (LinkedList<Character> other : middle) {
            int curr_ec = 0;
            if (!other.equals(word)) {
                Iterator<Character> main_i = word.descendingIterator();
                Iterator<Character> new_i = other.iterator();
                char main_c, new_c;
                main_c = main_i.next();
                new_c = new_i.next();
                while (main_c != 0 || new_c != 0) {
                    if (main_c == new_c) curr_ec++;
                    else break;
                    main_c = (main_i.hasNext()) ? main_i.next() : 0;
                    new_c = (new_i.hasNext()) ? new_i.next() : 0;
                }
                if (economy < curr_ec) {
                    best_word = other;
                    as_start = true;
                    economy = curr_ec;
                }
                if (curr_ec >= need_economy) {
                    break;
                }

                main_i = word.iterator();
                new_i = other.descendingIterator();
                main_c = main_i.next();
                new_c = new_i.next();
                while (main_c != 0 || new_c != 0) {
                    if (main_c == new_c) curr_ec++;
                    else break;
                    main_c = (main_i.hasNext()) ? main_i.next() : 0;
                    new_c = (new_i.hasNext()) ? new_i.next() : 0;
                }
                if (economy < curr_ec) {
                    best_word = other;
                    as_start = false;
                    economy = curr_ec;
                }
                if (curr_ec >= need_economy) {
                    break;
                }
            }
        }
        if (best_word != null) merge_words(word, best_word, as_start);
        return economy;
    }

    private void merge_words(LinkedList<Character> word, LinkedList<Character> other, boolean as_start) {
        Iterator<Character> main_i = (as_start) ? word.descendingIterator() : word.iterator();
        Iterator<Character> new_i = (!as_start) ? other.descendingIterator() : other.iterator();
        char main_c, new_c;
        main_c = main_i.next();
        new_c = new_i.next();
        while (main_c != 0 && new_c != 0) {
            if (main_c != new_c) break;
            main_c = (main_i.hasNext()) ? main_i.next() : 0;
            new_c = (new_i.hasNext()) ? new_i.next() : 0;
        }
        if (main_c == new_c) return;
        if (as_start) {
            other.addFirst(main_c);
            while (main_i.hasNext()) {
                other.addFirst(main_i.next());
            }
        } else {
            other.addLast(main_c);
            while (main_i.hasNext()) {
                other.addLast(main_i.next());
            }
        }
    }

    private boolean update_tail(LinkedList<Character> tail_l) {
        Iterator<Character> main_i = tail.descendingIterator();
        Iterator<Character> new_i = tail_l.descendingIterator();
        char main_c, new_c;
        if (tail.isEmpty()) {
            tail = tail_l;
            return true;
        } else if (tail_l.isEmpty()) return true;
        main_c = main_i.next();
        new_c = new_i.next();
        while (main_c != 0 && new_c != 0) {
            if (main_c != new_c) return false;
            main_c = (main_i.hasNext()) ? main_i.next() : 0;
            new_c = (new_i.hasNext()) ? new_i.next() : 0;
        }
        if (new_c!=0) tail = tail_l;
        return true;
    }

    private boolean update_start(LinkedList<Character> start_l) {
        Iterator<Character> main_i = start.iterator();
        Iterator<Character> new_i = start_l.iterator();
        char main_c, new_c;
        if (start.isEmpty()) {
            start = start_l;
            return true;
        } else if (start_l.isEmpty()) return true;
        main_c = main_i.next();
        new_c = new_i.next();
        while (main_c != 0 && new_c != 0) {
            if (main_c != new_c) return false;
            main_c = (main_i.hasNext()) ? main_i.next() : 0;
            new_c = (new_i.hasNext()) ? new_i.next() : 0;
        }
        if (new_i.hasNext()) start = start_l;
        return true;
    }

    private void add_to_middle(LinkedList<Character> tail_l) {
        middle.addLast(tail_l);
    }

    String print(char[] chars, boolean correct) {
        if (correct) return new String(chars);
        return "*";
    }
}