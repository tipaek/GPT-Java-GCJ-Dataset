import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int slices= sc.nextInt();
            int dinner=sc.nextInt();
            Map<Long,Integer> map=new HashMap<Long,Integer>();
            for(int i=0;i<slices;i++){
                long slice=sc.nextLong();
                if(map.containsKey(slice)){
                    map.put(slice,map.get(slice)+1);
                }
                else{
                    map.put(slice,1);
                }
            }
            int output=dinner-1;
            for(Map.Entry<Long,Integer> mp:map.entrySet()){
                if(mp.getValue()==dinner){
                    output=0;
                }
                else{
                    int temp=mp.getValue();

                    for(Map.Entry<Long,Integer> smp:map.entrySet()){
                        int rtemp=0;
                        if(smp.getKey()!=mp.getKey() && mp.getKey()<smp.getKey()){
                            if(smp.getKey()%mp.getKey()==0){
                                rtemp+=smp.getKey()/mp.getKey();
                            }
                        }
                        //System.out.println(rtemp+" "+map);
                        if(rtemp>0 && dinner>=temp+rtemp){
                            if(output>(dinner-temp-1)){
                                output=dinner-temp-1;
                            }
                        }
                    }

                }
            }
            System.out.println("Case #" + t + ": "+output);

        }
    }

}
