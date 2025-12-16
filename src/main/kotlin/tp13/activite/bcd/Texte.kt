package tp13.activite.bcd

import tp13.activite.bcd.TextometrieOutils.caractereEstSeparateurDeToken
import tp13.activite.bcd.TextometrieOutils.dernierCaractere
import kotlin.text.iterator

/**
 * Classe décrivant les objets de type Texte
 */
class Texte(val contenu: String) {
    val tokens: List<Token>
    private val tokensAvecOccurences: Map<Token, Int>

    init {
        val res = this.buildListeEtMapTokens()
        this.tokens = res.first
        this.tokensAvecOccurences = res.second
    }

    /**
     * Récupère les tokens d'un texte dans une liste.
     *
     * @return la liste contenant les tokens
     */
    private fun buildListeEtMapTokens(): Pair<List<Token>, Map<Token, Int>> {
        if (this.contenu.length == 0) {
            return Pair(listOf(), mapOf())
        }
        val tokens = mutableListOf<Token>()
        val tokensAvecOccurences = mutableMapOf<Token, Int>()

        var caracterePrecedentEstSeparateur = true
        var caractereCourantEstSeparateur: Boolean
        var token = ""
        for (c in this.contenu) {
            caractereCourantEstSeparateur = caractereEstSeparateurDeToken(c)
            if (!caractereCourantEstSeparateur) {
                token += c
            } else if (!caracterePrecedentEstSeparateur) {
                val tokenCourant = Token(token)
                tokenCourant.insertIn(tokens) // insert le token courant dans la liste des tokens
                tokensAvecOccurences[tokenCourant] = tokensAvecOccurences.getOrDefault(tokenCourant, 0) + 1
                token = ""
            }
            caracterePrecedentEstSeparateur = caractereCourantEstSeparateur
        }
        if (!caractereEstSeparateurDeToken(dernierCaractere(this.contenu))) { // cas du dernier caractère
            val tokenCourant = Token(token)
            tokenCourant.insertIn(tokens) // insert le dernier token si besoin
            tokensAvecOccurences[tokenCourant] = tokensAvecOccurences.getOrDefault(tokenCourant, 0) + 1
        }
        return Pair(tokens, tokensAvecOccurences)
    }


    /**
     * Retourne le nombre d'occurences d'un token dans le texte.
     *
     * @param token le token dont on veut le nombre d'occurences.
     * @return le nombre d'occurences du token (0 si non présent).
     */
    fun nombreOccurrences(token: Token): Int {
        return this.tokensAvecOccurences.getOrDefault(token, 0)
    }

    /**
     * Retourne le nombre d'occurences d'un token dans le texte.
     *
     * @param token le token dont on veut le nombre d'occurences.
     * @return le nombre d'occurences du token (0 si non présent).
     */
    fun nombreOccurrencesSansMap(token: Token): Int {
        var compteur = 0
        for (t in this.tokens) {
            if (token == t) { // == OK car Token est une data class
                compteur++
            }
        }
        return compteur
    }
}