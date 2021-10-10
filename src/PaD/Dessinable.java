package PaD;

import java.awt.Color;

/**
 * La classe abstraite Dessinable est la classe de base de tous objets
 * dessinables sur la PlancheADessin.
 *
 * Les méthodes {@code addMousePressedListener}, {@code
 * addMouseReleasedListener} et {@code addMouseDraggedListener}
 * permettent l'ajout de gestionnaire d'événements, resp. {@code
 * MousePressed}, {@code MouseReleased} et {@code MouseDragged}, pour
 * appliquer les événéments souris correspondant sur un  {@code Dessinable}.
 * L'exemple suivant crée un Rectangle tel qu'à chaque fois que l'on clique
 * dessus le message  <em>Mouse pressed</em> est affiché sur la sortie standard :
 *
 *
 * <pre>
 * {@code
 *  PlancheADessin pad = new PlancheADessin(true);
 *  Dessinable r = new Rectangle(0, 0, 100, 100);
 *  pad.ajouter(r);
 *  r.addMousePressedListener((d, e) -> {
 *          System.out.println("Mouse pressed");
 *    });
 *  }
 *  </pre>
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 */
public abstract class Dessinable implements Comparable<Dessinable>
{

    protected MousePressed mp;
    protected MouseDragged md;
    protected MouseReleased mr;

    public void addMousePressedListener(MousePressed mp)   { this.mp = mp; }
    public void addMouseReleasedListener(MouseReleased mr) { this.mr = mr; }
    public void addMouseDraggedListener(MouseDragged md)   { this.md = md; }
    
    protected Color c = PlancheADessin.DEFAULT_PEN_COLOR;
    protected int ep = PlancheADessin.DEFAULT_PEN_RADIUS;

    protected int profondeur = 0;
	
    protected Dessinable(Color c) {
	this.c = c;
    }

    protected Dessinable(Color c, int ep) {
	this.c = c;
	this.ep = ep;
    }

    protected Color getColor() { return this.c; }
    protected int getEpaisseurTrait() { return this.ep; }
    
    /**
     * Rôle : dessine l'objet courant planche à dessin <em>pad</em>
     *
     * @param  pad {@code PlancheADessin} sur laquelle l'objet
     *         courant est dessiné
     *
     */

    /**
     * Rôle : fixe le point d'orgine de l'objet dessinable courant
     *        en <em>(x,y)</em>
     *
     * @param  x nouvelle abscisse du point d'origine
     * @param  y nouvelle ordonnée du point d'origine
     */
    public abstract void setOrig(double x, double y);


    /**
     * Rôle : renvoie l'abscisse du point d'orgine de l'objet
     *        dessinable courant
     *
     * @return <code>double</code>
     */
    public abstract double getX();

    /**
     * Rôle : renvoie l'ordonnée du point d'orgine de l'objet
     *        dessinable courant
     *
     * @return <code>double</code>
     */
    public abstract double getY();
    
    //
    protected abstract void dessiner(PlancheADessin pad);
    protected abstract boolean appartient(double x, double y);

    /**
     * Rôle : compare this avec le dessinable d selon leur profondeur
     */
    public int compareTo​(Dessinable d)  {
	if (this.profondeur == d.profondeur) return 0;
	if (this.profondeur<d.profondeur) return -1;
	return 1;
    }

    /**
     * Rôle : affecte au Dessinable courant la profondeur p
     *
     * @param  p nouvelle profondeur de this
     */
    public void setProfondeur(int p) {
	this.profondeur = p;
    }

    /**
     * Rôle : renvoie la profondeur du Dessinable courant
     *
     * @return   {@code int} la profondeur du Dessinable courant
     */
    public int getProfondeur() {
	return this.profondeur;
    }

}
