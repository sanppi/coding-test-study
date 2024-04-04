package Doit;

import java.util.Scanner;

public class P1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int A[] = new int[N];
//        for(int i=0; i<N; i++){
//            A[i] = sc.nextInt();
//        } // 배열을 저장해놓고,
        long sum = 0;
        long max = 0;

//        for(int i=0; i<N; i++){
//           if (A[i]>max) max = A[i];
//           sum = sum + A[i];
//        } // 배열을 탐색하면서 구했음

        // 숙달된 사람들은 이렇게
        for(int i=0; i<N; i++){
            int temp = sc.nextInt();
            if (temp>max) max = temp;
            sum = sum + temp;
        }

        System.out.println(sum * 100.0 / max / N);

    }
}
