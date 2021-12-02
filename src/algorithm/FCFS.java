package algorithm;

import java.util.Arrays;

public class FCFS {

	//main에서
	Process[] pArr;

	public FCFS(Process[] pArr) {
		this.pArr = pArr;
	}

	public void Play() {
		Arrays.sort(pArr, new ATSort() );
		
		//[0] : Average WatingTime, [1] : Average TurnArroundTime
		double Average[] = new double[2];
		
		//i = 0일 때의 값 저장
		pArr[0].setwT(0);
		pArr[0].settT(pArr[0].getbT() + pArr[0].getwT());
		pArr[0].setcT(pArr[0].gettT() + pArr[0].getaT());
		pArr[0].setpT_FCFS(pArr[0].getaT() + pArr[0].getwT(), 
				pArr[0].getaT() + pArr[0].getwT() + pArr[0].getbT());
		
		Average[0] += pArr[0].getwT();
		Average[1] += pArr[0].gettT();
		
		//i >= 1인 경우
		for(int i = 1; i < pArr.length; i++) {
			
			pArr[i].setwT(pArr[i-1].getcT()- pArr[i].getaT());
			pArr[i].settT(pArr[i].getbT() + pArr[i].getwT());
			pArr[i].setcT(pArr[i].gettT() + pArr[i].getaT());
			pArr[i].setpT_FCFS(pArr[i].getaT() + pArr[i].getwT(), 
					pArr[i].getaT() + pArr[i].getwT() + pArr[i].getbT());
			
			Average[0] += pArr[i].getwT();
			Average[1] += pArr[i].gettT();
		}
		
		Average[0] = Average[0] / (double)pArr.length;
		Average[1] = Average[1] / (double)pArr.length;
		//재정렬
		Arrays.sort(pArr, new ReSort() );
		
		for(Process p : pArr) {
			System.out.println("[P" + p.getpNum() + "]\tPT\tWT\tCT");
			System.out.print("\t");
			p.getpT_FCFS();
			System.out.print("\t" + p.getwT());
			System.out.println("\t" + p.getcT());
		}
		System.out.println("\tAWT\tATT");
		System.out.print("\t" + Average[0]);
		System.out.println("\t" + Average[1] +"\n");
	}
}
