/*
 * Copyright (c) 2017.
 */

package com.aribanilia.rest.simple.hcms.dao;

import com.aribanilia.rest.simple.hcms.entity.TblHRestLogEChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRestLogEChannelDao extends JpaRepository<TblHRestLogEChannel, Long> {

    TblHRestLogEChannel findByReffSwitching(String reffSwitching);
}
