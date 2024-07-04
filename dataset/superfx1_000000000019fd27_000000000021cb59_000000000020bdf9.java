
import java.util.*;
import java.io.*;
public class Solution {
    public static void merge(
  int[][] a, int[][] l, int[][] r, int left, int right) {
  
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i][0] <= r[j][0]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
}
    public static void mergeSort(int[][] a, int n) {
    if (n < 2) {
        return;
    }
    int mid = n / 2;
    int[][] l = new int[mid][3];
    int[][] r = new int[n - mid][3];
 
    for (int i = 0; i < mid; i++) {
        l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
        r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);
 
    merge(a, l, r, mid, n - mid);
}
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=input.nextInt();
        for(int t=0;t<T;t++){
        int N=input.nextInt();
        int[][] list=new int[N][3];
        for(int i=0;i<N;i++){
            list[i][0]=input.nextInt();
            list[i][1]=input.nextInt();
            list[i][2]=i;
        }
        mergeSort(list,N);
        String taskAssignement="";
        int lastC=0;
        int lastJ=0;
        char[] assigne=new char[N];
        for(int[] i:list){
            if(lastC<=i[0]){
                assigne[i[2]]='C';
                lastC=i[1];
            }else if(lastJ<=i[0]){
                assigne[i[2]]='J';
                lastJ=i[1];
            }else{
            taskAssignement="IMPOSSIBLE";
            break;
            }
        }
        if(!taskAssignement.equals("IMPOSSIBLE"))
            taskAssignement=new String(assigne);
        System.out.println("Case #"+(t+1)+": "+taskAssignement);
        }
    }
}
