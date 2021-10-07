package PaD;
import java.awt.geom.Line2D;
import java.awt.Color;

/** 
 * La classe {@code Ligne} représente une ligne dessinable sur
 * la planche à dessin. La ligne est tracée selon la
 * couleur spécifiée dans le constructeur (ou celle par défaut).  La
 * ligne peut être aussi déplacée et effacée
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  6-Aug-2019 19:24
 */
public class Ligne extends Dessinable {
    protected Line2D s;
    /**
     * Rôle : crée une ligne de point d'origine <em>(x1,y1)</em> et
     * d'arrivée <em>(x2,y2)</em> de couleur <em>c</em> et d'épaisseur <em>ep</em>
     *
     * @param  x1 abscisse du point d'origine de la ligne
     * @param  y1 ordonnée du point d'origine de la ligne
     * @param  x2 abscisse du point d'arrivée de la ligne
     * @param  y2 ordonnée du point d'arrivée de la ligne
     * @param  c couleur de la ligne courante
     * @param  ep épaisseur de la ligne courante
     */
    public Ligne(double x1, double y1, double x2, double y2, Color c, int ep) {
	super(c, ep);
	s =  new Line2D.Double(x1, y1, x2, y2);
    }

    /**
     * Rôle : crée une ligne de point d'origine (x1,y1) et d'arrivée (x2,y2)
     * de couleur c
     *
     * @param x1 double abcisse du point d'origine
     * @param y1 double ordonnée du point d'origine
     * @param x2 double abcisse du point d'arrivée
     * @param y2 double ordonnée du point d'arrivée
     * @param c couleur de la ligne courante
     */
    public Ligne(double x1, double y1, double x2, double y2, Color c) {
	this(x1, y1, x2, y2, c, PlancheADessin.DEFAULT_PEN_RADIUS);
    }

    /**
     * Rôle : crée une ligne de point d'origine (x1,y1) et d'arrivée (x2,y2)
     * de couleur par défaut et d'épaisseur ep
     *
     * @param x1 double abcisse du point d'origine
     * @param y1 double ordonnée du point d'origine
     * @param x2 double abcisse du point d'arrivée
     * @param y2 double ordonnée du point d'arrivée
     * @param ep épaisseur de la ligne courante
     */
    public Ligne(double x1, double y1, double x2, double y2, int ep) {
	this(x1, y1, x2, y2,  PlancheADessin.DEFAULT_PEN_COLOR, ep);
    }
    
    /**
     * Rôle : crée une ligne de point d'origine (x1,y1) et d'arrivée (x2,y2)
     *        dans la couleur par défaut
     *
     * @param x1 double abcisse du point d'origine
     * @param y1 double ordonnée du point d'origine
     * @param x2 double abcisse du point d'arrivée
     * @param y2 double ordonnée du point d'arrivée
     */
    public Ligne(double x1, double y1, double x2, double y2) {
	this(x1, y1, x2, y2, PlancheADessin.DEFAULT_PEN_COLOR);
    }
    
    /**
     * Rôle : crée une ligne de point d'origine (0,0) et d'arrivée (x2,y2)
     *        dans la couleur par défaut
     *
     * @param x2 double abcisse du point d'arrivée
     * @param y2 double ordonnée du point d'arrivée
     */
    public Ligne(double x2, double y2) {
	this(0, 0, x2, y2, PlancheADessin.DEFAULT_PEN_COLOR);
    }

    /**
     * Rôle : dessine la ligne courante dans la planche à dessin <em>pad</em>
     *
     * @param pad la planche à dessin
     */
    @Override 
    protected void dessiner(PlancheADessin pad) {
	pad.offscreen.setColor(this.c);
	pad.setPenRadius(super.ep);
	pad.offscreen.draw(this.s);
    }

    @Override 
    protected boolean appartient(double x, double y) {
	double précision = 2;
	double x1 = s.getX1();
	double x2 = s.getX2();
	double y1 = s.getY1();
	double y2 = s.getY2();
	// droite verticale ?
	if (x1-x2==0)
	    return Math.abs(x-x1)<précision &&  y>=y1 && y<=y2; 
	// droite horizontale ?
	if (y1-y2==0)
	    return  Math.abs(y-y1)<=précision && x>=x1 && x<=x2; 
	// droite quelconque
	double a = (y1-y2)/(x1-x2);
	double b = y1- a*x1;
	return Math.abs(y-(a*x+b))<=précision;
    }

    /**
     * Rôle : fixe le point d'orgine de la ligne courante en
     *        <em>(x,y)</em> et calcule son nouveau point d'arrivée
     *
     * @param  x nouvelle abscisse du point d'origine
     * @param  y nouvelle ordonnée du point d'origine
     */
    @Override 
    public void setOrig(double x, double y) {
	double offX = x-s.getX1();
	double offY = y-s.getY1();
	s.setLine(x, y , s.getX2()+offX, s.getY2()+offY);
    }

    @Override
    public double getX() {return this.s.getX1(); }

    @Override
    public double getY() {return this.s.getY1(); }

    @Override
    public String toString() {
	return "Ligne";
    }

}
