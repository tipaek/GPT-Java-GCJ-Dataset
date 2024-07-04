import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int N=in.nextInt();
          int S[]=new int[N];
          int E[]=new int[N];
          int arr[]=new int[1441];
          for(int j=0;j<N;j++){
              S[j]=in.nextInt();
              E[j]=in.nextInt();
              arr[S[j]]++;
              arr[E[j]]--;
          }
          String y=null;
          for(int j=1;j<1441;j++){
              arr[j]+=arr[j-1];
              if(arr[j]>2){
                  y="IMPOSSIBLE";
                  break;
              }
          }
          if(y==null){
              List<Integer>[]addedActivities=new List[1441];
              List<Integer>[]removedActivities=new List[1441];
              for(int j=0;j<N;j++){
                  if(addedActivities[S[j]]==null){
                      addedActivities[S[j]]=new ArrayList();
                  }
                  addedActivities[S[j]].add(j);
                  if(removedActivities[E[j]]==null){
                      removedActivities[E[j]]=new ArrayList();
                  }
                  removedActivities[E[j]].add(j);
              }
              char ans[]=new char[N];
              if(addedActivities[0]==null){
                  addedActivities[0]=new ArrayList();
              }
              int size=addedActivities[0].size();
              if(size==1){
                  int activity=addedActivities[0].get(0);
                  if(ans[activity]=='\u0000'){
                      ans[activity]='C';
                  }
              }else if(size==2){
                  int activity1=addedActivities[0].get(0);
                  int activity2=addedActivities[0].get(1);
                  if(ans[activity1]=='\u0000'){
                      ans[activity1]=ans[activity2]=='C'?'J':'C';
                  }
                  if(ans[activity2]=='\u0000'){
                      ans[activity2]=ans[activity1]=='C'?'J':'C';
                  }
              }
              for(int j=1;j<1441;j++){
                  if(addedActivities[j]==null){
                      addedActivities[j]=new ArrayList();
                  }
                  addedActivities[j].addAll(addedActivities[j-1]);
                  if(removedActivities[j]==null){
                      removedActivities[j]=new ArrayList();
                  }
                  addedActivities[j].removeAll(removedActivities[j]);    
                  size=addedActivities[j].size();
              if(size==1){
                  int activity=addedActivities[j].get(0);
                  if(ans[activity]=='\u0000'){
                      ans[activity]='C';
                  }
              }else if(size==2){
                  int activity1=addedActivities[j].get(0);
                  int activity2=addedActivities[j].get(1);
                  if(ans[activity1]=='\u0000'){
                      ans[activity1]=ans[activity2]=='C'?'J':'C';
                  }
                  if(ans[activity2]=='\u0000'){
                      ans[activity2]=ans[activity1]=='C'?'J':'C';
                  }
              }
              }
              y=new String(ans);
          }
          System.out.println("Case #" + i + ": " + y);
        }
      }
    }