package com.wane.data.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
@SQLDelete(sql = "UPDATE ${entityName} SET deleted_at = NOW() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt = null;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
