import java.io.*;
import java.util.*;


public class Solution {


    static class Data {
        int index;
        Character user;
        int s;
        int e;

        public Data(int index, int s, int e) {
            this.index = index;
            this.s = s;
            this.e = e;
            user = null;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int index=0;index<t;index++){
            int n = scanner.nextInt();
            List<Data> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                list.add(new Data(i, s, e));
            }
            Collections.sort(list, (a,b)->{
                if(a.s == b.s) return a.e-b.e;
                return a.s-b.s;
            });
            int lastEndTimeOfJ = 0;
            int lastEndTimeOfC = 0;
            boolean impossible = false;
            for(Data d : list){
                if(lastEndTimeOfJ <= d.s) {
                    d.user = 'C';
                    lastEndTimeOfJ = d.e;
                }else if(lastEndTimeOfC <= d.s){
                    d.user = 'J';
                    lastEndTimeOfC = d.e;
                }
                if(d.user == null){
                    impossible = true;
                    break;
                }
            }
            StringBuilder ans = new StringBuilder();

            if(impossible == false){
                Collections.sort(list, (a,b)-> a.index - b.index);
                for(Data d  : list) ans.append(d.user);
            }else {
                ans.append("IMPOSSIBLE");
            }

            System.out.print("Case #");
            System.out.print((index+1)+": ");
            System.out.print(ans);
            System.out.println();
        }
    }




}

