//package googleCodeJam;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i< n; i++){
            int m = sc.nextInt();
            int a = -1;
            int b = -1;
            String s = "";
            ArrayList<MyPair> arrayList = new ArrayList<>();
            for(int j = 0; j < m; j++){
                MyPair myPair = new MyPair();
                myPair.l = sc.nextInt();
                myPair.r = sc.nextInt();
                arrayList.add(myPair);
            }

            arrayList.sort(new Comparator<MyPair>() {
                @Override
                public int compare(MyPair o1, MyPair o2) {
                    return Integer.compare(o1.l, o2.l);
                }
            });

            for(int j = 0; j < m; j++){
                if(a != -1){
                    if(arrayList.get(j).l >= arrayList.get(a).r){
                        s+="C";
                        a = j;
                    } else {
                        if(b != -1){
                            if(arrayList.get(j).l >= arrayList.get(b).r){
                                s+="J";
                                b = j;
                            } else {
                                s = "IMPOSSIBLE";
                                break;
                            }
                        } else {
                            s+="J";
                            b = j;
                        }
                    }
                } else {
                    s+="C";
                    a = j;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + s);
        }

    }
}

class MyPair{
    int l,r;
}