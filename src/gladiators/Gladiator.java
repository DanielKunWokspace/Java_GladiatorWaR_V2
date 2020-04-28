package gladiators;

public abstract class Gladiator {

	/** ATTRIBUTES */
	private String name;

	/** 0 - 100 */
	private int healthPoint = 1000;

	private int attackPower;

	private int blockPower;

	/** CONSTRUCTOR */
	public Gladiator(String name, int attackPower, int blockPower) {
		this.name = name;
		this.attackPower = attackPower;
		this.blockPower = blockPower;
	}

	/** SETTERS & GETTERS */
	public String getName() {
		return name;
	}

	public int getHealthPoint() {
		return this.healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public void setBlockPower(int blockPower) {
		this.blockPower = blockPower;
	}

	public int getBlockPower() {
		return blockPower;
	}

	/** Abstract methods */
	public abstract int skillA();

	public abstract int skillB();

	public abstract int skillC();

	public abstract int skillD();

	/** Method for character to have a 25% chance of saying otherwise. */
	public String individualTalk(String optionA, String optionB, String optionC, String optionD) {
		String retString = null;
		double random = Math.random();

		if (random < 0.25) {
			retString = optionA;
		} else if (random > 0.25 && random < 0.5) {
			retString = optionB;
		}
		if (random > 0.5 && random < 0.75) {
			retString = optionC;
		}
		if (random > 0.75) {
			retString = optionD;
		}

		return retString;
	}

	/** Method for print character greets. */
	public void sayHello(String character, String characterName, String individualMessage) {
		System.out.println(("# Hello im a ") + (character) + (". My name is ") + (characterName) + (". \"")
				+ (individualMessage) + ("\""));
	}

	/** TOSTRING */
	@Override
	public String toString() {
		return "Character: " + name + ", hP=" + healthPoint + ", atkP=" + attackPower + ", def=" + blockPower + " ";
	}

	/** METHODS */
	public void attackedByAttackPower(int enemyAttackPower) {

		int blockPower = this.blockPower;

		if (enemyAttackPower > blockPower) {
			System.out.println(("AtkP: ") + (enemyAttackPower));
			System.out.println(("Enemy def: ") + (blockPower));
			System.out.println(("Enemy hp: ") + (this.healthPoint));
			int newVitalityPoint = this.getHealthPoint() - (enemyAttackPower - blockPower);
			System.out.println(("Gived damage: ") + (enemyAttackPower - blockPower));
			System.out.println(("Enemy new HP: ") + (newVitalityPoint));
			System.out.println();
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println();
			/** Save */
			this.setHealthPoint(newVitalityPoint);
		} else {
			System.out.println();
			System.out.println("Attack blocked");
			System.out.println();

			this.setBlockPower(blockPower - enemyAttackPower);
		}
	}
}
