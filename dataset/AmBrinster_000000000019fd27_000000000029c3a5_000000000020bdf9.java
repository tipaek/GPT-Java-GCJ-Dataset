import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0; ++i<=t; ) {
            int n = Integer.parseInt(in.nextLine());
            String[] arr = new String[n];
            for(int j = 0; j<n; j++) {
                arr[j] = in.nextLine();
            }
            System.out.print("Case #"+i+": ");
            printOut(arr,n);
            System.out.println();
        }
    }

    private static void printOut(String[] arr, int n) {
        NavigableMap<Integer, Integer> mapJ = new TreeMap<>(), mapC = new TreeMap<>();
        NavigableMap<String, String> jMap = new TreeMap<>(), cMap = new TreeMap<>();
        for(int i=0; i<n; i++) {
            String[] str = arr[i].split(" ");
            mapJ.put(Integer.parseInt(str[1]),Integer.parseInt(str[0]));
        }
        for(Integer i : mapJ.navigableKeySet()) {
            if (jMap.isEmpty())
                jMap.put(mapJ.get(i)+" "+i,"J");
            else {
                String str = jMap.lastKey();
                if (Integer.parseInt(str.split(" ")[1])<=mapJ.get(i)){
                    jMap.put(mapJ.get(i)+" "+i, "J");
                } else {
                    mapC.put(i, mapJ.get(i));
                }
            }
        }
        for(Integer i : mapC.navigableKeySet()) {
            if (cMap.isEmpty())
                cMap.put(mapC.get(i)+" "+i,"C");
            else {
                String str = cMap.lastKey();
                if (Integer.parseInt(str.split(" ")[1])<=mapC.get(i)){
                    cMap.put(mapC.get(i)+" "+i, "C");
                } else {
                    System.out.print("IMPOSSIBLE");
                    return;
                }
            }
        }
        for(int i =0; i<n; i++) {
            if (jMap.containsKey(arr[i]))
                System.out.print(jMap.get(arr[i]));
            else
                System.out.print(cMap.get(arr[i]));
        }
    }
}
