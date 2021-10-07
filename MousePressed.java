package PaD;

import java.awt.event.*;

/**
 * Interface fonctionnelle qui décrit la fonction à appliquer
 * sur un Dessinable lorsqu'on clique dessus
 */
@FunctionalInterface
public interface MousePressed {
    /**
     * Cette méthode est appliquée quand un bouton de souris est
     * appuyé sur un objet Dessinable
     *
     * @param d le Dessinable sur lequel on a cliqué
     * @param e l'événement bouton souris
     */
    void mousePressed(Dessinable d, MouseEvent e);
}
