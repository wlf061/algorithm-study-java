# algorithm-study-java
### chapter 系列是学习牛客网左大神的视频学习的算法
### datastructures 是 极客帮《数据结构和算法之美》：https://time.geekbang.org/column/126
- 13章. 线性排序:
   基数排序的适用场景：基数排序对排序的数据有要求， 要求可以分割出独立的"位"来比较，
   而且位之间有递进的关系，如果a数据的高位比b 数据大，那么剩下的低位就不用比较了。除此之外，
   每一位的数据范围不能太大，要可以用线性排序算法来排序，否则，基数排序的时间复杂度无法做到O（n）.
   举例：假设有10万个手机号码，手机号码有11位，如何排序？
     为了保证稳定的排序： 先按照最后一位来排序手机号码，然后再按照倒数第二位重新排序，
     以此类推，最后按照第一位重新排序。经过11次排序之后，手机号都有序了。
   实际上，有时候要排序的数据并不都是等长的。需要把所有的单词补齐到相同的长度，位数不够的可以考虑加0
### nlp 系列是自然语言中 常用的算法系列，学习 Hanlp.