package com.seekerhut.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.seekerhut.utils.EnumAndConstData.CharRangeKey;
import com.seekerhut.utils.custombean.datagenerator.FieldMetaData;

import io.netty.util.internal.ThreadLocalRandom;

public class CommonFunctions {
    private static String charIndex = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+`-=abcdefghijklmnopqrstuvwxyz{}:|<>?[];',./";
    private static HashMap<CharRangeKey, String> charInRange;
    private static HashMap<String, String> cachedCharRange;
    private static HashMap<Long, Long> prevRandSeedMap;

    static {
        prevRandSeedMap = new HashMap<Long, Long>();
        cachedCharRange = new HashMap<String, String>();
        charInRange = new HashMap<CharRangeKey, String>();
        charInRange.put(CharRangeKey.number, "0123456789");
        charInRange.put(CharRangeKey.lowercase, "abcdefghijklmnopqrstuvwxyz");
        charInRange.put(CharRangeKey.uppercase, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        charInRange.put(CharRangeKey.symbol, "~!@#$%^&*()_+`-={}:|<>?[];',./");
        charInRange.put(CharRangeKey.wordchar, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_abcdefghijklmnopqrstuvwxyz");
        charInRange.put(CharRangeKey.chinese, "的一国在人了有中是年和大业不为发会工经上地市要个产这出行作生家以成到日民来我部对进多全建他公开们场展时理新方主企资实学报制政济用同于法高长现本月定化加动合品重关机分力自外者区能设后就等体下万元社过前面农也得与说之员而务利电文事可种总改三各好金第司其从平代当天水省提商十管内小技位目起海所立已通入量子问度北保心还科");
    }

    public static String generateRandomString(int length) {
        return stringGenBase(length, charIndex);
    }

    public static String generateRandomString(int length, List<CharRangeKey> rangeKeys) {
        String rangeKeyStr = String.join(",", rangeKeys.stream().map(r -> r.toString()).collect(Collectors.toList()));
        String charRange = "";
        if (!cachedCharRange.containsKey(rangeKeyStr)) {
            for (CharRangeKey r : rangeKeys) {
                charRange += charInRange.get(r);
            }
            cachedCharRange.put(rangeKeyStr, charRange);
        } else {
            charRange = cachedCharRange.get(rangeKeyStr);
        }
        return stringGenBase(length, charRange);
    }

    private static String stringGenBase(int length, String charRange) {
        StringBuilder sb = new StringBuilder();
        int rangeLen = charRange.length();
        // Generate random seed, guaranteed to be different every time we generate.
        long randSeedBase = System.nanoTime();
        long threadId = Thread.currentThread().getId();
        long randSeed = randSeedBase ^ (threadId << 32);
        if (prevRandSeedMap.containsKey(threadId) && prevRandSeedMap.get(threadId).equals(randSeed)) {
            randSeed += 10; // you can add whatever you want except zero.
        }
        prevRandSeedMap.put(threadId, randSeed);
        Random r = new Random(randSeed);
        for (int i = 0; i < length; i++) {
            int idx = r.nextInt(rangeLen);
            sb.append(charRange.charAt(idx));
        }
        return sb.toString();
    }

    public static HashMap<String, String> generateQueryDataByConfig(HashMap<String, FieldMetaData> config)
    {
        HashMap<String, String> result = new HashMap<String, String>();
        for (String key : config.keySet()) {
            FieldMetaData data = config.get(key);
            String strBase = data.getStringFormatBase();
            int[] elementLen = data.getElementLength();
            List<List<CharRangeKey>> rangeKeys = data.getElementCharRanges();
            ArrayList<String> elements = new ArrayList<String>();
            for (int i = 0; i < elementLen.length; i++) {
                elements.add(generateRandomString(elementLen[i], rangeKeys.get(i)));
            }
            String curValue = String.format(strBase, elements.toArray(Object[]::new));
            result.put(key, curValue);
        }
        return result;
    }
}
