package bullscows;

import java.util.*;

public class SuperGame {

    protected static void startSuperGame() {

        char[] secretCode = makeSecretCode();
        int turnCounter = 0;
        int bullNumber;
        do {

            turnCounter++;
            bullNumber = writeUserInputPlusGetBull(secretCode, turnCounter);

        } while (bullNumber < Objects.requireNonNull(secretCode).length);

        System.out.println("Congratulations! You guessed the secret code.");
    }
    protected static char[] makeSecretCode() {

        System.out.println("Input the length of the secret code:");
        Scanner scanner = new Scanner(System.in);

        String length1 = scanner.nextLine();
        int length = 0;
        if (length1.matches("[0-9]+")) {

            length = Integer.parseInt(length1);
        } else {

            System.out.printf("Error: \"%s\" isn't a valid number.", length1);
            System.exit(0);
        }

        if (length > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %d " +
                    "because there aren't enough unique digits.", length);
            System.exit(0);
        }

        if (length == 0) {

            System.out.printf("Error: \"%s\" isn't a valid number.", length1);
            System.exit(0);
        }

        System.out.println("Input the number of possible symbols in the code:");
        int lenOfPosSymb = scanner.nextInt();

        if (lenOfPosSymb > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z)");
            System.exit(0);
        }

        if (length > lenOfPosSymb) {

            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.",
                    length, lenOfPosSymb);
            System.exit(0);
        }

        String stars = "*".repeat(length);
        String posSymb = "";
        if (lenOfPosSymb <= 10) {

            posSymb = String.format("(0-%d)", lenOfPosSymb - 1);
        } else {
            char c2 = (char) (lenOfPosSymb - 11 + 'a');
            char c1 = 'a';
            posSymb = String.format("(0-9, %c-%c)", c1, c2);
        }

        System.out.printf("The secret is prepared: %s %s.%n", stars, posSymb);
        System.out.println("Okay, let's start a game!");
        Random r = new Random();

        char[] secretCode = new char[length];
        char z = ' ';

        for (int i = 0; i < secretCode.length; i++) {

            if (lenOfPosSymb > 10) {

                int zeroOrOne = r.nextInt(2);

                if (zeroOrOne == 0) {

                    z = (char)(r.nextInt(lenOfPosSymb - 10) + 'a');
                } else {

                    z = (char) (r.nextInt(10) + '0');
                }
            } else {

                z = (char) (r.nextInt(lenOfPosSymb) + '0');
            }

            if (!contains2(secretCode, z)) {


                secretCode[i] = z;
            } else {

                i--;
            }
        }

        //System.out.println(Arrays.toString(secretCode));
        return secretCode;
    }

    protected static boolean contains2(char[] secretCode, char randChar) {

        boolean isThere = false;
        for (char j : secretCode) {

            if (j == randChar) {

                isThere = true;
                break;
            }
        }

        return isThere;
    }
    protected static int writeUserInputPlusGetBull(char[] secretCodeArg, int counter) {

        System.out.printf("Turn %d:%n", counter);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] charArr = input.toCharArray();
        //String[] arr = input.split("");
//        int[] userInput = new int[charArr.length];

//        for (int i = 0; i < charArr.length; i++) {
//
//            userInput[i] = Integer.parseInt(arr[i]);
//        }

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < charArr.length; i++) {

            if (charArr[i] == secretCodeArg[i]) {
                bulls++;
            } else if (contains(secretCodeArg, charArr[i])) {
                cows++;
            }
        }

        String resultText = "Something goes wrong!";
        if (bulls == 0 && cows == 0) {

            resultText = "Grade: None.";

        } else {

            String bullStr = "bulls";
            String cowStr = "cows";

            if (bulls == 1) {

                bullStr = "bull";
            }

            if (cows == 1) {

                cowStr = "cow";
            }

            resultText = String.format("Grade: %d %s and %d %s.", bulls, bullStr, cows, cowStr);
        }

        System.out.println(resultText);
        return bulls;
    }
    protected static boolean contains(char[] array, char key) {

        boolean isThere = false;

        for (char c : array) {

            if (c == key) {

                isThere = true;
                break;
            }
        }
        return isThere;

//        for (int arrayValue : array) {
//
//            if (key == arrayValue) {
//                isThere = true;
//                System.out.println("It is there");
//                //break;
//            }
//        }
//        return isThere;
    }

//    protected static int[] makeSecretCode() {
//
//        long pseudoRandomNumber = System.nanoTime();
//
//        StringBuilder pseudoNumbers = new StringBuilder(Long.toString(pseudoRandomNumber));
//        StringBuilder secretCode = new StringBuilder();
//
//        System.out.println("Please, enter the secret code's length:");
//        Scanner scanner = new Scanner(System.in);
//        int lengthInput = scanner.nextInt();
//        if (lengthInput > 10) {
//            System.out.printf("Error: can't generate a secret number with a length of %d " +
//                    "because there aren't enough unique digits.", lengthInput);
//            return null;
//        }
//        System.out.println("Okay, let's start a game!");
//        int lengthCount = 0;
//
//        for (int i = 0; lengthCount < lengthInput; i++) {
//
//            if (!contains(secretCode, pseudoNumbers.charAt(i))) {
//
//                secretCode.append(pseudoNumbers.charAt(i));
//                lengthCount++;
//            }
//
//            if (i == 0 && secretCode.charAt(0) == '0') {
//
//                secretCode.deleteCharAt(0);
//            }
//
//            if (i == pseudoNumbers.length() - 1 && lengthCount < lengthInput) {
//
//                makeSecretCode();
//            }
//        }
//
//        String[] secretCodeStrArr = secretCode.toString().split("");
//        int[] secretCodeIntArr = new int[secretCode.length()];
//
//        for (int i = 0; i < secretCode.length(); i++) {
//
//            secretCodeIntArr[i] = Integer.parseInt(secretCodeStrArr[i]);
//        }
//
//        return secretCodeIntArr;
//    }



//    protected static boolean contains(StringBuilder secretCode, char pseudoNumber) {
//
//        boolean isThere = false;
//        for (int i = 0; i < secretCode.length(); i++) {
//
//            if (secretCode.charAt(i) == pseudoNumber) {
//
//                isThere = true;
//                break;
//            }
//        }
//
//        return isThere;
//    }
}