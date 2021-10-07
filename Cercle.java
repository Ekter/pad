package PaD;
import java.awt.Color;

/** 
 * La classe {@code Cercle} représente un cercle dessinable sur la
 * planche à dessin dont le point d'origine est le centre du
 * cercle. Le contour du cercle est tracé selon la couleur spécifiée
 * dans le constructeur (celle par défaut).  Le cercle peut être aussi
 * déplacé et effacé
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  7-Nov-2018 16:33
 */
public class Cercle extends Ellipse {
    /**
     * Rôle : crée un cercle de diamètre <em>l</em> à partir du point
     * d'origine <em>(x,y)</em> de couleur <em>c</em>, et d'épaisseur de trait <em>ep</em>
     *
     * @param  x abscisse du point d'origine du cercle
     * @param  y ordonnée abscisse du point d'origine du cercle
     * @param  l longueur du diamètre du cercle
     * @param  c couleur du contour du cercle
     * @param  ep épaisseur de trait
     */
    public Cercle(double x, double y, double l, Color c, int ep) {
	super(x-l/2.0, y-l/2.0, l, l, c, ep);
    }

    /**
     * Rôle : crée un cercle de diamètre <em>l</em> à partir du point
     * d'origine <em>(x,y)</em> de couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine du cercle
     * @param  y ordonnée abscisse du point d'origine du cercle
     * @param  l longueur du diamètre du cercle
     * @param  c couleur du contour du cercle
     */
    public Cercle(double x, double y, double l, Color c) {
	super(x, y, l, l, c);
    }

    /**
     * Rôle : crée un cercle de diamètre <em>l</em> à partir du point
     * d'origine <em>(x,y)</em> dans la couleur par défaut
     *
     * @param  x abscisse du point d'origine du cercle
     * @param  y ordonnée abscisse du point d'origine du cercle
     * @param  l longueur du diamètre du cercle
     */
    public Cercle(double x, double y, double l) {
	this(x, y, l, PlancheADessin.DEFAULT_PEN_COLOR);
    }

    /**
     * Rôle : crée un cercle de diamètre <em>l</em> à partir du point
     * d'origine <em>(0,0)</em> dans la couleur par défaut
     *
     * @param  l longueur du diamètre du cercle
     */
    public Cercle(double l) {
	this(0, 0, l, PlancheADessin.DEFAULT_PEN_COLOR);
    }

    @Override
    public String toString() {
	return "Cercle";
    }

}

