package com.example.lizheng.greendaotest;

import android.location.Address;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lizheng.greendaotest.many.ScoreMany;
import com.example.lizheng.greendaotest.many.ScoreManyDao;
import com.example.lizheng.greendaotest.many.StudentMany;
import com.example.lizheng.greendaotest.many.StudentManyDao;
import com.example.lizheng.greendaotest.one.Score;
import com.example.lizheng.greendaotest.one.ScoreDao;
import com.example.lizheng.greendaotest.one.Student;
import com.example.lizheng.greendaotest.one.StudentDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 知识点：
 * <p>
 * 1.基础使用
 * 2.1对1绑定
 * 3.1对多绑定
 * 4.多对多绑定
 * <p>
 * 5.多表查询-关联一个表
 * 6.多表查询-关联两个表
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private Shop mShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void delete(View view) {
        DaoHelper.deleteLove(2);
    }

    public void add(View view) {
        for (int i = 10; i > 0; i--) {
            Shop shop = new Shop();
            shop.setAddress("test" + 1);
            DaoHelper.insertLove(shop);
        }


        mShop = new Shop();
        mShop.setAddress("special");
        DaoHelper.insertLove(mShop);
    }

    public void update(View view) {
        mShop.setAddress("update");
        DaoHelper.updateLove(mShop);
    }

    public void query(View view) {
        List<Shop> shops = DaoHelper.queryLove(0);
        Toast.makeText(this, shops.size() + "", Toast.LENGTH_SHORT).show();
    }

    public void many(View view) {
        ScoreManyDao scoreDao = DaoHelper.getDaoInstant().getScoreManyDao();
        StudentManyDao studentDao = DaoHelper.getDaoInstant().getStudentManyDao();
//        先向数据库中插入两条数据
        for (int i = 0; i < 10; i++) {
            ScoreMany score = new ScoreMany("1101" + i, 80, "110");
            scoreDao.insertOrReplace(score);
        }
        StudentMany magicer = new StudentMany("110", "Magicer", 12, "1101");
        studentDao.insertOrReplace(magicer);
    }

    /**
     * 一对多，
     * 如果使用referencedJoinProperty，指的StudentMany的id字段 对应 scoreMany的scoreManyId字段
     * 如果使用 @ToMany(joinProperties = {
     *
     * @JoinProperty(name = "tag", referencedName = "customerTag")
     * })
     * 指的是指定的tag字段，对应customerTag外键，参看博客
     */
    public void manyGet(View view) {
        QueryBuilder<StudentMany> queryBuilder = DaoHelper.getDaoInstant().getStudentManyDao().queryBuilder().where(StudentManyDao.Properties.Name.eq("Magicer"));
        for (StudentMany student : queryBuilder.list()) {
            List<ScoreMany> score1 = student.getScore();
            Log.i(TAG, "onCreate: " + student.toString());
        }

    }


    public void one(View view) {
        ScoreDao scoreDao = DaoHelper.getDaoInstant().getScoreDao();
        StudentDao studentDao = DaoHelper.getDaoInstant().getStudentDao();
        Score score = new Score("1101", 80);
        scoreDao.insertOrReplace(score);
        Student magicer = new Student("110", "Magicer", 12, "1101");
        studentDao.insertOrReplace(magicer);

    }

    /**
     * 一对一，指的是当前joinPreperty指定的字段，对应score的id字段
     */
    public void oneGet(View view) {
        QueryBuilder<Student> queryBuilder = DaoHelper.getDaoInstant().getStudentDao().queryBuilder().where(StudentDao.Properties.Name.eq("Magicer"));
        for (Student student : queryBuilder.list()) {
            Score score = student.getScore();
            Log.i(TAG, "onCreate: " + student.toString());
        }
    }

//*******************关联单个表查询****************
//查询地址是住在迪拜大楼的用户
//QueryBuilder<User> queryBuilder = userDao.queryBuilder();
//queryBuilder.join(Address .class, AddressDao.Properties.userId)
//            .where(AddressDao.Properties.Street.eq("迪拜大楼"));
//    List<User> users = queryBuilder.list();

//*******************关联多个表查询****************

    //查询在欧洲人口超过100000的城市
//        //查询超过100000的城市
//        QueryBuilder qb = cityDao.queryBuilder().where(Properties.Population.ge(1000000));
//        //查询城市所在的国家id
//        Join country = qb.join(Properties.CountryId, Country.class);
//        //查询国家id所属的大陆
//        Join continent = qb.join(country, CountryDao.Properties.ContinentId,
//                Continent.class, ContinentDao.Properties.Id);
//        continent.where(ContinentDao.Properties.Name.eq("Europe"));
//        //得到结果
//        List<City> bigEuropeanCities = qb.list();

}
