import java.io.*;
import java.util.*;
class Solution{

    static void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
    
        int i = 0, j = 0;   
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
  
    static void schedulingTasks(ArrayList<Integer> start, ArrayList<Integer> end, int testNo, int n){

        char[] assignTask = new char[start.size()];
        int[] s = new int[start.size()];
        ArrayList<Integer> remaining = new ArrayList<Integer>();
        int eTime = 0;
        String ans = new String();

        for(int i=0;i<start.size();i++)
           s[i]=start.get(i);

        sort(s, 0, s.length-1); 

        eTime = end.get(start.indexOf(s[0]));
        assignTask[start.indexOf(s[0])] = 'C';
        for(int j=1;j<s.length;j++){
            if(eTime<=s[j]){
                eTime=end.get(start.indexOf(s[j]));
                assignTask[start.indexOf(s[j])] = 'C';
            }
            else
               remaining.add(s[j]);
        }

        if(!remaining.isEmpty()){
            eTime = end.get(start.indexOf(remaining.get(0)));
            assignTask[start.indexOf(remaining.get(0))] = 'J';
            for(int j=1;j<remaining.size();j++){
                if(eTime<=remaining.get(j)){
                    eTime=end.get(start.indexOf(remaining.get(j)));
                    assignTask[start.indexOf(remaining.get(j))] = 'J';
                }
                else
                    assignTask[start.indexOf(remaining.get(j))] = 'I';
            }
        }

        for(int i=0;i<assignTask.length;i++)
            if(assignTask[i]=='C' || assignTask[i]=='J')
               ans+=assignTask[i];

        PrintWriter writer = new PrintWriter(System.out);  
        if(ans.length()<n)   
            writer.write("Case #"+testNo+": IMPOSSIBLE\n");
        else if(ans.length()==n)
            writer.write("Case #"+testNo+": "+ans+"\n");
        writer.flush();
           
    }

    public static void main(String args[])throws IOException{

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int t = Integer.parseInt(br.readLine());
        for(int k=1;k<=t;k++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> startTime = new ArrayList<Integer>(n); 
            ArrayList<Integer> endTime = new ArrayList<Integer>(n); 
            for(int i=0;i<n;i++){
                 String[] taskTimes = br.readLine().split(" ");
                 startTime.add(Integer.parseInt(taskTimes[0]));
                 endTime.add(Integer.parseInt(taskTimes[1]));
            }            
            schedulingTasks(startTime, endTime, k, n);
        }
    }
}