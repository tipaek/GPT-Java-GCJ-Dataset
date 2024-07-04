import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static class Task{
        int s;
        int e;
        int i;
        char ass;
        Task(int s, int e, int i){
            this.s=s;
            this.e=e;
            this.i=i;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Task[] a = new Task[n];
            for (int j = 0; j < n; j++) {
                String str[] = br.readLine().split(" ");
                a[j]=new Task(Integer.parseInt(str[0]), Integer.parseInt(str[1]), j);
            }
            Arrays.sort(a, Comparator.comparingInt(task->task.s));
            boolean possible = true;
            int freeByC = -1;
            int freeByJ = -1;
            for (int j = 0; j < n; j++) {
                if (freeByC<=a[j].s){
                    a[j].ass='C';
                    freeByC = a[j].e;
                    continue;
                }
                if (freeByJ<=a[j].s){
                    a[j].ass='J';
                    freeByJ = a[j].e;
                    continue;
                }
                possible=false;
                break;
            }
            sb.append("Case #").append(i+1).append(": ");
            if (possible){
                Arrays.sort(a, Comparator.comparingInt(task -> task.i));
                for (int j = 0; j < n; j++) {
                    sb.append(a[j].ass);
                }
            } else {
                sb.append("IMPOSSIBLE");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
