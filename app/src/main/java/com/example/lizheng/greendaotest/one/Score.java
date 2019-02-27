package com.example.lizheng.greendaotest.one;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author lizheng
 * create at 2019/2/27
 * description:
 *
 *
 */
@Entity
public class Score {
    @Id
    private String id;
    private int score;

    @Generated(hash = 1043832192)
    public Score(String id, int score) {
        this.id = id;
        this.score = score;
    }

    @Generated(hash = 226049941)
    public Score() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
