package com.example.lizheng.greendaotest.many;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @author lizheng
 * create at 2019/2/27
 * description:
 */
@Entity
public class ScoreMany {
    @Id
    private String id;
    private int score;
    private String scoreManyId;
    @Generated(hash = 169432512)
    public ScoreMany(String id, int score, String scoreManyId) {
        this.id = id;
        this.score = score;
        this.scoreManyId = scoreManyId;
    }
    @Generated(hash = 911606384)
    public ScoreMany() {
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
    public String getScoreManyId() {
        return this.scoreManyId;
    }
    public void setScoreManyId(String scoreManyId) {
        this.scoreManyId = scoreManyId;
    }
}
