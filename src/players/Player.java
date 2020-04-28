package players;

import java.util.ArrayList;

import gladiators.Gladiator;

public class Player {
	private String name;
	private ArrayList<Gladiator> myChracters = null;

	public Player(String name) {
		this.name = name;
		this.myChracters = new ArrayList<Gladiator>();
	}
	/** Method for add character to list */
	public void pickCharacter(Gladiator caracter) {
		this.myChracters.add(caracter);
	}
	/** Kick character from list @isDead@ */
	public void kickCharacter(Gladiator character) {
		this.myChracters.remove(character);
	}
	/** Method for return an alive next character */
	public Gladiator getMyFirstCharacter() {
		return myChracters.get(0);
	}

	public ArrayList<Gladiator> getMyCharacters() {
		return this.myChracters;
	}

	public String getPlayerName() {
		return this.name;
	}

}
