package org.itstep.liannoi.androidpaging.application.common.interfaces

import org.itstep.liannoi.androidpaging.application.common.storage.Disposable
import org.itstep.liannoi.androidpaging.application.common.storage.Repository
import org.itstep.liannoi.androidpaging.application.storage.users.commands.CreateCommand
import org.itstep.liannoi.androidpaging.application.storage.users.commands.DeleteCommand
import org.itstep.liannoi.androidpaging.application.storage.users.commands.UpdateCommand
import org.itstep.liannoi.androidpaging.application.storage.users.queries.DetailQuery
import org.itstep.liannoi.androidpaging.application.storage.users.queries.ListQuery

interface UsersRepository : Repository<CreateCommand, CreateCommand.Handler,
        ListQuery, ListQuery.Handler,
        DetailQuery, DetailQuery.Handler,
        UpdateCommand, UpdateCommand.Handler,
        DeleteCommand, DeleteCommand.Handler>,
    Disposable
