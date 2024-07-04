import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main (String[] args) {
        //code
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        for(int i=0;i<a;i++){
            int x=s.nextInt();
            int y=s.nextInt();
            int ans=-1;
            long arr[]=new long[x];
            boolean even=false,found=false,megafound=false;
//            int arr
            boolean doublle=false;
            boolean triple=false;
            boolean twice=false;
            TreeSet<Long> treeSet=new TreeSet<>();
            HashMap<Long,Integer> map=new HashMap<>();
//            int min=-1,minindex=-1;
            for(int j=0;j<x;j++) {
                arr[j] = s.nextLong();
                treeSet.add(arr[j]);
                if(map.containsKey(arr[j]))
                    map.put(arr[j],map.get(arr[j])+1);
                else
                    map.put(arr[j],1);
                if (arr[j] % 2 == 0) {
                    even = true;
                }
            }
            long minndouble=Long.MAX_VALUE;
            for(Map.Entry entry:map.entrySet()){
                long key=(long)entry.getKey();
                int value=(int)entry.getValue();
//                System.out.println(value);
                if(value>=2){
                if(minndouble>key)
                    minndouble=key;
                    doublle=true;
                }
                 if(value>=3)
                    triple=true;
                if(map.containsKey(2*key))
                    twice=true;
            }
             if(y==2){
                if(doublle==true)
                    ans=0;
                else
                    ans=1;
            }
            else if(y==3) {
                 if (x >= 3) {
                     if (triple == true)
                         ans = 0;
                     else if (twice||(doublle==true&&treeSet.higher(minndouble)!=null)) {
//                         System.out.println(treeSet.higher(minndouble));
                         ans = 1;
                     }
                     else
                         ans = 2;
                 }
                 else if(x==1){
                     ans=2;
                 }
                 else{
                     if(twice==true)
                         ans=1;
                     else
                         ans=2;
                 }
             }
//            System.out.println(triple);
//            for(int j=0;j<x;j++){
//                if(arr[j]==min/2){
////                    if(j==minindex);
////                    else
//                        found=true;
//                }
//                else if(arr[j]>=min/2)
//            }
//            if(even==true){
//                if(y==1)
//                    ans=0;
//                if(y==2)
//                    ans=1;
//                else
//                    ans=2;
//            }
//            String dir=s.next();

//            for(int j=0;j<dir.length();j++){
//                if(dir.charAt(j)=='S')
//                    y--;
//               else if(dir.charAt(j)=='N')
//                    y++;
//                else if(dir.charAt(j)=='E')
//                    x++;
//                else
//                    x--;
////                System.out.println(x+" "+y);
//                if(Math.abs(x)+Math.abs(y)<=j+1) {
//                    ans = j+1;
////                    System.out.println(x+" "+y);
//                    break;
//                }
//            }
            String answer;
            answer=ans+"";
                System.out.println("Case #"+(i+1)+": "+answer);
//            for(int i=0;i<a;i++){

//            int arr[]=new int[b];
//            int c=s.nextInt();
//            int max=0;
//            for(int j=0;j<b;j++){
//                arr[j]=s.nextInt();
//                if(max<arr[j])
//                    max=arr[j];
//            }
//            int m=(1<<((int)(Math.log(max)/Math.log(2))+1))-1;
//            System.out.println(m);
//            int dp[][]=new int[b+1][m+1];
//            dp[0][0]=1;
//            for(int j=1;j<=b;j++){
//                for(int k=0;k<=m;k++){
//                    dp[j][k]=dp[j-1][k]+dp[j-1][k^arr[j-1]];
////                    System.out.println(j+" "+k+" "+arr[j-1]);
                }
            }
//            System.out.println(dp[b][c]);
        }
