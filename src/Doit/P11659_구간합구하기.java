package Doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        // 입력된 데이터를 한 줄 씩 읽음
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        // 읽어들인 줄을 공백을 기준으로 토큰으로 분리
        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        // 1. 합배열 먼저
        long[]S = new long[suNo + 1]; // 힙배열
        // +1한 이유는? 배열은 0번째째 인덱스를 가지고 있으니,
        // 0번쨰 인덱스를 무시하고 질의를 바로 받아서 쓰고자 +1을 한 것

        // 합배열을 바로 저장해줘야 함. 긴 suNo만큼의 데이터를 한 줄로 쭉 받아와야 함.
        stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());

        for(int i=1; i<=suNo; i++) // 1부터 시작하는 이유? 0번째 인덱스는 신경 안쓰고 싶어서
        {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 2. 구간 합
        for(int q=0; q<quizNo; q++) {
            stringTokenizer =
                    new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}
