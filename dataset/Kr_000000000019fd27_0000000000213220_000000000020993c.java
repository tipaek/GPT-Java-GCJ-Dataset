import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


 class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        for(int x=1;x<=t;x++){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    arr[i][j]=sc.nextInt();
            }
            int k=0;
            int r=0,c=0;

            for(int i=0;i<n;i++) {
                ArrayList<Integer> celements=new ArrayList<>();
                Set<Integer> colDup=new HashSet<>();
                ArrayList<Integer> relements=new ArrayList<>();
                Set<Integer> rowDup=new HashSet<>();
                boolean cflag=false,rflag=false;
                for (int j = 0; j < n; j++) {
                    //int relement=arr[i][j];
                    int celement=arr[j][i];
                    if(i==j)
                        k+=arr[i][j];

                    if(relements.contains(arr[i][j])&& !rowDup.contains(arr[i][j]) && !rflag){
                        rowDup.add(arr[i][j]);
                        r++;
                        rflag=true;
                    }
                    else
                        relements.add(arr[i][j]);


                    if(celements.contains(celement)&& !colDup.contains(celement) && !cflag){
                        colDup.add(celement);
                        c++;
                        cflag=true;
                    }
                    else
                        celements.add(celement);
                }
            }

            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        }
    }
}
