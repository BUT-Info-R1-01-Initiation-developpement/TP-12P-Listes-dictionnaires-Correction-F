package tp13.activite.bcd

data class Token(val contenu: String) {
    val longueur = contenu.length

    init {
        require(this.contenu.isNotEmpty()) { "Un token ne peut pas être vide" }
        require(this.contenuNeContientPasSeparateur()) { "Un token ne peut pas contenir de séparateur." }
    }

    /**
     * Compare le token courant au token passé en paramètre suivant l'ordre alphabétique.
     *
     * @param autre le Token à comparer.
     * @return 0 si égaux, une valeur strict. négative si token courant avant token autre,
     * strict. positive si token courant après token autre.
     */
    fun compareTo(autre: Token): Int {
        return this.contenu.compareTo(autre.contenu)
    }

    /**
     * Insert le token courant dans la liste triée passée en paramètre.
     * Le token courant est inséré de manière à préserver l'ordre alphabétique.
     *
     * @param tokens la liste de tokens dans laquelle on doit insérer le token courant.
     */
    fun insertIn(tokens: MutableList<Token>) {
        tokens.add(this)
        // extrait algo tri par insertion
        val i = tokens.size-1
        val elementAInserer = tokens[i] // this
        var j = i - 1
        // Décaler les éléments plus grands vers la droite
        while (j >= 0 && tokens[j].compareTo(elementAInserer) > 0) {
            tokens[j + 1] = tokens[j]
            j--
        }
        // Insérer l'élément à sa place
        tokens[j + 1] = elementAInserer
    }

    private fun contenuNeContientPasSeparateur(): Boolean {
        for (c in this.contenu) {
            if (TextometrieOutils.caractereEstSeparateurDeToken(c)) {
                return false
            }
        }
        return true
    }
}
