package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.section.DivisibleTypeSection;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParse extends DivisibleParse {

    private static final String REGEX_SENTENCE = "(?<=[.?!])(\\s*|\\r\\n)";

    public SentenceParse(){
        nextParse = new LexemeParse();
        currentTypeSection = DivisibleTypeSection.SENTENCE;
    }

    @Override
    protected List<String> partitionText(String paragraph) {
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(paragraph);
        int indexStart = 0;
        while (matcher.find()){
            int indexEnd = matcher.end();
            String sentence = paragraph.substring(indexStart, indexEnd);
            indexStart = indexEnd;
//            System.out.print(sentence);
            sentences.add(sentence);
        }
        return sentences;
    }
}
