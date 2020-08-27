package org.itstep.liannoi.androidpaging.application.common.storage

import androidx.room.Insert

interface BaseDao<TEntity> {

    @Insert
    fun create(entity: TEntity)
}
