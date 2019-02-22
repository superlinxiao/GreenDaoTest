package com.example.lizheng.greendaotest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * @author lizheng
 * create at 2019/2/22
 * description:
 */
public class DaoHelper {

    private static DaoSession daoSession;

    /**
     * 配置数据库
     *
     * @param context
     */
    public static void setupDatabase(Context context) {
        //创建数据库shop.db"
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "shop.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }


    /**
     * 添加数据，如果有重复则覆盖
     *
     * @param shop
     */
    public static void insertLove(Shop shop) {
        daoSession.insertOrReplace(shop);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteLove(long id) {
        daoSession.getShopDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(Shop shop) {
        daoSession.getShopDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Shop> queryLove(int type) {
        return daoSession.getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(type)).list();
    }

    /**
     * 查询全部数据
     */
    public static List<Shop> queryAll() {
        return daoSession.getShopDao().loadAll();
    }
}
