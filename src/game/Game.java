package game;

import java.util.ArrayList;
import java.util.Scanner;
import gladiators.Gladiator;
import gladiators.Mage;
import gladiators.Paladin;
import gladiators.Warrior;
import players.Player;

public class Game {
	private ArrayList<Gladiator> characters;

	// ** Constructor make Characters and Draw HeadLine */
	public Game() {
		// ** List for choose character */
		this.characters = new ArrayList<Gladiator>();

		System.out.println(
				"===================================================================================================");
		System.out.println("#                                           -[Character List]-");
		System.out.println("#");
		Paladin pala = new Paladin("Paladinosaur", 50, 10);
		System.out.println("#");
		Mage mage = new Mage("Magestro", 50, 10);
		System.out.println("#");
		Warrior wari = new Warrior("Warrithor", 50, 10);
		System.out.println("#");
		Paladin pala2 = new Paladin("Palazite", 50, 10);
		System.out.println("#");
		Mage mage2 = new Mage("Magenhoe", 50, 10);
		System.out.println("#");
		Warrior wari2 = new Warrior("Warrirraw", 50, 10);
		System.out.println("#");
		System.out.println("# SKILL[ q ]: Use like basic. ");
		System.out.println("# SKILL[ w ]: Use for more Atk dmg. ");
		System.out.println("# SKILL[ e ]: Use for plus your Def. ");
		System.out.println("# SKILL[ r ]: Use like Ultimate. ");
		System.out.println("#");
		System.out.println(
				"===================================================================================================");
		// ** Add Characters to List */
		this.characters.add(pala);
		this.characters.add(pala2);
		this.characters.add(wari);
		this.characters.add(wari2);
		this.characters.add(mage);
		this.characters.add(mage2);
		System.out.println();

	}

