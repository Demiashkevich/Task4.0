package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.section.DivisibleTypeSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParagraphParse extends DivisibleParse {

    private static final String REGEX_PARAGRAPH = "\\t";

    public ParagraphParse(){
        nextParse = new SentenceParse();
        currentTypeSection = DivisibleTypeSection.PARAGRAPH;
        valueSignSectionBefore = "\t";
        valueSignSectionAfter = "\r\n";
    }

    @Override
    protected List<String> partitionText(String text) {
        List<String> paragraphs = new ArrayList<>();
        paragraphs.addAll(Arrays.asList(text.split(REGEX_PARAGRAPH)));
        return paragraphs;
    }
}
