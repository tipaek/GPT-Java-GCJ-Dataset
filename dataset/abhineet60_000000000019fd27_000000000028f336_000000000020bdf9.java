import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args)throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int z=1;
        while(z<=t){
           int n = s.nextInt();
           int arr[][] = new int[n][3];
           for(int i = 0;i<n;i++){
               arr[i][0] = s.nextInt();
               arr[i][1] = s.nextInt();
               arr[i][2] = i;
           }
           
           Arrays.sort(arr,new Comparator<int[]>(){
               public int compare(int a1[], int a2[]){
                   if(a1[0]>a2[0]) return 1;
                   return -1;
               }
            });
            HashSet<Integer> cam = new HashSet<>();
            HashSet<Integer> jam = new HashSet<>();
            int tp = 0;
            cam.add(arr[0][2]);
            for(int i = 1;i<n;i++){
                if(arr[i][0]>=arr[tp][1]){
                     cam.add(arr[i][2]);
                     tp = i;
                }
            }
            
            for(int i = 1;i<n;i++){
                if(!cam.contains(arr[i][2])){
                    jam.add(arr[i][2]);
                    tp = i;
                    break;
                }
            }
            
            for(int i = 1;i<n;i++){
                if(!(cam.contains(arr[i][2])) && arr[i][0]>=arr[tp][1]){
                     jam.add(arr[i][2]);
                     tp = i;
                }
            }
            String res="";
            if(cam.size()+jam.size()<arr.length) res="IMPOSSIBLE";
            else{
                
                for(int i = 0;i<n;i++){
                    if(cam.contains(i)) res+="C";
                    else res+="J";
                }
            }
            
            System.out.println("Case #"+z+": "+res);
            z++;
        }
    }
}