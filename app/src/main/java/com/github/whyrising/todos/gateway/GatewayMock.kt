package com.github.whyrising.todos.gateway

import kotlinx.coroutines.delay

object GatewayMock : UsersGateway {
    private val USERS: MutableList<User> = ArrayList()
    private val TODOS: MutableList<Todo> = ArrayList()
    private const val COUNT = 25

    init {
        for (i in 1..COUNT)
            USERS.add(createPlaceholderUser(i))

        for (i in 1..COUNT)
            TODOS.add(createPlaceholderTodo(i))
    }

    private fun createPlaceholderUser(index: Int): User = User(
        id = "$index",
        name = "John Doe",
        username = "johndoe",
        email = "johndoe@example.com"
    )

    private fun createPlaceholderTodo(index: Int): Todo = Todo(
        id = "$index",
        title = "task",
        isCompleted = true
    )

    override suspend fun users(): List<User> {
        delay(1000)
        return USERS
    }

    override suspend fun todosBy(user: User): List<Todo> {
        delay(500)
        return TODOS
    }
}
