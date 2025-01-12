package kubex.shaders;

import kubex.KubexGame;

/**
 * This work is licensed under the Creative Commons Attribution 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 * 
 * @author V�ctor Arellano Vicente (Ivelate)
 * 
 * Second pass deferred under water shader with shadows disabled
 */
public class DeferredUnderwaterUnshadowTerrainShaderProgram extends DeferredShaderProgram{

	public DeferredUnderwaterUnshadowTerrainShaderProgram(boolean verbose)
	{
		super("/shaders/finalDrawShader.vshader", "/shaders/finalDrawShaderUnderwaterUnshadow.fshader",true);
	}
	@Override
	protected void setupCustomAttributes() {
		
	}
	@Override
	public boolean supportShadows() {
		return false;
	}
	@Override
	public int colorTexLocation() {
		return KubexGame.BASEFBO_COLOR_TEXTURE_LOCATION;
	}
	@Override
	public int miscTexLocation() {
		return -1;
	}
	@Override
	public boolean supportSkyParameters() {
		return true;
	}
	@Override
	public boolean supportWorldPosition() {
		return false;
	}
	@Override
	public int miscTex2Location() {
		return -1;
	}
	@Override
	public boolean supportPlayerLighting() 
	{
		return true;
	}

}
