package PaD;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.util.Arrays;
import java.util.Vector;
import java.util.List;
import java.awt.BasicStroke;
import java.awt.event.*;

/**
 * La classe {@code PlancheADessin} définit une zone graphique sur
 * laquelle il sera possible de dessiner et manipuler des objets qui
 * representent des formes géométriques (rectangles, carrés, ellipses,
 * cercles, segments de droite), du texte et des images. Les objets
 * sont placés selon un système de coordonnées cartésiennes. Le point
 * nord-ouest d'une {@code PlancheADessin} a pour coordonnées
 * (0,0). De plus, il sont dessinés selon leur profondeur. Ceux qui
 * ont la profondeur la plus grande se superposent aux autres
 *
 * <p>
 * Le principe d'utilisation de la <em>Planche à Dessin</em> est
 * simple.  On crée d'abord une planche à dessin, puis on crée des
 * objets dessinables, et enfin on les ajoute à la planche à dessiner
 * pour les voir apparaître.  La position (coordonnées cartésiennes)
 * des objets à dessiner est indiquée à la création de l'objet, par
 * défaut <em>(0,0)</em>. Elle peut être également modifiée avec la
 * méthode {@code setOrig}.
 * <p>
 * Les objets dessinables peuvent être déplacés à l'aide de la souris si constructeur
 * de la planche à dessin l'a permis.
 * <p>
 * L'exemple suivant crée un planche à dessin sur laquelle est dessiné
 * un cercle rouge relié par une ligne à un rectangle dans lequel est
 * écrit le mot <em>Hello</em> :
 *
 * <pre>
 * <b>import</b> PaD.*;
 * <b>public class</b> Dessin {
 *     <b>public static void</b> main(String [] args) {
 *         PlancheADessin pad = <b>new</b> PlancheADessin();
 *         Dessinable f1 = <b>new</b> CerclePlein(0, 0, 60, PlancheADessin.ROUGE);
 *         Dessinable f2 = <b>new</b> Rectangle(120, 0, 100, 150);
 *         Dessinable l = <b>new</b> Ligne(60, 30, 120, 30);
 *         Dessinable mess = <b>new</b> Texte(150, 80, "Hello");
 *         pad.ajouter(f1, f2, l, mess);
 *     }
 *  }
 *  </pre>
 *
 * @author V. Granet (vg@unice.fr)
 * @version 1.0.13
 */
