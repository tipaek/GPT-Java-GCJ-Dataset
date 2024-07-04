import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int numberOfTasks = scanner.nextInt();
            Set<Integer> cam = new HashSet<>();
            Set<Integer> jam = new HashSet<>();
            StringBuilder res = new StringBuilder();
            for(int j=0;j<numberOfTasks;j++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Set<Integer> t = new HashSet<>();
                for(int s=start;s<end;s++){
                    t.add(s);
                }
                Set<Integer> interC = new HashSet<>(t);
                interC.retainAll(cam);
                Set<Integer> interJ = new HashSet<>(t);
                interJ.retainAll(jam);
                if(interC.isEmpty()){
                    res.append("C");
                    cam.addAll(t);
                }
                else if(interJ.isEmpty()){
                    res.append("J");
                    jam.addAll(t);
                }
                else{
                    res = new StringBuilder("IMPOSSIBLE");
                }
            }
            out.append("Case #").append(i+1).append(": ").append(res).append("\n");
        }
        System.out.print(out);
    }
}
