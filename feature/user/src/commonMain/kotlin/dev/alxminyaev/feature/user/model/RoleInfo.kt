package dev.alxminyaev.feature.user.model

sealed class RoleInfo {

    abstract val id: Role
    abstract val name: String?

    data class Admin(override val name: String? = "Администратор") : RoleInfo() {
        override val id: Role = Role.ADMIN
    }

    data class Professor(override val name: String? = "Преподаватель") : RoleInfo() {
        override val id: Role = Role.PROFESSOR
    }

    data class Student(override val name: String? = "Студент") : RoleInfo() {
        override val id: Role = Role.STUDENT
    }

    data class Tutor(override val name: String? = "Тьютер") : RoleInfo() {
        override val id: Role = Role.TUTOR
    }
}

enum class Role(val id: Int) {
    UNKNOWN(0),
    PROFESSOR(1),
    STUDENT(2),
    TUTOR(3),
    ADMIN(4);


    companion object {
        fun valueById(id: Int): Role {
            return when (id) {
                PROFESSOR.id -> PROFESSOR
                STUDENT.id -> STUDENT
                TUTOR.id -> TUTOR
                ADMIN.id -> ADMIN
                else -> UNKNOWN
            }
        }

    }
}