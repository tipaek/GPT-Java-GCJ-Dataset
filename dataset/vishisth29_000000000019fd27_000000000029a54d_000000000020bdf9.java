import java.util.*;
public class Solution {
    private static Scanner scn;
    private static int cases =1;

    public static void main(String args[]) {

        scn=new Scanner(System.in);
        int t=scn.nextInt();
        scn.nextLine();
            while(t-->0){
                solve();
            }

        }

        private static void solve(){
        int n=scn.nextInt();

        int [][] arr=new int[n][2];
        int [][] arr_sort =arr.clone();
        char p ='J';
        char[] char_temp=new char[n];

        Map<int[],Integer> map=new HashMap<>();

        Stack<int[]> stack_j = new Stack<>();
        Stack<int[]> stack_C = new Stack<>();
        boolean impossible=false;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]= scn.nextInt();
            }
            map.put(arr[i],i);
        }

        Arrays.sort(arr_sort, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int i=0;i<arr_sort.length;i++){
            char_temp[map.get(arr_sort[i])]=p;
            if(i<arr_sort.length-1&& overlap_check(arr_sort[i],arr_sort[i+1])){
                if(p== 'J'){
                    stack_j.push(arr_sort[i]);
                    if(p=='J'){
                        p='C';
                    }else{
                        p='J';
                    }
                    if(!stack_C.isEmpty()&& overlap_check(stack_C.peek(),arr_sort[i+1])){
                        impossible=true;
                        break;
                    }
                }else{
                    stack_C.push(arr_sort[i]);
                    if(p=='J'){
                        p='C';
                    }else{
                        p='J';
                    }
                    if(!stack_j.isEmpty()&& overlap_check(stack_j.peek(),arr_sort[i+1])){
                        impossible=true;
                        break;
                    }
                }

            }else{
                if(p=='J'){
                    stack_j.push(arr_sort[i]);
                }else{
                    stack_C.push(arr_sort[i]);
                }

            }


        }

        System.out.println("Case #" + (cases++)+": "+(impossible ? "IMPOSSIBLE" : new String(char_temp)));

        }

        private static boolean overlap_check(int[] a, int[] b){
        return a[1]>b[0];
        }

    }














