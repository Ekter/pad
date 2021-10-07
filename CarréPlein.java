package PaD;
import java.awt.Color;

/** 
 * La classe {@code CarréPlein} représente un carré plein dessinable
 * sur la planche à dessin. La surface du carré est tracée selon la
 * couleur spécifiée dans le constructeur (celle par défaut).  Le
 * carré plein peut être aussi déplacé et effacé
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  7-Nov-2018 16:33
 */
public class CarréPlein extends RectanglePlein {
    /**
     * Rôle : crée un carré plein de coté <em>l</em> à partir du
     * point <em>(x,y)</em> de couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine du carré plein
     * @param  y ordonnée du point d'origine du carré plein
     * @param  l longueur du coté du carré plein
     * @param  c couleur du carré plein
     */
    public CarréPlein(double x, double y, double l, Color c) {
	super(x, y, l, l, c);
    }

    /**
     * Rôle : crée un carré plein de coté <em>l</em> à partir du
     * point d'origine <em>(x,y)</em> dans la couleur par défaut
     *
     * @param  x abscisse du point d'origine du carré plein
     * @param  y ordonnée du point d'origine du carré plein
     * @param  l longueur du coté du carré plein
     */
    public CarréPlein(double x, double y, double l) {
	super(x, y, l, l);
    }

    /**
     * Rôle : crée un carré plein de coté <em>l</em> à partir du
     * point d'origine <em>(0,0)</em> dans la couleur par défaut
     *
     * @param  l longueur du coté du carré plein
     */
    public CarréPlein(double l) {
	super(l, l);
    }

    @Override
    public String toString() {
	return "Carré Plein";
    }

}
