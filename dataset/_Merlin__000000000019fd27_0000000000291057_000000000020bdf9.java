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
                myPair.i = j;
                arrayList.add(myPair);
            }

            arrayList.sort(new Comparator<MyPair>() {
                @Override
                public int compare(MyPair o1, MyPair o2) {
                    return Integer.compare(o1.l, o2.l);
                }
            });
            boolean t = true;
            for(int j = 0; j < m; j++){
                if(a != -1){
                    if(arrayList.get(j).l >= arrayList.get(a).r){
                        arrayList.get(j).s="C";
                        a = j;
                    } else {
                        if(b != -1){
                            if(arrayList.get(j).l >= arrayList.get(b).r){
                                arrayList.get(j).s="J";
                                b = j;
                            } else {
                                s = "IMPOSSIBLE";
                                break;
                            }
                        } else {
                            arrayList.get(j).s="J";
                            b = j;
                        }
                    }
                } else {
                    arrayList.get(j).s="C";
                    a = j;
                }
            }

            if(s != "IMPOSSIBLE"){
                arrayList.sort(new Comparator<MyPair>() {
                    @Override
                    public int compare(MyPair o1, MyPair o2) {
                        return Integer.compare(o1.i, o2.i);
                    }
                });
                for(int j = 0; j < m; j++){
                    s+= arrayList.get(j).s;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + s);
        }

    }
}

class MyPair{
    int l,r,i;
    String s;
}