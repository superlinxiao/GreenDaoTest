package com.example.lizheng.greendaotest.one;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.example.lizheng.greendaotest.DaoSession;

/**
 * @author lizheng
 * create at 2019/2/27
 * description:
 * <p>
 * 一对一，指的是当前joinPreperty指定的字段，对应score的id字段
 */
@Entity
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
    private String scoreId;
    @ToOne(joinProperty = "scoreId")
    private Score score;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;

    @Generated(hash = 969993200)
    public Student(String id, String name, int age, String scoreId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.scoreId = scoreId;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getScoreId() {
        return this.scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    @Generated(hash = 1761141606)
    private transient String score__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1205688158)
    public Score getScore() {
        String __key = this.scoreId;
        if (score__resolvedKey == null || score__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ScoreDao targetDao = daoSession.getScoreDao();
            Score scoreNew = targetDao.load(__key);
            synchronized (this) {
                score = scoreNew;
                score__resolvedKey = __key;
            }
        }
        return score;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 205861525)
    public void setScore(Score score) {
        synchronized (this) {
            this.score = score;
            scoreId = score == null ? null : score.getId();
            score__resolvedKey = scoreId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }
}

