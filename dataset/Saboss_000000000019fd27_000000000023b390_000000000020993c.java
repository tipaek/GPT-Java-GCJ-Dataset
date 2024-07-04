import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static public void truce(int[][] array,int test){

        Set<Integer> count = new HashSet<>();
        Set<Integer> ccount = new HashSet<>();
        int sum=0;
        int repeatedRow=0;
        int repeatedColumn=0;

        for(int i=0;i<array.length;i++){
            boolean repeated = false;
            boolean repeatedc = false;
            int k=0;
            for(int j=0;j<array.length;j++){
                if(count.contains(array[i][j])){
                    count.remove(array[i][j]);
                    repeated = true;
                }else {
                    count.add(array[i][j]);
                }

                //Column
                if(ccount.contains(array[j][i])){
                    repeatedc = true;
                }else {
                    ccount.add(array[j][i]);
                }
                if(i==j){
                    sum =sum+array[i][j];
                }
            }
            if(repeated){
                repeatedRow++;
            }
            if(repeatedc){
                repeatedColumn++;
            }
            count.clear();
            ccount.clear();
        }
        System.out.println("Case #"+test+":  " + sum + " " +repeatedRow + " " + repeatedColumn);
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        int tno=1;

        while(tno <= test) {
            int sizeofArray = scan.nextInt();
            int[][] array = new int[sizeofArray][sizeofArray];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = scan.nextInt();
                }
            }
            truce(array,tno);
            tno++;
        }
    }
}
