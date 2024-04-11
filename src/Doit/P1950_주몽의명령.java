package Doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1950_주몽의명령 {
    public static void main(String[] args) throws IOException {
        // 한 줄로 숫자 빨리 받아야 해서 scanner 대신 BufferedReader 씀
        // 한 번에 한 줄 전체를 문자열로 읽어올. But, 그러나 공백을 포함하여 전체 줄을 하나의 문자열로 읽어오기 때문에, 이를 개별 데이터로 분리하기 위한 추가 작업 필요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 문자열 입력받기
        int N = Integer.parseInt(br.readLine()); // 읽어온 문자열을 정수로 변환하기 위해 Integer.parseInt() 메소드를 사용
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열을 특정 구분자(기본적으로는 공백)를 기준으로 여러 개의 토큰으로 분리할 때 사용
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 오름차순 정렬
        int count = 0;
        // 투포인터 만들어주기
        int i = 0; // A[0] -> Min
        int j = N-1; // A[N-1] -> Max
        while(i<j) {
            if(A[i]+A[j]<M)i++;
            else if (A[i]+A[j]>M)j--;
            else {
                count++;
                i++; j--; // 썼던 재료 못쓰니깐
            }
        }
        System.out.println(count);
    }
}
