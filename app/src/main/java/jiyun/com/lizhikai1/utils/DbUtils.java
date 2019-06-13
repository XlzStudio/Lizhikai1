package jiyun.com.lizhikai1.utils;



import java.util.List;

import jiyun.com.lizhikai1.app.MyApp;
import jiyun.com.lizhikai1.bean.DbBean;
import jiyun.com.lizhikai1.dao.DaoMaster;
import jiyun.com.lizhikai1.dao.DaoSession;
import jiyun.com.lizhikai1.dao.DbBeanDao;

public class DbUtils {
    private static DbUtils dbUtils;
    private final DbBeanDao dbBeanDao;

    private DbUtils(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "xlz.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        dbBeanDao = daoSession.getDbBeanDao();
    }
    public static DbUtils getDbutils(){
        if (dbUtils==null){
            synchronized (DbUtils.class){
                if (dbUtils==null){
                    dbUtils=new DbUtils();
                }
            }
        }
        return dbUtils;
    }
    public void insert(DbBean dbBean){
        dbBeanDao.insertOrReplaceInTx(dbBean);
    }
    public void delete(DbBean dbBean){
        dbBeanDao.delete(dbBean);
    }
    public void updata(DbBean dbBean){
        dbBeanDao.update(dbBean);
    }
    public List<DbBean>queryAll(){
        return dbBeanDao.queryBuilder().list();
    }
}
