package Practice;

import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N]; // char로 바꿀 필요 없음 N의 크기가 1000이하고, 현재 성적들도 100이하 등등 조건들 있음

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        long sum = 0;
        long max = 0;

        for(int i=0; i<N; i++){
            if (A[i]>max) max = A[i]; //   현재 원소(A[i])가 현재까지의 최댓값(max)보다 크다면, 최댓값을 현재 원소의 값으로 갱신
            sum = sum + A[i];
        }

//        이런 간략한 방법도 있음.. 점수를 배열에 저장하지 않는 방법
//        for(int i=0; i<N; i++){
//            int temp = sc.nextInt();
//            if (temp>max) max = temp;
//            sum = sum + temp;
//        }

        System.out.println(sum * 100.0 / max / N); // 이 식을 먼저 설계해야지 sum, max 필요하겠구나를 알 수 있군..
    }
}

// P1546 문제에서는 각 점수가 공백으로 구분되어 입력되므로,
// nextInt() 메서드를 사용하여 각 점수를 정수로 바로 입력받을 수 있습니다.
// 이 경우, 각 점수는 별도의 변환 과정 없이 바로 정수로 처리되며,
// 따라서 각 점수를 배열에 저장하는 과정이 간단해집니다.
