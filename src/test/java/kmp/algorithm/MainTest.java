package kmp.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class MainTest {

    @Test
    void shouldFindWord() {
        // given
        String text = "abcabcdabcabdabcabcaa";
        String word = "abcabca";

        // when
        int index = Main.kmpSearch(text, word);

        // then
        then(index).isEqualTo(13);
    }

    @Test
    void shouldNotFindWord() {
        // given
        String text = "abcabcdabcabdacbacb";
        String word = "abcabca";

        // when
        int index = Main.kmpSearch(text, word);

        // then
        then(index).isEqualTo(-1);
    }
}