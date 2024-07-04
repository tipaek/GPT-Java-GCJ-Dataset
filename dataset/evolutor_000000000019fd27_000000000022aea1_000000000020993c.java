

import java.util.*;
import java.io.*;
class Solution {
    public static void main (String[] args) {
        //System.out.println("GfG!");
        int t;
        int cse=0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t--!=0){
            cse++;
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            int cr=0;
            int cc=0;
            int trace=0;
            HashSet<Integer> set1 = new HashSet<>();
            //HashSet<Integer> set2 = new HashSet<>();
            int checkRow =0;
            //int checkCol=1;
            for(int i=0;i<n;i++){

                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                    if(set1.contains(a[i][j]) && checkRow==0)
                    {cr++;
                        checkRow=1;
                    }
                    set1.add(a[i][j]);


                }
                set1.clear();
                checkRow=0;

            }
            set1.clear();
            checkRow=0;
            for(int j=0;j<n;j++){

                for(int i=0;i<n;i++){
                    //a[i][j]=sc.nextInt();
                    //if(i==j)
                      //  trace+=a[i][j];
                    if(set1.contains(a[i][j]) && checkRow==0)
                    {cc++;
                        checkRow=1;
                    }
                    set1.add(a[i][j]);


                }
                set1.clear();
                checkRow=0;

            }
            System.out.println("Case #"+cse+": "+trace +" "+ cr +" "+cc);
        }
    }
}