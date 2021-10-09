package PaD;

import java.awt.Color;

/** 
 * La classe {@code RectanglePlein} représente un rectangle dessinable
 * sur la planche à dessin. La surface du rectangle est tracée selon
 * la couleur spécifiée dans le constructeur (celle par défaut).  Le
 * rectangle plein peut être aussi déplacé et effacé
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  7-Nov-2018 11:16
 */
public class RectanglePlein extends Rectangle {
    /**
     * Rôle : crée un rectangle plein de longueur <em>l</em> et de
     * hauteur <em>h</em> à partir du point d'origine <em>(x,y)</em>
     * et de couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine du rectangle plein
     * @param  y ordonnée du point d'origine du rectangle plein
     * @param  l longueur du rectangle plein
     * @param  h hauteur du rectangle plein
     * @param  c couleur de fond du rectangle plein
     */
    public RectanglePlein(double x, double y, double l, double h, Color c) {
	super(x, y, l, h, c);
    }

    /**
     * Rôle : crée un rectangle plein de longueur <em>l</em> et de
     * hauteur <em>h</em> à partir du point d'origine <em>(x,y)</em>
     * dans la couleur par défaut
     *
     * @param  x abscisse du point d'origine du rectangle plein
     * @param  y ordonnée du point d'origine du rectangle plein
     * @param  l longueur du rectangle plein
     * @param  h hauteur du rectangle plein
     */
    public RectanglePlein(double x, double y, double l, double h) {
	this(x, y, l, h, PlancheADessin.DEFAULT_PEN_COLOR);
    }

    /**
     * Rôle : crée un rectangle plein de longueur <em>l</em> et de
     * hauteur <em>h</em> à partir du point d'origine <em>(0,0)</em>
     * dans la couleur par défaut
     *
     * @param  l longueur du rectangle plein
     * @param  h hauteur du rectangle plein
     */
    public RectanglePlein(double l, double h) {
	this(0, 0, l, h, PlancheADessin.DEFAULT_PEN_COLOR);
    }


    /**
     * Rôle : crée un rectangle plein de longueur <em>l</em> et de
     * hauteur <em>h</em> à partir du point d'origine <em>(0,0)</em>
     * dans la couleur <em>c</em>
     *
     * @param  l longueur du rectangle plein
     * @param  h hauteur du rectangle plein
     * @param  c la couleur du rectangle plein
     */
    public RectanglePlein(double l, double h, Color c) {
	this(0, 0, l, h, c);
    }

    /**
     * Rôle : dessine le rectangle plein courant dans la planche à dessin pad
     *
     * @param  <em>pad</em> la planche à dessin
     */
    @Override 
    protected void dessiner(PlancheADessin pad) {
	pad.offscreen.setColor(super.getColor());
	pad.offscreen.fill(s);
    }

    @Override
    public String toString() {
	return "Rectangle Plein";
    }

}
