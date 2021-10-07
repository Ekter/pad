package PaD;

import java.awt.MediaTracker;
import javax.swing.ImageIcon;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.geom.Rectangle2D;

/**
 * La classe {@code Image} représente une image dessinable sur la planche à
 * dessin. L'image est lue à partir d'un fichier (png, gif, ...) L'image peut
 * être aussi déplacée et effacée sur la planche à dessin
 *
 * @author Vincent Granet (vg@unice.fr)
 * @version 1.0.12
 *
 *          Creation @date: 24-Jul-2017 11:22 Last file update: 30-Sep-2019
 *          17:45
 */
public class Image extends Dessinable {
    protected double x; // abscisse de l'image
    protected double y; // ordonnée de l'image
    protected double l; // largeur de l'image
    protected double h; // hauteur de l'image
    protected double d;
    protected String fileName; // le nom du fichier associée à l'image

    protected java.awt.Image i;

    // get an image from the given filename
    private static java.awt.Image getImage(String f) {
        if (f == null)
            throw new IllegalArgumentException();
        ImageIcon icon = new ImageIcon(f);
        // try to read from URL
        if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
            try {
                URL url = new URL(f);
                icon = new ImageIcon(url);
            } catch (MalformedURLException e) {
                /* not a url */ }
        }
        // in case file is inside a .jar (classpath relative to PlancheADessin)
        if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
            URL url = PlancheADessin.class.getResource(f);
            if (url != null)
                icon = new ImageIcon(url);
        }
        // in case file is inside a .jar (classpath relative to root of jar)
        if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
            URL url = PlancheADessin.class.getResource("/" + f);
            if (url == null)
                throw new IllegalArgumentException("image " + f + " not found");
            icon = new ImageIcon(url);
        }
        return icon.getImage();
    }

    /**
     * Rôle : crée une Image positionnable au point d'origine <em>(x,y)</em>
     * contenue dans le fichier <em>f</em> selon l'orientation de <em>d</em> degrés
     * 
     *
     * @param x abscisse du point d'origine de l'image
     * @param y ordonnée du point d'origine de l'image
     * @param f le fichier contenant l'image
     * @param d le nombre de degrés d'orientation
     *
     */
    public Image(double x, double y, String f, double d) {
        super(null);
        this.x = x;
        this.y = y;
        this.fileName = f;
        this.i = this.getImage(f);
        this.d = d;
        this.l = this.i.getWidth(null);
        this.h = this.i.getHeight(null);
        if (l < 0 || h < 0)
            throw new IllegalArgumentException("image " + f + "corrompue");
    }

    /**
     * Rôle : crée une Image positionnable au point d'origine <em>(x,y)</em>
     * contenue dans le fichier <em>f</em>
     *
     * @param x abscisse du point d'origine de l'image
     * @param y ordonnée du point d'origine de l'image
     * @param f le fichier contenant l'image
     *
     */
    public Image(double x, double y, String f) {
        this(x, y, f, 0.0);
    }

    /**
     * Rôle : crée une Image positionnable au point d'origine <em>(0,0)</em>
     * contenue dans le fichier <em>f</em>, selon l'orientation <em>d</em>
     *
     * @param f le fichier contenant l'image
     * @param d le nombre de degrés d'orientation
     *
     */
    public Image(String f, double d) {
        this(0, 0, f, d);
    }

    /**
     * Rôle : crée une Image positionnable au point d'origine <em>(0,0)</em>
     * contenue dans le fichier <em>f</em>
     *
     * @param f le fichier contenant l'image
     *
     */
    public Image(String f) {
        this(0, 0, f, 0.0);
    }

    /**
     * Rôle : renvoie la largeur de l'image courante
     *
     * @return la largeur de l'image courante
     */
    public double getLargeur() {
        return this.l;
    }

    /**
     * Rôle : renvoie la hauteur de l'image courante
     *
     * @return la hauteur de l'image courante
     */
    public double getHauteur() {
        return this.h;
    }

    /**
     * Rôle : renvoie le nom du fichier associé à l'image courante
     *
     * @return <code>String</code>
     */
    public String getFichierImage() {
        return this.fileName;
    }

    /**
     * Rôle : dessine l'Image courante sur la planche à dessin <em>pad</em>
     *
     * @param pad la planche à dessin
     */
    @Override
    protected void dessiner(PlancheADessin pad) {
        pad.offscreen.rotate(Math.toRadians(-this.d), this.getX(), this.getY());
        pad.offscreen.drawImage(this.i, (int) Math.round(x), (int) Math.round(y), null);
        pad.offscreen.rotate(Math.toRadians(+this.d), this.getX(), this.getY());
    }

    @Override
    protected boolean appartient(double x, double y) {
        return x >= getX() && x <= getX() + this.getLargeur() && y >= getY() && y <= getY() + this.getHauteur();
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    /**
     * Rôle : fixe le point d'orgine de l'objet dessinable courant en <em>(x,y)</em>
     *
     * @param x nouvelle abscisse du point d'origine
     * @param y nouvelle ordonnée du point d'origine
     */
    @Override
    public void setOrig(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Image";
    }
}
