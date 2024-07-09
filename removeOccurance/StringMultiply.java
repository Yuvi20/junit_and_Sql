package removeOccurance;

import java.math.BigInteger;

public class StringMultiply {
    public static String stringMultiply(String A, String B) {
        // Convert the strings to BigInteger
        BigInteger numA = new BigInteger(A);
        BigInteger numB = new BigInteger(B);
        
        // Perform the multiplication
        BigInteger result = numA.multiply(numB);
        
        // Convert the result back to a string and return
        return result.toString();
    }

    public static void main(String[] args) {
        String A = "3";
        String B = "3";
        String result = stringMultiply(A, B);
        System.out.println(result); // Output: "9"
    }
}