	// ** Method for newGame */
	public void playGame() {
		Scanner in = new Scanner(System.in);
		System.out.println("========== Welcome in Gladiator WaR ==========");
		System.out.println();

		// ** Make player and read&set player name */
		System.out.println("+++++++++++++++++++++");
		String playerOneName = userStringInput("+ First player name: ", in);
		System.out.println("+++++++++++++++++++++");
		String playerTwoName = userStringInput("+ Second player name: ", in);
		System.out.println("+++++++++++++++++++++");
		System.out.println();
		Player player1 = new Player(playerOneName);
		Player player2 = new Player(playerTwoName);
		// ** End of section */

		// ** Cycle for choose characters */
		while (this.characters.size() > 0) {
			boolean correctInput = false;
			getCharacterPickList();
			System.out.println();

			// ** Cycle for First player correct input */
			while (correctInput == false) {

				// ** Read integer input */
				System.out.println("++++++++++++++++++++++++++++++++++++");
				int pickedIndexP1 = userIntInput(
						("+ ") + (player1.getPlayerName()) + ("Select your character number: "), in);
				System.out.println("++++++++++++++++++++++++++++++++++++");
				System.out.println();
				// ** End of read section */

				// ** First player character pick after a condition check */
				if (pickedIndexP1 >= 0 && pickedIndexP1 < this.characters.size()) {
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					System.out.println(
							("@ ") + (player1.getPlayerName()) + (" picked ") + (this.characters.get(pickedIndexP1)));
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					System.out.println();
					player1.pickCharacter(this.characters.get(pickedIndexP1));
					this.characters.remove(pickedIndexP1);
					correctInput = true;

				}

				else {
					System.out.println("##################################");
					System.out.println("# Check your input and try again. #");
					System.out.println("###################################");
					System.out.println();
				}
			}
			// ** End of input cycle section */

			// ** Take switch off */
			correctInput = false;

			// ** List optional characters */
			getCharacterPickList();
			System.out.println();

			// ** Cycle for Second player correct input */
			while (correctInput == false) {
				// ** Read integer input */
				System.out.println("++++++++++++++++++++++++++++++++++++");
				int pickedIndexP2 = userIntInput(
						("+ ") + (player2.getPlayerName()) + (" Select your character number: "), in);
				System.out.println("++++++++++++++++++++++++++++++++++++");
				System.out.println();
				// ** End of read section */

				if (pickedIndexP2 >= 0 && pickedIndexP2 < this.characters.size()) {

					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					System.out.println(
							("@ ") + (player2.getPlayerName()) + (" picked ") + (this.characters.get(pickedIndexP2)));
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					System.out.println();

					player2.pickCharacter(this.characters.get(pickedIndexP2));
					this.characters.remove(pickedIndexP2);
					correctInput = true;

				} else {

					System.out.println("##################################");
					System.out.println("# Check your input and try again. #");
					System.out.println("###################################");
					System.out.println();
				}
			}
			// ** End of input cycle section */

		}
		// ** End of pick character cycle section */

		// ** Head or Tail section */
		boolean correctUserInput = false;
		String userTip = null;

		// ** Cycle for correct input */
		while (correctUserInput == false) {
			// ** Read string input */
			System.out.println("++++++++++++++++++++++++++++++++++++");
			String getUserTip = userStringInput(("+ ") + (player1.getPlayerName() + (" Type here tail or head")), in);
			System.out.println("++++++++++++++++++++++++++++++++++++");
			System.out.println();
			// ** End of read section */

			if (getUserTip.equals("tail") || getUserTip.equals("head")) {
				userTip = getUserTip;
				correctUserInput = true;

			} else {

				System.out.println("#########################################################################");
				System.out.println("# Incorrect input, you can choose just \"tail\" or \"head\", try again. #");
				System.out.println("#########################################################################");
				System.out.println();

			}

		}
		// ** End of correct input cycle */

		// ** Set head or tail winner as first player */
		Player beginner;
		Player second;
		if (checkTip(userTip)) {
			beginner = player1;
			second = player2;
		} else {
			beginner = player2;
			second = player1;
		}
		// ** End of section */

		// ** Fight cycle */
		int round = 1;
		while ((beginner.getMyFirstCharacter().getHealthPoint() > 0)
				&& (second.getMyFirstCharacter().getHealthPoint() > 0)) {
			

			// ** First player select attack */
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			String selectedAttack = userStringInput(("+ ") + (beginner.getPlayerName())
					+ (" Select your Skill: q , w, e , r , for ") + (beginner.getMyFirstCharacter().getName())
					+ (" HP:") + (beginner.getMyFirstCharacter().getHealthPoint()) + (" AP:")
					+ (beginner.getMyFirstCharacter().getAttackPower()) + (" DP:")
					+ (beginner.getMyFirstCharacter().getBlockPower()), in);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println(("+ ") + (beginner.getPlayerName()) + ("`s Attack: "));
			System.out.println();
			// ** End of select attack section */

			// ** First player attack with selected */
			if (selectedAttack.contentEquals("q")) {
				second.getMyFirstCharacter().attackedByAttackPower(beginner.getMyFirstCharacter().skillA());
			} else if (selectedAttack.contentEquals("w")) {
				second.getMyFirstCharacter().attackedByAttackPower(beginner.getMyFirstCharacter().skillB());
			} else if (selectedAttack.contentEquals("e")) {
				second.getMyFirstCharacter().attackedByAttackPower(beginner.getMyFirstCharacter().skillC());
			} else if (selectedAttack.contentEquals("r")) {
				second.getMyFirstCharacter().attackedByAttackPower(beginner.getMyFirstCharacter().skillD());
			} else {

				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("! Wrong input, default attack goes. !");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println();
				second.getMyFirstCharacter().attackedByAttackPower(beginner.getMyFirstCharacter().getAttackPower());
			}
			// ** End of attack section */

			// ** Check second player status and HasNextEnemy @ Program exit point 1 of 2 @
			// */
			if (second.getMyFirstCharacter().getHealthPoint() <= 0) {
				System.out.println("=======================================");
				System.out.println(("Sorry ") + (second.getPlayerName()) + (", ")
						+ (second.getMyFirstCharacter().getName()) + (" died."));
				System.out.println("=======================================");
				System.out.println();

				second.kickCharacter(second.getMyFirstCharacter());

				// beginner.getMyFirstCharacter().setHealthPoint(1000);

			}

			else {
				System.out.println("XXXXXXXXXXXXXX");
				System.out.println("X Next Payer X");
				System.out.println("XXXXXXXXXXXXXX");
				System.out.println();
			}

			if (second.getMyCharacters().isEmpty()) {
				System.out.println("##############################");
				System.out.println(("# ") + (second.getPlayerName()) + (" is out of characters."));
				System.out.println("##############################");
				System.out.println();

				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println(("$ The winner is: ") + (beginner.getPlayerName()) + (" with ")
						+ (beginner.getMyFirstCharacter().getName()) + (" HP:")
						+ (beginner.getMyFirstCharacter().getHealthPoint()));
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.exit(1);
			}
			// ** End of check section */

			// ** Second player select attack */
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			String selectedAttackP2 = userStringInput(("+ ") + (second.getPlayerName())
					+ (" Select your Skill: q , w, e , r, for ") + (second.getMyFirstCharacter().getName()) + (" HP:")
					+ (second.getMyFirstCharacter().getHealthPoint()) + (" AP:")
					+ (second.getMyFirstCharacter().getAttackPower()) + (" DP:")
					+ (second.getMyFirstCharacter().getBlockPower()), in);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println(("+ ") + (second.getPlayerName()) + ("`s Attack: "));
			System.out.println();
			// ** End of select section */

			// ** Second player attack with selected */
			if (selectedAttackP2.contentEquals("q")) {
				beginner.getMyFirstCharacter().attackedByAttackPower(second.getMyFirstCharacter().skillA());
			} else if (selectedAttackP2.contentEquals("w")) {
				beginner.getMyFirstCharacter().attackedByAttackPower(second.getMyFirstCharacter().skillB());
			} else if (selectedAttackP2.contentEquals("e")) {
				beginner.getMyFirstCharacter().attackedByAttackPower(second.getMyFirstCharacter().skillC());
			} else if (selectedAttackP2.contentEquals("r")) {
				beginner.getMyFirstCharacter().attackedByAttackPower(second.getMyFirstCharacter().skillD());
			} else {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("! Wrong input, default attack goes. !");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println();

				beginner.getMyFirstCharacter().attackedByAttackPower(second.getMyFirstCharacter().getAttackPower());
			}
			// ** End of attack section */

			// ** Check second player status and HasNextEnemy @ Program exit point 2 of 2 @
			// */
			if (beginner.getMyFirstCharacter().getHealthPoint() <= 0) {

				System.out.println("=======================================");
				System.out.println(("Sorry ") + (beginner.getPlayerName()) + (", ")
						+ (beginner.getMyFirstCharacter().getName()) + (" died."));
				System.out.println("=======================================");
				System.out.println();

				beginner.kickCharacter(beginner.getMyFirstCharacter());

				// second.getMyFirstCharacter().setHealthPoint(1000);

			}
			
			else {
				round++;
				System.out.println("XXXXXXXXXXXXXX");
				System.out.println(("X  Round ")+(round)+("   X"));
				System.out.println("XXXXXXXXXXXXXX");
				System.out.println();

			}

			if (beginner.getMyCharacters().isEmpty()) {
				System.out.println("##############################");
				System.out.println("Out of character.");
				System.out.println("##############################");
				System.out.println();

				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println(("$ The winner is: ") + (second.getPlayerName()) + (" with ")
						+ (second.getMyFirstCharacter().getName()) + (" HP:")
						+ (second.getMyFirstCharacter().getHealthPoint()));
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.exit(1);
			}
			// ** End of check section */

		}
		// ** End of fight section !@! Unattainable !@! 2 program exit in check section
		// !@! */

		in.close();

	}

