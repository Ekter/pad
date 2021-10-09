package PaD;

import java.awt.Color;
/** 
 * La classe {@code Carré} représente un carré dessinable sur
 * la planche à dessin. Le contour du carré est tracé selon la
 * couleur spécifiée dans le constructeur (celle par défaut).  Le
 * carré peut être aussi déplacé et effacé

 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  7-Nov-2018 16:33
 */

public class Carré extends Rectangle {
    /**
     * Rôle : crée un carré de coté <em>l</em> à partir du point
     * d'origine <em>(x,y)</em> de couleur <em>c</em> et d'épaisseur
     * de trait ep
     *
     * @param  x abscisse du point d'origine du carré
     * @param  y ordonnée du point d'origine du carré
     * @param  l longueur du cotyé du carré
     * @param  c couleur du contour du carré
     * @param  ep l'épaisseur du trait du carré
     */
    public Carré(double x, double y, double l, Color c, int ep) {
	super(x, y, l, l, c, ep);
    }

    /**
     * Rôle : crée un carré de coté <em>l</em> à partir du point
     * d'origine <em>(x,y)</em> de couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine du carré
     * @param  y ordonnée du point d'origine du carré
     * @param  l longueur du cotyé du carré
     * @param  c couleur du contour du carré
     */
    public Carré(double x, double y, double l, Color c) {
	super(x, y, l, l, c);
    }

    /**
     * Rôle : crée un carré de coté <em>l</em> à partir du point
     * d'origine <em>(x,y)</em> dans la couleur par défaut
     *
     * @param  x abscisse du point d'origine du carré
     * @param  y ordonnée du point d'origine du carré
     * @param  l longueur du coté du carré
     */
    public Carré(double x, double y, double l) {
	super(x, y, l, l);
    }

    /**
     * Rôle : crée un carré de coté <em>l</em> à partir du point
     * d'origine <em>(x,y)</em> dans la couleur par défaut
     *
     * @param  x abscisse du point d'origine du carré
     * @param  y ordonnée du point d'origine du carré
     * @param  l longueur du coté du carré
     * @param  ep l'épaisseur du trait du carré
     */
    public Carré(double x, double y, double l, int ep) {
	super(x, y, l, l, ep);
    }
    
    /**
     * Rôle : crée un carré de coté <em>l</em> à partir du point
     * d'origine <em>(0,0)</em> dans la couleur par défaut
     *
     * @param l longueur du coté du carré
     */
    public Carré(double l) {
	super(l, l);
    }

    @Override
    public String toString() {
	return "Carré";
    }
}
