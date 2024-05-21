package codeSoftIntershipTasks;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame
{
    public static int MIN_RANGE = 1;
    public static int MAX_RANGE = 100;
    public static int MAX_ATTEMPTS = 10;
    public static int MAX_ROUNDS = 3;

    public static void main(String[] args) 
    {
    	int totScore = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
       

        System.out.println("THE NUMBER MYSTERY CHALLENGE");
        System.out.println("NUMBER OF ROUNDS : 3");
        System.out.println("ATTEMPTS TO GUESS NUMBER IN EACH ROUND : 10\n");
        System.out.println("------------------------------------------------------------");
        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attempts = 0;

            System.out.printf("ROUND %d: GUESS THE NUMBER BETWEEN %d AND %d IN %d ATTEMPTS.\n", i, MIN_RANGE, MAX_RANGE,
                    MAX_ATTEMPTS);
            while (attempts < MAX_ATTEMPTS) {
                System.out.println("ENTER YOUR GUESS NUMBER: ");
                int guess_number = scanner.nextInt();
                attempts = attempts + 1;

                if (guess_number == number) {
                    int score = MAX_ATTEMPTS - attempts;
                    totScore = totScore + score;
                    System.out.printf("CONGRATS NUMBER GUESSED SUCCESSFULLY. ATTEMPTS : %d. Round Score : %d\n",
                            attempts, score);
                    break;
                }

                else if (guess_number < number) {
                    System.out.printf("THE NUMBER IS GREATER THAN %d. ATTEMPTS LEFT = %d.\n", guess_number,
                            MAX_ATTEMPTS - attempts);
                }

                else if (guess_number > number) {
                    System.out.printf("THE NUMBER IS LESS THAN %d. ATTEMPTS LEFT = %d.\n", guess_number,
                            MAX_ATTEMPTS - attempts);
                }

            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.printf("\nROUND = %d\n", i);
                System.out.println("ATTEMPTS = 0");
                System.out.printf("THE RANDOM NUMBER IS : %d\n\n", number);
            }
        }
        System.out.printf("GAME OVER. TOTAL SCORE = %d\n", totScore);
        scanner.close();
    }
}