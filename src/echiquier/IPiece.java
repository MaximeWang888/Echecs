package echiquier;

import java.util.List;

/**
 * Modélise une pièce basique.
 * @author  Fabien Rondan, Maxime Wang, Sebastien Ramirez
 * @version 1.0
 */
public interface IPiece {

    /**
     * Permet de connaître le type de la pièce
     * @return le type de la pièce
     */
    String getType();

    /**
     * Permet de savoir la couleur d'une pièce de l'echequier
     * @return Une couleur blanc ou noir
     */
    Couleur getCouleur();

    /**
     * Permet de connaître les coordonnées d'une pièce.
     * @return La coordonnée de la pièce
     */
    Coordonnee getCoordonnee();

    /**
     * Permet de fixer une nouvelle valeur à la coordonnée
     * @param coord la nouvelle coordonnée de la pièce
     */
    void setCoord(Coordonnee coord);

    /**
     * Permet de déplacer une pièce.
     * @param coordonnee la coordonnée de destination
     * @param echiquier l'échéquier sur lequel le déplacement de la pièce aura lieu
     */
    void deplacer(Coordonnee coordonnee, Echiquier echiquier);

    /**
     * Retourne une liste des différentes possibilités pour le déplacement d'une pièce
     * @param echiquier l'échequier sur lequel la pièce se trouvant
     * @return une liste des possibilités de déplacements d'une pièce
     */
    List<Coordonnee> listeDeplacement(Echiquier echiquier);

    /**
     * Permet de savoir si la pièce sur l'échequier est à nous
     * @param piece la pièce testée
     * @return True si la pièce est une pièce alliée, False dans le cas contraire.
     */
    boolean estAllie(IPiece piece);

    /**
     * Permet de savoir si le déplacement de la pièce vers la destination passée en paramètre est possible ou non
     * @param destination la coordonnee de destination de la piece
     * @return TRUE si le deplacement de la piece vers la destination est possible, FALSE dans le cas contraire
     */
    boolean isDeplacementPossible(Echiquier echiquier, Coordonnee destination, Couleur couleurJoueur,
                                  List<Coordonnee> listDeplacementDeMaPiece);

    /**
     * Permet de savoir si notre roi est en position d'echec ou non
     * @param echiquier l'echiquier sur lequel la vérification à lieu
     * @return TRUE si le roi est en position d'echec, FALSE dans le cas contraire
     */
    boolean craintEchec(Echiquier echiquier);

}
