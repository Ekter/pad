package PaD;

import java.awt.event.*;

/**
 * Interface fonctionnelle qui décrit la fonction à appliquer
 * sur un Dessinable lorsqu'on le déplace
 */
@FunctionalInterface
public interface MouseDragged {
    /**
     * Cette méthode est appliquée sur un objet Dessinable
     * quand il est déplacé sur la planche à dessins
     *
     * @param d le Dessinable déplacé
     * @param e l'événement bouton souris
     */
    void mouseDragged(Dessinable d, MouseEvent e);
}
