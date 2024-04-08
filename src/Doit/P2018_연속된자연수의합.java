package Doit;

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(end_index!=N) {
            if(sum==N) {
                count++; end_index++; sum = sum + end_index; // 같았을 때는 end_index를 확장하고, sum에 더해줘야 함
            } else if (sum>N) {
                sum = sum - start_index;
                start_index++; // 먼저 start_index를 빼주고, start_index를 오른쪽으로 하나 이동(순서 중요)
            }else {
                end_index++; sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
