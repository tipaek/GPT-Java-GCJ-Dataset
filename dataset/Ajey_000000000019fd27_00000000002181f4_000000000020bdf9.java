import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Yadav's
 */
public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int t1 = 1;t1<=t;t1++){
            int n = in.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            int[] arr3 = new int[n];
            int[] indx = new int[n];
            for (int i = 0; i < arr1.length; i++) {
                indx[i] = i;
            }
            for(int n1 = 0;n1<n;n1++){
                arr1[n1] = in.nextInt();
                arr2[n1] = in.nextInt();
            }
            Map<Integer, Integer> arr = new HashMap<Integer, Integer>(arr1.length);
            for (int i = 0; i < arr1.length; i++) {
                arr.put(arr1[i], indx[i]);
            }
            Arrays.sort(arr1);
            for (int i = 0; i < arr1.length; i++) {
                indx[i] = arr.get(arr1[i]);
            }
            for (int i = 0; i < arr1.length; i++) {
                arr3[i] = arr2[indx[i]];
            }
            boolean java = true;
            int a1=arr1[0],a2=arr3[0],b1=0,b2=0;
            String ans = "C";
            for(int i = 1;i<n;i++){
                if(!java) break;
                if(arr1[i]>=a2){
                    a1 = arr1[i];
                    a2 = arr3[i];
                    ans+="C";
                }
                else if (arr1[i]>=b2){
                    b1 = arr1[i];
                    b2 = arr3[i];
                    ans+="J";
                }
                else java = false;
            } 
            if(java){
                System.out.print("Case #"+t1+": ");
                char[] a = ans.toCharArray();
                char[] b = new char[n];
                for (int i = 0; i < arr1.length; i++) {
                    b[i] = a[indx[i]];
                }
                for(char l :b)System.out.print(l);
                System.out.println();
            }
            else System.out.println("Case #"+t1+": IMPOSSIBLE");    
        }
    }
}
