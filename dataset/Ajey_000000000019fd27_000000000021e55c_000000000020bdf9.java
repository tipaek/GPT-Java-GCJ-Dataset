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
            for (int i = 0; i < arr1.length-1; i++) {
                for(int j = i+1;j<arr1.length;j++){
                    if(arr1[i]>arr1[j]){
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                        temp = indx[i];
                        indx[i] = indx[j];
                        indx[j] = temp;
                    }
                }
            }
            for (int i = 0; i < arr1.length; i++) {
                arr3[i] = arr2[indx[i]];
            }
           /* for(int i : arr1) 
                System.out.print(i+"\t");
            System.out.println();
            for(int i : arr3) 
                System.out.print(i+"\t");
            System.out.println();*/
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
   //         System.out.println(ans);
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
