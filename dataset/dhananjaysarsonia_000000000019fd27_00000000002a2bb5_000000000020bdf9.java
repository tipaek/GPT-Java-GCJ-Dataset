

import java.util.*;
public class Solution {
    private static Scanner scanner;
    private static int cases =1;

    public static void main(String args[]) {

        scanner =new Scanner(System.in);
        int testcases= scanner.nextInt();
        scanner.nextLine();
        while(testcases>0){
            testcases--;


            int next= scanner.nextInt();

            int [][] arr=new int[next][2];
            int [][] arr_sort =arr.clone();
            char p ='J';
            char[] char_temp=new char[next];

            Map<int[],Integer> map=new HashMap<>();

            Stack<int[]> jamie = new Stack<>();
            Stack<int[]> cameron = new Stack<>();
            boolean impossible=false;

            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    arr[i][j]= scanner.nextInt();
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
                if(i<arr_sort.length-1&& compareOverLap(arr_sort[i],arr_sort[i+1])){
                    if(p== 'J'){
                        jamie.push(arr_sort[i]);
                        if(p=='J'){
                            p='C';
                        }else{
                            p='J';
                        }
                        if(!cameron.isEmpty()&& compareOverLap(cameron.peek(),arr_sort[i+1])){
                            impossible=true;
                            break;
                        }
                    }else{
                        cameron.push(arr_sort[i]);
                        if(p=='J'){
                            p='C';
                        }else{
                            p='J';
                        }
                        if(!jamie.isEmpty()&& compareOverLap(jamie.peek(),arr_sort[i+1])){
                            impossible=true;
                            break;
                        }
                    }

                }else{
                    if(p=='J'){
                        jamie.push(arr_sort[i]);
                    }else{
                        cameron.push(arr_sort[i]);
                    }

                }


            }

            System.out.println("Case #" + (cases++)+": "+(impossible ? "IMPOSSIBLE" : new String(char_temp)));

        }

    }
    
    private static boolean compareOverLap(int[] a, int[] b){
        return a[1]>b[0];
    }

}