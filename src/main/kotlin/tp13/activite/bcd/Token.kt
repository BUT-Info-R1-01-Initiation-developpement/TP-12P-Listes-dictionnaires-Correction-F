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
    private fun contenuNeContientPasSeparateur(): Boolean {
        for (c in this.contenu) {
            if (TextometrieOutils.caractereEstSeparateurDeToken(c)) {
                return false
            }
        }
        return true
    }
}
