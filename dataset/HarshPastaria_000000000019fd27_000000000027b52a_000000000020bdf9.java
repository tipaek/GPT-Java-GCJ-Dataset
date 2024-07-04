import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t = T;
        while(T-->0){
            System.out.print("Case #"+(t-T)+": ");
            int N = sc.nextInt();
            int[][] arr = new int[N][2];
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
            for(int i = 0;i<N;i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                hm.put(arr[i][0],arr[i][1]);
            }
            TreeMap<Integer, Integer> sorted = new TreeMap<>(hm); 
            HashMap<Integer,Character> test = new HashMap<>();
            HashMap<Integer, Character> result = new HashMap<>();
            boolean C = true;
            boolean J = true;
            int flag = 0;
            for(int i = 0;i<=1440;i++){
                if(test.containsKey(i)){
                    char ch = (char)test.remove(i);
                    if(ch == 'C'){
                        C = true;
                    }
                    else{
                        J = true;
                    }
                }
                if(sorted.containsKey(i)){
                    
                    if(C == true){
                        C = false;
                      //  System.out.println("-C-"+i+"-C-");
                        test.put(sorted.get(i),'C');
                        result.put(i,'C');
                    }
                    else if(J == true){
                        J = false;
                        test.put(sorted.get(i),'J');
                    //    System.out.println("-J-"+i+"-J-");
                        result.put(i,'J');
                    }
                    else{
                        System.out.print("IMPOSSIBLE");
                        flag = 1;
                        break;
                    }
                }
                
            }
            if(flag != 1){
            for(int i = 0;i<result.size();i++){
                System.out.print(result.get(arr[i][0]));
            }
            }
            System.out.println();
        }
    }
}