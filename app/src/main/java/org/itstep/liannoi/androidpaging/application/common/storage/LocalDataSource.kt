package org.itstep.liannoi.androidpaging.application.common.storage

import io.reactivex.Maybe
import org.itstep.liannoi.androidpaging.application.storage.core.paging.PagingDetails

interface LocalDataSource<TEntity, TKey> {

    fun create(entity: TEntity)

    fun getAll(paging: PagingDetails): Maybe<List<TEntity>>

    fun getById(id: TKey): Maybe<TEntity>

    fun update(entity: TEntity)

    fun delete(id: TKey)
}
