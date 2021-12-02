package algorithm;

public class P_SJF {
	Process[] pArr;
	public P_SJF(Process[] pArr) {
		this.pArr = pArr;
	}

	public void Play() {
		//[0] : Average WatingTime, [1] : Average TurnArroundTime
		double Average[] = new double[2];

		int time,done = 0;
		int smallest,endTime = 0;
		int[] rt = new int[pArr.length+1];

		for(int i = 0; i < pArr.length; i++)
			rt[i] = pArr[i].getbT();
		rt[pArr.length] = 1000;

		for(time = 0; done != pArr.length; time++) {
			smallest = pArr.length;
			for(int i = 0; i < pArr.length; i++) {
				if(pArr[i].getaT() <= time && rt[i] < rt[smallest] && rt[i]>0)
					smallest = i;

			}
			rt[smallest]--;
			if(smallest < pArr.length)	//ArrayIndexOutOfBoundsException 처리
				System.out.println(time + "~" + (time+1) +":	P" + pArr[smallest].getpNum());
			
			if(rt[smallest] == 0) {
				done++;	//처리한 프로세스 개수
				endTime = time +1;
				pArr[smallest].settT(endTime - pArr[smallest].getaT());
				pArr[smallest].setwT(endTime - pArr[smallest].getbT() - pArr[smallest].getaT());
				pArr[smallest].setcT(endTime);
				Average[0] += pArr[smallest].getwT();
				Average[1] += pArr[smallest].gettT();
			}
		}
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

	}
}
