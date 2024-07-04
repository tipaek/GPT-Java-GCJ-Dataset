
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.HashSet;

public class Solution {
    static int test_case=1;
    public static void main(String[] args) {
        Scanner in = createScanner();
        int t = in.nextInt();
        String newLine = in.nextLine();
	    for(int i=0; i<t; ++i){
            String seq = in.nextLine();

            NestingDepths newDepth = new NestingDepths(seq);
            newDepth.solve();
        }
    }

    public static Scanner createScanner(){
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

}
class NestingDepths {
    static int test_case;
    String seq ;
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder output = new StringBuilder();
    NestingDepths(){}
    NestingDepths(String str){
        seq = str;

    }
    public void solve(){
        for (int i=0;i<seq.length();++i){
            if(seq.charAt(i) == '0'){
                emptyQueue_buildString();
                output.append("0");
            }
            else {
                queue.add(Character.getNumericValue(seq.charAt(i)));
            }
        }
        emptyQueue_buildString();
        System.out.println("Case #" + test_case++ + ": " + output.toString());
    }

    public void emptyQueue_buildString(){
        while(!queue.isEmpty()){
            int num = queue.peek();
            for(int i=0;i < num;++i){
                output.append("(");
            }
            output.append(num);
            queue.remove();
            while(!queue.isEmpty() && queue.peek() == num){
                output.append(queue.peek());
                queue.remove();
            }
            while(!queue.isEmpty() && queue.peek() < num){

                for(int c =0; c< num - queue.peek(); ++c){
                    output.append(")");
                }
                num = num - (num - queue.peek());
                output.append(queue.peek());
                queue.remove();

            }
            for(int j=0;j < num;++j){
                output.append(")");
            }
        }
    }


}