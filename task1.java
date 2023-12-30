import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ":");

            while (attempts < attemptsLimit) {
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts < attemptsLimit) {
                    System.out.println("Attempts left: " + (attemptsLimit - attempts));
                } else {
                    System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + targetNumber);
                }
            }

            System.out.println("Your current score: " + totalAttempts + " attempts");

            System.out.println("Do you want to play again? (yes/no):");
            String playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("yes")) {
                rounds++;
            } else {
                System.out.println("Thanks for playing! Your total score: " + totalAttempts + " attempts in " + (rounds + 1) + " rounds.");
                break;
            }

        } while (true);

        scanner.close();
    }
    
}