import java.util.Scanner;

public class Solution {

    static public void check(int[][] array,int test){
        StringBuilder sequence =new StringBuilder("C");
        boolean overlap = false;
        for(int i=0;i<array.length - 1;i++){
            if(array[i][1]>array[i+1][0]){
                sequence.append("C");
                if(overlap==true){
                    sequence = new StringBuilder("IMPOSSIBLE");
                }
                overlap = true;
            }
            else if(array[i][1]==array[i+1][0]){
                int len = sequence.length()-1;
                if(sequence.charAt(len)=='C'){
                    sequence.append("J");
                    overlap= false;
                }else {
                    sequence.append("C");
                    overlap = true;
                }
            }
            else {
                sequence.append("J");
            }
        }
        System.out.println("Case #"+ test +" : " + sequence);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int test = scan.nextInt();
        int t =1;
        while(t<=test){
            int size = scan.nextInt();
            int[][] array = new int[size][2];
            for(int i=0;i<array.length;i++){
                for(int j =0;j<2;j++){
                    array[i][j] = scan.nextInt();
                }
            }
            check(array,t);
            t++;
        }


    }

}
