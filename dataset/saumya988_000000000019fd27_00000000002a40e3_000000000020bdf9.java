import java.util.*;

class Solution{

    static ArrayList<Integer> Cstart = new ArrayList<>();
    static ArrayList<Integer> Cend = new ArrayList<>();
    static ArrayList<Integer> Jstart = new ArrayList<>();
    static ArrayList<Integer> Jend = new ArrayList<>();
    static String str = "";
    static String stringArray[];
    static int count=0;

    public static boolean CAvailable(int start, int end){
        boolean flag = true;
        for(int i=0; i<Cstart.size(); i++){
            if(start<Cend.get(i)){
                if(start>Cstart.get(i)){
                    flag = false;
                    break;
                }
            }
            if(end>Cstart.get(i)){
                if(end<Cend.get(i)){
                    flag = false;
                    break;
                }
            }
            if(start<=Cstart.get(i) && end>=Cend.get(i)){
                flag = false;
                break;
            }
        }
        if(flag){
            Cstart.add(start);
            Cend.add(end);
            str+="C";
            //stringArray[count] = "C";
            //count++;
        }
        return flag;

    }

    public static boolean JAvailable(int start, int end){
        boolean flag = true;
        for(int i=0; i<Jstart.size(); i++){
            if(start<Jend.get(i)){
                if(start>Jstart.get(i)){
                    flag = false;
                    break;
                }
            }
            if(end>Jstart.get(i)){
                if(end<Jend.get(i)){
                    flag = false;
                    break;
                }
            }
            if(start<=Jstart.get(i) && end>=Jend.get(i)){
                flag = false;
                break;
            }
        }
        if(flag){
            Jstart.add(start);
            Jend.add(end);
            str+="J";
            //stringArray[count] = "J";
            //count++;
        }
        return flag;

    }

    public static ArrayList<Integer> sortbykey(HashMap<Integer, Integer> map) 
    { 
        ArrayList<Integer> sortedKeys = new ArrayList<>(map.keySet()); 
          
        Collections.sort(sortedKeys);  
  
        // Display the TreeMap which is naturally sorted 
        return sortedKeys;     
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int start[], end[];
        int endC=0, endJ=0, curCase = 1, n;
        HashMap<Integer, Integer> map = new HashMap<>();
        //String schedule;
        
        while(curCase<=t){
            n = sc.nextInt();
            stringArray = new String[n];
            start = new int[n];
            end = new int[n];
            Cstart.clear();
            Cend.clear();
            Jstart.clear();
            Jend.clear();
            map.clear();
            str = "";
            for(int i=0; i<n; i++){
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
                if(end[i]<start[i]){
                    end[i] = start[i] + end[i];
                    start[i] = end[i] - start[i];
                    end[i] = end[i] - start[i];
                }
                map.put(start[i], i);
            }
            //Cstart.add(start[0]);
            //Cend.add(end[0]);
            //str +="C";
            //System.out.println("n: "+n);
            for(int i=0; i<n; i++){
                if(!CAvailable(start[i], end[i])){
                    if(!JAvailable(start[i], end[i])){
                        str = "IMPOSSIBLE";
                        break;
                    }
                    //str+=
                }
            }
            // int i=0, st;
            // for (Map.Entry<Integer, Integer> entry : map.entrySet()){ 
            //     i = entry.getValue();
            //     st = entry.getKey();
            //     count = i;
            //     if(!CAvailable(st, end[i])){
            //         if(!JAvailable(st, end[i])){
            //             str = "IMPOSSIBLE";
            //             break;
            //         }
            //         //str+=
            //     }
            // }
            // if(str!="IMPOSSIBLE"){
            //     str="";
            //     for(int i=0; i<n; i++){
            //         str+=stringArray[i];
            //         //System.out.println(stringArray[i]);
            //     }
            // }
            //System.out.println(sortbykey(map));
            System.out.println("Case #"+curCase+": "+str);
            curCase++;
        }
    }
}