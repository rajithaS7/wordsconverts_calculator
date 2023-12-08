import java.util.Scanner;

public class NumberToWordsConverter {

    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number (0 to exit): ");
            int number = scanner.nextInt();

            if (number == 0) {
                System.out.println("Exiting...");
                break;
            }

            String words = convertToWords(number);
            System.out.println("Words: " + words);
        }

        scanner.close();
    }

    public static String convertToWords(int number) {
        if (number == 0) {
            return "Zero";
        }

        return convertToWordsHelper(number);
    }

    private static String convertToWordsHelper(int number) {
        String result = "";

        if (number < 0) {
            result += "Negative ";
            number = -number;
        }

        if (number >= 1000000) {
            result += convertToWordsHelper(number / 1000000) + " Million ";
            number %= 1000000;
        }

        if (number >= 1000) {
            result += convertToWordsHelper(number / 1000) + " Thousand ";
            number %= 1000;
        }

        if (number >= 100) {
            result += units[number / 100] + " Hundred ";
            number %= 100;
        }

        if (number > 0) {
            if (number >= 20) {
                result += tens[number / 10] + " " + units[number % 10];
            } else if (number > 10) {
                result += teens[number - 10];
            } else {
                result += units[number];
            }
        }

        return result.trim();
    }
}
