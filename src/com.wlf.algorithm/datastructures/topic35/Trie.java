package com.wlf.algorithm.datastructures.topic35;

/**
 * Created by NJLT004 on 2019/5/4.
 */

class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;

    public TrieNode(char data) {
        this.data = data;
    }
}

public class Trie {
    private TrieNode root = new TrieNode('/');
    public void inserNode(char[] text){
        TrieNode p = root;
        for(int index=0; index < text.length; index++){
            int pos = text[index] - 'a';
            if(p.children[pos] == null){
                TrieNode newNode = new TrieNode(text[pos]);
                p.children[pos] = newNode;
            }
            p = p.children[pos];
        }
        p.isEndingChar=true;
    }

    public boolean find(char[] pattern){
        TrieNode p = root;
        for(int i=0; i < pattern.length;i++){
            int index =  pattern[i] = 'a';
            if(p.children[index] == null)
                return false;
            p = p.children[index];
        }
        if(p.isEndingChar == false) return false;  //不能全部匹配，前缀匹配
        return true;
    }


}
