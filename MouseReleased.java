package PaD;

import java.awt.event.*;
/**
 * Interface fonctionnelle qui décrit la fonction à appliquer
 * sur un Dessinable lorsqu'on relâche le bouton qui l'a sélectionné
 */
@FunctionalInterface
public interface MouseReleased {
    /**
     * Cette méthode est appliquée sur un objet Dessinable
     * lorsque un bouton de souris est relâché
     *
     * @param d le Dessinable sur lequel le bouton de souris est relâché
     * @param e l'événement bouton souris
     */
    void mouseReleased(Dessinable d, MouseEvent e);
}
