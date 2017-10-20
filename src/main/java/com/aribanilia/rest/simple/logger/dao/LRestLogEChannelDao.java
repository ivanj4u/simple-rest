/*
 * Copyright (c) 2017.
 */

package com.aribanilia.rest.simple.logger.dao;

import com.aribanilia.rest.simple.logger.entity.TblLRestLogEChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LRestLogEChannelDao extends JpaRepository<TblLRestLogEChannel, Long> {

    TblLRestLogEChannel findByReffSwitchingAndRequestType(String reffSwitching, String requestType);
}
