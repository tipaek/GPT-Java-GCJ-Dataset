import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        for (int k=0;k<n1;k++){
            int sum=0;
            int n2 = s.nextInt();

            Integer [][] arr = new Integer[n2][n2];
            Integer [][] arr1 = new Integer[n2][n2];
            for(int i=0;i<arr.length;i++){
                for (int j=0;j<n2;j++){
                    arr[i][j]=s.nextInt();
                    arr1[j][i]=arr[i][j];
                    if(i==j){
                        sum+= arr[i][j];
                    }
                }
            }
            int Row=Duplicates(arr);
            int Col = Duplicates(arr1);
            System.out.println("Case #"+(k+1)+": "+(sum)+" "+Row+" "+Col);
            /*for(int i=0;i<arr.length;i++){
                for (int j=0;j<n2;j++){
                    if(j!=(n2-1)) {
                        System.out.print(arr[i][j] + " ");
                    }
                    else{
                        System.out.println(arr[i][j]);
                    }
                }
            }*/

        }
    }

    public static int Duplicates(Integer [][] inArray) {
        int c=0;
        for (int row = 0; row < inArray.length; row++) {
            Integer []curRow= new Integer[inArray.length];
            curRow = inArray[row];
            Set<Integer> set = new HashSet<Integer>();
            Collections.addAll(set, curRow);
            if (set.size() < curRow.length) {
                c++;
            }
        }
        return c;
    }
}