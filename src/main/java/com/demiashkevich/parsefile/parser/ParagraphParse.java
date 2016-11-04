package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.section.DivisibleTypeSection;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParse extends DivisibleParse {

    private static final String REGEX_PARAGRAPH = "(\\t|\\s{4})+.+(\\r\\n=?)";


    public ParagraphParse(){
        nextParse = new SentenceParse();
        currentTypeSection = DivisibleTypeSection.PARAGRAPH;
    }

    @Override
    protected List<String> partitionText(String text) {
        List<String> paragraphs = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String paragraph = matcher.group();
            paragraphs.add(paragraph);
        }
        return paragraphs;
    }
}
