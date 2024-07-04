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
           int arr[][] = new int[n][2];
           for(int i = 0;i<n;i++){
               arr[i][0] = s.nextInt();
               arr[i][1] = s.nextInt();
           }
           
           Arrays.sort(arr,new Comparator<int[]>(){
               public int compare(int a1[], int a2[]){
                   if(a1[1]>a2[1]) return 1;
                   return -1;
               }
            });
            HashSet<Integer> cam = new HashSet<>();
            HashSet<Integer> jam = new HashSet<>();
            int tp = 0;
            cam.add(0);
            for(int i = 1;i<n;i++){
                if(arr[i][0]>=arr[tp][1]){
                     cam.add(i);
                     tp = i;
                }
            }
            
            for(int i = 1;i<n;i++){
                if(!cam.contains(i)){
                    jam.add(i);
                    tp = i;
                    break;
                }
            }
            
            for(int i = 1;i<n;i++){
                if(!(cam.contains(i)) && arr[i][0]>=arr[tp][1]){
                     jam.add(i);
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