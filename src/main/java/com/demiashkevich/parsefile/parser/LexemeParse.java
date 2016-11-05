package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.section.DivisibleTypeSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexemeParse extends DivisibleParse {

    private static final String REGEX_LEXEME = "[\\s]";

    public LexemeParse(){
        nextParse = new WordAndSignParse();
        currentTypeSection = DivisibleTypeSection.LEXEME;
        valueSignSectionBefore = "";
        valueSignSectionAfter = " ";
    }

    @Override
    protected List<String> partitionText(String sentence) {
        List<String> lexemes = new ArrayList<>();
        lexemes.addAll(Arrays.asList(sentence.split(REGEX_LEXEME)));
        return lexemes;
    }
}