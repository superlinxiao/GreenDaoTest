package com.example.lizheng.greendaotest.many;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.example.lizheng.greendaotest.DaoSession;

/**
 * @author lizheng
 * create at 2019/2/27
 * description:
 * <p>
 * 一对多，指的StudentMany的id字段 对应 scoreMany的scoreManyId字段
 */
@Entity
public class StudentMany {
    @Id
    private String id;
    private String name;
    private int age;
    private String scoreId;
    @ToMany(referencedJoinProperty = "scoreManyId")
    private List<ScoreMany> score;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 2128523125)
    private transient StudentManyDao myDao;

    @Generated(hash = 215310612)
    public StudentMany(String id, String name, int age, String scoreId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.scoreId = scoreId;
    }

    @Generated(hash = 464826166)
    public StudentMany() {
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

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 355704553)
    public List<ScoreMany> getScore() {
        if (score == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ScoreManyDao targetDao = daoSession.getScoreManyDao();
            List<ScoreMany> scoreNew = targetDao._queryStudentMany_Score(id);
            synchronized (this) {
                if (score == null) {
                    score = scoreNew;
                }
            }
        }
        return score;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 681169439)
    public synchronized void resetScore() {
        score = null;
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
    @Generated(hash = 207151502)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentManyDao() : null;
    }
}

