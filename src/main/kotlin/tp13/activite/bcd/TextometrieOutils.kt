package tp13.activite.bcd

object TextometrieOutils {

    /**
     * Récupère les tokens d'un texte dans un tableau.
     *
     * @param texte Le texte dont on veut récupérer les tokens.
     * @return le tableau contenant les tokens.
     */
    fun tableauTokens(texte: String): Array<String> {
        if (texte.length == 0) {
            return arrayOf("")
        }
        val tokens = Array(texte.length) {""}
        var caracterePrecedentEstSeparateur = true
        var caractereCourantEstSeparateur: Boolean
        var token = ""
        var compteurToken = 0
        for (c in texte) {
            caractereCourantEstSeparateur = caractereEstSeparateurDeToken(c)
            if (!caractereCourantEstSeparateur) {
                token += c
            } else if (!caracterePrecedentEstSeparateur) {
                tokens[compteurToken] = token
                compteurToken++
                token = ""
            }
            caracterePrecedentEstSeparateur = caractereCourantEstSeparateur
        }
        if (!caractereEstSeparateurDeToken(dernierCaractere(texte))) { // cas du dernier caractère
            tokens[compteurToken] = token
        }
        return tokens
    }

    /**
    * Récupère les tokens d'un texte dans une liste.
    * @param texte Le texte dont on veut récupérer les tokens.
    * @return la liste contenant les tokens.
    */
    fun listeTokens(texte: String): List<String> {
        if (texte.length == 0) {
            return listOf<String>()
        }
        val tokens = mutableListOf<String>()
        var caracterePrecedentEstSeparateur = true
        var caractereCourantEstSeparateur: Boolean
        var token = ""
        for (c in texte) {
            caractereCourantEstSeparateur = caractereEstSeparateurDeToken(c)
            if (!caractereCourantEstSeparateur) {
                token += c
            } else if (!caracterePrecedentEstSeparateur) {
                tokens.add(token)
                token = ""
            }
            caracterePrecedentEstSeparateur = caractereCourantEstSeparateur
        }
        if (!caractereEstSeparateurDeToken(dernierCaractere(texte))) { // cas du dernier caractère
            tokens.add(token)
        }
        return tokens.toList()
    }

    /**
     * Teste si un carcatère est un séparateur de token.
     *
     * @param caractere le caractère à tester.
     *
     * @return true si le caractère est un séparateur de caractère, false sinon.
     */
    fun caractereEstSeparateurDeToken(caractere: Char): Boolean {
        return caractereEstEspace(caractere) ||
                caractereEstPonctuation(caractere) ||
                caractereEstApostrophe(caractere)
    }

    /**
     * Retourne le dernier caractère d'un texte.
     *
     * @param texte le texte dont on veut le dernier caractère.
     * @return le dernier caractère du texte.
     */
    fun dernierCaractere(texte: String): Char {
        return texte[texte.length - 1]
    }

    /**
     * Teste si un caractère est un caractère d'espacement.
     *
     * @param caractere le caractère testé.
     * @return true si le caractère est un espacement, false sinon.
     */
    fun caractereEstEspace(caractere: Char): Boolean {
        return caractere == ' ' || caractere == '\t' || caractere == '\r' || caractere == '\n'
    }

    /**
     * Teste si un caractère est un caractère de ponctuation.
     *
     * @param caractere le caractère testé.
     * @return true si le caractère est une ponctuation, false sinon.
     */
    fun caractereEstPonctuation(caractere: Char): Boolean {
        return caractere == '.' || caractere == '!' || caractere == '?'
                || caractere == ',' || caractere == ';' || caractere == ':' || caractere == '…'
    }

    /**
     * Teste si un caractère est une apostrophe.
     *
     * @param caractere le caractère testé.
     * @return true si le caractère est une apostrophe, false sinon.
     */
    fun caractereEstApostrophe(caractere: Char): Boolean {
        return caractere == '\'' || caractere == '’'
    }
}


