import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
	private static class ReadWrite {
		BufferedReader in;
		PrintWriter out;
		
		public ReadWrite() {
			in = new BufferedReader(new InputStreamReader(System.in));
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ReadWrite(String fileName, Boolean isInput) {
			try {
				if (isInput) {
					in = new BufferedReader(new FileReader(fileName));
				} else {
					in = new BufferedReader(new InputStreamReader(System.in));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (isInput) {
					out = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));	
				} else {
					out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ReadWrite(String inputFileName, String outputFileName) {
			try {
				in = new BufferedReader(new FileReader(inputFileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public BufferedReader getIn() {
			return this.in;
		}
		
		public PrintWriter getOut() {
			return this.out;
		}
	}
	
	private static class Pair {
		private Integer startTime;
		private Integer endTime;
		public Pair(Integer startTime, Integer endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		public Integer getStartTime() {
			return this.startTime;
		}
		
		public Integer getEndTime() {
			return this.endTime;
		}
	}
	
	private static class Job {
		private Integer endTime;
		private String parent;

		public Job(Integer endTime) {
			this.endTime = endTime;
			this.parent = null;
		}
		
		public void setParent(String parent) {
			this.parent = parent;
		}
		
		public String isJobTaken() {
			return this.parent;
		}
		
		public Integer getEndTime() {
			return this.endTime;
		}
		
		public String toString() {
			return parent + ":" + endTime;
		}
		
	}

	private static class Scheduler {
		private TreeMap<Integer, ArrayList<Job>> orderedSchedule;
		private Integer[][] schedule;
		private String[] workerSchedule;

		public Scheduler(Integer scheduleSize) {
			this.orderedSchedule = new TreeMap<Integer, ArrayList<Job>>();
			this.schedule = new Integer[scheduleSize][2];
			this.workerSchedule = new String[scheduleSize];
		}
		
		public TreeMap<Integer, ArrayList<Job>> getOrderedSchedule() {
			return this.orderedSchedule;
		}
		
		public Integer[][] getSchedule() {
			return this.schedule;
		}
		
		public void addToSchedule(Integer index, Integer startTime, Integer endTime) {
			this.schedule[index][0] = startTime;
			this.schedule[index][1] = endTime;
			Job job = new Job(endTime);
			
			ArrayList<Job> jobs = this.orderedSchedule.get(startTime);
			if (jobs == null) {
				jobs = new ArrayList<Job>();
			}
			jobs.add(job);
			this.orderedSchedule.put(startTime, jobs);
		}
		
		public String toString() {
			return String.join("", workerSchedule);
		}
	}
	
	public static String solve(String input, ReadWrite rw) throws IOException {
		int numSchedules = Integer.valueOf(input);
		Scheduler sch = new Scheduler(numSchedules);
		for (int numSchedule = 0; numSchedule < numSchedules; numSchedule++) {
			String[] metadata = rw.getIn().readLine().split(" ");
			Integer startTime = Integer.valueOf(metadata[0]);
			Integer endTime = Integer.valueOf(metadata[1]);

			sch.addToSchedule(numSchedule, startTime, endTime);
		}
		
		// process data
		Stack<Pair> parentC = new Stack<Pair>();
		Stack<Pair> parentJ = new Stack<Pair>();
		
		TreeMap<Integer, ArrayList<Job>> orderedSchedule = sch.getOrderedSchedule();
		for (Integer startTime: orderedSchedule.keySet()) {
			if (orderedSchedule.get(startTime).size() > 2) {
				// too many jobs for 2 people
				return "IMPOSSIBLE";
			}
			for (Job job : orderedSchedule.get(startTime)) {
				if (parentC.isEmpty()) {
					parentC.push(new Pair(startTime, job.getEndTime()));
					job.setParent("C");
				} else {
					Integer lastEndTime = parentC.peek().getEndTime();
					if (lastEndTime > startTime) {
						if (parentJ.isEmpty()) {
							parentJ.push(new Pair(startTime, job.getEndTime()));
							job.setParent("J");
						} else {
							lastEndTime = parentJ.peek().getEndTime();
							if (lastEndTime > startTime) {
								// both parents are busy. this is impossible
								break;
							} else {
								parentJ.push(new Pair(startTime, job.getEndTime()));
								job.setParent("J");
							}
						}
					} else {
						parentC.push(new Pair(startTime, job.getEndTime()));
						job.setParent("C");
					}
				}
			}
		}
		
		String result = "";
		Integer[][] schedule = sch.getSchedule();
		for (int i = 0; i < schedule.length; i++) {
			Integer startTime = schedule[i][0];
			Integer endTime = schedule[i][1];
			ArrayList<Job> jobs = orderedSchedule.get(startTime);
			String parent = null;
			for (Job j : jobs) {
				if (j.getEndTime() == endTime) {
					parent = j.isJobTaken();
				}
			}

			if (parent == null) {
				result = "IMPOSSIBLE";
				break;
			} else {
				result += parent;
			}
		}
		return result;
	}

	public static void main(String[] arg) throws NumberFormatException, IOException {
		Boolean isDebug = false;
		ReadWrite rw = isDebug ? new ReadWrite("input.in", true) : new ReadWrite();
    	int numCases = Integer.valueOf(rw.getIn().readLine());
    	for (int i = 1; i <= numCases; i++) {
    		String output = "Case #" + i + ": " + solve(rw.getIn().readLine(), rw).toString();
    		System.out.println(output);
    		rw.getOut().println(output);
    	}
    	rw.getOut().close();
	}
}
