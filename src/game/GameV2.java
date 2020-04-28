package game;

import java.util.ArrayList;
import java.util.Scanner;

import gladiators.Gladiator;
import gladiators.Mage;
import gladiators.Paladin;
import gladiators.Warrior;
import players.Player;

public class GameV2 {

	private ArrayList<Gladiator> characters;

	// ** Constructor make Characters and Draw HeadLine */
	public GameV2() {
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

		getCharacterPickList();
		System.out.println();
		// ** End of section */

		while (this.characters.size() > 0) {

			pickCharacter(player1, in);
			pickCharacter(player2, in);

		}
		// ** Play head or tail for first turn */
		Player beginner;
		Player second;
		if (checkTip(headOrTailForFirst(player1, in))) {
			beginner = player1;
			second = player2;
		} else {
			beginner = player2;
			second = player1;
		}
		// ** End of section */

		while (true) {
			attack(beginner, second, in);
			attack(second, beginner, in);
		}

	}

	public void attack(Player attacker, Player defender, Scanner in) {

		// ** First player select attack */
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		String selectedAttack = userStringInput(("+ ") + (attacker.getPlayerName())
				+ (" Select your Skill: q , w, e , r , for ") + (attacker.getMyFirstCharacter().getName()) + (" HP:")
				+ (attacker.getMyFirstCharacter().getHealthPoint()) + (" AP:")
				+ (attacker.getMyFirstCharacter().getAttackPower()) + (" DP:")
				+ (attacker.getMyFirstCharacter().getBlockPower()), in);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		System.out.println(("+ ") + (attacker.getPlayerName()) + ("`s Attack: "));
		System.out.println();
		// ** End of select attack section */

		// ** First player attack with selected */
		if (selectedAttack.contentEquals("q")) {
			defender.getMyFirstCharacter().attackedByAttackPower(attacker.getMyFirstCharacter().skillA());
		} else if (selectedAttack.contentEquals("w")) {
			defender.getMyFirstCharacter().attackedByAttackPower(attacker.getMyFirstCharacter().skillB());
		} else if (selectedAttack.contentEquals("e")) {
			defender.getMyFirstCharacter().attackedByAttackPower(attacker.getMyFirstCharacter().skillC());
		} else if (selectedAttack.contentEquals("r")) {
			defender.getMyFirstCharacter().attackedByAttackPower(attacker.getMyFirstCharacter().skillD());
		} else {

			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("! Wrong input, default attack goes. !");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println();
			defender.getMyFirstCharacter().attackedByAttackPower(attacker.getMyFirstCharacter().getAttackPower());
		}
		// ** End of attack section */

		// ** Check second player status and HasNextEnemy @ Program exit point 1 of 2 @
		// */
		if (defender.getMyFirstCharacter().getHealthPoint() <= 0) {
			System.out.println("=======================================");
			System.out.println(("Sorry ") + (defender.getPlayerName()) + (", ")
					+ (defender.getMyFirstCharacter().getName()) + (" died."));
			System.out.println("=======================================");
			System.out.println();

			defender.kickCharacter(defender.getMyFirstCharacter());

			// beginner.getMyFirstCharacter().setHealthPoint(1000);

		}

		else {
			System.out.println("XXXXXXXXXXXXXX");
			System.out.println("X Next Payer X");
			System.out.println("XXXXXXXXXXXXXX");
			System.out.println();
		}

		if (defender.getMyCharacters().isEmpty()) {
			System.out.println("##############################");
			System.out.println(("# ") + (defender.getPlayerName()) + (" is out of characters."));
			System.out.println("##############################");
			System.out.println();

			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println(("$ The winner is: ") + (attacker.getPlayerName()) + (" with ")
					+ (attacker.getMyFirstCharacter().getName()) + (" HP:")
					+ (attacker.getMyFirstCharacter().getHealthPoint()));
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.exit(1);
		}
		// ** End of check section */

	}

	public void pickCharacter(Player player, Scanner in) {
		boolean correctInput = false;

		// ** Cycle for First player correct input */
		while (correctInput == false) {

			// ** Read integer input */
			System.out.println("++++++++++++++++++++++++++++++++++++");
			int pickedIndexP1 = userIntInput(("+ ") + (player.getPlayerName()) + (" Select your character number: "),
					in);
			System.out.println("++++++++++++++++++++++++++++++++++++");
			System.out.println();
			// ** End of read section */

			// ** First player character pick after a condition check */
			if (pickedIndexP1 >= 0 && pickedIndexP1 < this.characters.size()) {
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				System.out.println(
						("@ ") + (player.getPlayerName()) + (" picked ") + (this.characters.get(pickedIndexP1)));
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				System.out.println();
				player.pickCharacter(this.characters.get(pickedIndexP1));
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

		getCharacterPickList();
		System.out.println();
	}

	public String headOrTailForFirst(Player player, Scanner in) {
		boolean correctUserInput = false;
		String userTip = null;

		// ** Cycle for correct input */
		while (correctUserInput == false) {
			// ** Read string input */
			System.out.println("++++++++++++++++++++++++++++++++++++");
			String getUserTip = userStringInput(("+ ") + (player.getPlayerName() + (" Type here tail or head")), in);
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
		return userTip;
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
