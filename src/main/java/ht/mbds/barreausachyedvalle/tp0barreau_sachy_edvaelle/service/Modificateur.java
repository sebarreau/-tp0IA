package ht.mbds.barreausachyedvalle.tp0barreau_sachy_edvaelle.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.Locale;

/**
 * Classe de service pour les modificateurs de question.
 * Un modificateur de question prend en entrée une question et retourne
 * la question modifiée.
 */
@Dependent
public class Modificateur implements Serializable {

    /**
     * Modificateur de question.
     * @param question La question à modifier.
     * @param roleSysteme Le rôle système à utiliser pour la modification de la question.
     * @return La réponse générée selon le contenu de la question.
     */
    public String modifier(String question, String roleSysteme) {
        if (question == null || question.isEmpty()) {
            return "||Veuillez poser une question.||";
        }

        String q = question.toLowerCase(Locale.FRENCH);
        String reponse;

        if (q.contains("belle")) {
            reponse = "Bien sûr, chacun a sa propre beauté !";
        } else if (q.contains("travail")) {
            reponse = "Le travail est important pour réussir.";
        } else if (q.contains("fatigu")) {
            reponse = "Repose-toi un peu pour récupérer de l'énergie.";
        } else {
            reponse = "Je ne suis pas sûr, mais continue d'avancer.";
        }

        if (roleSysteme != null && !roleSysteme.isBlank()) {
            return "||" + roleSysteme.toUpperCase(Locale.FRENCH) + "\n" + reponse + "||";
        }

        return "||" + reponse + "||";
    }
}