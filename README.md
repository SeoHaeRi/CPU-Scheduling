# CPU-Scheduling
컴퓨터 시스템의 성능향상에 대해 이해, 프로세스 도착 시간이 다를 때 선점형으로 구현된 자료가 없어서 직접 구현

## 1. CPU-Scheduling 종류
- FCFS : 도착 시간을 비교하여 먼저 도착한 것부터 처리
- Preemptive SJF(SRTF) : 프로세스별 남은 처리 시간을 비교하며 작은 것부터 처리
- Preemptive Priority : 프로세스별 우선 순위를 비교하여 높은 것부터 처리
- RR : 도착한 순서대로 타임 퀀텀만큼 번갈아 처리

## 2. 실행 모습
![image](https://user-images.githubusercontent.com/62414262/159397930-e8df5edd-8088-4053-9c89-911c65073437.png)
![image](https://user-images.githubusercontent.com/62414262/159397963-be770bfb-376d-412b-a9e6-f2101158786a.png)

