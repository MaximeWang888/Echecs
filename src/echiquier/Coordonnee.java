package echiquier;

import static echiquier.Echiquier.HAUTEUR;
import static echiquier.Echiquier.LARGEUR;

/**
 * Modélise une coordonnée d'une pièce d'échecs.
 * @author  Fabien Rondan, Maxime Wang, Sebastien Ramirez
 * @version 1.0
 */
public class Coordonnee {

    /** Les coordonnées d'une pièce */
    private int x, y;

    /**
     * Constructeur à partir d'une colonne et d'une ligne
     * @param x la colonne d'une coordonnée
     * @param y la ligne d'une coordonnée
     */
    public Coordonnee(int x, int y) {
        assert (x < LARGEUR && x >= 0 && y < HAUTEUR && y >= 0);
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur vide initialisant les coordonnées à (0,0)
     */
    public Coordonnee(){
        this(0,0);
    }

    /**
     * Retourne la colonne de la pièce.
     * @return La colonne de la pièce.
     */
    public int getY() {
        return y;
    }

    /**
     * Retourne la ligne de la pièce.
     * @return La ligne de la pièce.
     */
    public int getX() {
        return x;
    }

    /**
     * Permet de savoir si les coordonnée son des coordonnées valide sur le plateau
     * @return True si les coordonnées son valide sinon return False
     */
    public boolean coordValide(){
        return this.y >= 0 && this.y < Echiquier.LARGEUR && this.x >= 0 && this.x < HAUTEUR;
    }

    /**
     * Convertie une chaine de deux caractères en coordonée
     * @param saisie La chaine de caractère a convertir
     * @return la coordonnée correspondant à la saisie passé en paramètre
     */
    public Coordonnee conversionEnCoord(String saisie){
        Coordonnee coordonnee = new Coordonnee();
        coordonnee.x = -1 ;
        coordonnee.y = -1 ;

        if(saisie.length()>= 2){
            coordonnee.y = HAUTEUR - Character.getNumericValue(saisie.charAt(1));
            switch (saisie.charAt(0)){
                case 'a': coordonnee.x = 0;
                    break;
                case 'b': coordonnee.x = 1;
                    break;
                case 'c': coordonnee.x = 2;
                    break;
                case 'd': coordonnee.x = 3;
                    break;
                case 'e': coordonnee.x = 4;
                    break;
                case 'f': coordonnee.x = 5;
                    break;
                case 'g': coordonnee.x = 6;
                    break;
                case 'h': coordonnee.x = 7;
                    break;
            }
        }
        return coordonnee;
    }

    /**
     * Affiche les coordonnées
     * @return les coordonnées
     */
    @Override
    public String toString() {
        return "Coordonnee{" +
                "colonne=" + x +
                ", ligne=" + y +
                '}';
    }

}