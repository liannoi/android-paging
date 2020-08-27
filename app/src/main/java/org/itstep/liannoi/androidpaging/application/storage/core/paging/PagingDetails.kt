package org.itstep.liannoi.androidpaging.application.storage.core.paging

import org.itstep.liannoi.androidpaging.application.ApplicationDefaults

data class PagingDetails constructor(
    val startPosition: Int = ApplicationDefaults.PAGING_START_POSITION,
    val itemsPerPage: Int = ApplicationDefaults.PAGING_ITEMS_PER_PAGE,
)
