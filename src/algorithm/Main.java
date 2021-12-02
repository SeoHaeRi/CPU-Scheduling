package algorithm;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int number;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Process number? : ");
		number = sc.nextInt();
		Process[] pArr = new Process[number];
		
		for(int i = 0; i < number; i++) {
			Process p = new Process();
			
			System.out.println("[" + "P" + i + "]");
			p.setpNum(i);
			System.out.print("Arrival Time? : ");
			p.setaT(sc.nextInt());
			System.out.print("Burst Time? : ");
			p.setbT(sc.nextInt());
			System.out.print("Priority? : ");
			p.setPriority(sc.nextInt());
			
			pArr[i] = p;
		}//for
		

		//각각의 Scheduling 실행
		System.out.println("\n---FCFS---");
		FCFS fcfs = new FCFS(pArr);
		fcfs.Play();		
		
		System.out.println("---Preemptive SJF---");
		P_SJF p_sjf = new P_SJF(pArr);
		p_sjf.Play();

		System.out.println("---Preemptive Priority---");
		P_Priority p_priority = new P_Priority(pArr);
		p_priority.Play();
		
		System.out.println("---RR---");
		RR rr = new RR(pArr);
		rr.Play();
		
		sc.close();
	}//main
}
