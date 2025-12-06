package tp13.activite.bcd

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TextometrieOutilsTest {

    val texteReference = "L’éléphant mange des pommes-de-terre ! Qu’est-ce qu’il aime ? Il n’aime pas… les carottes."

    @Test
    fun testRecupererTokensTexteReference() {
        val tokens = TextometrieOutils.tableauTokens(texteReference)
        assertEquals("L", tokens[0])
        assertEquals("éléphant", tokens[1])
        assertEquals("mange", tokens[2])
        assertEquals("des", tokens[3])
        assertEquals("pommes-de-terre", tokens[4])
        assertEquals("Qu", tokens[5])
        assertEquals("est-ce", tokens[6])
        assertEquals("qu", tokens[7])
        assertEquals("il", tokens[8])
        assertEquals("aime", tokens[9])
        assertEquals("Il", tokens[10])
        assertEquals("n", tokens[11])
        assertEquals("aime", tokens[12])
        assertEquals("pas", tokens[13])
        assertEquals("les", tokens[14])
        assertEquals("carottes", tokens[15])
        assertEquals("", tokens[16])
    }

    @Test
    fun testRecupererTokensTexteVide() {
        val tokens = TextometrieOutils.tableauTokens("")
        assertEquals("", tokens[0])
    }

    @Test
    fun testRecupererTokensCasBase() {
        val tokens = TextometrieOutils.tableauTokens("ab abcdefgh")
        assertEquals("ab", tokens[0])
        assertEquals("abcdefgh", tokens[1])
        assertEquals("", tokens[2])
    }

}