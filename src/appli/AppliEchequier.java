package appli;

import echiquier.Coordonnee;
import echiquier.Echiquier;
import echiquier.IJoueur;
import echiquier.IPiece;
import echiquier.Couleur;

import fabrique.FabriqueJoueur;
import fabrique.FabriquePiece;

import joueur.TypeJoueur;
import piece.TypePiece;

/**
 * Modélise l'application lancant une partie entre deux joueurs.
 * @author  Fabien Rondan, Maxime Wang, Sebastien Ramirez
 * @version 1.0
 */
public class AppliEchequier {

    private static boolean estAuBlancDeJouer = true;

    public static void main(String[] args) {

        /* Initialise l'echiquier */
        Echiquier echiquier = initialiserPieces();

        /* Initialise une fabrique joueur */
        FabriqueJoueur fj = new FabriqueJoueur();

        /* Initialise les joueurs  */
        IJoueur joueurPBlanc = fj.creationJoueur(TypeJoueur.HUMAIN, Couleur.BLANC);
        IJoueur joueurPNoir = fj.creationJoueur(TypeJoueur.ROBOT, Couleur.NOIR);

        /* Le joueur qui jouera */
        IJoueur joueur = changerDeJoueur(joueurPBlanc, joueurPNoir, estAuBlancDeJouer);

        /* Le boolean indiquant si le roi est en position d'echec */
        boolean attentionRoiPresqueEnEchec = false;

        /* Le coup jouer par le joueur */
        String coup = "AUDEPARTCAPEUTETREDUNIMPORTEQUOISAUFVIDE";

        while (!echiquier.estPartieTerminee(joueur, coup)){
            attentionRoiPresqueEnEchec = isAttentionRoiPresqueEnEchec(echiquier, joueur);
            coup = echiquier.jouer(joueur, attentionRoiPresqueEnEchec);
            joueur = changerDeJoueur(joueurPBlanc, joueurPNoir, estAuBlancDeJouer);
        }
    }

    /**
     * Permet de savoir si le roi du joueur est en position d'echec
     * @param echiquier l'echiquier sur lequel les pieces du joueur se trouve
     * @param joueur le joueur qui joue
     * @return TRUE si le roi est en position d'echec, FALSE dans le cas contraire
     */
    private static boolean isAttentionRoiPresqueEnEchec(Echiquier echiquier, IJoueur joueur) {
        boolean attentionRoiPresqueEnEchec;
        attentionRoiPresqueEnEchec = echiquier.trouverRoi(joueur.getCouleur()).craintEchec(echiquier);
        if (attentionRoiPresqueEnEchec)
            System.out.println("attention ton roi est en danger \n");
        return attentionRoiPresqueEnEchec;
    }

    /**
     * Permet de changer le tour de jeu au joueur qui n'a pas encore joué
     * @param joueurBlanc le joueur blanc
     * @param joueurNoir le joueur noir
     * @param estAuBlancDeJouer le boolean indiquant si c'est au blanc de jouer
     * @return le joueur qui jouera
     */
    private static IJoueur changerDeJoueur(IJoueur joueurBlanc , IJoueur joueurNoir, Boolean estAuBlancDeJouer) {
        if (estAuBlancDeJouer) {
            AppliEchequier.estAuBlancDeJouer = false;
            return joueurBlanc;
        }else {
            AppliEchequier.estAuBlancDeJouer = true;
            return joueurNoir;
        }
    }

    /**
     * Permet d'initialiser un echiquier avec les pieces
     * @return l'echiquier avec les pieces initialisees dessus
     */
    private static Echiquier initialiserPieces(){
        Echiquier echiquier = new Echiquier();
        FabriquePiece fp = new FabriquePiece();

        IPiece roiB = fp.creationPiece(TypePiece.ROI, Couleur.BLANC, new Coordonnee(5,5));
        IPiece tourB = fp.creationPiece(TypePiece.TOUR, Couleur.BLANC, new Coordonnee(1,6));

        echiquier.ajoutPiece(roiB, roiB.getCoordonnee());
        echiquier.ajoutPiece(tourB, tourB.getCoordonnee());

        IPiece roiN = fp.creationPiece(TypePiece.ROI, Couleur.NOIR, new Coordonnee(5,7));

        echiquier.ajoutPiece(roiN, roiN.getCoordonnee());

        return echiquier;
    }


}
