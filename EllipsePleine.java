package PaD;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/** 
 * La classe {@code EllipsePleine} représente une ellipse pleine
 * dessinable sur la planche à dessin de point d'origine son
 * centre. La surface de l'ellipse est tracée selon la couleur
 * spécifiée dans le constructeur (celle par défaut).  L'ellipse
 * pleine peut être aussi déplacée et effacée
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  7-Nov-2018 11:15
 */
public class EllipsePleine extends Ellipse {
    /**
     * Rôle : crée une ellipse pleine de longueur <em>l</em> et de
     * hauteur <em>h</em> à partir du point d'origine <em>(x,y)</em>
     * et de couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine de l'ellipse pleine 
     * @param  y ordonnée du point d'origine de l'ellipse pleine
     * @param  l longueur de l'ellipse pleine
     * @param  h hauteur de l'ellipse pleine
     * @param  c couleur de l'ellipse pleine
     */
    public EllipsePleine(double x, double y, double l, double h, Color c) {
	super(x, y, l, h, c);
    }

    /**
     * Rôle : crée une ellipse pleine de longueur <em>l</em> et de hauteur
     * <em>h</em> à partir du point d'origine <em>(x,y)</em> dans la
     * couleur par défaut
     *
     * @param  x abscisse du point d'origine de l'ellipse pleine 
     * @param  y ordonnée du point d'origine de l'ellipse pleine
     * @param  l longueur de l'ellipse pleine
     * @param  h hauteur de l'ellipse pleine
     */
    public EllipsePleine(double x, double y, double l, double h) {
	super(x, y, l, h);
    }

    /**
     * Rôle : crée une ellipse pleine <em>l</em> x <em>h</em> à partir du
     * point <em>(0,0)</em> dans la couleur par défaut
     *
     * @param  l longueur de l'ellipse pleine
     * @param  h hauteur de l'ellipse pleine
     */
    public EllipsePleine(double l, double h) {
	super(l, h);
    }

    /**
     * Rôle : crée une ellipse pleine <em>l</em> x <em>h</em> à partir du
     * point <em>(0,0)</em> dans la couleur <em>c</em>
     *
     * @param  l longueur de l'ellipse pleine
     * @param  h hauteur de l'ellipse pleine
     * @param  c couleur de l'ellipse pleine
     */
    public EllipsePleine(double l, double h, Color c) {
	super(l, h, c);
    }
    
    /**
     * Rôle : dessine l'ellipse pleine courante sur la planche à
     * dessin pad
     *
     * @param  pad la planche à dessin
     */
    @Override 
    protected void dessiner(PlancheADessin pad) {
	pad.offscreen.setColor(this.getColor());
	pad.offscreen.fill(s);
    }

    @Override
    public String toString() {
	return "Ellipse Pleine";
    }

}
