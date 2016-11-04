package com.demiashkevich.parsefile.action;

import com.demiashkevich.parsefile.entity.CompositeSectionText;
import com.demiashkevich.parsefile.entity.SectionText;
import com.demiashkevich.parsefile.parser.ParagraphParse;
import com.demiashkevich.parsefile.parser.Parse;
import com.demiashkevich.parsefile.section.DivisibleTypeSection;

public class ParseAction {

    public SectionText parseFile(String text){
        Parse paragraphParse = new ParagraphParse();
        return paragraphParse.parse(text, new CompositeSectionText(DivisibleTypeSection.TEXT));
    }
}
