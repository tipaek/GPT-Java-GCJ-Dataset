
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        int i = 1,j=1;
        ArrayList<ArrayList<String>> anstestcases = new ArrayList<ArrayList<String>>(t);
        while(i <= t){
            int n = sc.nextInt();
           // HashMap<Integer,String> map = new HashMap<Integer, String>();
            HashMap<Integer,String> map = new HashMap<Integer, String>();
            ArrayList<ArrayList<Integer>> totallist = new ArrayList<ArrayList<Integer>>(n);
            j=1;
            while(j <= n){
                int s = sc.nextInt();
                int e = sc.nextInt();
                boolean flag = false;
                ArrayList<Integer> list = new ArrayList<Integer>(2);
                list.add(new Integer(s));
                list.add(new Integer(e));
//                totallist.add(list);
                if(map.isEmpty()){
                    map.put(j,"J");
                    totallist.add(list);
                }
                else{
                    if(!map.containsValue("J")){
                        map.put(j,"J");
                        totallist.add(list);
                    }

                    else if(!map.containsValue("C")){
                        map.put(j,"C");
                        totallist.add(list);
                    }
                    else{
                        for(Integer task : map.keySet()){
                            int st = totallist.get(task-1).get(0);
                            int end = totallist.get(task-1).get(1);
                            if(((st<s)&&(end<=s))||(end>=e)&&(st>e)){
                                String parent = map.get(task);
                                totallist.add(list);
                                map.put(j,parent);
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            map.put(j,"IMPOSSIBLE");
                            break;
                        }
                    }
                }
              j++;
            }
            if(map.containsValue("IMPOSSIBLE")){
               ArrayList<String> ansone = new ArrayList<String>();
               ansone.add("IMPOSSIBLE");
               anstestcases.add(ansone);
            }
            else{
                ArrayList<String> listonetest = new ArrayList<String>();
                for(Integer anstestone : map.keySet()){
                    listonetest.add(map.get(anstestone));
                }
                anstestcases.add(listonetest);
            }
            i++;
        }
        for(int l = 0; l<anstestcases.size(); l++){
            for(String val : anstestcases.get(l)){
                System.out.print(val);
            }
            System.out.println();
        }
    }

}
