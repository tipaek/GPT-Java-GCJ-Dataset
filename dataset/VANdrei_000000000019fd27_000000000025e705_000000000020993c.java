import java.util.*;

public class Solution{
    public static void main(String[] args){
        Integer noOfCases,i,j,n,caz,trace=0;
        int[][] matrice = new int[100][100];

        Scanner scanner = new Scanner(System.in);
        noOfCases= scanner.nextInt();
        for(caz=0;caz<noOfCases;caz++){
            trace=0;
            String caseString="Case #"+(caz+1)+": ";

            n = scanner.nextInt();
            for( i=0;i<n;i++){

                for(j=0;j<n;j++){
                    matrice[i][j]=scanner.nextInt();
                    if(i==j){
                        trace += matrice[i][j];
                    }
                }
            }
            caseString+=trace.toString()+" ";
            Integer randuri=0;
            for( i=0;i<n;i++){
                Set<Integer> set = new HashSet<>();
                for(j=0;j<n;j++) {
                   set.add(matrice[i][j]);
                }
                if(set.size()<n){
                    randuri++;
                }
            }
            Integer coloane=0;
            for( j=0;j<n;j++){
                Set<Integer> set = new HashSet<>();
                for(i=0;i<n;i++) {
                   set.add(matrice[i][j]);
                }
                if(set.size()<n){
                    coloane++;
                }
            }

            caseString+=randuri.toString()+" "+coloane.toString();
            System.out.println(caseString);
        }
    }

}