/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author huongnq2
 */
public class MagicDictionary {

    static List<String> hash(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char temp = chars[i];
            if (temp != '2') {
                chars[i] = '2';
                res.add(new String(chars));
                chars[i] = temp;
            }
        }
        return res;
    }

    public Map<String, Integer> mapMagic = new HashMap<>();
    public Map<String, Integer> mapNormal = new HashMap<>();


    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String disString : dictionary) {
            mapNormal.put(disString, Integer.MIN_VALUE);
            List<String> res = hash(disString);
            for (int i = 0; i < res.size(); i++) {
                if (mapMagic.containsKey(res.get(i))) {
                    mapMagic.put(res.get(i), 2);
                } else {
                    mapMagic.put(res.get(i), 1);
                }
            }
        }

    }

    public boolean search(String searchWord) {
        List<String> res = hash(searchWord);
        for (String s : res) {
            if (mapMagic.containsKey(s)) {
                if (mapNormal.containsKey(s) && mapMagic.get(s) == 2) {
                    return true;
                }
                if (!mapNormal.containsKey(s) && mapMagic.get(s) == 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        MagicDictionary obj = new MagicDictionary();
        obj.buildDict(new String[]{"hello"});
        System.out.println(obj.search("hello"));
        System.out.println(obj.search("hhllo"));
        System.out.println(obj.search("hell"));
        System.out.println(obj.search("leetcoded"));

    }
}
