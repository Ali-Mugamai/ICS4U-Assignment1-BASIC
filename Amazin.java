import java.util.Random;
import java.util.Scanner;

public class ACEYDU {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int totalMoney = 100;
		int betAmount, card1, card2, nextCard;
		String playAgain;

		System.out.println("ACEY-DUCEY IS PLAYED IN THE FOLLOWING MANNER:");
		System.out.println("THE DEALER (COMPUTER) DEALS TWO CARDS FACE UP.");
		System.out.println("YOU HAVE THE OPTION TO BET OR NOT TO BET DEPENDING");
		System.out.println("ON WHETHER OR NOT YOU FEEL THE NEXT CARD WILL HAVE");
		System.out.println("A VALUE BETWEEN THE FIRST TWO.");
		System.out.println("IF YOU DO NOT WANT TO BET, INPUT A 0.");
		System.out.println();

		while (true) {
			System.out.println("YOU NOW HAVE " + totalMoney + " DOLLARS.");
			System.out.println();
			System.out.println("HERE ARE YOUR NEXT TWO CARDS...");

			card1 = random.nextInt(13) + 2;
			card2 = random.nextInt(13) + 2;

			while (card1 >= card2) {
				card1 = random.nextInt(13) + 2;
				card2 = random.nextInt(13) + 2;
			}

			printCard(card1);
			printCard(card2);

			System.out.println();
			System.out.print("WHAT IS YOUR BET: ");
			betAmount = scanner.nextInt();

			if (betAmount == 0) {
				System.out.println("CHICKEN!!");
				System.out.println();
				continue;
			}

			if (betAmount > totalMoney) {
				System.out.println("SORRY, MY FRIEND, BUT YOU BET TOO MUCH");
				System.out.println("YOU HAVE ONLY " + totalMoney + " DOLLARS TO BET.");
				continue;
			}

			nextCard = random.nextInt(13) + 2;
			printCard(nextCard);

			if (nextCard > card1 && nextCard < card2) {
				System.out.println("YOU WIN!!!");
				totalMoney += betAmount;
			} else {
				System.out.println("SORRY, YOU LOSE.");
				totalMoney -= betAmount;
			}

			if (totalMoney <= 0) {
				System.out.println();
				System.out.println("SORRY, FRIEND, BUT YOU BLEW YOUR WAD.");
				System.out.print("TRY AGAIN (YES OR NO): ");
				playAgain = scanner.next();
				if (playAgain.equalsIgnoreCase("YES")) {
					totalMoney = 100;
				} else {
					System.out.println();
					System.out.println("O. K. HOPE YOU HAD FUN!!");
					break;
				}
			}
		}

		scanner.close();
	}

	private static void printCard(int card) {
		switch (card) {
			case 11:
				System.out.println("JACK");
				break;
			case 12:
				System.out.println("QUEEN");
				break;
			case 13:
				System.out.println("KING");
				break;
			case 14:
				System.out.println("ACE");
				break;
			default:
				System.out.println(card);
				break;
		}
	}
}