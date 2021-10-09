package PaD;
import java.awt.Color;

/** 
 * La classe {@code CerclePlein} représente un cercle plein dessinable
 * sur la planche à dessin dont l'origine est son centre. La surface
 * du cercle est tracée selon la couleur spécifiée dans le
 * constructeur (celle par défaut).  Le cercle plein peut être aussi
 * déplacé et effacé
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  7-Nov-2018 16:34
 */
public class CerclePlein extends EllipsePleine {
    /**
     * Rôle : crée un cercle plein de diamètre <em>l</em> à partir du
     * point d'origine <em>(x,y)</em> de couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine du cercle plein 
     * @param  y ordonnée du point d'origine du cercle plein
     * @param  l longueur du diamètre du cercle plein
     * @param  c couleur du cercle plein
     */
    public CerclePlein(double x, double y, double l, Color c) {
	super(x, y, l, l, c);
    }

    /**
     * Rôle : crée un cercle plein de diamètre <em>l</em> à partir du
     * point d'origine <em>(x,y)</em> dans la couleur par défaut
     *
     * @param  x abscisse du point d'origine du cercle plein 
     * @param  y ordonnée du point d'origine du cercle plein
     * @param  l longueur du diamètre du cercle plein
     */
    public CerclePlein(double x, double y, double l) {
	super(x, y, l, l);
    }

    /**
     * Rôle : crée un cercle plein de diamètre <em>l</em> à partir du
     * point d'origine <em>(0,0)</em> dans la couleur par défaut
     *
     * @param  l longueur du diamètre du cercle plein
     */
    public CerclePlein(double l) {
	super(l, l);
    }

    /**
     * Rôle : crée un cercle plein de diamètre <em>l</em> à partir du
     * point  <em>(0,0)</em>  dans la couleur <em>c</em>
     *
     * @param  l longueur du diamètre du cercle plein
     * @param  c couleur du cercle plein
     */
    public CerclePlein(double l, Color c) {
	super(l, l, c);
    }

    @Override
    public String toString() {
	return "Cercle Plein";
    }

}
