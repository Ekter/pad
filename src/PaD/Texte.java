package PaD;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;

/** 
 * La classe {@code Texte} représente du texte dessinable sur la
 * planche à dessin. Le texte est écrit selon la couleur et la police
 * spécifiées dans le constructeur (ou celles par défaut).  Le
 * texte peut être aussi déplacé et effacé
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *    Creation @date: 24-Jul-2017 11:22
 *  Last file update:  6-Aug-2019 19:25
 */
public class Texte extends Dessinable {
    protected double x;
    protected double y;
    protected double l;
    protected double h;
    protected Font f;
    protected String t;

    /**
     * Rôle : crée un Texte positionnable au point d'origine <em>(x,y)</em> dans
     * la police <em>f</em> et la couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine du texte
     * @param  y ordonnée du point d'origine du texte
     * @param  t le texte à dessiner/écrire
     * @param  f la police du texte
     * @param  c couleur du texte
     *
     */
    public Texte(double x, double y, String t, Font f, Color c) {
	super(c);
	if (t == null) throw new IllegalArgumentException();
	this.x = x;
	this.y = y;
	this.f = f;
	this.t = t;
	this.c = c;
    }

    /**
     * Rôle : crée un Texte positionnable au point d'origine <em>(x,y)</em> dans
     * la police par défaut et la couleur <em>c</em>
     *
     * @param  x abscisse du point d'origine du texte
     * @param  y ordonnée du point d'origine du texte
     * @param  t le texte à dessiner/écrire
     * @param  c couleur du texte
     */
    public Texte(double x, double y, String t, Color c) {
	this(x, y, t, PlancheADessin.DEFAULT_FONT, c);
    }

    /**
     * Rôle : crée un Texte positionnable au point d'origine <em>(x,y)</em> dans
     * la police <em>f</em>  dans la couleur par défaut
     *
     * @param  x abscisse du point d'origine du texte
     * @param  y ordonnée du point d'origine du texte
     * @param  t le texte à dessiner/écrire
     * @param  f la police du texte
     */
    public Texte(double x, double y, String t, Font f) {
	this(x, y, t, f, PlancheADessin.DEFAULT_PEN_COLOR);
    }

    /**
     * Rôle : crée un Texte positionnable au point d'origine <em>(x,y)</em> dans
     * la police par défaut et la couleur par défaut
     *
     * @param  x abscisse du point d'origine du texte
     * @param  y ordonnée du point d'origine du texte
     * @param  t le texte à dessiner/écrire
     */
    public Texte(double x, double y, String t) {
	this(x, y, t, PlancheADessin.DEFAULT_FONT, PlancheADessin.DEFAULT_PEN_COLOR);
    }

    /**
     * Rôle : crée un Texte positionnable au point d'origine <em>(0,0)</em> dans
     * la police par défaut et la couleur par défaut
     *
     * @param  t le texte à dessiner/écrire
     */    
    public Texte(String t) {
	this(0, 0, t, PlancheADessin.DEFAULT_FONT, PlancheADessin.DEFAULT_PEN_COLOR);
    }

    protected void setX(double x) { this.x = x; }
    protected void setY(double y) { this.y = y; }
    protected double getLargeur() { return this.l;}
    protected double getHauteur() { return this.h;}
    public double getX() { return this.x;}
    public double getY() { return this.y;}

    
    /**
     * Rôle : dessine/écrit le Texte courant dans la planche à dessin pad
     *
     * @param  pad la planche à dessin
     */
    @Override 
    protected void dessiner(PlancheADessin pad) {
	pad.offscreen.setFont(this.f);
	// get metrics from the graphics2D
	FontMetrics metrics = pad.offscreen.getFontMetrics(this.f);
	// get the height of the text in this
	// font and render context
	this.h = metrics.getHeight();
	// get the length of the text in this font
	// and render context
	this.l = metrics.stringWidth(this.t);
	pad.setPenColor(this.c);
	pad.offscreen.drawString(this.t, (float) this.x, (float) (this.y+this.h));
    }
    
    @Override 
    protected boolean appartient(double x, double y) {
	return x>=getX() && x<=getX()+getLargeur() && y>=getY() && y<=getY()+getHauteur();
    }

    /**
     * Rôle : fixe le point d'orgine de l'objet dessinable courant
     *        en <em>(x,y)</em>
     *
     * @param  x nouvelle abscisse du point d'origine
     * @param  y nouvelle ordonnée du point d'origine
     */
    @Override
    public void setOrig(double x, double y) {
	this.x = x;
	this.y = y;
    }

    @Override
    public String toString() {
	return "Texte";
    }

}
