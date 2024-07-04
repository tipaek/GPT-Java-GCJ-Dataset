
import java.io.*;
import java.util.*;
class Act{
    int start;
    int end;
    int index;
    char work;
}
class Solution {
    public static void main(String[] args) {
        //System.out.println("GfG!");
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int cse = 0;
        while (t-- != 0) {
            cse++;
            int n;
            n = sc.nextInt();
            int arr[][] = new int[1441][1441];
            for (int i = 0; i <= 1440; i++) {
                for (int j = 0; j <= 1440; j++)
                    arr[i][j] = 0;
            }
            int count[] = new int[1441];
            Act a[] = new Act[n];
            //String ans;
            for (int i = 0; i < n; i++) {
                int a2 = sc.nextInt();
                int b = sc.nextInt();
                a[i] = new Act();
                a[i].start = a2;
                a[i].end = b;
                a[i].index=i;
                arr[a2][b]++;
                count[a2]++;

            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[i].start > a[j].start) {
                        int tmp = a[i].start;
                        a[i].start = a[j].start;
                        a[j].start = tmp;
                        tmp = a[i].end;
                        a[i].end = a[j].end;
                        a[j].end = tmp;
                        tmp=a[i].index ;
                        a[i].index=a[j].index;
                        a[j].index=tmp;
                    }
                }
            }

            int freeJ=-1;
            int freeC=-1;
            boolean check=true;
            char ans[]=new char[n];
            for(int j=0;j<n;j++){
                Act tmp=a[j];
                if(freeC!=-1   &&  freeC<=tmp.start){
                    freeC=-1;
                }
                if(freeJ!=-1  &&   freeJ<=tmp.start){
                    freeJ=-1;
                }


                if(freeC==-1){
                    freeC=tmp.end;
                    ans[tmp.index]='C'; }
                else if(freeJ==-1){
                    freeJ=tmp.end;
                    ans[tmp.index]='J';
                }
                else{
                    check=false;
                    break;
                }
            }
            String anss="";
            if(!check){
                anss="IMPOSSIBLE";
            }
            else{
                for(int i=0;i<n;i++){
                    anss+=ans[i];
                }
            }
            System.out.println("Case #"+cse+": "+anss);


        }
    }
}
