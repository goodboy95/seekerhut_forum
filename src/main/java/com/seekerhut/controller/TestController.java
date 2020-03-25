package com.seekerhut.controller;

import com.alibaba.fastjson.JSONObject;
import com.seekerhut.utils.JedisHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "/api/test")
public class TestController extends BaseController {
    @RequestMapping(value = "base_test", method = RequestMethod.GET)
    public @ResponseBody String baseTest(@RequestParam String begin, @RequestParam String end, @RequestParam String wordStr) {
        List<String> words = Arrays.asList(wordStr.split(","));
        int res = ladderLength(begin, end, words);
        var x = new HashMap<Character, Integer>();
        x.
        return Success(res);
    }

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create graph
        int wordNum = wordList.size();
        int begin = -1, end = -1;
        StringBuilder sb = new StringBuilder("dedede");
        sb.
        ArrayList<ArrayList<Integer>> wordGraph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < wordNum; i++) {
            wordGraph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < wordNum; i++) {
            String curWord = wordList.get(i);
            if (beginWord.equals(curWord)) {
                begin = i;
            }
            if (endWord.equals(curWord)) {
                end = i;
            }
            for (int j = 0; j < wordNum; j++) {
                String targetWord = wordList.get(j);
                if (j != i && isNextTo(curWord, targetWord)) {
                    wordGraph.get(i).add(j);
                    wordGraph.get(j).add(i);
                }
            }
        }
        System.out.println(JSONObject.toJSONString(wordGraph));
        // solve by BFS
        if (begin < 0 || end < 0) {
            return 0;
        }
        Queue<AntClass> ants = new LinkedList<AntClass>();
        ants.add(new AntClass(begin));
        while (ants.size() > 0) {
            AntClass curAnt = ants.poll();
            if (curAnt.curPos == end) {
                return curAnt.visited.size();
            }
            ArrayList<Integer> nextUps = wordGraph.get(curAnt.curPos);
            for (int i : nextUps) {
                AntClass newAnt = new AntClass(i, curAnt);
                if (newAnt.isValid) {
                    ants.offer(newAnt);
                }
            }
        }
        return 0;
    }

    private Boolean isNextTo(String s1, String s2) {
        Boolean hasDiff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                if (hasDiff) {
                    return false;
                } else {
                    hasDiff = true;
                }
            }
        }
        return true;
    }

    class AntClass {
        public int curPos;
        public HashSet<Integer> visited;
        public Boolean isValid;
        public AntClass(int pos) {
            curPos = pos;
            visited = new HashSet<Integer>();
            visited.add(pos);
            isValid = true;
        }
        public AntClass(int pos, AntClass oldAnt) {
            curPos = pos;
            visited = oldAnt.visited;
            if (visited.contains(pos)) {
                isValid = false;
            } else {
                visited.add(pos);
                isValid = true;
            }

        }
    }
}
