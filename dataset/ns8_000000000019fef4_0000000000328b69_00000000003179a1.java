import java.util.*;

public class Solution {

    static class subset{
        public int x;
        public int y;
        subset(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-->0){
                int u = sc.nextInt();
                Map<Integer,List<Character>> charIntMapping  = new HashMap<>();
                Map<Character,subset> possMapping  = new HashMap<>();
                for(int i=0;i<10000;i++){
                    int n = sc.nextInt();
                    String sequence = sc.next();
                    addToMap(possMapping,n,sequence, u);
                }
                char arr[] = new char[10];
                boolean decided[] = new boolean[10];
                for(int i=0;i<10;i++){
                    decided[i] = false;
                }
                for(int i=0;i<10;i++){
                    for(char j: possMapping.keySet()){
                        if(possMapping.get(j).x == 0 && possMapping.get(j).y == i){
                            arr[i] = j;
                        }
                    }
                }
                String s = "";
                for(int i=0;i<10;i++){
                    s+=arr[i];
                }
                System.out.println("Case #" + t+1 + ": " + s);
            }


//            for(char ch: possMapping.keySet()){
//                int x = possMapping.get(ch).x;
//                if(x == possMapping.get(ch).y){
//                    arr[x] = ch;
//                    decided[x] = true;
//                }else{
//                    if(!decided[x]){
//                        arr[x] = ch;
//                    }
//                }
//                System.out.println(ch+" "+ possMapping.get(ch).x+" "+ possMapping.get(ch).y);
//            }



    }

    public static void addToMap(Map<Character,subset> integersubsetMap, int n, String s , int u){
        int d = getNumberOfDigits(n);
        int len = s.length();
        if(d == len ){
            int i=0;
            while(n>0){
                int nd = n%10;
                if(i==0 && n>10){
                    addToMapSubset(integersubsetMap,new subset(0,9),s.charAt(len-i-1));
                }else{
                    addToMapSubset(integersubsetMap,new subset(0,nd),s.charAt(len-i-1));
                }
                n = n/10;
                i++;
            }
        }else{
            int nn = (int)Math.pow(10,len)-1;
            addToMap(integersubsetMap,nn,s,u);
        }
    }


    public static void addToMapSubset(Map<Character,subset> integersubsetMap, subset s, char ch){
        if(integersubsetMap.containsKey(ch)){
            subset s1 = integersubsetMap.get(ch);
            integersubsetMap.put(ch, getSubset(s1,s));
        }else{
            integersubsetMap.put(ch,s);
        }
    }


    public static subset getSubset(subset s1, subset s2){
        int x = Math.max(s1.x,s2.x);
        int y = Math.min(s1.y,s2.y);
        return new subset(x,y);
    }

    public static int getNumberOfDigits(int n){
        int t=0;
        while(n>0){
            n = n/10;
            t++;
        }
        return t;
    }



}
