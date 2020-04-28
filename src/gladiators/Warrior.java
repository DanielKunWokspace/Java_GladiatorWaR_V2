package gladiators;

public class Warrior extends Gladiator {
	/** Final individual strings */
	private final String individualTalkOne = "We fight for those who cannot.";
	private final String individualTalkTwo = "Fear not, I'm coming.";
	private final String individualTalkThree = "Never forget why we fight!";
	private final String individualTalkFour = "We are the vanguard.";

	public Warrior(String name, int attackPower, int blockPower) {
		super(name, attackPower, blockPower);
		sayHello(Warrior.class.getSimpleName(), this.getName(),
				individualTalk(individualTalkFour, individualTalkThree, individualTalkTwo, individualTalkOne));

	}

	/** @Override Method for skill Q */
	@Override
	public int skillA() {
		int skillA = this.getAttackPower();
		return skillA;
	}

	/** @Override Method for skill W */
	@Override
	public int skillB() {
		int skillB = this.getAttackPower() * 2;
		if (this.getHealthPoint() <= 500) {
			skillB = this.getAttackPower() * 6;
			this.setBlockPower(getBlockPower() - 20);
		}
		
		this.setBlockPower(getBlockPower() - 10);
		return skillB;
	}

	/** @Override Method for skill E */
	@Override
	public int skillC() {
		int skillC = this.getAttackPower();
		if (this.getHealthPoint() <= 750) {
			this.setBlockPower(getBlockPower() + 50);
		}
		return skillC;
	}

	/** @Override Method for skill R */
	@Override
	public int skillD() {
		int skillD = this.getAttackPower() * 3;
		if (this.getHealthPoint() <= 100 && this.getHealthPoint() > 50) {
			this.setAttackPower(500);
			this.setHealthPoint(getHealthPoint() - 50);
		}
		return skillD;
	}

}
