package PaD;
import java.awt.Color;

/** 
 * La classe {@code PolygonePlein} représente un polygône plein dessinable
 * sur la planche à dessin. La surface polygône est tracé selon la
 * couleur spécifiée dans le constructeur (ou celle par défaut).  Le
 * polygône peut être aussi déplacé et effacé
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  7-Nov-2018 11:13
 */
public class PolygonePlein extends Polygone {
    /**
     * Rôle : crée un polygone plein à partir des points dont les
     * abscisses et les ordonnées sont données, respectivement, par
     * les tableaux <em>x</em> et <em>y</em>.  Le polygône plein
     * est de couleur <em>c</em> et d'épaisseur de trait <em>ep</em>
     *
     * @param  x les abscisses des points du polygône plein
     * @param  y les ordonnées des points du polygône plein
     * @param  c couleur du contour du rectangle plein
     * @param  ep épaisseur du trait du rectangle plein
     */
    public PolygonePlein(double[] x, double[] y, Color c, int ep) {
	super(x, y, c, ep);
    }

    /**
     * Rôle : crée un polygone plein à partir des points dont les
     * abscisses et les ordonnées sont données, respectivement, par
     * les tableaux <em>x</em> et <em>y</em>.  Le polygône plein
     * est de couleur et d'épaisseur de trait par défaut
     *
     * @param  x les abscisses des points du polygône plein
     * @param  y les ordonnées des points du polygône plein
     */
    public PolygonePlein(double[] x, double[] y) {
	super(x, y);
    }

    /**
     * Rôle : crée un polygone plein à partir des points dont les
     * abscisses et les ordonnées sont données, respectivement, par
     * les tableaux <em>x</em> et <em>y</em>.  Le polygône plein
     * est de couleur <em>c</em> et d'épaisseur de trait par défaut
     *
     * @param  x les abscisses des points du polygône plein
     * @param  y les ordonnées des points du polygône plein
     * @param  c couleur du contour du rectangle plein
     */
    public PolygonePlein(double[] x, double[] y, Color c) {
	super(x, y, c);
    }

    /**
     * Rôle : crée un polygone plein à partir des points dont les
     * abscisses et les ordonnées sont données, respectivement, par
     * les tableaux <em>x</em> et <em>y</em>.  Le polygône plein
     * est de couleur par défaut et d'épaisseur de trait <em>ep</em>
     *
     * @param  x les abscisses des points du polygône plein
     * @param  y les ordonnées des points du polygône plein
     * @param  ep épaisseur du trait du rectangle plein
     */
    public PolygonePlein(double[] x, double[] y, int ep) {
	super(x, y, ep);
    }
    
    /**
     * Rôle : dessine le rectangle courant dans la planche à dessin pad
     *
     * @param  pad la planche à dessin
     */
    @Override 
    protected void dessiner(PlancheADessin pad) {
	pad.offscreen.setColor(super.getColor());
	pad.setPenRadius(super.ep);
	pad.offscreen.fill(this.s);
    }

    @Override
    public String toString() {
	return "Polygône Plein";
    }

}
