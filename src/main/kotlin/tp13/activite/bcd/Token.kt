package tp13.activite.bcd

data class Token(val contenu: String) {
    val longueur = contenu.length

    init {
        require(this.contenu.isNotEmpty()) { "Un token ne peut pas être vide" }
        require(this.contenuNeContientPasSeparateur()) { "Un token ne peut pas contenir de séparateur." }
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
