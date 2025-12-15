package tp13.activite.bcd

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TexteTest {

    val texteReference = Texte("L’éléphant mange des pommes-de-terre ! Qu’est-ce qu’il aime ? Il n’aime pas… les carottes.")

    // === Tests sur tokens

    @Test
    fun testListeTokensTexteReference() {
        val tokens = texteReference.tokens
        println(tokens.toString())
        assertEquals(16, tokens.size)
        assertEquals("Il", tokens[0].contenu)
        assertEquals("L", tokens[1].contenu)
        assertEquals("Qu", tokens[2].contenu)
        assertEquals("aime", tokens[3].contenu)
        assertEquals("aime", tokens[4].contenu)
        assertEquals("carottes", tokens[5].contenu)
        assertEquals("des", tokens[6].contenu)
        assertEquals("est-ce", tokens[7].contenu)
        assertEquals("il", tokens[8].contenu)
        assertEquals("les", tokens[9].contenu)
        assertEquals("mange", tokens[10].contenu)
        assertEquals("n", tokens[11].contenu)
        assertEquals("pas", tokens[12].contenu)
        assertEquals("pommes-de-terre", tokens[13].contenu)
        assertEquals("qu", tokens[14].contenu)
        assertEquals("éléphant", tokens[15].contenu)
    }

    @Test
    fun testListeTokensTexteVide() {
        val tokens = Texte("").tokens
        assertTrue(tokens.isEmpty())
    }

    @Test
    fun testListeTokensCasBase() {
        val tokens = Texte("az abcdefgh").tokens
        assertEquals("az", tokens.last().contenu)
        assertEquals("abcdefgh", tokens.first().contenu)
        assertEquals(2, tokens.size)
    }
    /*
        // === Tests sur nombre occurrences

        @Test
        fun `test le nombre de token sur le texte de référence (sans map)`() {
            assertEquals(0, texteReference.nombreOccurrencesSansMap(Token("chat")))
            assertEquals(1, texteReference.nombreOccurrencesSansMap(Token("éléphant")))
            assertEquals(2, texteReference.nombreOccurrencesSansMap(Token("aime")))
        }

        @Test
        fun `test le nombre de token sur le texte de référence`() {
            assertEquals(0, texteReference.nombreOccurrences(Token("chat")))
            assertEquals(1, texteReference.nombreOccurrences(Token("éléphant")))
            assertEquals(2, texteReference.nombreOccurrences(Token("aime")))
        }
    */
}