import java.util.*;
public class NumberGame{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("************Welcome to Number Game*************");

        System.out.println("Select Difficulty Level: ");
        System.out.println("1) Press 1 for Easy (7 attempts will be given)");
        System.out.println("2) Press 2 for Medium (5 attempts will be given)");
        System.out.println("3) Press 3 for Hard (2 attempts will be given)");

        int difficulty = sc.nextInt();

        if(difficulty < 1 || difficulty > 3){
            System.out.println("Enter a valid difficulty level");
            sc.close();
            return;
        }

        System.out.println("Enter how many rounds you want to play: ");
        int rounds = sc.nextInt();

        Random rand = new Random();

        int score = 0;
        if(difficulty == 1){
            score = game(sc, rand, rounds, 7);
        }
        else if(difficulty == 2){
            score = game(sc, rand, rounds, 5);
        }
        else if(difficulty == 3){
            score = game(sc, rand, rounds, 2);
        }

        System.out.println("****************GAME OVER!******************");
        System.out.println("Great Play!!!");
        System.out.println("Your Over All Score: " + score + " out of " + (rounds * 100) + ".");

        sc.close();
    }

    private static int game(Scanner sc, Random rand, int rounds, int attempts){
        int score = 0;
        for(int i=0; i<rounds; i++){
            System.out.println("*********************** Round " + (i + 1)+ " ************************");
            System.out.println("                                       Current Score: " + score);
            System.out.println();

            System.out.println("Enter a minimum boundary you want: ");
            int min = sc.nextInt();
            System.out.println();
            System.out.println("Enter a maximum boundary you want: ");
            int max = sc.nextInt();

            int num = rand.nextInt(max - min + 1) + min;
            System.out.println("---------------------------------------------------");
            for(int j=0; j<attempts; j++){
                System.out.println("Attempts left: " + (attempts - (j+1)));
                System.out.println("Guess a number within the specified range (" + min + " - " + max + ") :-");

                int guessed = sc.nextInt();

                if(guessed == num){
                    System.out.println("Awesome!!! Your Guess is Correct!!!");
                    score += (100 - (j * 10));
                    System.out.println("Your current Score: " + score);
                    break;
                }
                else if(guessed < num){
                    System.out.println("Too Low!");
                    if(j == attempts-1){
                        System.out.println();
                        System.out.println("Oh no! Round Over!!");
                        System.out.println("Expected Number is: " + num);
                        System.out.println("Your current Score: " + score);
                    }
                }
                else{
                    System.out.println("Too High!");
                    if(j == attempts-1){
                        System.out.println();
                        System.out.println("Oh no! Round Over!!");
                        System.out.println("Expected Number is: " + num);
                        System.out.println("Your current Score: " + score);
                    }
                }
                System.out.println();
            }
        }
        return score;
    }
}