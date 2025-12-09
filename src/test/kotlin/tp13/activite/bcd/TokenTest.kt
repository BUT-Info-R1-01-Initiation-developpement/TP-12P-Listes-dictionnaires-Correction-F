package tp13.activite.bcd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TokenTest {

    // === Tests de création et validation

    @Test
    fun `test contenu ne peut pas être vide`() {
        assertThrows<IllegalArgumentException> {
            Token("")
        }
    }
    @Test
    fun `test contenu ne peut pas contenir de séparateur de tokens`() {
        assertThrows<IllegalArgumentException> {
            Token("\n")
        }
        assertThrows<IllegalArgumentException> {
            Token("avv vvv")
        }
        assertThrows<IllegalArgumentException> {
            Token(".")
        }
        assertThrows<IllegalArgumentException> {
            Token("!")
        }
        assertThrows<IllegalArgumentException> {
            Token("'")
        }
    }

    @Test
    fun `test contenu et taille sur token valide`() {
        val tok = Token("abcde")
        assertEquals("abcde", tok.contenu)
        assertEquals(5, tok.longueur)
    }

        //=== Tests de comparaison alphabétique de deux tokens

        @Test
        fun `test la comparaison alphabétique de deux tokens différents`() {
            val token1 = Token("abcd")
            val token2 = Token("bcde")
            assertTrue(token1.compareTo(token2) < 0)
            assertTrue(token2.compareTo(token1) > 0)
        }

        @Test
        fun `test la comparaison alphabétique de deux tokens égaux en contenu`() {
            val token1 = Token("abcd")
            val token2 = Token("abcd")
            assertTrue(token1.compareTo(token2) == 0)
            assertTrue(token2.compareTo(token1) == 0)
        }

        //=== Tests l'insertion d'un token dans une liste triée

        @Test
        fun `test l'insertion dans une liste de tokens triées (au milieu)`() {
            val tokens = mutableListOf(Token("abcd"), Token("accd"), Token("adcd"))
            val tokenAInserer = Token("acbcd")
            tokenAInserer.insertIn(tokens)
            println(tokens)
            assertEquals(4, tokens.size)
            assertEquals(Token("abcd"), tokens[0])
            assertEquals(Token("acbcd"), tokens[1])
            assertEquals(Token("accd"), tokens[2])
            assertEquals(Token("adcd"), tokens[3])
        }

        @Test
        fun `test l'insertion dans une liste de tokens triées (en dernier)`() {
            val tokens = mutableListOf(Token("abcd"), Token("accd"), Token("adcd"))
            val tokenAInserer = Token("aecbcd")
            tokenAInserer.insertIn(tokens)
            println(tokens)
            assertEquals(4, tokens.size)
            assertEquals(Token("abcd"), tokens[0])
            assertEquals(Token("accd"), tokens[1])
            assertEquals(Token("adcd"), tokens[2])
            assertEquals(Token("aecbcd"), tokens[3])
        }

        @Test
        fun `test l'insertion dans une liste de tokens triées (en premier)`() {
            val tokens = mutableListOf(Token("abcd"), Token("accd"), Token("adcd"))
            val tokenAInserer = Token("aacbcd")
            tokenAInserer.insertIn(tokens)
            println(tokens)
            assertEquals(4, tokens.size)
            assertEquals(Token("aacbcd"), tokens[0])
            assertEquals(Token("abcd"), tokens[1])
            assertEquals(Token("accd"), tokens[2])
            assertEquals(Token("adcd"), tokens[3])
        }
}