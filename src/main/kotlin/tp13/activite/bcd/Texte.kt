package tp13.activite.bcd

import tp13.activite.bcd.TextometrieOutils.caractereEstSeparateurDeToken
import tp13.activite.bcd.TextometrieOutils.dernierCaractere
import kotlin.text.iterator

class Texte(val contenu: String) {
    val tokens: List<Token>
    init {
        this.tokens = this.listeTokens()
    }

    /**
    * Récupère les tokens d'un texte dans une liste triée
    * suivant l'ordre alphabétique.
    *
    * @return la liste contenant les tokens
    */
    private fun listeTokens(): List<Token> {
        if (this.contenu.length == 0) {
            return listOf<Token>()
        }
        val tokens = mutableListOf<Token>()
        var caracterePrecedentEstSeparateur = true
        var caractereCourantEstSeparateur: Boolean
        var tokenContenu = ""
        for (c in this.contenu) {
            caractereCourantEstSeparateur = caractereEstSeparateurDeToken(c)
            if (!caractereCourantEstSeparateur) {
                tokenContenu += c
            } else if (!caracterePrecedentEstSeparateur) {
                val tokenCourant = Token(tokenContenu)
                tokenCourant.insertIn(tokens)
                tokenContenu = ""
            }
            caracterePrecedentEstSeparateur = caractereCourantEstSeparateur
        }
        if (!caractereEstSeparateurDeToken(dernierCaractere(this.contenu))) { // cas du dernier caractère
            val tokenCourant = Token(tokenContenu)
            tokenCourant.insertIn(tokens)
        }
        return tokens.toList()
    }
}