import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Select a secret word
        String secretWord = selectSecretWord();
        int wordLength = secretWord.length();

        System.out.println("To go through the door guess the " + wordLength + "-letter word to move on to the next door.");
        System.out.println("You have 6 attempts to get the right answer.\nIn the feedback line a dash means the letter is not in the word, a + means the letter is in the word but in the wrong position, and if your guess is correct in the right position it will be shown.");

        int attempts = 0;
        boolean isGuessed = false;

        while (attempts < 6 && !isGuessed) {
            System.out.print("Enter Attempt #" + (attempts + 1) + ": ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.equals(secretWord)) {
                System.out.println("Congratulations! You guessed the word \"" + secretWord + "\".");
                isGuessed = true;
            } else if(!guess.matches(".*[a-z].*")) { 
                System.out.println("Make sure your guess only includes letters.\n");
            } else if(guess.length() != 5) {
                System.out.println("Make sure your guess is 5 letters long.\n");
            }else {
                String feedback = generateFeedback(secretWord, guess);
                System.out.println("Feedback: " + feedback + "\n");
                attempts++;
            }
        }

        if (!isGuessed) {
            System.out.println("Sorry, you've run out of attempts. The word was \"" + secretWord + "\".");
        }

        scanner.close();
    }

    // Method to select a secret word
    public static String selectSecretWord() {
        String[] words = {
            "apple", "grape", "peach", "lemon", "mango", "bread", "pizza", "chips", "salsa", 
            "fries", "toast", "salad", "pasta", "sauce", "curry", "steak", "roast", "bacon", 
            "hammy", "trout", "melon", "onion", "sushi", "sugar", "syrup", "bunty", "cream", 
            "cider", "juice", "water", "winey", "table", "chair", "paper", "brush", "smile", 
            "happy", "laugh", "teeth", "beach", "tiger", "cheer", "jelly", "dance", "sunny", 
            "cloud", "candy", "frost", "shoes", "boots", "glove", "watch", "clock", "heart", 
            "knife", "plate", "spoon", "forks", "glass", "dress", "skirt", "pants", "short", 
            "shirt", "gowns", "towel", "sleep", "dream", "night", "light", "black", "white", 
            "green", "bluey", "redye", "beige", "brown", "beamy", "soury", "crush", "tasty", 
            "spicy", "sweet", "salty", "crisp", "fresh", "fizzy", "funky", "chill", "breez", 
            "beers", "drunk", "party", "disco", "music", "funky", "swing", "jazzy", "poppy", 
            "heavy", "metal", "rocky", "softy", "class", "honey", "cigar", "bills", "money", 
            "coins", "bonds", "check", "cards", "bliss", "money", "brisk", "vigor", "puppy", 
            "kitty", "horse", "bunny", "panda", "zebra", "whale", "shark", "crane", "doves", 
            "ducks", "geese", "swans", "finch", "robin", "perch", "salmo", "cobia", "coddy", 
            "hakee", "trout", "bream", "shads", "snaps", "coral", "shale", "stone", "pebby", 
            "marble", "brick", "slate", "basal", "clayl", "quartz", "sandy", "terra"};

        Random rand = new Random();
        return words[rand.nextInt(words.length)];
    }

    // Method to generate feedback for the guess
    public static String generateFeedback(String secretWord, String guess) {
        StringBuilder feedback = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            char secretChar = secretWord.charAt(i);
            char guessChar = guess.charAt(i);
            if (secretChar == guessChar) {
                feedback.append(secretChar);
            } else if (secretWord.indexOf(guessChar) != -1) {
                feedback.append("+");
            } else {
                feedback.append("-");
            }
        }
        return feedback.toString();
    }
}
