package com.seekerhut.utils.custombean.datagenerator;

import com.seekerhut.utils.EnumAndConstData.CharRangeKey;

import java.util.List;

public class FieldMetaData {
    private String stringFormatBase;
    private int[] elementLength;
    private List<List<CharRangeKey>> elementCharRanges;

    public String getStringFormatBase() {
        return stringFormatBase;
    }

    public void setStringFormatBase(String stringFormatBase) {
        this.stringFormatBase = stringFormatBase;
    }

    public int[] getElementLength() {
        if (elementLength.length != elementCharRanges.size()) {
            //throw new exception("param length mismatch!");
        }
        return elementLength;
    }

    public void setElementLength(int[] elementLength) {
        this.elementLength = elementLength;
    }

    public List<List<CharRangeKey>> getElementCharRanges() {
        if (elementLength.length != elementCharRanges.size()) {
            //throw new exception("param length mismatch!");
        }
        return elementCharRanges;
    }

    public void setElementCharRanges(List<List<CharRangeKey>> elementCharRanges) {
        this.elementCharRanges = elementCharRanges;
    }
}