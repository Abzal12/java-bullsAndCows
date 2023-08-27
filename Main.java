package bullscows;

public class Main {

    public static void main(String[] args) {

        SuperGame.startSuperGame();
    }
}

// stage 2/7
//    int[] secretCode = {9, 3, 0, 5};as
//    Scanner scanner = new Scanner(System.in);
//    String[] arr = scanner.nextLine().split("");
//    int[] userInput = new int[arr.length];
//
//        for (int i = 0; i < arr.length; i++) {
//
//        userInput[i] = Integer.parseInt(arr[i]);
//    }
//
//    int bulls = 0;
//    int cows = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//
//        if (userInput[i] == secretCode[i]) {
//            bulls++;
//        } else if (contains(secretCode, userInput[i])) {
//            cows++;
//        }
//    }
//
//        if (bulls == 0 && cows == 0) {
//
//        System.out.println("Grade: None. The secret code is 9305.");
//    } else {
//
//        System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is 9305.", bulls, cows);
//    }
//}
//
//    public static boolean contains(int[] array, int key) {
//
//        boolean isThere = false;
//        for (int arrayValue : array) {
//
//            if (key == arrayValue) {
//                isThere = true;
//                break;
//            }
//        }
//
//        return isThere;
//    }



// stage 1/7
//System.out.println("""
//                The secret code is prepared: ****.
//
//                Turn 1. Answer:
//                9205
//                Grade: 3 bulls.
//
//                Turn 2. Answer:
//                9305
//                Grade: 4 bulls.
//                Congrats! The secret code is 9305.""");