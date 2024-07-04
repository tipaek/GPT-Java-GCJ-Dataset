import java.util.*;
class Solution
{
     static int vertices;
        static LinkedList<Edge> [] adjacencylist;
    Solution(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }
   public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        }
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
       
        
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        for(int it=1;it<=t;it++)
        {
            int n=ob.nextInt();
            int len=callen(n);
            int pasarr[]=new int[len];
            Pascal(len,pasarr);
            Solution sol=new Solution(len);
            int h=1;
            int hinut=0;
            int hs=0,he=0;
            for(int i=0;i<len;i++)
            {
                he+=i+2;
                for(int j=he;j<he;j++)
                {
                    sol.addEgde(i,j,pasarr[j]);
                }
                hs=he;
            }
            int path[]=new int[len];
            Arrays.fill(path,-1);
            boolean s=solve(0,0,n,it,path,0);
            
        }
    }
    public static Boolean solve(int st,int in,int sum,int te,int path[],int pin)
    {
         LinkedList<Edge> list = adjacencylist[st];
         for (int j = 0; j <list.size() ; j++) {
                    //System.out.println("vertex-" + i + " is connected to " +
                 int we=list.get(j).weight;
                 if(we<sum)
                 {
                     path[pin]=(in);pin++;
                     if(solve(j,list.get(j).destination,sum,te,path,pin)==false)
                     {
                        path[pin]=-1;
                        pin++;
                    }
                 }
                 else if(we==sum)
                 {
                     for(int i=0;i<path.length&& path[i]!=-1;i++)
                     {
                        System.out.println("Case #"+te+": "+path[i]);
                    }
                    }
                 else
                 {
                     
                    return false;
                 }
                }
                return false;
    }
    //Pascal function  
    public static void Pascal(int n,int pasarr[]) 
    { 
        int in=0,i,j;
        for(i = 0; i < n; i++) {
		
		for(j = 0; j <= i; j++){
			pasarr[in]=ncr(i, j);
			in++;
		}
		
 	}
    } 
    static int fact(int num) {
	int factorial;

	for(factorial = 1; num > 1; num--){
		factorial *= num;
	}
	return factorial;
    }
    static int ncr(int n,int r) {
	return fact(n) / ( fact(n-r) * fact(r) );
    }
    static long calculateSum(int n) 
    { 
  
        // Initialize sum with 0 
        long sum = 0; 
  
        // Calculate 2^n 
        sum = 1 << n; 
  
        return (sum - 1); 
    } 
    
    static int callen(int s)
    {
        if(s<=511)
        {
            return 9;
        }
        else if(s<=1023)
        {
            return 10;
        }
        return 10000;
    }
    
}
