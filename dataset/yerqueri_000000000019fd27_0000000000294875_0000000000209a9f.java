import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        for(int x=0;x<size;x++) {
            String  input = in.nextLine();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i=0;i<input.length();i++){
                arrayList.add(Integer.parseInt(String.valueOf(input.charAt(i))));
            }
            String sol ="";
            for(int i=0;i<arrayList.size();i++){
                int current =arrayList.get(i);
                int prev = 0;
                if(i-1>=0){
                    prev = arrayList.get(i-1);
                }
                int diff = current-prev;
                sol+=evaluteExpression(current,diff,i,arrayList.size()-1);
            }
            System.out.println("Case #"+(x+1)+": "+sol);
        }
    }

    private static String evaluteExpression(int x, int diff, int index,int size) {
        String sol="";
        if(index==0){
            for(int i = 0; i<x; i++){
                sol+="(";
            }
            sol+=x;
        }else {
            int modDiff = Math.abs(diff);
            if (diff > 0) {
                for (int i = 0; i < modDiff; i++) {
                    sol+="(";
                }
            } else {
                for (int i = 0; i < modDiff; i++) {
                    sol+=")";
                }
            }
            sol+=x;
        }
        if(index==size){
            for(int i = 0; i<x; i++){
                sol+=")";
            }
        }
        return sol;
    }
}