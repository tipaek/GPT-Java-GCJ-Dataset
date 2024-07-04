import java.util.*;
public class Solution {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int testcase = 1 ;
        while(t--!=0){
            int n = in.nextInt();
            int [][]arr = new int[n][2];
            for(int i=0;i<n;++i){
                arr[i][0]  = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            Arrays.sort(arr,(a,b)->(a[1]-b[1]));
            int max = 0;
            int end = arr[0][1];
            int count = 1;
            StringBuilder sb = new StringBuilder();
            sb.append("J");
            HashMap<Character,int[]> map = new HashMap<>();
            map.put('J',new int[]{arr[0][0],arr[0][1]});
            boolean flag = true;
            for(int i=1;i<n;++i){
                if(end>arr[i][0]){
                    count++;
                    if(!map.containsKey('J')||map.get('J')[1]<=arr[i][0]){
                        map.put('J',new int[]{arr[i][0],arr[i][1]});
                        sb.append('J');
                    }
                    else if(!map.containsKey('C')||map.get('C')[1]<=arr[i][0]){
                        map.put('C',new int[]{arr[i][0],arr[i][1]});
                        sb.append('C');
                    }else{
                        flag = false;
                        break;
                    }
                }else{
                    max = Math.max(max,count);
                    if(max>=3){
                        flag = false;
                        break;
                    }
                    boolean t_flag = false;
                    //checking for J
                    if(map.containsKey('J')&&map.get('J')[1]<=arr[i][0]){
                            t_flag = true;
                            map.put('J',new int[]{arr[i][0],arr[i][1]});
                            sb.append("J");
                    }
                    //checking for C
                    if(map.containsKey('C')&&map.get('C')[1]<=arr[i][0]){
                       if(t_flag){
                           map.remove('C');
                       }else{
                           t_flag = true;
                           map.put('C',new int[]{arr[i][0],arr[i][1]});
                           sb.append("C");
                       }
                    }
                    if(!t_flag){
                        flag = false;
                        break;
                    }
                    end = arr[i][1];
                    count = 1;
                }
            }
            if(max>=3||count>=3){
                System.out.println("Case #"+testcase+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+testcase+": "+sb.toString());
            }
            testcase++;
        }
    }
}
