import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int nu=1;nu<=t;nu++){
      int n = in.nextInt();
      int trace=in.nextInt();
      int[][] a=new int[n][n];
      List<List<Integer>> res=null;
      int[] temp=new int[n];
      for(int i=0;i<n;i++)temp[i]=i+1;
      for(int i=1;i<=n;i++){
         // System.out.println(Arrays.toString(temp));
      res=printLatin(temp,trace,n);
      //System.out.println(Arrays.toString(temp));
      nextPermutation(temp);
      if(res!=null)break;
      //System.out.println(res);
      }
      if(res==null){
      System.out.println("Case #" + nu + ": " +"IMPOSSIBLE");
      }else{
         System.out.println("Case #" + nu + ": " + "POSSIBLE");
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 System.out.print(res.get(i).get(j)+" ");
             }
             System.out.println();
         }
      }
    }
  }
      static List<List<Integer>> printLatin(int a[],int t,int n) 
    { List<List<Integer>> res=new ArrayList();
        for (int i = 1; i <= n; i++) 
        { 
            List<Integer> ta=new ArrayList();
            for(int j:a)ta.add(j);
            res.add(ta);
            rotate(a);
        }
        int trace=0;
        for(int i=0;i<n;i++){
          trace+=res.get(i).get(i);
        }
        if(t==trace)return res;
        return null;
    }
    static void rotate(int []a){
        int temp=a[0];
        for(int i=0;i<a.length-1;i++)
        a[i]=a[i+1];
        a[a.length-1]=temp;
    }
static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}