public class PlancheADessin
        implements MouseListener, MouseMotionListener {
    protected static final String SERIAL_VERSION = "1.0.13";

    /**
     * La couleur Blanc
     */
    public static final Color BLANC = Color.WHITE;
    /**
     * La couleur Noir
     */
    public static final Color NOIR = Color.BLACK;
    /**
     * La couleur Gris foncé
     */
    public static final Color GRIS_FONCÉ = Color.DARK_GRAY;
    /**
     * La couleur Gris
     */
    public static final Color GRIS = Color.GRAY;
    /**
     * La couleur Gris clair
     */
    public static final Color GRIS_CLAIR = Color.LIGHT_GRAY;
    /**
     * La couleur Rouge  (couleur primaire additive)
     */
    public static final Color ROUGE = Color.RED;
    /**
     * La couleur Bleu  (couleur primaire additive)
     */
    public static final Color BLEU = Color.BLUE;
    /**
     * La couleur Vert  (couleur primaire additive)
     */
    public static final Color VERT = Color.GREEN;
    /**
     * La couleur Cyan (couleur primaire soustractive)
     */
    public static final Color CYAN = Color.CYAN;
    /**
     * La couleur Magenta  (couleur primaire soustractive)
     */
    public static final Color MAGENTA = Color.MAGENTA;
    /**
     * La couleur Orange
     */
    public static final Color ORANGE = Color.ORANGE;
    /**
     * La couleur Jaune  (couleur primaire soustractive)
     */
    public static final Color JAUNE = Color.YELLOW;
    /**
     * La couleur Rose
     */
    public static final Color ROSE = Color.PINK;

    protected static final Color DEFAULT_CLEAR_COLOR = Color.WHITE;
    protected static final Color DEFAULT_PEN_COLOR = Color.BLACK;
    protected static final Font DEFAULT_FONT = new Font("SansSerif", Font.PLAIN, 16);
    protected static final int DEFAULT_PEN_RADIUS = 1;

    private List<Dessinable> voad;

    private Font font;
    private int width;
    private int height;
    private Color penColor;
    private double penRadius;

    private BufferedImage offscreenImage, onscreenImage;
    protected Graphics2D offscreen, onscreen;

    private JFrame frame;

    /**
     * Rôle : définit la police pour les objets textuels
     *
     * @param font la nouvelle police
     */
    protected void setFont(Font font) {
        if (font == null) throw new IllegalArgumentException();
        this.font = font;
    }

    private void setFont() {
        setFont(DEFAULT_FONT);
    }

    /**
     * Rôle : définit la couleur pour dessiner
     *
     * @param color la nouvelle couleur
     */
    protected void setPenColor(Color color) {
        if (color == null) throw new IllegalArgumentException();
        this.penColor = color;
        offscreen.setColor(penColor);
    }

    protected void setPenColor() {
        setPenColor(DEFAULT_PEN_COLOR);
    }


    protected double getPenRadius() {
        return penRadius;
    }

    void setPenRadius() {
        setPenRadius(DEFAULT_PEN_RADIUS);
    }

    protected void setPenRadius(int radius) {
        BasicStroke stroke =
                new BasicStroke(radius, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        offscreen.setStroke(stroke);
    }

    /**
     * Rôle : efface toutes les dessins de la planche courante
     */
    public void clear() {
        this.clear(DEFAULT_CLEAR_COLOR);
        this.voad.clear();
    }

    private void clear(Color color) {
        this.clearOff(color);
        this.draw();
    }

    private void clearOff(Color color) {
        this.offscreen.setColor(color);
        this.offscreen.fillRect(0, 0, width, height);
        this.offscreen.setColor(penColor);
    }

    /**
     * Rôle : ajoute à la planche à dessin l'objet dessinable
     * <em>d</em>, et le dessine
     *
     * @param d l'objet dessinable à ajouter
     */
    public void ajouter(Dessinable d) {
        this.voad.add(d);
        this.draw();
    }

    /**
     * Rôle : ajoute à la planche à dessin les objets dessinables
     * <em>objsD</em>, et les dessine
     *
     * @param objsD les objets dessinables à ajouter
     */
    public void ajouter(Dessinable... objsD) {
        this.voad.addAll(Arrays.asList(objsD));
        this.draw();
    }

    /**
     * Rôle : supprime de la planche à dessin l'objet dessinable
     * <em>d</em>
     *
     * @param d l'objet dessinable à supprimer
     */
    public void supprimer(Dessinable d) {
        this.voad.remove(d);
        this.draw();
    }

    /**
     * Rôle : supprime de la planche à dessin tous les objets dessinables
     * <em>objsD</em>
     *
     * @param objsD les objets dessinables à supprimer
     */
    public void supprimer(Dessinable... objsD) {
        for (Dessinable d : objsD) this.voad.remove(d);
        this.draw();
    }

    /**
     * Rôle : déplace sur la planche à dessin l'objet dessinable
     * <em>d</em> à la position  <em>(x,y)</em>
     *
     * @param d l'objet dessinable à déplacer
     * @param x abcisse de d sur sur la planche à dessin
     * @param y ordonnée de d sur sur la planche à dessin
     */
    public void déplacer(Dessinable d, double x, double y) {
        d.setOrig(x, y);
        this.draw();
    }

    /**
     * Rôle : construit une {@code PlancheADessin} de la taille <em>l x h</em>
     * avec gestion ou non de la souris
     *
     * @param l         largeur de la PlancheADessin
     * @param h         hauteur de la PlancheADessin
     * @param isMouseOn gestion de la souris ou non
     */
    public PlancheADessin(int l, int h, boolean isMouseOn) {
        //
        if (l <= 0 || h <= 0)
            throw new IllegalArgumentException("largeur et hauteur doivent être positives");
        this.width = l;
        this.height = h;
        //
        if (frame != null) frame.setVisible(false);
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(this.width, this.height));

        voad = new Vector<Dessinable>();

        onscreenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        onscreen = onscreenImage.createGraphics();
        offscreenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        offscreen = offscreenImage.createGraphics();

        offscreen.setColor(DEFAULT_CLEAR_COLOR);
        offscreen.fillRect(0, 0, this.width, this.height);

        setPenColor();
        setPenRadius();
        clear();

        //

        ImageIcon icon = new ImageIcon(onscreenImage);
        JLabel draw = new JLabel(icon);
        frame.setContentPane(draw);
        if (isMouseOn) {
            draw.addMouseListener(this);
            draw.addMouseMotionListener(this);
        }

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Planche à Dessin");
        frame.pack();
        frame.requestFocusInWindow();
        frame.setVisible(true);
    }


    /**
     * Rôle : construit une {@code PlancheADessin} de la taille <em>l x h</em>
     * sans gestion  de la souris
     *
     * @param l largeur de la PlancheADessin
     * @param h hauteur de la PlancheADessin
     */
    public PlancheADessin(int l, int h) {
        this(l, h, false);
    }


    /**
     * Rôle : construit une {@code PlancheADessin} de la taille d'un
     * quart de l'écran sans gestion de souris
     */
    public PlancheADessin() {
        this(false);
    }

    /**
     * Rôle : construit une {@code PlancheADessin} de la taille d'un
     * quart de l'écran avec gestion ou non de la souris
     *
     * @param isMouseOn gestion de la souris ou non
     */
    public PlancheADessin(boolean isMouseOn) {
        this((int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2),
                (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2),
                isMouseOn);
    }

    /**
     * Rôle : redessine les objets sur la planche à dessins courante
     */
    public void redraw() {
        this.draw();
    }

    /*
     * Rôle : dessine les objets sur la planche à dessins courante
     */
    protected void draw() {
        clearOff(DEFAULT_CLEAR_COLOR);
        // trier selon la profondeur
        this.voad.sort((x, y) -> x.compareTo(y));
        // dessiner chacun des Dessinable de la liste voad
        for (Dessinable d : this.voad)
            d.dessiner(this);
        //
        onscreen.drawImage(offscreenImage, 0, 0, null);
        frame.repaint();
    }

    /**
     * Rôle : renvoie la largeur de la planche à dessin courante
     *
     * @return double
     */
    public double getLargeur() {
        return this.width;
    }

    /**
     * Rôle : renvoie la largeur de la planche à dessin courante
     *
     * @return double
     */
    public double getHauteur() {
        return this.height;
    }

    //
    // méthodes de rappel pour les auditeurs de souris
    //
    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    private Dessinable sélection;
    private double offX;
    private double offY;

    /**
     * Rôle : sélectionne un objet dessinable dans la planche à dessin
     * courante lorsque le bouton de la souris clique dessus.
     */
    @Override
    public void mousePressed(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        sélection = null;
        for (int i = this.voad.size() - 1; i >= 0; i--) {
            Dessinable d = this.voad.get(i);
            if (d.appartient(x, y)) {
                offX = x - d.getX();
                offY = y - d.getY();
                sélection = d;
                if (d.mp != null) {
                    d.mp.mousePressed(d, me);
                    this.redraw();
                }
                //
                return;
            }
        }
    }

    /**
     * Rôle : déplace l'objet dessinable sélectionné dans la planche à
     * dessin courante lorsqu'on déplace la souris
     */
    @Override
    public void mouseDragged(MouseEvent me) {
        if (sélection != null) {
            déplacer(sélection, me.getX() - offX, me.getY() - offY);
            if (sélection.md != null)
                sélection.md.mouseDragged(sélection, me);
        }
    }

    /**
     * Rôle : libère l'objet dessinable sélectionné
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        if (sélection != null && sélection.mr != null) {
            sélection.mr.mouseReleased(sélection, me);
            this.redraw();
            sélection = null;
        }
    }

    /**
     * Rôle : renvoie le numéro de version de la planche à dessin courante
     *
     * @return String
     */
    public String version() {
        return SERIAL_VERSION;
    }
}
