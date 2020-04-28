package gladiators;

public class Paladin extends Gladiator {
	/** Final individual strings */
	private final String individualTalkOne = "Blood is the wine of victory.";
	private final String individualTalkTwo = "One of us will finally die today!";
	private final String individualTalkThree = "Nothing will stop me!";
	private final String individualTalkFour = "When does the killing start?";

	public Paladin(String name, int attackPower, int blockPower) {
		super(name, attackPower, blockPower);
		sayHello(Paladin.class.getSimpleName(), this.getName(),
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
		int skillB = this.getAttackPower();
		if (this.getHealthPoint() <= 750) {
			skillB = this.getAttackPower() * 2;
			this.setBlockPower(getBlockPower() + 5);
		}

		return skillB;
	}

	/** @Override Method for skill E */
	@Override
	public int skillC() {
		int skillC = this.getAttackPower() + 10;
		this.setBlockPower(getBlockPower() * 2);
		return skillC;
	}

	/** @Override Method for skill R */
	@Override
	public int skillD() {
		int skillD = this.getAttackPower() * 2;
		if (this.getHealthPoint() <= 100 && this.getHealthPoint() > 50) {
			this.setBlockPower(500);
			this.setAttackPower(200);
			this.setHealthPoint(getHealthPoint() - 50);
		}
		return skillD;
	}

}
