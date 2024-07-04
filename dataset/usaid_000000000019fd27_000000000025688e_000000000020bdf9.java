import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> starting = new LinkedList<>();
        LinkedList<Integer> finished = new LinkedList<>();
        LinkedList<Integer> ending = new LinkedList<>();
        String [] res;
        int testCase = Integer.parseInt(sc.nextLine());
        int smallest;
        for (int i = 0; i < testCase; i++) {

            ending.clear();finished.clear();starting.clear();
            String line[] = sc.nextLine().split(" ");
            int numberOfLines = Integer.parseInt(line[0]);
            res = new String[numberOfLines];
            for (int j = 0; j < numberOfLines; j++) {
                line = sc.nextLine().split(" ");
                starting.add(Integer.parseInt(line[0]));
                ending.add(Integer.parseInt(line[1]));
            }
            int k=-1,flag=0,jending=0,cending=0;
            for(int index=0;index<starting.size();index++){
                smallest = Integer.MAX_VALUE;
                flag=0;
                if(k!=-1){
                    starting.set(k,-1);
                }
                for(int s=0;s<starting.size();s++){
                    if(starting.get(s)==-1){
                        continue;
                    }
                    if(smallest>starting.get(s)){
                        smallest=starting.get(s);
                        k=s;
                        flag=1;
                    }
                }
                if(flag==0)
                    break;

                if(starting.get(k)>=jending){
                    jending=0;
                }
                if(starting.get(k)>=cending){
                    cending=0;
                }
                if(cending==0){
                    cending = ending.get(k);
                    finished.add(starting.get(k));
                    res[k]= "C";
                    continue;
                }
                if(jending==0){
                    jending = ending.get(k);
                    res[k]="J";
                    finished.add(starting.get(k));
                }
            }
            String result= "Case #"+(i+1)+": ";
            if(starting.size()==finished.size()){
                for(String o:res){
                    result+=o;
                }
                System.out.println(result);
            }
            else {
                System.out.println(result + "IMPOSSIBLE");
            }
        }
    }
}




