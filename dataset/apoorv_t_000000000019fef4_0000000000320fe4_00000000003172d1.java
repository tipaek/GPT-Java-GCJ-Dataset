import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        String s;
        boolean flag;
        int c =0;
        Map<Integer, Integer> map;
        while(c++!=t){
            map = new HashMap<>();
            flag=false;
            int n = in.nextInt();
            int d = in.nextInt();
            int[] arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                if(map.get(arr[i])>=d){
                    System.out.println("Case #" + c+ ": 0");
                    flag=true;
                    break;
                }
            }
            /*for(int i=0;i<n;i++){
                System.out.print(arr[i]);
            }*/
            if(!flag){
                if(d==2){
                    System.out.println("Case #" + c+ ": 1");
                }
                else{
                    Arrays.sort(arr);
                    for(int i=0;i<n;i++){
                        if(map.get(arr[i])==2 && i!=n-1){
                            flag=true;
                            System.out.println("Case #" + c+ ": 1");
                            break;
                        }
                    }
                    if(!flag){
                        System.out.println("Case #" + c+ ": 2");
                    }

                }
            }

        }
    }
}
