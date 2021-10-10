package PaD;
import java.awt.Color;
import java.awt.geom.GeneralPath;

/** 
 * La classe {@code Polygone} représente un polygône dessinable sur
 * la planche à dessin. Le contour du polygône est tracé selon la
 * couleur spécifiée dans le constructeur (ou celle par défaut).  Le
 * polygône peut être aussi déplacé et effacé
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  6-Aug-2019 19:25
 */
public class Polygone extends Dessinable {
    protected GeneralPath s;
    protected double []x;
    protected double []y;
    
    /**
     * Rôle : crée un polygone à partir des points dont les abscisses
     * et les ordonnées sont données, respectivement, par les tableaux
     * <em>x</em> et <em>y</em>.  Le contour du polygône est de
     * couleur <em>c</em> et d'épaisseur de trait <em>ep</em>
     *
     * @param  x les abscisses des points du polygône
     * @param  y les ordonnées des points du polygône
     * @param  c couleur du contour du rectangle
     * @param  ep épaisseur du trait du rectangle
     */
    public Polygone(double[] x, double[] y, Color c, int ep) {
	super(c, ep);
	// vérifier la validité des points
	if (x==null)
	    throw new IllegalArgumentException("tableau des abscisses null !");
	if (y==null)
	    throw new IllegalArgumentException("tableau des ordonnées null !");
        if (x.length!=y.length)
	    throw new IllegalArgumentException("tableaux de ld differentes");
	//
	s = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x.length);
	this.x = x;
	this.y = y;
	//
	s.moveTo(x[0], y[0]);
        for (int i = 1; i<x.length; i++)
	    s.lineTo(x[i], y[i]);
        s.closePath();
    }

    /**
     * Rôle : crée un polygone à partir des points dont les abscisses
     * et les ordonnées sont données, respectivement, par les tableaux
     * <em>x</em> et <em>y</em>.  Le contour du polygône est de
     * couleur <em>c</em> et d'épaisseur de trait par défaut
     *
     * @param  x les abscisses des points du polygône
     * @param  y les ordonnées des points du polygône
     * @param  c couleur du contour du rectangle
     */
    public Polygone(double[] x, double[] y, Color c) {
	this(x, y, c, PlancheADessin.DEFAULT_PEN_RADIUS);
    }
    
    /**
     * Rôle : crée un polygone à partir des points dont les abscisses
     * et les ordonnées sont données, respectivement, par les tableaux
     * <em>x</em> et <em>y</em>.  Le contour du polygône est de la
     * couleur par défaut et d'épaisseur de trait <em>ep</em>
     *
     * @param  x les abscisses des points du polygône
     * @param  y les ordonnées des points du polygône
     * @param  ep épaisseur du trait
     */
    public Polygone(double[] x, double[] y, int ep) {
	this(x, y, PlancheADessin.DEFAULT_PEN_COLOR, ep);
    }

    /**
     * Rôle : crée un polygone à partir des points dont les abscisses
     * et les ordonnées sont données, respectivement, par les tableaux
     * <em>x</em> et <em>y</em>.  Le contour du polygône est de la
     * couleur par défaut et d'épaisseur de trait par défaut
     *
     * @param  x les abscisses des points du polygône
     * @param  y les ordonnées des points du polygône
     */
    public Polygone(double[] x, double[] y) {
	this(x, y, PlancheADessin.DEFAULT_PEN_COLOR, PlancheADessin.DEFAULT_PEN_RADIUS);
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
	pad.offscreen.draw(this.s);
    }

    @Override 
    protected boolean appartient(double x, double y) {
	return this.s.contains(x,y);
    }
    
    @Override
    public double getX() {return this.x[0]; }

    @Override
    public double getY() {return this.y[0]; }

    /**
     * Rôle : fixe le point d'orgine de l'objet dessinable courant
     *        en <em>(x,y)</em>
     *
     * @param  x nouvelle abscisse du point d'origine
     * @param  y nouvelle ordonnée du point d'origine
     */
    @Override
    public void setOrig(double x, double y) {
	double offX = x-this.x[0];
	double offY = y-this.y[0];
	s = new GeneralPath(GeneralPath.WIND_EVEN_ODD, this.x.length);
	s.moveTo(this.x[0]+=offX, this.y[0]+=offY);
        for (int i=1; i<this.x.length; i++)
	    s.lineTo(this.x[i]+=offX, this.y[i]+=offY);
        s.closePath();
    }

    @Override
    public String toString() {
	return "Polygône";
    }

}

