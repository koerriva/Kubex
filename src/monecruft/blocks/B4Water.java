package monecruft.blocks;

public class B4Water extends LiquidBlock{

	public B4Water(int level) {
		super(level,8);
	}

	@Override
	public byte getUpTex() {
		return 4;
	}

	@Override
	public byte getLatTex() {
		return 4;
	}

	@Override
	public byte getDownTex() {
		return 4;
	}

	@Override
	public String getCubeName() {
		return "Water block (Level "+this.heightLiquidLevel+")";
	}
}
