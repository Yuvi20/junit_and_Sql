package removeOccurance;

import java.util.Scanner;

public class AttendanceString {

    private static final int MOD = 1000000007;

    public static long modularExponentiation(long base, long exponent, int mod) {
        long result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent % 2) == 1) {
                result = (result * base) % mod;
            }
            exponent = exponent >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static long countWays(int n) {
        return modularExponentiation(3, n, MOD);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countWays(n));
    }
}
//package pack2;
//
//import java.util.Scanner;
//
//public class Attendance {
//	private static final int MOD = 1000000007;
//
//	public static int solve(int n) {
//		return (int) power(3, n, MOD);
//	}
//
//	static long power(long x, long y, long p) { long res = 1; x = x % p; while (y > 0) { if ((y & 1) == 1) { res = (res * x) % p; } y = y >> 1; x = (x * x) % p; } return res; }
//
//public static void main(String[] args) { Scanner sc = new Scanner(System.in); int n = sc.nextInt(); // long result = power(3, n, MOD); System.out.println(solve(n)); sc.close(); } }
