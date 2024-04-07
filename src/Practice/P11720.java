package Practice;

import java.util.Scanner;

public class P11720 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt(); // 1번째 줄 숫자의 개수 입력받기
        String sNum = sc.next(); // 2번째 줄 숫자들 N개 받아야 하는데 long, int 안되니깐 String으로
        char[] cNum = sNum.toCharArray(); // int형으로 바꾸려고 일단 charArray로 바꿈
        int sum = 0; // sum을 0으로 초기화해서 미리 선언
        for (int i=0; i<cNum.length; i++) { // cNum배열 안의 숫자들 for문 돌려서 더하기
            sum+= cNum[i] - '0'; // 문자열 cNum을 숫자형으로 바꾸려고 0의 아스키값(48) 빼주기
        }
        System.out.println();
    }
}

// P11720 문제에서는 두 번째 줄에 숫자들이 공백 없이 붙어서 입력되기 때문에,
// 전체를 하나의 문자열로 받아 처리해야 합니다.
// 예를 들어, 12345와 같이 입력되면, 이는 하나의 문자열로써 12345를 의미합니다.
// 따라서, 이를 각각 분리하여 정수로 변환하기 위해 문자열을 문자 배열로 변환한 후,
// 각 문자를 숫자로 변환하여 합계를 구하는 과정이 필요합니다.