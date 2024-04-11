package Doit;

import java.util.Scanner;

public class P10986_나머지합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M]; // S를 M으로 나눈 나머지가 아니라, 같은 나머지의 인덱스를 카운트하는 배열.
        // C[1] = 2 -> 나머지가 1인 누적 합이 2개
        long answer = 0; // 최종적으로 찾고자 하는 조건을 만족하는 연속 부분 수열의 개수

        // 합 배열
        S[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }

        // S를 M으로 나눈 나머지 계산 및 C배열 채우기
        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            if (remainder == 0) answer++;
            C[remainder]++;
        }

        // C[i]개 중 2개를 뽑는 경우의 수
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i]-1) / 2);
            }
        }
        System.out.println(answer);
    }
}