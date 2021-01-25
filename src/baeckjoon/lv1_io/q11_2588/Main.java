package baeckjoon.lv1_io.q11_2588;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(b%10*a);
		System.out.println(b%100/10*a);
		System.out.println(b/100*a);
		System.out.print(b*a);
		// System.out.println(b/100); // 백의자리 숫자
		// System.out.println(b%100/10); // 십의자리 숫자
		// System.out.println(b%10); // 일의자리 숫자
	}
}
