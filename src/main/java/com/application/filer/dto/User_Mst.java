package com.application.filer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="user_mst")
public class User_Mst {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long user_id;
    private String user_name;
    private String user_email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String user_pasasword_hash;
    private String user_full_name;
    private Date user_dob;
    private Timestamp user_crt_date;
    private Timestamp user_updt_date;
    private Boolean user_is_active;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pasasword_hash() {
        return user_pasasword_hash;
    }

    public void setUser_pasasword_hash(String user_pasasword_hash) {
        this.user_pasasword_hash = BCrypt.hashpw(user_pasasword_hash, BCrypt.gensalt());
    }

    public String getUser_full_name() {
        return user_full_name;
    }

    public void setUser_full_name(String user_full_name) {
        this.user_full_name = user_full_name;
    }

    public Date getUser_dob() {
        return user_dob;
    }

    public void setUser_dob(Date user_dob) {
        this.user_dob = user_dob;
    }

    public Timestamp getUser_crt_date() {
        return user_crt_date;
    }

    public void setUser_crt_date(Timestamp user_crt_date) {
        this.user_crt_date = user_crt_date;
    }

    public Timestamp getUser_updt_date() {
        return user_updt_date;
    }

    public void setUser_updt_date(Timestamp user_updt_date) {
        this.user_updt_date = user_updt_date;
    }

    public Boolean getUser_is_active() {
        return user_is_active;
    }

    public void setUser_is_active(Boolean user_is_active) {
        this.user_is_active = user_is_active;
    }


}
