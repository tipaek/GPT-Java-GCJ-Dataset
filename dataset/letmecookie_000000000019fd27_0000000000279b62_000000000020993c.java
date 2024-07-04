import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i<= t; i++){
            int n = in.nextInt();
            int tr = 0;
            int r = 0;
            int c =0;
            ArrayList<HashMap<Integer, Integer>> list = new ArrayList<HashMap<Integer, Integer>>(n);
            for(int k = 0; k< n; k++){
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                list.add(map);
            }
            for(int k = 0; k < n; k++){
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

                for(int j = 0; j< n; j++){

                    int a = in.nextInt();
                    if(map.containsKey(a)){


                        if(!map.containsKey(-1)){
                            map.put(-1, 0);
                            r++;
                        }



                    }
                    else{
                        map.put(a, 0);
                    }

                    if(list.get(j).containsKey(a)){


                        if(!list.get(j).containsKey(-1)){
                            list.get(j).put(-1,0);
                            c++;
                        }



                    }
                    else{
                        list.get(j).put(a, 0);
                    }

                    if(k == j) tr+= a;


                }

            }
            System.out.printf("Case #%d: %d %d %d", i+1, tr, r, c);


        }
    }

}
