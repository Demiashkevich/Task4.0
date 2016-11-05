package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.section.DivisibleTypeSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceParse extends DivisibleParse {

    private static final String REGEX_SENTENCE = "(?<=[.?!])\\s*";

    public SentenceParse(){
        nextParse = new LexemeParse();
        currentTypeSection = DivisibleTypeSection.SENTENCE;
        valueSignSectionBefore = "";
        valueSignSectionAfter = " ";
    }

    @Override
    protected List<String> partitionText(String paragraph) {
        List<String> sentences = new ArrayList<>();
        sentences.addAll(Arrays.asList(paragraph.split(REGEX_SENTENCE)));
        return sentences;
    }
}
