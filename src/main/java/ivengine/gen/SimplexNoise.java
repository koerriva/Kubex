package ivengine.gen;
import java.util.Random;

/**
 * This work is licensed under the Creative Commons Attribution 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 *
 * @author V�ctor Arellano Vicente (Ivelate)
 *
 * Simplex noise implementation. Uses as many octaves as desired and haves helper methods to get 2D or 3D noise
 */
public class SimplexNoise {

    SimplexNoise_octave[] octaves;
    double[] frequencys;
    double[] amplitudes;

    int largestFeature;
    double persistence;
    int seed;
    double zoom;

    public SimplexNoise(int numberOfOctaves,double persistence, int seed,int zoom){
        this.persistence=persistence;
        this.seed=seed;
        this.zoom=zoom;

        octaves=new SimplexNoise_octave[numberOfOctaves];
        frequencys=new double[numberOfOctaves];
        amplitudes=new double[numberOfOctaves];

        Random rnd=new Random(seed);

        for(int i=0;i<numberOfOctaves;i++){
            octaves[i]=new SimplexNoise_octave(rnd.nextInt());

            frequencys[i] = Math.pow(2,i);
            amplitudes[i] = Math.pow(persistence,numberOfOctaves-i);
        }

    }


    public double getNoise(int x, int y){

        double result=0;

        for(int i=0;i<octaves.length;i++){

            result=result+octaves[i].noise((x/zoom)/frequencys[i], (y/zoom)/frequencys[i])* amplitudes[i];
        }

        return result;

    }
    public double getNormalizedNoise(int x,int y)
    {
        return (this.getNoise(x, y)+1)/2;
    }

    public double getNoise(int x,int y, int z){

        double result=0;

        for(int i=0;i<octaves.length;i++){
            double frequency = Math.pow(2,i);
            double amplitude = Math.pow(persistence,octaves.length-i);

            result=result+octaves[i].noise((x/zoom)/frequency, (y/zoom)/frequency,(z/zoom)/frequency)* amplitude;
        }


        return result;

    }
}
