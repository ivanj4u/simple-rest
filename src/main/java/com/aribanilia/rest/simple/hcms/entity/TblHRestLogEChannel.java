/*
 * Copyright (c) 2017.
 */

package com.aribanilia.rest.simple.hcms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_REST_LOG_ECHANNEL", catalog = "testing_database", schema = "dbo")
public class TblHRestLogEChannel implements Cloneable {
    private long id;
    private String clientId;
    private String channelId;
    private String reffSwitching;

    public TblHRestLogEChannel() {
    }

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "client_id", length = 10, nullable = false)
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Column(name = "channel_id", length = 10, nullable = false)
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Column(name = "reff_switching", length = 30)
    public String getReffSwitching() {
        return reffSwitching;
    }

    public void setReffSwitching(String reffSwitching) {
        this.reffSwitching = reffSwitching;
    }

}
