import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char play;
        System.out.println("\nHey!! ヾ(＾∇＾) \nDo you want to play a rock - paper - scissors game? (Yes/No) .(^‿^).");
        play = input.nextLine().charAt(0);

        while ( play != 'Y' && play != 'y' ) {
            if ( play == 'N' || play == 'n' ) {
                System.out.println("Well (-_-). See you then. ヾ(･_･)");
                break;
            } else {     //Exception control
                System.out.println("You typed something wrong (╭ರ_⊙). Please type yes or no!");
                play = input.nextLine().charAt(0);
            }
        }

        int choice;
        int counter = 1;//Round counter
        while ( play == 'Y' || play == 'y' ) {

            System.out.println("\nGame time!!\t◕‿◕");
            System.out.println("Who gets 5 points wins the game. Let's go!! ◑.◑");

            int pointsComputer = 0;
            int pointsUser = 0;

            while ( pointsComputer < 5 && pointsUser < 5 ) {

                int computerChoice = (int) (Math.random() * 3);
                computerChoice++;    //Random number++: 1 is rock - 2 is paper - 3 is scissors
                choice = 0;
                boolean catchException = false;

                System.out.println("\n---- Round " +counter+ " ----");
                System.out.println("\nRock (1) -- Paper (2) -- Scissors (3)? (Type a number)");

                do {
                    if ( input.hasNextInt() ) {
                        choice = input.nextInt();
                        catchException = true;
                    } else {
                        input.nextLine();
                    }
                } while ( !catchException );

                if ( choice == computerChoice ) {
                    System.out.println("\n---- Round " +counter+ " ----" + "\n\nIt's a tie! (・・；)");

                } else if ( choice == 2 ) {
                    if ( computerChoice == 1 ) {
                        pointsUser++;
                        System.out.println("\n---- Round " +counter+" ----" + "\n\nYou chose paper, I chose rock. Paper covers rock. You Win!!"+"\nYour point(s): "
                                +pointsUser+ "  -  My point(s): " +pointsComputer );
                    } else if ( computerChoice == 3 ) {
                        pointsComputer++;
                        System.out.println("\n---- Round " +counter+ " ----" + "\n\nYou chose paper, I chose scissors. Scissors cuts paper. You Lose!!"+"\nYour point(s): "
                                +pointsUser+ "  -  My point(s): " +pointsComputer );
                    }
                } else if ( choice == 1 ) {
                    if ( computerChoice == 2 ) {
                        pointsComputer++;
                        System.out.println("\n---- Round " +counter+ " ----" + "\n\nYou chose rock, I chose paper. Paper covers rock. You Lose!!"+"\nYour point(s): "
                                +pointsUser+ "  -  My point(s): " +pointsComputer );
                    } else if ( computerChoice == 3 ) {
                        pointsUser++;
                        System.out.println("\n---- Round " +counter+ " ----" + "\n\nYou chose rock, I chose scissors. Rock crushes scissors. You Win!!"+"\nYour point(s): "
                                +pointsUser+ "  -  My point(s): " + pointsComputer );
                    }
                } else if ( choice == 3) {
                    if (computerChoice == 2) {
                        pointsUser++;
                        System.out.println("\n---- Round " +counter+ " ----" + "\n\nYou chose scissors, I chose paper. Scissors cuts paper. You Win!!"+"\nYour point(s): "
                                +pointsUser+ "  -  My point(s): " +pointsComputer );

                    } else if ( computerChoice == 1 ) {
                        pointsComputer++;
                        System.out.println("\n---- Round " +counter+ " ----" + "\n\nYou chose scissors, I chose rock. Rock crushes scissors. You Lose!!"+"\nYour point(s): "
                                +pointsUser+ "  -  My point(s): " +pointsComputer);
                    }
                } else {
                    System.out.println("You typed an invalid number. Please type a valid number!");
                    counter--;//Exception & Not played round
                }
                counter++;//Played round
                if( pointsUser == 4 && pointsComputer == 4)
                    System.out.println("\nLast round!!! ಠﭛಠ");
            }

            if ( pointsUser == 5 )
                System.out.println("\n\nGAME OVER!! \nYou won!! (ToT)");
            else if ( pointsComputer == 5 )
                System.out.println("\n\nGAME OVER!! \nI won!! (/^▽^)/\nBetter luck next time! (•‿•)");

            System.out.println("\nWanna play again? (ง •̀_•́)ง \n(Yes/No)");
            play = input.next().charAt(0);

            while ( play != 'Y' && play != 'y' ) {
                if ( play == 'N' || play == 'n' ) {
                    System.out.println("Well (-_-). See you next time! ヾ(･_･)");
                    break;
                } else {   //Exception control
                    System.out.println("You typed something wrong (╭ರ_⊙). Please type yes or no!");
                    play = input.next().charAt(0);
                }
            }
            counter = 1;//Round Reset
        }
    }
}