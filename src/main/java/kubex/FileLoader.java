package kubex;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.newdawn.slick.util.ResourceLoader;

/**
 * This work is licensed under the Creative Commons Attribution 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 *
 * @author V�ctor Arellano Vicente (Ivelate)
 *
 * Contains methods to load the game resources from disk
 */
public class FileLoader
{
	private static int IMAGE_NUMBER=23;
	private static String TILES_ROUTE="images/tiles/";
	private static String MISC_ROUTE="images/";

	/**
	 * Returns in an URL[] all game cube textures
	 */
	public static URL[] loadTileImages()
	{
		URL[] tileImages=new URL[IMAGE_NUMBER];

		try {
			tileImages[0]=new File(TILES_ROUTE+"000_hierba_lateral.png").toURI().toURL();
			tileImages[1]=new File(TILES_ROUTE+"001_hierba.png").toURI().toURL();
			tileImages[2]=new File(TILES_ROUTE+"002_tierra.png").toURI().toURL();
			tileImages[3]=new File(TILES_ROUTE+"003_piedra.png").toURI().toURL();
			tileImages[4]=new File(TILES_ROUTE+"004_lava.png").toURI().toURL();
			tileImages[5]=new File(TILES_ROUTE+"005_lava_lateral.png").toURI().toURL();
			tileImages[6]=new File(TILES_ROUTE+"006_madera.png").toURI().toURL();
			tileImages[7]=new File(TILES_ROUTE+"007_adoquin.png").toURI().toURL();
			tileImages[8]=new File(TILES_ROUTE+"008_planta.png").toURI().toURL();
			tileImages[9]=new File(TILES_ROUTE+"009_transparent.png").toURI().toURL();
			tileImages[10]=new File(TILES_ROUTE+"010_brick.png").toURI().toURL();
			tileImages[11]=new File(TILES_ROUTE+"011_sand.png").toURI().toURL();
			tileImages[12]=new File(TILES_ROUTE+"012_glass.png").toURI().toURL();
			tileImages[13]=new File(TILES_ROUTE+"013_lightblock.png").toURI().toURL();
			tileImages[14]=new File(TILES_ROUTE+"014_snow.png").toURI().toURL();
			tileImages[15]=new File(TILES_ROUTE+"015_clearbrick.png").toURI().toURL();
			tileImages[16]=new File(TILES_ROUTE+"016_flower_dandelion.png").toURI().toURL();
			tileImages[17]=new File(TILES_ROUTE+"017_stone_rusty.png").toURI().toURL();
			tileImages[18]=new File(TILES_ROUTE+"018_wood.png").toURI().toURL();
			tileImages[19]=new File(TILES_ROUTE+"019_leaves.png").toURI().toURL();
			tileImages[20]=new File(TILES_ROUTE+"020_wood_top.png").toURI().toURL();
			tileImages[21]=new File(TILES_ROUTE+"021_tnt.png").toURI().toURL();
			tileImages[22]=new File(TILES_ROUTE+"022_bedrock.png").toURI().toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

		return tileImages;
	}

	/**
	 * Returns the URL of the water normal texture
	 */
	public static URL loadWaterNormalImage()
	{
		try {
			return new File(MISC_ROUTE+"water_normal.png").toURI().toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}
