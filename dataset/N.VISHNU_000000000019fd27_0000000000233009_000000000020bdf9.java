import java.util.*;
public class Solution {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int testcase = 1 ;
        while(t--!=0){
            int n = in.nextInt();
            int [][]arr = new int[n][2];
            int [][]copy = new int[n][2];
            for(int i=0;i<n;++i){
                arr[i][0]  = in.nextInt();
                arr[i][1] = in.nextInt();
                copy[i][0] = arr[i][0];
                copy[i][1] = arr[i][1];
            }

            Arrays.sort(arr,(a,b)->(a[1]-b[1]));
            int max = 0;
            int end = arr[0][1];
            int count = 1;
            HashMap<Character,int[]> map = new HashMap<>();
            map.put('C',new int[]{arr[0][0],arr[0][1]});
            boolean flag = true;
            HashMap<String,List<Character>> ret = new HashMap<>();
            List<Character> et = new ArrayList<>();
            et.add('C');
            ret.put(arr[0][0]+"#"+arr[0][1],et);
            for(int i=1;i<n;++i){
                if(end>arr[i][0]){
                    count++;
                    if(!map.containsKey('J')||map.get('J')[1]<=arr[i][0]){
                        map.put('J',new int[]{arr[i][0],arr[i][1]});
                        ret.putIfAbsent(arr[i][0]+"#"+arr[i][1],new ArrayList<Character>());
                        ret.get(arr[i][0]+"#"+arr[i][1]).add('J');
                    }
                    else if(!map.containsKey('C')||map.get('C')[1]<=arr[i][0]){
                        map.put('C',new int[]{arr[i][0],arr[i][1]});
                        ret.putIfAbsent(arr[i][0]+"#"+arr[i][1],new ArrayList<Character>());
                        ret.get(arr[i][0]+"#"+arr[i][1]).add('C');
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
                    if(map.containsKey('C')&&map.get('C')[1]<=arr[i][0]){
                            t_flag = true;
                            map.put('C',new int[]{arr[i][0],arr[i][1]});
                        ret.putIfAbsent(arr[i][0]+"#"+arr[i][1],new ArrayList<Character>());
                            ret.get(arr[i][0]+"#"+arr[i][1]).add('C');
                    }
                    //checking for C
                    if(map.containsKey('J')&&map.get('J')[1]<=arr[i][0]){
                       if(t_flag){
                           map.remove('J');
                       }else{
                           t_flag = true;
                           map.put('J',new int[]{arr[i][0],arr[i][1]});
                           ret.putIfAbsent(arr[i][0]+"#"+arr[i][1],new ArrayList<Character>());
                           ret.get(arr[i][0]+"#"+arr[i][1]).add('J');
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
                char []ans = new char[n];
                for(int i=0;i<n;++i){
                    try{
                        List<Character> toadd = ret.get(copy[i][0]+"#"+copy[i][1]);
                        ans[i] = toadd.get(0);
                        toadd.remove(0);
                        ret.put(copy[i][0]+"#"+copy[i][1],toadd);
                    }
                    catch(Exception e){
                        ans[i] = 'J';
                    }
                }
                System.out.println("Case #"+testcase+": "+new String(ans));
            }
            testcase++;
        }
    }
}