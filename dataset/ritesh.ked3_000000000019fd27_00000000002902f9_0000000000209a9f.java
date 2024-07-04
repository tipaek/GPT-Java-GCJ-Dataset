import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
    
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int numberOfTestCases = Integer.parseInt(input.readLine());
            for(int index = 0;index<numberOfTestCases;++index){
                LinkedList<Integer> list = parseValues(input.readLine());
                int first = list.poll();
                String ans = append("(", first)+String.valueOf(first)+getAns(list, first);
                System.out.println("Case #"+(index+1)+": "+ans);
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    private static LinkedList<Integer> parseValues(String line) {
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int index =0;index<line.length();++index) {
            list.add(line.charAt(index)-'0');
        }
        
        return list;
    }
    
    private static String getAns(LinkedList<Integer> list, int pending) {
        if(list.isEmpty()) {
            return append(")", pending);
        }
        int first = list.poll();
        if(first == 0) {
            return append(")",pending)+"0"+getAns(list, 0);
        }
        if(first == pending) {
            return String.valueOf(first)+getAns(list, pending);
        }
        if(pending == 0) {
            return append("(",first)+String.valueOf(first)+getAns(list, first);
        }
        if(pending > first) {
            return append(")",pending-first)+String.valueOf(first)+getAns(list, first);
        }
        if(pending < first) {
            return append("(",first-pending)+String.valueOf(first)+getAns(list, first);
        }
        System.out.println("Nothing should be here");
        return append(")", pending);
    }
    
    private static String append(String given, int times) {
        String ans = "";
        for(int i=0;i<times;++i) {
            ans+=given;
        }
        return ans;
    }

}
