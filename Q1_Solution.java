package April_05_Assognment;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1_Solution {
    public String serializeStringArray(ArrayList<String> A) {
        StringBuilder serializedString = new StringBuilder();

        for (String str : A) {
            int length = str.length();
            serializedString.append(str).append(length).append("~");
        }

        return serializedString.toString();
    }

    public static void main(String[] args) {
        Q1_Solution solution = new Q1_Solution();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of strings in the array:");
        int n = scanner.nextInt();

        ArrayList<String> A = new ArrayList<>();
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            A.add(scanner.next());
        }

        String serializedString = solution.serializeStringArray(A);
        System.out.println("Serialized string: " + serializedString);

        scanner.close();
    }
}
