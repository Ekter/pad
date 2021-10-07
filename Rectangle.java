package PaD;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

/** 
 * La classe {@code Rectangle} représente un rectangle dessinable sur
 * la planche à dessin. Le contour du rectangle est tracé selon la
 * couleur spécifiée dans le constructeur (ou celle par défaut).  Le
 * rectangle peut être aussi déplacé et effacé
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  6-Aug-2019 19:22
 */
public class Rectangle extends Dessinable {
    protected Rectangle2D s;
    /**
     * Rôle : crée un rectangle de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(x,y)</em>, de
     * couleur <em>c</em> et d'épaisseur de trait <em>ep</em>
     *
     * @param  x abscisse du point d'origine du rectangle
     * @param  y ordonnée du point d'origine du rectangle
     * @param  l longueur du rectangle
     * @param  h hauteur du rectangle
     * @param  c couleur du contour du rectangle
     * @param  ep épaisseur du trait du rectangle
     */
    public Rectangle(double x, double y, double l, double h, Color c, int ep) {
	super(c, ep);
	s = new Rectangle2D.Double(x, y, l, h);
    }

    /**
     * Rôle : crée un rectangle de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(x,y)</em> et de
     * couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine du rectangle
     * @param  y ordonnée du point d'origine du rectangle
     * @param  l longueur du rectangle
     * @param  h hauteur du rectangle
     * @param  c couleur du contour du rectangle
     */
    public Rectangle(double x, double y, double l, double h, Color c) {
	this(x, y, l, h, c, PlancheADessin.DEFAULT_PEN_RADIUS);
    }
    
    /**
     * Rôle : crée un rectangle de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(x,y)</em> dans la 
     * couleur par défaut
     *
     * @param  x abscisse du point d'origine du rectangle
     * @param  y ordonnée du point d'origine du rectangle
     * @param  l longueur du rectangle
     * @param  h hauteur du rectangle
     */
    public Rectangle(double x, double y, double l, double h) {
	this(x, y, l, h, PlancheADessin.DEFAULT_PEN_COLOR, PlancheADessin.DEFAULT_PEN_RADIUS);
    }


    /**
     * Rôle : crée un rectangle de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(x,y)</em> dans la 
     * couleur par défaut et d'épaisseur de trait ep
     *
     * @param  x abscisse du point d'origine du rectangle
     * @param  y ordonnée du point d'origine du rectangle
     * @param  l longueur du rectangle
     * @param  h hauteur du rectangle
     * @param  ep l'épaisseur du trait du rectangle
     */
    public Rectangle(double x, double y, double l, double h, int ep) {
	this(x, y, l, h, PlancheADessin.DEFAULT_PEN_COLOR, ep);
    }

    /**
     * Rôle : crée un rectangle de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(0,0)</em> dans la 
     * couleur par défaut
     *
     * @param  l longueur du rectangle
     * @param  h hauteur du rectangle
     */
    public Rectangle(double l, double h) {
	this(0, 0, l, h, PlancheADessin.DEFAULT_PEN_COLOR, PlancheADessin.DEFAULT_PEN_RADIUS);
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
	return "Rectangle";
    }

}
