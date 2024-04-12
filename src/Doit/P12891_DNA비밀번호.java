package Doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    static int myArr[];
    static int checkArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken()); // 임으로 만든 DNA 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분 문자열의 길이
        int Result = 0;

        checkArr = new int[4]; // 체크 배열
        myArr = new int[4]; // 현재 상태 배열
        char A[] = new char[S]; // 문자 배열, 크기는 전체 문자 DNA 문자 배열 S
        checkSecret = 0; // 현재 4개 문자열 중에 몇개가 비밀번호 요건에 만족하는지, 4일때 count ++

        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine()); // 4개 문자열 조건
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); // 여기서 st변수에 숫자 4개가 들어간 것.
            if (checkArr[i] == 0) {
                checkSecret++; // 0이라는 건, 예를 들어 C가 0개 이상이어야 하는거니깐, 사실상 없어도 상관없는 것. 그래서 ++해주기.
            }
        }
        for (int i = 0; i < P; i++) { // 부분문자열 처음 받을 때 세팅 -> 슬라이딩윈도우 첫번쨰 원소부터
            Add(A[i]); // 문자배열에서 첫번째 윈도우 안의 첫번째 값부터 P-1인덱스의 값까지 쭉쭉 넣어주는 것
        }

        if (checkSecret == 4) Result++;

        // 슬라이딩 윈도우 -> 슬라이딩 윈도우가 한 칸 옆으로 간 것부터
        for (int i = P; i < S; i++) { // i가 오른쪽에 있는 애...?
            int j = i - P;
            Add(A[i]);// 한 칸 이동하면서 새로운 값이 들어온 것
            Remove(A[j]); // 한 칸 이동했으니 슬라이딩 윈도우 맨 앞에 값 없애주기
            if (checkSecret == 4) Result++;
        }
        System.out.println(Result);
        bf.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++; // A의 첫번째 인덱스, myArr에러 나는 이유? 전역변수로 선언안했으니깐 위에서 static 변수로 선언해줌.
                if (myArr[0] == checkArr[0]) checkSecret++; // A의 값이랑 똑같냐는것
                // checkSecret을 +1 할 수 있는 건 딱 한 번 밖에 안돼서 myArr[0] >= checkArr[0]
                // 처음 만족했을 때 +1되는 것, 최소 개수 만족했을 때
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