	// ** Method for read integer input */
	public int userIntInput(String text, Scanner inputReader) {
		System.out.println(text);
		return inputReader.nextInt();
	}

	// ** Method for read string input */
	public String userStringInput(String text, Scanner inputReader) {
		System.out.println(text);
		return inputReader.next();
	}

	// ** Method for list optional character */
	public void getCharacterPickList() {
		for (int i = 0; i < this.characters.size(); i++) {
			System.out.println((i) + (" ") + (this.characters.get(i)));
		}
	}

	// ** Method for Head & Tail and Check */
	public boolean checkTip(String tip) {
		boolean head = false;
		boolean retVal = false;
		double random = Math.random();
		if (random < 0.5) {
			head = true;
			System.out.println("************");
			System.out.println("****Head****");
			System.out.println("************");
			System.out.println();
		} else {
			System.out.println("************");
			System.out.println("****Tail****");
			System.out.println("************");
			System.out.println();
		}
		if (head == true && tip.equals("head")) {

			System.out.println("$$$$$$$$$$$$");
			System.out.println("$ You win! $");
			System.out.println("$$$$$$$$$$$$");
			System.out.println();
			retVal = true;
		}

		else if (head == false && tip.equals("tail")) {

			System.out.println("$$$$$$$$$$$$");
			System.out.println("$ You win! $");
			System.out.println("$$$$$$$$$$$$");
			System.out.println();
			retVal = true;
		}

		else {
			System.out.println("%%%%%%%%%%%%%");
			System.out.println("% You lose. %");
			System.out.println("%%%%%%%%%%%%%");
			System.out.println();
		}

		return retVal;
	}

}
