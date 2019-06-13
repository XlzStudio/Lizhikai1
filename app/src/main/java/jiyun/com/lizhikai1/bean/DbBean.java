package jiyun.com.lizhikai1.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {
    @Id
    private  Long Id;
    @Property
    private String title;
    @Property
    private String pic;
    @Generated(hash = 1708704734)
    public DbBean(Long Id, String title, String pic) {
        this.Id = Id;
        this.title = title;
        this.pic = pic;
    }
    @Generated(hash = 1953169116)
    public DbBean() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }

}
