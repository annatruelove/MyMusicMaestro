package com.example.joycezhong.game;

/**
 * Created by joycezhong on 2/11/17.
 */

public class Question {
    String _answer;
    String _question;
    int _soundFile;
    int _pic;

    public Question(String answer, String question, int soundFile, int pic) {
        _answer = answer;
        _question = question;
        _soundFile = soundFile;
        _pic = pic;
    }
}
