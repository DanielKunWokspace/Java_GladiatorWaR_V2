package gladiators;

public class Mage extends Gladiator {
	/** Final individual strings */
	private final String individualTalkOne = "You need to use magic to get the power of the gods...";
	private final String individualTalkTwo = "The magic, it calls to me!";
	private final String individualTalkThree = "You deny the darkness in your soul! You deny your power!";
	private final String individualTalkFour = "I smell death.";

	public Mage(String name, int attackPower, int blockPower) {
		super(name, attackPower, blockPower);
		sayHello(Mage.class.getSimpleName(), this.getName(),
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
			skillB = this.getAttackPower() * 4;
			this.setBlockPower(this.getBlockPower() - 5);
		}

		return skillB;
	}

	/** @Override Method for skill E */
	@Override
	public int skillC() {
		int skillC = this.getAttackPower();
		if (this.getHealthPoint() <= 750) {
			this.setBlockPower(getBlockPower() * 4);
			skillC = skillC + 50;
		}
		return skillC;
	}

	/** @Override Method for skill R */
	@Override
	public int skillD() {
		int skillD = this.getAttackPower();
		if (this.getHealthPoint() <= 100 && this.getHealthPoint() > 50) {
			this.setAttackPower(200);
			this.setHealthPoint(getHealthPoint() + 200);

		}
		return skillD;
	}

}
