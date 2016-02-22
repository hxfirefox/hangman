hangman game
============
# 简介

Hangman是一个非常有趣的猜字游戏，游戏双方可以是玩家或电脑，游戏中玩家或电脑准备一个单词，另一玩家尝试猜出该单词，当玩家猜错时，作为惩罚性措施，对方将画上一笔hangman的其中一个元素，当整个hangman完成时，游戏终止，玩家告负。

![hangman](https://en.wikipedia.org/wiki/Hangman_%28game%29#/media/File:Hangman.svg)
下面请简单实现该游戏，游戏需求如下：

# 需求
1. 游戏中玩家共有12次猜字机会，猜错一次，扣除一次机会，猜对则机会不减少，在游戏开始时显示
   rest chance: 12
2. 每次游戏开始时，会预先使用AEIOU进行匹配，作为单词提示，并输出
   used: AEIOU
3. 当AEIOU命中单词时，显示该单词出现的位置，未命中位置单词用"_"显示，例如：
   给定单词HANGMAN，在游戏开始时应显示：guess: _A___A_
4. 玩家开始猜字母后，猜测字母应显示在已使用字母中，例如
   给定单词HANGMAN，玩家猜测字母为P，则应显示used： AEIOUP
5. 当玩家在12次机会耗尽前猜出单词，则游戏结束，显示"You Win"
6. 当玩家在12次机会全部用尽仍未猜出单词，则游戏结束，显示"Game Over"
7. 游戏显示如下所示：
   rest chance: 12
   used: AEIOU
   guess: _A___A_
