import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> string = new ArrayList<>();
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            int act[][] = new int[num][2];
            for(int j=0;j<num;j++){
                act[j][0] = sc.nextInt();
                act[j][1] = sc.nextInt();
            }
            string.add(new Solver1().solve(act,num));
        }
        int temp=0;
        for(String s:string){
            temp+=1;
            System.out.println("Case #" + temp + ": " + s + " ");
        }
    }
}

class Solver1 {
    public static String solve(int arr[][], int n) {
        String output = "" ;
        int freeC = 0;
        int freeJ = 0;
        int freeC0 = 0;
        int freeJ0 = 0;
        ArrayList<String> assign =new ArrayList<>();
        for(int i=0;i<n;i++){
            int subarr[] = arr[i];
            if(freeC <= subarr[0] || freeC0 >= subarr[1]){
                assign.add("C");
                freeC0 = subarr[0];
                freeC = subarr[1];
            }
            else if (freeJ  <= subarr[0] || freeJ0 >= subarr[1]){
                assign.add("J");
                freeJ0 = subarr[0];
                freeJ = subarr[1];
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        for(String s:assign){
            output+=s;
        }
        return output;
    }
}