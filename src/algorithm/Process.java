package algorithm;

import java.util.Comparator;

public class Process {
//	pNum : Process 번호	
//	aT : Arrival Time
//	bT : Burst Time
//	Priority
	
//	pT : Processing Time	
//	wT : Wating Time
//	cT : Complete Time
//	tT : Turnaround Time
	
	private int pNum;
	private int aT;
	private int bT;
	private int priority;
	
	private int[] pT = new int[2];
	private int wT;
	private int cT;
	private int tT;
	
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getaT() {
		return aT;
	}
	public void setaT(int aT) {
		this.aT = aT;
	}
	public int getbT() {
		return bT;
	}
	public void setbT(int bT) {
		this.bT = bT;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	public void getpT_FCFS() {
		System.out.print("[" + pT[0] +"~"+ pT[1] + "]");
	}

	public void setpT_FCFS(int a, int b) {
		this.pT[0] = a;
		this.pT[1] = b;
	}
	public int getwT() {
		return wT;
	}
	public void setwT(int wT) {
		this.wT = wT;
	}
	public int getcT() {
		return cT;
	}
	public void setcT(int cT) {
		this.cT = cT;
	}
	public int gettT() {
		return tT;
	}
	public void settT(int tT) {
		this.tT = tT;
	}
	
}

class ATSort implements Comparator<Process>{

	@Override
	public int compare(Process o1, Process o2) {
		if( o1.getaT() == o2.getaT() )
			return 0;
		return o1.getaT() < o2.getaT() ? -1 : 1;
	}
	
}

class ReSort implements Comparator<Process>{

	@Override
	public int compare(Process o1, Process o2) {
		return o1.getpNum() < o2.getpNum() ? -1 : 1;
	}
}