import java.util.Scanner;
import java.util.ArrayList;
public class Solution{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());
        ArrayList<String> list = new ArrayList<String>();
        for(int run = 1; run <= runs; run++){
            String input = console.nextLine();
            int n = 0;
            list.add(input.substring(0,1));
            for(int i = 1; i<input.length(); i++){
                if(input.substring(i-1, i).equals(input.substring(i, i+1))){
                    String current = list.get(n);
                    list.set(n, current + input.substring(i, i+1));
                }
                else{
                    n++;
                    list.add(input.substring(i, i+1));
                }
            }
            System.out.print("Case #" + run + ": ");
            for(String i : list){
                for(int k = 0; k<Integer.parseInt(i.substring(0,1)); k++){
                    System.out.print("(");
                }
                System.out.print(i);
                for(int k = 0; k<Integer.parseInt(i.substring(0,1)); k++){
                    System.out.print(")");
                }
            }
            while(list.size() >0){
                list.remove(0);
            }
            System.out.println();
        }
    }
}