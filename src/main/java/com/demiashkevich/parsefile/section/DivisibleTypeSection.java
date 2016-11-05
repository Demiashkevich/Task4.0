package com.demiashkevich.parsefile.section;

import java.util.EnumSet;
import java.util.Iterator;

public enum DivisibleTypeSection {
    TEXT("","",""), PARAGRAPH("\\t", "\\t", "\\r\\n"), SENTENCE("(?<=[.?!])\\s*", "", " "), LEXEME("[\\s]" ,"", " ");

    private String regex;
    private String valueSignSectionBefore;
    private String valueSignSectionAfter;

    DivisibleTypeSection(String regex, String valueSignSectionBefore, String valueSignSectionAfter) {
        this.regex = regex;
        this.valueSignSectionBefore = valueSignSectionBefore;
        this.valueSignSectionAfter = valueSignSectionAfter;
    }

    public DivisibleTypeSection nextTypeSection(DivisibleTypeSection currentTypeSection){
        EnumSet<DivisibleTypeSection> typesSection = EnumSet.allOf(DivisibleTypeSection.class);
        for(Iterator<DivisibleTypeSection> iterator = typesSection.iterator(); iterator.hasNext();){
            if(currentTypeSection.name().equalsIgnoreCase(iterator.next().name()) && iterator.hasNext()){
                return iterator.next();
            }
        }
        return null;
    }

    public String getRegex() {
        return regex;
    }

    public String getValueSignSectionAfter() {
        return valueSignSectionAfter;
    }

    public String getValueSignSectionBefore() {
        return valueSignSectionBefore;
    }
}
