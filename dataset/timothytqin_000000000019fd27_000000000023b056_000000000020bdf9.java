import java.util.*;
// import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            for(int j = 0; j < N; j++) {
                start[j] = scan.nextInt();
                end[j] = scan.nextInt();
            }
            List<String> bfSolutions = bf(new ArrayList<String>(), N, "");
            List<String> valid = filter(bfSolutions, start, end);
            
            System.out.printf("Case #%d: %s\n", i + 1, valid.size() == 0 ? "IMPOSSIBLE" : valid.get(0));
        }
        scan.close();

    }
    
    static List<String> bf(List<String> backpack, int length, String s) {
        if(s.length() == length) {
            backpack.add(s);
        }
        else {
            bf(backpack, length, s + 'C');
            bf(backpack, length, s + 'J');
        }
        return backpack;
    }
    
    static List<String> filter(List<String> l, int[] start, int[] end) {
        List<String> solution = new ArrayList<String>();
        for(String s : l) 
            if(valid(s, start, end))
                solution.add(s);
        return solution;
    }
    
    static boolean valid(String s, int[] start, int[] end) {
        // C
        List<Integer> cStart = new ArrayList<Integer>();
        List<Integer> cEnd = new ArrayList<Integer>();
        List<Integer> jStart = new ArrayList<Integer>();
        List<Integer> jEnd = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'C') {
                cStart.add(start[i]);
                cEnd.add(end[i]);
            }
            else {
                jStart.add(start[i]);
                jEnd.add(end[i]);
            }
        }
        
        for(int i = 0; i < cStart.size() - 1; i++) {
            for(int j = i + 1; j < cStart.size(); j++) {
                //Beginning
                if(cStart.get(j) < cStart.get(i) && cEnd.get(j) > cStart.get(i))
                    return false;
                //End
                if(cStart.get(j) < cEnd.get(i) && cEnd.get(j) > cEnd.get(i))
                    return false;
                //Middle
                if(cStart.get(j) > cStart.get(i) && cEnd.get(j) < cEnd.get(i))
                    return false;
            }
        }
        
        for(int i = 0; i < jStart.size() - 1; i++) {
            for(int j = i + 1; j < jStart.size(); j++) {
                //Beginning
                if(jStart.get(j) < jStart.get(i) && jEnd.get(j) > jStart.get(i))
                    return false;
                //End
                if(jStart.get(j) < jEnd.get(i) && jEnd.get(j) > jEnd.get(i))
                    return false;
                //Middle
                if(jStart.get(j) > jStart.get(i) && jEnd.get(j) < jEnd.get(i))
                    return false;
            }
        }
        
        return true;
    } 

}