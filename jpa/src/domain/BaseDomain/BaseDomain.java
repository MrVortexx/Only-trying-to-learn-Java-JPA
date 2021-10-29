package domain.BaseDomain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Index;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@MappedSuperclass
@Table(indexes = @Index(columnList = "uuid"))
public abstract class BaseDomain implements Serializable {

    private static final long serialVersionUID = 21341202003210391L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id")
    private Long id;

    @Column(name="uuid", length=64, unique=true, nullable=false, updatable = false)
    private String uuid;    

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable = false, updatable = false)
    private Date createdAt;

    @PrePersist
    public void beforeCreate(){
        if(getUuid() == null){
            setUuid(UUID.randomUUID().toString());
        }
        if(getCreatedAt() == null){
            this.createdAt = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }
}
