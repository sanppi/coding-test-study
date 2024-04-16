package Doit;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택오름차순수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열의 갯수
        int[] A = new int[N]; // 갯수만큼 A 배열 만들기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt(); // 실제로 데이터 받기
        }
        Stack<Integer> stack = new Stack<>(); // 스택 자료구조 만들어주기, Integer 객체로
        int num = 1;
        boolean result = true; // No 찍히고 종료했다는 걸 알기 위해 boolean값 만들기
        StringBuffer bf = new StringBuffer();

        // if (su >= num)은 su 값을 스택에 push하고, 그 값을 만족할 때까지 스택에 누적하는 과정을 처리
        for (int i = 0; i < A.length; i++) {
            int su = A[i]; // 현재 처리해야 할 수열의 값
            if (su >= num) { // 배열에 있는 값이 현재 오름차순 자연수보다 큰 경우
                while (su >= num) {
                    stack.push(num++); // 같아질 때까지 반복해줌. 하나씩 증가
                    bf.append("+\n"); // 수열값만큼 + 찍힘
                }
                stack.pop(); // 똑같아졌을 때 마지막에 있는 하나 가져와야 하니깐 pop연산
                bf.append("-\n");
            }

            // 반면, else는 su 값이 이미 스택에 있으며, 그 값을 꺼내어 수열의 해당 값을 만족시키는 과정을 처리
            else { // 현재 수열 값(su) < 오름차순 자연수(num)
                int n = stack.pop(); // 스택에서 가장 위에 있는 데이터를 꺼내고, 그 값을 n 변수에 저장
                if (n > su) { // 스택에서 꺼낸 값(n)이 현재 수열에서 처리해야 하는 값(su)보다 큰 경우
                    System.out.println("No");
                    result = false;
                    break;
                } else { // n == su..?
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString()); // result = true일때의 값들 찍기
    }
}
