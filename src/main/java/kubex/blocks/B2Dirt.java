package kubex.blocks;

/**
 * This work is licensed under the Creative Commons Attribution 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 *
 * @author V�ctor Arellano Vicente (Ivelate)
 *
 * Dirt block. Most of the world terrain is composed by it.
 */
public class B2Dirt extends OpaqueSolidBlock{

	@Override
	public byte getUpTex() {
		return 2;
	}

	@Override
	public byte getLatTex() {
		return 2;
	}

	@Override
	public byte getDownTex() {
		return 2;
	}

	@Override
	public String getCubeName() {
		return "Dirt block";
	}
}
