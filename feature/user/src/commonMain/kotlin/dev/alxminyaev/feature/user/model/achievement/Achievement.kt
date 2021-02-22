package dev.alxminyaev.feature.user.model.achievement

import com.alxminyaev.tool.domain.model.EntityRef
import dev.alxminyaev.feature.user.model.User

data class Achievement(
    val id: Long,
    val name: String,
    val score: Int,
    val balanceScore: Int,
    val user: EntityRef<Long, User>,
    val eventId: Long,
    val criterionId: Long
)