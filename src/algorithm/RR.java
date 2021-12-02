package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class RR {
	//main에서
	Process[] pArr;

	public RR(Process[] pArr) {
		this.pArr = pArr;
	}

	public void Play() {
		Arrays.sort(pArr, new ATSort() );
		
		int counter = 0;
		int limit = pArr.length;
		int remain = limit;
		
		System.out.print("time quantum? : ");
		Scanner sc = new Scanner(System.in);
		int quantum = sc.nextInt();
		
		//[0] : Average WatingTime, [1] : Average TurnArroundTime
		double Average[] = new double[2];
		
		int[] rt = new int[pArr.length];
		for(int i = 0; i < pArr.length; i++)
			rt[i] = pArr[i].getbT();
		
		for(int i = 0, endTime = 0; remain != 0; ) {
			
			if(pArr[i].getaT() > endTime)
				endTime += pArr[i].getaT();
			
			if(pArr[i].getaT() <= endTime && rt[i] <= quantum && rt[i] > 0) {
				System.out.print(endTime);
				endTime += rt[i];
				System.out.println("~" + endTime + ":	P"+ pArr[i].getpNum());
				rt[i] = 0;
				counter = 1;
			}else if(pArr[i].getaT() <= endTime && rt[i] > 0) {
				rt[i] -= quantum;
				System.out.print(endTime);
				endTime += quantum;
				System.out.println("~" + endTime + ":	P"+ pArr[i].getpNum());
			}
			
			if(rt[i] == 0 && counter == 1) {
				remain--;	//남은 프로세스 개수
				pArr[i].settT(endTime - pArr[i].getaT());
				pArr[i].setwT(endTime - pArr[i].getbT() - pArr[i].getaT());
				pArr[i].setcT(endTime);
				Average[0] += pArr[i].getwT();
				Average[1] += pArr[i].gettT();
				counter = 0;
			}
			
			if(i == limit -1)
				i = 0;
			else if(pArr[i+1].getaT() <= endTime)
				i++;
			else if(rt[i] == 0 && pArr[i+1].getaT() > endTime) {
				endTime = pArr[i+1].getaT();
				i++;
			}
				
		}//for
		
		//재정렬
		Arrays.sort(pArr, new ReSort() );
		
		Average[0] = Average[0] / (double)pArr.length;
		Average[1] = Average[1] / (double)pArr.length;

		for(Process p : pArr) {
			System.out.println("[P" + p.getpNum() + "]\tWT\tCT");
			System.out.print("   \t" + p.getwT());
			System.out.println("\t" + p.getcT());
		}
		System.out.println("\tAWT\tATT");
		System.out.print("\t" + Average[0]);
		System.out.println("\t" + Average[1] +"\n");
		
		sc.close();
	}	
}
