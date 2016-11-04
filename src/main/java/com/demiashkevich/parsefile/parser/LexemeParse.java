package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.section.DivisibleTypeSection;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParse extends DivisibleParse {

    private static final String REGEX_LEXEME = "[\\S]+(\\r\\n)?";

    public LexemeParse(){
        nextParse = new WordAndSignParse();
        currentTypeSection = DivisibleTypeSection.LEXEME;
    }

    @Override
    protected List<String> partitionText(String sentence) {
        List<String> paragraphs = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_LEXEME);
        Matcher matcher = pattern.matcher(sentence);
        int indexStart = 0;
        while (matcher.find()){
            int indexEnd = matcher.end();
            String s = sentence.substring(indexStart, indexEnd);
            indexStart = indexEnd;
//            System.out.print(s);
            paragraphs.add(s);
        }
        return paragraphs;
    }
}
