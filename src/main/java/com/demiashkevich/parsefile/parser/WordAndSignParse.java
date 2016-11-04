package com.demiashkevich.parsefile.parser;

import com.demiashkevich.parsefile.entity.LeafSectionText;
import com.demiashkevich.parsefile.entity.SectionText;
import com.demiashkevich.parsefile.section.IndivisibleTypeSection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndSignParse extends Parse {

    private static final String REGEX_WORD = "[\\w]+";
    private static final String REGEX_SIGN_BEFORE_WORD = "^[^\\w]+";
    private static final String REGEX_SIGN_AFTER_WORD = "[^\\w]+$";

    public WordAndSignParse(){
    }

    @Override
    public SectionText parse(String lexeme, SectionText currentComposite) {
        SectionText signBeforeWord = this.createSign(lexeme, REGEX_SIGN_BEFORE_WORD);
        if(signBeforeWord != null){
            currentComposite.addSection(signBeforeWord);
        }
        SectionText word = this.createWord(lexeme);
        if(word != null){
            currentComposite.addSection(word);
        }
        SectionText signAfterWord = this.createSign(lexeme, REGEX_SIGN_AFTER_WORD);
        if(signAfterWord != null){
            currentComposite.addSection(signAfterWord);
        }

//        char[] symbols = lexeme.toCharArray();
//        StringBuilder word = new StringBuilder();
//        String sign;
//        for (int i = 0; i < symbols.length; i++) {
//            Character symbol = symbols[i];
//            if(Character.isLetter(symbol)){
//                word.append(symbol);
//            }else{
//                sign = String.valueOf(symbol);
//                SectionText signSection = new LeafSectionText(IndivisibleTypeSection.SIGN, sign);
//                currentComposite.addSection(signSection);
//            }
//        }
//        SectionText wordSection = new LeafSectionText(IndivisibleTypeSection.WORD, word.toString());
//        currentComposite.addSection(wordSection);


//        Pattern patternLexeme = Pattern.compile(REGEX_WORD_AND_SIGN);
//        Matcher matcherLexeme = patternLexeme.matcher(lexeme);
//        if(matcherLexeme.matches()){
//            Pattern patternWord = Pattern.compile(REGEX_WORD);
//            Matcher matcherWord = patternWord.matcher(lexeme);
//            if(matcherWord.find()) {
//                String word = lexeme.substring(matcherWord.start(), matcherWord.end());
//                SectionText wordSection = new LeafSectionText(IndivisibleTypeSection.WORD, word);
//                currentComposite.addSection(wordSection);
//            }
//
//            Pattern patternSign = Pattern.compile(REGEX_SIGN);
//            Matcher matcherSign = patternSign.matcher(lexeme);
//            if(matcherSign.find()) {
//                String sign = lexeme.substring(matcherSign.start(), matcherSign.end());
//                SectionText signSection = new LeafSectionText(IndivisibleTypeSection.SIGN, sign);
//                currentComposite.addSection(signSection);
//            }
//        }
//        else {
//            SectionText wordSection = new LeafSectionText(IndivisibleTypeSection.WORD, lexeme);
//            currentComposite.addSection(wordSection);
//        }
        return currentComposite;
    }

    private SectionText createSign(String lexeme, String REGEX){
        SectionText signSection = null;
        Pattern patternSign = Pattern.compile(REGEX);
            Matcher matcherSign = patternSign.matcher(lexeme);
            if(matcherSign.find()) {
                String sign = lexeme.substring(matcherSign.start(), matcherSign.end());
                signSection = new LeafSectionText(IndivisibleTypeSection.SIGN, sign);
            }
        return signSection;
    }

    private SectionText createWord(String lexeme){
        SectionText wordSection = null;
        Pattern patternWord = Pattern.compile(REGEX_WORD);
            Matcher matcherWord = patternWord.matcher(lexeme);
            if(matcherWord.find()) {
                String word = lexeme.substring(matcherWord.start(), matcherWord.end());
                wordSection = new LeafSectionText(IndivisibleTypeSection.WORD, word);

            }
        return wordSection;
    }
}
