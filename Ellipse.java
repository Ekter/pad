package PaD;

import java.awt.geom.Ellipse2D;
import java.awt.Color;

/** 
 * La classe {@code Ellipse} représente une ellipse dessinable sur la
 * planche à dessin. Le contour de l'ellipse est tracé selon la
 * couleur spécifiée dans le constructeur (ou celle par défaut).
 * L'ellipse peut être aussi déplacée et effacée
 * 
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 * 
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  6-Aug-2019 19:23
 */
public class Ellipse extends Dessinable {
    protected Ellipse2D s;

    /**
     * Rôle : crée une ellipse de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(x,y)</em>,centre de
     * l'ellipse, et de couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine de l'ellipse
     * @param  y ordonnée du point d'origine de l'ellipse
     * @param  l longueur de l'ellipse
     * @param  h hauteur de l'ellipse
     * @param  c couleur du contour de l'ellipse
     * @param  ep épaisseur du trait de l'ellipse
     */
    public Ellipse(double x, double y, double l, double h, Color c, int ep) {
	super(c, ep);
	s = new Ellipse2D.Double(x-l/2.0, y-h/2.0, l, h);
    }

        /**
     * Rôle : crée une ellipse de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(x,y)</em> et de
     * couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine de l'ellipse
     * @param  y ordonnée du point d'origine de l'ellipse
     * @param  l longueur de l'ellipse
     * @param  h hauteur de l'ellipse
     * @param  c couleur du contour de l'ellipse
     */
    public Ellipse(double x, double y, double l, double h, Color c) {
	this(x, y, l, h, c, PlancheADessin.DEFAULT_PEN_RADIUS);
    }

    /**
     * Rôle : crée une ellipse de longueur <em>l</em> et de hauteur
     *  <em>h</em> à partir du point d'origine <em>(x,y)</em> dans la
     *  couleur par défaut
    * 
     * @param  x abscisse du point d'origine de l'ellipse
     * @param  y ordonnée du point d'origine de l'ellipse
     * @param  l longueur de l'ellipse
     * @param  h hauteur de l'ellipse
     */
    public Ellipse(double x, double y, double l, double h) {
	this(x, y, l, h, PlancheADessin.DEFAULT_PEN_COLOR, PlancheADessin.DEFAULT_PEN_RADIUS);
    }

    /**
     * Rôle : crée une ellipse de longueur <em>l</em> et de hauteur
     *  <em>h</em> à partir du point d'origine <em>(x,y)</em> dans la
     *  couleur par défaut
     *
     * @param  x abscisse du point d'origine de l'ellipse
     * @param  y ordonnée du point d'origine de l'ellipse
     * @param  l longueur de l'ellipse
     * @param  h hauteur de l'ellipse
     * @param  ep l'épaisseur du trait de l'ellipse
     */
    public Ellipse(double x, double y, double l, double h, int ep) {
	this(x, y, l, h, PlancheADessin.DEFAULT_PEN_COLOR, ep);
    }
    /**
     * Rôle : crée une ellipse de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(0,0)</em> dans la
     * couleur par défaut
     *
     * @param  l longueur de l'ellipse
     * @param  h hauteur de l'ellipse
     */
    public Ellipse(double l, double h) {
	this(0, 0, l, h, PlancheADessin.DEFAULT_PEN_COLOR);
    }


        /**
     * Rôle : crée une ellipse de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(0,0)</em> dans la
     * couleur c
     *
     * @param  l longueur de l'ellipse
     * @param  h hauteur de l'ellipse
     * @param  c couleur de l'ellipse
     */
    public Ellipse(double l, double h, Color c) {
	this(0, 0, l, h, c);
    }

    /**
     * Rôle : dessine l'ellipse courante sur la planche à dessin pad
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
    public double getX() {return this.s.getX(); }

    @Override
    public double getY() {return this.s.getY(); }

    /**
     * Rôle : fixe le point d'orgine de l'objet dessinable courant
     *        en <em>(x,y)</em>
     *
     * @param  x nouvelle abscisse du point d'origine
     * @param  y nouvelle ordonnée du point d'origine
     */
    @Override
    public void setOrig(double x, double y) {
	s.setFrame(x, y, s.getWidth(), s.getHeight());
    }

    @Override
    public String toString() {
	return "Ellipse";
    }

}
